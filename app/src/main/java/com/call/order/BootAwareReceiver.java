package com.call.order;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;

/**
 *
 * There is an interesting case where this broadcast receiver is called before any of the other component
 * (even before content receiver). This receiver listens to LOCKED_BOOT_COMPLETED intent. The system fires this
 * intent when device is booted and user hasn't entered his pin code yet.
 * <p>
 *
 * The intent is for apps to run initialization code before the file system is decrypted and ready for user
 * <a href="https://developer.android.com/privacy-and-security/direct-boot">...</a>
 * <p>
 * This allows us to call our function at the very early stage of device boot :) However, at this stage, we don't have
 * access to adb to log the timestamp of our function all. Hence, we have to write timestamp information
 * into a file (log.txt)
 * <p>
 * We can inspect this file and compare the stamp with other timestamp calls logged on ADB
 *
 */
public class BootAwareReceiver extends BroadcastReceiver {
    private static final String TAG = BootAwareReceiver.class.getSimpleName();

    public BootAwareReceiver() {
        Function.Call("BootAwareReceiver Constructor");
    }

    @Override
    public void onReceive(Context appContext, Intent intent) {
        if(Objects.equals(intent.getAction(), "android.intent.action.LOCKED_BOOT_COMPLETED")) {
            Function.Call(this.getClass(), "LOCKED_BOOT_COMPLETED onReceive");
            Context directBootContext = appContext.createDeviceProtectedStorageContext();
            try {
                FileOutputStream outStream = directBootContext.openFileOutput("log.txt", 0);
                outStream.write(String.valueOf(System.nanoTime()).getBytes());
                outStream.close();
            } catch (IOException e) {
                Log.e(TAG, e.toString());
            }
        }
    }
}

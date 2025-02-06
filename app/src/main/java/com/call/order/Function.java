package com.call.order;

import android.util.Log;

public class Function {

    private static final String TAG = Function.class.getSimpleName();

    /**
     *
     * This method is responsible to logging the timestamp and class related function call to ADB
     *
     * @param cls class name
     * @param functionName function name
     */
    public static void Call(Class<?> cls, String functionName) {
        Log.d(TAG, String.format("[%d] %s %s", System.nanoTime(), cls.getSimpleName(), functionName));
    }

    public static void Call(String functionName) {
        Log.d(TAG, functionName + " ==> " + System.nanoTime());
    }
}

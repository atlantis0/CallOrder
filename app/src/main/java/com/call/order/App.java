package com.call.order;

import android.app.Application;
import android.util.Log;

import java.util.Objects;

/**
 * This is application level class. Its one of the early classes instantiated
 * during process start up. I have added two classes
 * 1. Constructor - Called when this class is instantiated
 * 2. onCreate - Called by the Android system during app launch
 * <p>
 * In each of these method, I have called one function (Function.Call)
 * This function will be responsible for logging the class name of the caller
 * along with the timestamp if the call
 *
 */
public class App extends Application {

    static {
        System.loadLibrary("launch");
    }

    public App() {
        Function.Call(this.getClass(), "Constructor");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Function.Call(this.getClass(), "onCreate");
    }
}

package com.call.order;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 *
 * This is a content provider class. Its the "first" system component that is called.
 * Android system comprises of 4 major components. Activity, Service, Content Provider & Receivers.
 * Content Providers are called ahead of these three components and even ahead of the application's onCreate
 * method.
 * <p>
 * This behaviour is documented here, <a href="https://developer.android.com/reference/android/app/Application#onCreate()">...</a>
 *
 *
 */
public class AppContentProvider extends ContentProvider {

    private static final String TAG = AppContentProvider.class.getSimpleName();

    public AppContentProvider() {
        Function.Call(this.getClass(), "Constructor");
    }

    @Override
    public boolean onCreate() {
        Function.Call(this.getClass(), "onCreate");
        return false;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        return null;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return "";
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }
}

package com.cook.simpleservices.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by roma on 02.02.16.
 */
public class SimpleService extends Service {

    private final String TAG = this.getClass().getSimpleName();

    private Executor executor;

    @Override
    public void onCreate() {
        Log.i(TAG, "onCreate()");
        super.onCreate();
        executor = Executors.newFixedThreadPool(3);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.i(TAG, "onDestroy()");
        super.onDestroy();
    }
}

package com.cook.simpleservices.service.serviceConnection;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by roma on 05.02.16.
 */
public class ServiceConnectionService extends Service {

    private final String TAG = this.getClass().getSimpleName();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG, "onBind()");
        return new Binder();
    }

    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "onCreate()");
    }

    public void onRebind(Intent intent) {
        super.onRebind(intent);
        Log.i(TAG, "onRebind()");
    }

    public boolean onUnbind(Intent intent) {
        Log.i(TAG, "onUnbind()");
        return true;//завжди буде заходити в onRebind();
    }

    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy()");
    }

}

package com.cook.simpleservices.service.redeliver_intent;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by roma on 03.02.16.
 *
 * Will start all calls startService() which didn't finish with stopSelf();
 */
public class SimpleServiceRedeliverIntent extends Service{

    private final String TAG = this.getClass().getSimpleName();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, intent.getStringExtra("START_REDELIVER_INTENT"));
        return  START_REDELIVER_INTENT;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy()");
    }
}

package com.cook.simpleservices.service.intentService;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

/**
 * Created by roma on 07.02.16.
 */
public class CustomIntentService extends IntentService {

    private final String TAG = this.getClass().getSimpleName();

    public CustomIntentService() {
        super("CustomIntentService");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "onCreate()");
    }

    @Override
    protected void onHandleIntent(Intent intent) {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy()");
    }
}

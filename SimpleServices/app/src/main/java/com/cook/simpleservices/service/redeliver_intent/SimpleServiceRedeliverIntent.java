package com.cook.simpleservices.service.redeliver_intent;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by roma on 03.02.16.
 *
 * Will start all calls startService() which didn't finish with stopSelf();
 */
public class SimpleServiceRedeliverIntent extends Service{

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}

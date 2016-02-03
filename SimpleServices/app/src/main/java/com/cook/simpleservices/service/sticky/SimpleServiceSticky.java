package com.cook.simpleservices.service.sticky;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by roma on 03.02.16.
 *
 * Will restart after system killed this process
 */
public class SimpleServiceSticky extends Service{

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}

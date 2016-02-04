package com.cook.simpleservices.service.broadcast;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.cook.simpleservices.ui.broadcastreceiver.MainBroadcastActivity;

import java.util.concurrent.TimeUnit;

/**
 * Created by roma on 04.02.16.
 */
public class ServiceBroadcastExample extends Service{

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Intent broadcastIntent = new Intent(MainBroadcastActivity.BROADCAST_ACTION);

                broadcastIntent.putExtra(MainBroadcastActivity.STARTED, MainBroadcastActivity.STARTED);
                sendBroadcast(broadcastIntent);
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                broadcastIntent.putExtra(MainBroadcastActivity.FINISHED, MainBroadcastActivity.FINISHED);
                sendBroadcast(broadcastIntent);
            }
        });
        thread.start();

        return super.onStartCommand(intent, flags, startId);
    }



}

package com.cook.simpleservices.service.onStartCommand.not_sticky;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import com.cook.simpleservices.ui.onStartCommand.MainActivity;

/**
 * Created by roma on 03.02.16.
 * <p/>
 * Will not restart after system killed this process
 * <p/>
 * Example how to use pending intent in service.
 * Sends data to Activity from Service.
 */
public class SimpleServiceNotSticky extends Service {

    private final String TAG = this.getClass().getSimpleName();

    public static String MESSAGE = "message";

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        PendingIntent pendingIntent = intent.getParcelableExtra(MainActivity.PENDING_INTENT);
        try {

            Intent resultIntent = new Intent();
            resultIntent.putExtra(MESSAGE, MESSAGE);
//            pendingIntent.send(this, MainActivity.RESULT_CANCELED, resultIntent);
            pendingIntent.send(this, MainActivity.RESULT_OK, resultIntent);

        } catch (PendingIntent.CanceledException e) {
            e.printStackTrace();
        }
        return START_NOT_STICKY;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy()");
    }

}

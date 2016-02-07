package com.cook.simpleservices.service.localbinding;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by roma on 07.02.16.
 */
public class ServiceLocalBinding extends Service {

    private Timer timer = new Timer();
    private TimerTask timerTask;
    private long interval = 1000;
    private String TAG = this.getClass().getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new Binder();
    }

    public void schedule() {
        if (timerTask != null) timerTask.cancel();
        if (interval > 0) {
            timerTask = new TimerTask() {
                public void run() {
                    Log.d(TAG, "schedule()");
                }
            };
            timer.schedule(timerTask, 1000, interval);
        }
    }

    public long upInterval(long gap) {
        interval = interval + gap;
        schedule();
        return interval;
    }

    public long downInterval(long gap) {
        interval = interval - gap;
        if (interval < 0) interval = 0;
        schedule();
        return interval;
    }

    public class MyBinder extends Binder {
        public ServiceLocalBinding getService() {
            return ServiceLocalBinding.this;
        }
    }

}

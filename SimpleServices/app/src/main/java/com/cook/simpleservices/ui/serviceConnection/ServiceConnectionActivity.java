package com.cook.simpleservices.ui.serviceConnection;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.cook.simpleservices.R;
import com.cook.simpleservices.service.serviceConnection.ServiceConnectionService;

/**
 * Created by roma on 05.02.16.
 */
public class ServiceConnectionActivity extends AppCompatActivity {

    private final String TAG = this.getClass().getSimpleName();
    private ServiceConnection serviceConnection;
    private Intent intent;
    private boolean isBind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_connection);

        intent = new Intent("com.cook.simpleservices.service.serviceConnection.ServiceConnectionService");

        serviceConnection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                Log.i(TAG, "onServiceConnected()");
                isBind = true;
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                Log.i(TAG, "onServiceDisconnected()");
                isBind = false;
            }
        };
    }

    public void onStartService(View view) {
        startService(intent);
    }

    public void onStopService(View view) {
        stopService(intent);
    }

    public void onBind(View view) {
        bindService(intent, serviceConnection, BIND_AUTO_CREATE);
//        bindService(intent, serviceConnection, 0); лишає заявку на те аби підключити біндінг при старті сервіса
    }

    public void onUnBind(View view) {
        if (!isBind) return;
        unbindService(serviceConnection);
        isBind = false;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        onUnBind(null);
    }
}


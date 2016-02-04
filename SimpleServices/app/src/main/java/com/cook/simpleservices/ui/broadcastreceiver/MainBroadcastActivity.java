package com.cook.simpleservices.ui.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.cook.simpleservices.R;
import com.cook.simpleservices.service.broadcast.ServiceBroadcastExample;

/**
 * Created by roma on 04.02.16.
 */
public class MainBroadcastActivity extends AppCompatActivity implements View.OnClickListener {

    public final String TAG = this.getClass().getSimpleName();
    public static String BROADCAST_ACTION = "com.simple.service.broadcast";
    public static String STARTED = "started";
    public static String FINISHED = "finished";

    private BroadcastReceiver broadcastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast);
        initBroadcastReceiver();
        initComponents();
    }

    private void initComponents() {
        findViewById(R.id.startBroadcastService).setOnClickListener(this);
        findViewById(R.id.stopBroadcastService).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.startBroadcastService: {
                Intent intent = new Intent(this, ServiceBroadcastExample.class);
                startService(intent);
                break;
            }
            case R.id.stopBroadcastService: {
                Intent intent = new Intent(this, ServiceBroadcastExample.class);
                stopService(intent);
                break;
            }

        }
    }

    private void initBroadcastReceiver() {
        broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                if (intent.getStringExtra(FINISHED) !=null){
                    Log.i(TAG, "---> " + intent.getStringExtra(FINISHED) );
                    return;
                }
                if (intent.getStringExtra(STARTED) != null){
                    Log.i(TAG, "---> " + intent.getStringExtra(STARTED));
                }

            }
        };
        IntentFilter broadcastIntentFilter = new IntentFilter(BROADCAST_ACTION);
        registerReceiver(broadcastReceiver, broadcastIntentFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(broadcastReceiver);
    }


}

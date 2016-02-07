package com.cook.simpleservices.ui.localbinding;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.cook.simpleservices.R;
import com.cook.simpleservices.service.localbinding.ServiceLocalBinding;

/**
 * Created by roma on 07.02.16.
 */
public class LocalBindingActivity extends AppCompatActivity {

    private String TAG = this.getClass().getSimpleName();
    private ServiceLocalBinding myService;
    private ServiceConnection serviceConnection;
    private boolean bound;
    private Intent intent;
    private static final int ORDER_TO_START_BINDING = 0;
    private long interval;
    private TextView tvInterval;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_binding);
        intent = new Intent(this, ServiceLocalBinding.class);
        tvInterval = (TextView) findViewById(R.id.tv_interval);
        serviceConnection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                myService = ((ServiceLocalBinding.MyBinder) service).getService();
                Log.i(TAG, "onServiceConnected()");
                bound = true;
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                Log.i(TAG, "onServiceDisconnected()");
                bound = false;
            }
        };
    }

    public void onStartService(View view) {
        startService(intent);
    }

    public void onStopService(View view) {
        stopService(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        bindService(intent, serviceConnection, ORDER_TO_START_BINDING);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (!bound) return;
        unbindService(serviceConnection);
        bound = false;
    }

    public void onClickUp(View view){
        if (!bound) return;
        interval = myService.upInterval(500);
        tvInterval.setText("interval = " + interval);
    }

    public void onClickDown(View view){
        if (!bound) return;
        interval = myService.downInterval(500);
        tvInterval.setText("interval = " + interval);
    }
}

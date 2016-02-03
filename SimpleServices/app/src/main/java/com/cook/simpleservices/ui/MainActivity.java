package com.cook.simpleservices.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.cook.simpleservices.R;
import com.cook.simpleservices.service.not_sticky.SimpleServiceNotSticky;
import com.cook.simpleservices.service.redeliver_intent.SimpleServiceRedeliverIntent;
import com.cook.simpleservices.service.sticky.SimpleServiceSticky;

/**
 * Created by roma on 02.02.16.
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.bt_not_sticky_start).setOnClickListener(this);
        findViewById(R.id.bt_not_sticky_stop).setOnClickListener(this);
        findViewById(R.id.bt_sticky_start).setOnClickListener(this);
        findViewById(R.id.bt_sticky_stop).setOnClickListener(this);
        findViewById(R.id.bt_intent_start).setOnClickListener(this);
        findViewById(R.id.bt_intent_stop).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.bt_not_sticky_start: {
                startService(new Intent(this, SimpleServiceNotSticky.class));
                break;
            }
            case R.id.bt_not_sticky_stop: {
                stopService(new Intent(this, SimpleServiceNotSticky.class));
                break;
            }
            case R.id.bt_sticky_start: {
                startService(new Intent(this, SimpleServiceSticky.class));
                break;
            }
            case R.id.bt_sticky_stop: {
                stopService(new Intent(this, SimpleServiceSticky.class));
                break;
            }
            case R.id.bt_intent_start: {
                startService(new Intent(this, SimpleServiceRedeliverIntent.class));
                break;
            }
            case R.id.bt_intent_stop: {
                stopService(new Intent(this, SimpleServiceRedeliverIntent.class));
                break;
            }
        }
    }
}

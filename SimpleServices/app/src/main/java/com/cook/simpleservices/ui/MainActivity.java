package com.cook.simpleservices.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.cook.simpleservices.R;
import com.cook.simpleservices.service.SimpleService;

/**
 * Created by roma on 02.02.16.
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.bt_start_service).setOnClickListener(this);
        findViewById(R.id.bt_stop_service).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, SimpleService.class);
        switch (v.getId()) {
            case R.id.bt_start_service: {
                startService(intent);
                break;
            }
            case R.id.bt_stop_service: {
                stopService(intent);
                break;
            }
        }
    }
}

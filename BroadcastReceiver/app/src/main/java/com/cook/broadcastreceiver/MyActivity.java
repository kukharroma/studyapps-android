package com.cook.broadcastreceiver;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.cook.broadcastreceiver.databinding.ActivityMainBinding;

/**
 * Created by roma on 17.02.16.
 */
public class MyActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setViewModel(new MyActivityViewModel());
    }

    public class MyActivityViewModel{

        public MyActivityViewModel() {

        }

        public void onStartBroadcastReceiver(View view){
            Intent intent = new Intent("TEST_BROADCAST_ACTION");
            sendBroadcast(intent);
        }
    }

}


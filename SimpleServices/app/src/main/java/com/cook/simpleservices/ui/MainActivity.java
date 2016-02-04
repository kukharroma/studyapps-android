package com.cook.simpleservices.ui;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.cook.simpleservices.R;
import com.cook.simpleservices.service.not_sticky.SimpleServiceNotSticky;
import com.cook.simpleservices.service.redeliver_intent.SimpleServiceRedeliverIntent;
import com.cook.simpleservices.service.sticky.SimpleServiceSticky;


/**
 * Created by roma on 02.02.16.
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private final String TAG = this.getClass().getSimpleName();
    private PendingIntent pendingIntent;
    public static int PENDING_INTENT_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();
    }

    private void initComponents() {
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
                PendingIntent pendingIntent = createPendingResult(PENDING_INTENT_REQUEST_CODE, new Intent(), 0);
                Intent intent = new Intent(this, SimpleServiceNotSticky.class);
                intent.putExtra("pendingIntent", pendingIntent);
                startService(intent);
                break;
            }
            case R.id.bt_not_sticky_stop: {
                stopService(new Intent(this, SimpleServiceNotSticky.class));
                break;
            }
            case R.id.bt_sticky_start: {
                Intent intent = new Intent(this, SimpleServiceSticky.class);
                intent.putExtra("START_STICKY", "sticky");
                startService(intent);
                break;
            }
            case R.id.bt_sticky_stop: {
                stopService(new Intent(this, SimpleServiceSticky.class));
                break;
            }
            case R.id.bt_intent_start: {
                Intent intent = new Intent(this, SimpleServiceRedeliverIntent.class);
                intent.putExtra("START_REDELIVER_INTENT", "redeliver intent");
                startService(intent);
                break;
            }
            case R.id.bt_intent_stop: {
                stopService(new Intent(this, SimpleServiceRedeliverIntent.class));
                break;
            }
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PENDING_INTENT_REQUEST_CODE) {
            if (resultCode == RESULT_OK)
                Log.i(TAG, "Message from  " + data.getStringExtra(SimpleServiceNotSticky.MESSAGE));
        }
    }
}

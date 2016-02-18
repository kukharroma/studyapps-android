package com.cook.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by roma on 17.02.16.
 */
public class BroadcastReceiverPrioryty2 extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        System.out.println(this.getClass().getSimpleName());
    }
}

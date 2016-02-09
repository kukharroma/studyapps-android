package com.cook.databinding;

import android.util.Log;
import android.view.View;

/**
 * Created by roma on 09.02.16.
 */
public class CustomHandler  {

    private final String TAG = this.getClass().getSimpleName();

    public void onLike(View view){
        Log.i(TAG, "onLike");
    }

    public void onDislike(View view){
        Log.i(TAG, "onDislike");
    }
}

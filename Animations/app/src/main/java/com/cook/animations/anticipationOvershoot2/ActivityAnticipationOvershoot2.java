package com.cook.animations.anticipationOvershoot2;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.cook.animations.R;
import com.cook.animations.databinding.ActivityAnticipationOvershoot2Binding;

/**
 * Created by roma on 11.03.16.
 */
public class ActivityAnticipationOvershoot2 extends AppCompatActivity {

    private ActivityAnticipationOvershoot2Binding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_anticipation_overshoot2);
        binding.setViewModel(new AnticipationOvershoot2ViewModel());
    }

    public class AnticipationOvershoot2ViewModel {

    }
}

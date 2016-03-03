package com.cook.animations;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.cook.animations.databinding.ActivityMainBinding;

/**
 * Created by roma on 02.03.16.
 */
public class ActivityMain extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setViewModel(new MainActivityModelView());
    }

    public class MainActivityModelView {

        public void onProperyAnimationClick(View view) {
            startActivity(new Intent(getApplicationContext(), ActivityPropertyAnimations.class));
        }

        public void onViewAnimationClick(View view) {
            startActivity(new Intent(getApplicationContext(), ActivityViewAnimations.class));
        }
    }
}

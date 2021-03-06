package com.cook.animations;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.cook.animations.anticipationOvershoot1.ActivityAnticipationOvershoot1;
import com.cook.animations.anticipationOvershoot2.ActivityAnticipationOvershoot2;
import com.cook.animations.crossfading.ActivityCrossFading;
import com.cook.animations.databinding.ActivityMainBinding;
import com.cook.animations.keyframe.ActivityKeyFrame;
import com.cook.animations.requestingLayout.ActivityTestRequestLayout;
import com.cook.animations.viewPicture.ActivityViewPicture;

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

        public void onLayoutTransitionsClick(View view) {
            startActivity(new Intent(getApplicationContext(), ActivityLayoutTransitions.class));
        }

        public void onRequstLayout(View view) {
            startActivity(new Intent(getApplicationContext(), ActivityTestRequestLayout.class));
        }

        public void onKeyFrame(View view) {
            startActivity(new Intent(getApplicationContext(), ActivityKeyFrame.class));
        }

        public void onCrossFade(View view) {
            startActivity(new Intent(getApplicationContext(), ActivityCrossFading.class));
        }

        public void onImageViewer(View view) {
            startActivity(new Intent(getApplicationContext(), ActivityViewPicture.class));
        }

        public void onOvershootClick1(View view) {
            startActivity(new Intent(getApplicationContext(), ActivityAnticipationOvershoot1.class));
        }

        public void onOvershootClick2(View view) {
            startActivity(new Intent(getApplicationContext(), ActivityAnticipationOvershoot2.class));
        }
    }
}

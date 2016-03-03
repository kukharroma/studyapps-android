package com.cook.animations;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.cook.animations.databinding.ActivityPropertyAnimationsBinding;

/**
 * Created by roma on 03.03.16.
 */
public class ActivitySimplePropertyAnimations extends AppCompatActivity {

    private ObjectAnimator alphaAnimation;
    private ObjectAnimator translateAnimation;
    private ObjectAnimator rotateAnimation;
    private ObjectAnimator scaleAnimation;

    private ActivityPropertyAnimationsBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_animations);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_property_animations);
        binding.setViewModel(new SimplePropertyAnimationsViewModel());
    }

    public class SimplePropertyAnimationsViewModel {
        public void alphaClick(View view) {
            alphaAnimation = ObjectAnimator.ofFloat(binding.btAlpha, View.ALPHA, 0);
            alphaAnimation.setRepeatCount(1);
            alphaAnimation.setRepeatMode(ValueAnimator.REVERSE);
            alphaAnimation.start();
        }

        public void translation_X_Click(View view) {
            translateAnimation = ObjectAnimator.ofFloat(binding.btTranslation, View.TRANSLATION_X, 800);
            translateAnimation.setRepeatCount(1);
            translateAnimation.setRepeatMode(ValueAnimator.REVERSE);
            translateAnimation.start();
        }

        public void rotateClick(View view) {
            rotateAnimation = ObjectAnimator.ofFloat(binding.btRotate, View.ROTATION, 360);
            rotateAnimation.setRepeatCount(1);
            rotateAnimation.setRepeatMode(ValueAnimator.REVERSE);
            rotateAnimation.start();
        }

        public void scaleClick(View view) {
            PropertyValuesHolder pvhX = PropertyValuesHolder.ofFloat(View.SCALE_X, 2);
            PropertyValuesHolder pvhY = PropertyValuesHolder.ofFloat(View.SCALE_Y, 2);
            scaleAnimation = ObjectAnimator.ofPropertyValuesHolder(binding.btScale, pvhX, pvhY);
            scaleAnimation.setRepeatCount(1);
            scaleAnimation.setRepeatMode(ValueAnimator.REVERSE);
            scaleAnimation.start();
        }

        public void setClick(View view) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.play(translateAnimation).after(alphaAnimation).before(rotateAnimation);
            animatorSet.play(rotateAnimation).before(scaleAnimation);
            animatorSet.start();
        }
    }
}

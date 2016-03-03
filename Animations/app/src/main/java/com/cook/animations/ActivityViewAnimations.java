package com.cook.animations;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;

import com.cook.animations.databinding.ActivityViewAnimationsBinding;

/**
 * Created by roma on 03.03.16.
 */
public class ActivityViewAnimations extends AppCompatActivity {

    private ActivityViewAnimationsBinding binding;

    private AlphaAnimation alphaAnimation;
    private TranslateAnimation translateAnimation;
    private RotateAnimation rotateAnimation;
    private ScaleAnimation scaleAnimation;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_animations);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_view_animations);
        ViewAnimationsViewModel viewModel = new ViewAnimationsViewModel();
        binding.setViewModel(viewModel);
        viewModel.initAnimations();
    }

    public class ViewAnimationsViewModel {

        public void initAnimations(){
            alphaAnimation = new AlphaAnimation(1, 0);
            alphaAnimation.setDuration(1000);


            translateAnimation = new TranslateAnimation(Animation.ABSOLUTE, 0, Animation.RELATIVE_TO_PARENT, 1, Animation.ABSOLUTE, 0, Animation.ABSOLUTE, 100);
            translateAnimation.setDuration(1000);


            rotateAnimation = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
            rotateAnimation.setDuration(1000);


            scaleAnimation = new ScaleAnimation(1, 2, 1, 3);
        }
        public void alphaClick(View view) {
            binding.btAlpha.startAnimation(alphaAnimation);
        }

        public void translation_X_Click(View view) {
            binding.btTranslate.startAnimation(translateAnimation);
        }

        public void rotateClick(View view) {
            binding.btRotate.startAnimation(rotateAnimation);
        }

        public void scaleClick(View view) {
            binding.btScale.startAnimation(scaleAnimation);
        }

        public void setClick(View view) {
            AnimationSet animationSet = new AnimationSet(true);
            animationSet.addAnimation(alphaAnimation);
            animationSet.addAnimation(translateAnimation);
            animationSet.addAnimation(rotateAnimation);
            animationSet.addAnimation(scaleAnimation);
            animationSet.startNow();
        }
    }
}

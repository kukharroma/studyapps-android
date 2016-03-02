package com.cook.animations;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by roma on 02.03.16.
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btAlpha;
    private Button btTranslation;
    private Button btRotate;
    private Button btScale;
    private Button btSet;

    private ObjectAnimator alphaAnimation;
    private ObjectAnimator translateAnimation;
    private ObjectAnimator rotateAnimation;
    private ObjectAnimator scaleAnimation;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btAlpha = (Button) findViewById(R.id.bt_alpha);
        btTranslation = (Button) findViewById(R.id.bt_translation_X);
        btRotate = (Button) findViewById(R.id.bt_rotate);
        btScale = (Button) findViewById(R.id.bt_scale);
        btSet = (Button) findViewById(R.id.bt_set);

        btAlpha.setOnClickListener(this);
        btTranslation.setOnClickListener(this);
        btRotate.setOnClickListener(this);
        btScale.setOnClickListener(this);
        btSet.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_alpha: {
                alphaAnimation = ObjectAnimator.ofFloat(btAlpha, View.ALPHA, 0);
                alphaAnimation.setRepeatCount(1);
                alphaAnimation.setRepeatMode(ValueAnimator.REVERSE);
                alphaAnimation.start();
                break;
            }
            case R.id.bt_translation_X: {
                translateAnimation = ObjectAnimator.ofFloat(btTranslation, View.TRANSLATION_X, 800);
                translateAnimation.setRepeatCount(1);
                translateAnimation.setRepeatMode(ValueAnimator.REVERSE);
                translateAnimation.start();
                break;
            }
            case R.id.bt_rotate: {
                rotateAnimation = ObjectAnimator.ofFloat(btRotate, View.ROTATION, 360);
                rotateAnimation.setRepeatCount(1);
                rotateAnimation.setRepeatMode(ValueAnimator.REVERSE);
                rotateAnimation.start();
                break;
            }
            case R.id.bt_scale: {
                PropertyValuesHolder pvhX = PropertyValuesHolder.ofFloat(View.SCALE_X, 2);
                PropertyValuesHolder pvhY = PropertyValuesHolder.ofFloat(View.SCALE_Y, 2);
                scaleAnimation = ObjectAnimator.ofPropertyValuesHolder(btScale, pvhX, pvhY);
                scaleAnimation.setRepeatCount(1);
                scaleAnimation.setRepeatMode(ValueAnimator.REVERSE);
                scaleAnimation.start();
                break;
            }
            case R.id.bt_set: {
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.play(translateAnimation).after(alphaAnimation).before(rotateAnimation);
                animatorSet.play(rotateAnimation).before(scaleAnimation);
                animatorSet.start();
                break;
            }
        }
    }
}

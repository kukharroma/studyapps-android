package com.cook.animations.crossfading;

import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.cook.animations.R;
import com.cook.animations.databinding.ActivityCrossfadingBinding;

/**
 * Created by roma on 04.03.16.
 */
public class ActivityCrossFading extends AppCompatActivity {

    private ActivityCrossfadingBinding binding;
    private int currentDrawable = 0;
    private TransitionDrawable transitionDrawable;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crossfading);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_crossfading);
        binding.setViewModel(new CrossFadingViewModel());
        initBitmaps();
    }

    private void initBitmaps() {
        Bitmap bitmap0 = Bitmap.createBitmap(500, 500, Bitmap.Config.ARGB_8888);
        Bitmap bitmap1 = Bitmap.createBitmap(500, 500, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap0);
        canvas.drawColor(Color.RED);
        canvas = new Canvas(bitmap1);
        canvas.drawColor(Color.GREEN);

        BitmapDrawable drawables[] = new BitmapDrawable[2];
        drawables[0] = new BitmapDrawable(getResources(), bitmap0);
        drawables[1] = new BitmapDrawable(getResources(), bitmap1);

        transitionDrawable = new TransitionDrawable(drawables);
        binding.ivCrossfade.setImageDrawable(transitionDrawable);

    }

    public class CrossFadingViewModel {

        public void onImageClick(View view) {
            if (currentDrawable == 0) {
                transitionDrawable.startTransition(500);
                currentDrawable = 1;
            } else {
                transitionDrawable.reverseTransition(500);
                currentDrawable = 0;
            }


        }
    }
}


package com.cook.animations.keyframe;

import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.cook.animations.R;
import com.cook.animations.databinding.ActivityKeyFrameBinding;

/**
 * Created by roma on 04.03.16.
 */
public class ActivityKeyFrame extends AppCompatActivity {

    private ActivityKeyFrameBinding binding;
    private AnimationDrawable animationDrawable = new AnimationDrawable();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_key_frame);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_key_frame);
        binding.setViewModel(new ActivityKeyFrameVoiewModel());
        fillAnimationDrawable();
    }

    private void fillAnimationDrawable() {
        for (int i = 0; i < 10; i++) {
            animationDrawable.addFrame(getDrawableByNumber(i), 300);
        }
        animationDrawable.setOneShot(true);
        binding.imageView.setImageDrawable(animationDrawable);
    }

    private Drawable getDrawableByNumber(int i) {
        Bitmap bitmap = Bitmap.createBitmap(400, 400, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        canvas.drawColor(Color.GRAY);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setTextSize(80);
        paint.setColor(Color.BLACK);
        canvas.drawText("Frame " + i, 40, 220, paint);
        return new BitmapDrawable(getResources(), bitmap);
    }

    public class ActivityKeyFrameVoiewModel {

        public void onImageViewClick(View view) {
            if (animationDrawable.isRunning())
                animationDrawable.stop();
            else
                animationDrawable.start();
        }
    }
}

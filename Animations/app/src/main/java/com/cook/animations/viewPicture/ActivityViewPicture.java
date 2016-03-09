package com.cook.animations.viewPicture;

import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.cook.animations.R;
import com.cook.animations.databinding.ActivityViewPictureBinding;

import java.util.TimerTask;

/**
 * Created by roma on 04.03.16.
 */
public class ActivityViewPicture extends AppCompatActivity {

    ActivityViewPictureBinding binding;

    private int currentDrawable = 0;
    private int drawablesId[] = {
            R.drawable.p1,
            R.drawable.p2,
            R.drawable.p3,
            R.drawable.p4,
            R.drawable.p5,
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_picture);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_view_picture);
        binding.setViewModel(new ViewPictureViewModel());


    }

    public class ViewPictureViewModel {

        private final BitmapDrawable drawables[] = new BitmapDrawable[drawablesId.length];

        public ViewPictureViewModel() {
            binding.prevImageView.setBackgroundColor(Color.TRANSPARENT);
            binding.nextImageView.setBackgroundColor(Color.TRANSPARENT);

            binding.prevImageView.animate().setDuration(1000);
            binding.nextImageView.animate().setDuration(1000);


            int index = R.drawable.p1;

            for (int i = 0; i < drawablesId.length; ++i, index++) {
                Bitmap bitmap = BitmapFactory.decodeResource(getResources(), drawablesId[i]);
                drawables[i] = new BitmapDrawable(getResources(), bitmap);
            }

            binding.prevImageView.setImageDrawable(drawables[0]);
            binding.prevImageView.setImageDrawable(drawables[1]);
            binding.prevImageView.animate().alpha(0).withLayer();
        }

        public void onNextImageClick(View view) {
            binding.nextImageView.animate().alpha(1).withLayer().
                    withEndAction(new TimerTask() {
                        @Override
                        public void run() {

                            currentDrawable = (currentDrawable + 1) % drawables.length;
                            int nextDrawableIndex = (currentDrawable + 1) % drawables.length;
                            binding.prevImageView.setImageDrawable(drawables[currentDrawable]);
                            binding.nextImageView.setImageDrawable(drawables[nextDrawableIndex]);
                            binding.nextImageView.setAlpha(0f);
                            binding.prevImageView.setAlpha(1f);
                        }
                    });
        }
    }
}

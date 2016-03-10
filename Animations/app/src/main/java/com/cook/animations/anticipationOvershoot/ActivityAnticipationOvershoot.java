package com.cook.animations.anticipationOvershoot;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.OvershootInterpolator;

import com.cook.animations.R;
import com.cook.animations.databinding.ActivityAnticipationOvershootBinding;

/**
 * Created by roma on 10.03.16.
 */
public class ActivityAnticipationOvershoot extends AppCompatActivity {

    private ActivityAnticipationOvershootBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anticipation_overshoot);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_anticipation_overshoot);
        binding.setViewModel(new AnticipationOvershootViewModel());
    }

    public class AnticipationOvershootViewModel {
        public AnticipationOvershootViewModel() {
            final DecelerateInterpolator decelerateInterpolator = new DecelerateInterpolator();
            final OvershootInterpolator overshootInterpolator = new OvershootInterpolator(25f);

            binding.btAnticipOvershoot.animate().setDuration(350);

            binding.btAnticipOvershoot.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    if (event.getAction() == MotionEvent.ACTION_DOWN) {
                        binding.btAnticipOvershoot
                                .animate()
                                .setInterpolator(decelerateInterpolator)
                                .scaleX(.7f)
                                .scaleY(.7f);
                    } else if (event.getAction() == MotionEvent.ACTION_UP) {
                        binding.btAnticipOvershoot
                                .animate()
                                .setInterpolator(overshootInterpolator)
                                .scaleX(1f)
                                .scaleY(1f);
                    }
                    return false;
                }
            });
        }
    }
}

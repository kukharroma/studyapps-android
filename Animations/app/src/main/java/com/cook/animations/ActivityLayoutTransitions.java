package com.cook.animations;

import android.animation.LayoutTransition;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;

import com.cook.animations.databinding.ActivityLayoutTransitionsBinding;

/**
 * Created by roma on 03.03.16.
 */
public class ActivityLayoutTransitions extends AppCompatActivity {

    private ActivityLayoutTransitionsBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_transitions);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_layout_transitions);
        binding.setViewModel(new ActivityLayoutViewModel());
    }

    public class ActivityLayoutViewModel {

        public ActivityLayoutViewModel() {
            for (int i = 0; i < 2; ++i) {
                binding.container.addView(new ColoredView(getApplicationContext()));
            }

            LayoutTransition transition = binding.container.getLayoutTransition();
            transition.enableTransitionType(LayoutTransition.CHANGING);
        }

        public void onAddItemClick(View view) {
            binding.container.addView(new ColoredView(getApplicationContext()), 1);
        }

        public void onDeleteItemClick(View view) {
            if (binding.container.getChildCount() > 0) {
                binding.container.removeViewAt(Math.min(1, binding.container.getChildCount() - 1));
            }
        }
    }


    private static class ColoredView extends View {

        private boolean mExpanded = false;

        private ViewGroup.LayoutParams mCompressedParams = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, 50);

        private ViewGroup.LayoutParams mExpandedParams = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, 200);

        private ColoredView(Context context) {
            super(context);
            setBackgroundColor(getColor());
            setLayoutParams(mCompressedParams);
            setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    setLayoutParams(mExpanded ? mCompressedParams : mExpandedParams);
                    mExpanded = !mExpanded;
                    requestLayout();
                }
            });
        }

        private int getColor() {
            int red = (int) (Math.random() * 128 + 127);
            int green = (int) (Math.random() * 128 + 127);
            int blue = (int) (Math.random() * 128 + 127);
            return 0xff << 24 | (red << 16) | (green << 8) | blue;
        }
    }
}

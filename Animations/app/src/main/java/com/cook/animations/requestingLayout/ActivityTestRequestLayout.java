package com.cook.animations.requestingLayout;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.cook.animations.R;
import com.cook.animations.databinding.ActivityRequestLayoutBinding;

/**
 * Created by roma on 04.03.16.
 */
public class ActivityTestRequestLayout extends AppCompatActivity {

    ActivityRequestLayoutBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_layout);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_request_layout);
        binding.setViewModel(new RequestLayoutViewModel());

    }

    public class RequestLayoutViewModel {

        public void add(View view) {
//            binding.container.addRequestPending = true;
//            binding.container.requestLayout();

            binding.container.addButton();
        }

        public void delete(View view) {
//            binding.container.removeRequestPending = true;
//            binding.container.requestLayout();

            binding.container.removeButton();
        }

        public void requsetLayout(View view) {
            binding.container.requestLayout();
        }
    }

}

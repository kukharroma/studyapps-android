package com.cook.animations.viewPicture;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.cook.animations.R;
import com.cook.animations.databinding.ActivityViewPictureBinding;

/**
 * Created by roma on 04.03.16.
 */
public class ActivityViewPicture extends AppCompatActivity {

    ActivityViewPictureBinding binding;

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

    }
}

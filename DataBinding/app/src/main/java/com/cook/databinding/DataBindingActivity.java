package com.cook.databinding;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.cook.databinding.databinding.ActivityDatabindingBinding;

/**
 * Created by roma on 09.02.16.
 */
public class DataBindingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDatabindingBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_databinding);
        User user = new User();
        user.setAge(15);
        user.setImageUrl("https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcS5eDs9VOSShXa5_ws0FJLguy5H-9_2YOzW3jcXqWMj6eEJUT2n6YaqZg");
        user.setName("Roma");
        binding.setUser(user);
        Log.i(this.getClass().getSimpleName(), binding.getUser().getImageUrl());

    }
}

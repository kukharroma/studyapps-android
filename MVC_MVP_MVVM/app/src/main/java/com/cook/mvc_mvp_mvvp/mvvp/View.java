package com.cook.mvc_mvp_mvvp.mvvp;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.cook.mvc_mvp_mvvp.R;
import com.cook.mvc_mvp_mvvp.databinding.MvvpActivityBinding;

/**
 * Created by roma on 16.02.16.
 */
public class View extends AppCompatActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MvvpActivityBinding binding = DataBindingUtil.setContentView(this, R.layout.mvvp_activity);
        binding.setViewModel(new ViewModel("Roma", "Kukhar", 21));
    }
}

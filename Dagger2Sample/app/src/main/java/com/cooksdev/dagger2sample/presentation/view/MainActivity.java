package com.cooksdev.dagger2sample.presentation.view;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.cooksdev.dagger2sample.App;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    App app;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        app.getAppComponent().inject(this);

    }
}

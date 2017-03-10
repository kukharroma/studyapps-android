package com.cooksdev.dagger2sample.presentation.view.activity;

import android.os.Bundle;

import com.cooksdev.dagger2sample.R;
import com.cooksdev.dagger2sample.presentation.core.view.BaseActivity;
import com.cooksdev.dagger2sample.presentation.view.presenter.MainPresenter;

import javax.inject.Inject;

public class MainActivity extends BaseActivity {

    @Inject
    MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainPresenter.setView(this);
    }
}

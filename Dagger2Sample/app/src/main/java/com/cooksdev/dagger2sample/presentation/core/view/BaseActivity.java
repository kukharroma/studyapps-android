package com.cooksdev.dagger2sample.presentation.core.view;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.cooksdev.dagger2sample.App;
import com.cooksdev.dagger2sample.presentation.di.component.AppComponent;

public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getAppComponent().inject(this);
    }

    /**
     * Get the Main Application component for dependency injection.
     *
     * @return {@link AppComponent}
     */
    public AppComponent getAppComponent() {
        return App.get(this).appComponent();
    }

}

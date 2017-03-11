package com.cooksdev.dagger2sample;


import android.app.Application;
import android.support.annotation.VisibleForTesting;

import com.cooksdev.dagger2sample.presentation.di.component.AppComponent;
import com.cooksdev.dagger2sample.presentation.di.component.DaggerAppComponent;
import com.cooksdev.dagger2sample.presentation.di.module.AppModule;


public class App extends Application {
    private AppComponent component;

    @VisibleForTesting
    protected AppComponent createComponent() {
        return DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent getAppComponent() {
        if (component == null) {
            component = createComponent();
        }
        return component;
    }
}

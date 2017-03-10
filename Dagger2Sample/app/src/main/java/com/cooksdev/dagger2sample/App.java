package com.cooksdev.dagger2sample;


import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;

import com.cooksdev.dagger2sample.presentation.di.component.AppComponent;
import com.cooksdev.dagger2sample.presentation.di.component.DaggerAppComponent;

public class App extends Application {

    private volatile AppComponent appComponent;

    @NonNull
    public static App get(@NonNull Context context) {
        return (App) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    /**
     * Create AppComponent {@link AppComponent}
     *
     * @return {@link AppComponent} instance
     */
    private AppComponent createAppComponent() {
        return DaggerAppComponent.builder().build();
    }

    /**
     * Initialize and return app component
     *
     * @return {@link AppComponent} instance
     */
    public AppComponent appComponent() {
        if (appComponent == null) {
            synchronized (App.class) {
                if (appComponent == null) {
                    appComponent = createAppComponent();
                }
            }
        }
        return appComponent;
    }

}

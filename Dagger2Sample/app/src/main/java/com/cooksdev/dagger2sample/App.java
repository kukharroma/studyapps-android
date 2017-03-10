package com.cooksdev.dagger2sample;


import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;

import com.cooksdev.dagger2sample.presentation.di.component.AppComponent;
import com.cooksdev.dagger2sample.presentation.di.component.DaggerAppComponent;
import com.cooksdev.dagger2sample.presentation.di.module.AppModule;
import com.cooksdev.dagger2sample.presentation.di.module.DomainModule;
import com.cooksdev.dagger2sample.presentation.di.module.NetworkModule;
import com.cooksdev.dagger2sample.presentation.di.module.PresenterModule;

public class App extends Application {

    private volatile AppComponent appComponent;

    @NonNull
    public static App get(@NonNull Context context) {
        return (App) context.getApplicationContext();
    }


    /**
     * Create AppComponent {@link AppComponent}
     *
     * @return {@link AppComponent} instance
     */
    private AppComponent createAppComponent() {
        return DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .domainModule(new DomainModule())
                .networkModule(new NetworkModule())
                .presenterModule(new PresenterModule())
                .build();
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

package com.cooksdev.dagger2sample.presentation.di.module;


import android.content.Context;
import android.support.annotation.NonNull;

import com.cooksdev.dagger2sample.App;
import com.cooksdev.dagger2sample.presentation.view.MainPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    private App app;

    public AppModule(App app) {
        this.app = app;
    }

    @Provides
    @NonNull
    @Singleton
    App provideContext() {
        return app;
    }

    @Provides
    @Singleton
    MainPresenter provideMainPresenter(MainPresenter presenter) {
        return presenter;
    }
}

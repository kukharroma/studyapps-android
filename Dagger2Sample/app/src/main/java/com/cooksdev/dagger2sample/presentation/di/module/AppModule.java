package com.cooksdev.dagger2sample.presentation.di.module;


import android.content.Context;
import android.support.annotation.NonNull;

import com.cooksdev.dagger2sample.App;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private final App app;

    public AppModule(@NonNull App app) {
        this.app = app;
    }

    @NonNull
    @Provides
    @Singleton
    Context provideContext() {
        return app;
    }
}

package com.cooksdev.dagger2sample.presentation.di.module;

import com.cooksdev.dagger2sample.data.Api;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class NetworkModule {

    @Provides
    @Singleton
    public Api provideApi(Api api) {
        return api;
    }
}

package com.cooksdev.dagger2sample.presentation.di.module;

import com.cooksdev.dagger2sample.data.Api;

import dagger.Module;
import dagger.Provides;

@Module
public class NetworkModule {

    @Provides
     Api provideApi(Api api) {
        return api;
    }
}

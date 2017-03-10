package com.cooksdev.dagger2sample.presentation.di.module;


import com.cooksdev.dagger2sample.domain.GetUserUseCase;

import dagger.Module;
import dagger.Provides;

@Module
public class DomainModule {

    @Provides
    GetUserUseCase provideGetUserUseCase(GetUserUseCase getUserUseCase) {
        return getUserUseCase;
    }
}

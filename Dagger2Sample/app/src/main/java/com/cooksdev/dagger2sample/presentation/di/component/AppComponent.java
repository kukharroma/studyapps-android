package com.cooksdev.dagger2sample.presentation.di.component;


import com.cooksdev.dagger2sample.presentation.core.view.BaseActivity;
import com.cooksdev.dagger2sample.presentation.di.module.AppModule;
import com.cooksdev.dagger2sample.presentation.di.module.DomainModule;
import com.cooksdev.dagger2sample.presentation.di.module.NetworkModule;
import com.cooksdev.dagger2sample.presentation.di.module.PresenterModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, DomainModule.class, NetworkModule.class, PresenterModule.class})
public interface AppComponent {
    void inject(BaseActivity activity);
}

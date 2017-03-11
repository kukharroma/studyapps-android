package com.cooksdev.dagger2sample.presentation.di.component;


import com.cooksdev.dagger2sample.presentation.di.module.AppModule;
import com.cooksdev.dagger2sample.presentation.view.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    void inject(MainActivity activity);
}

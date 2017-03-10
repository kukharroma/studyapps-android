package com.cooksdev.dagger2sample.presentation.di.module;

import com.cooksdev.dagger2sample.presentation.core.presenter.BasePresenter;
import com.cooksdev.dagger2sample.presentation.view.presenter.MainPresenter;

import org.eclipse.jdt.internal.compiler.batch.Main;

import dagger.Module;
import dagger.Provides;

@Module
public class PresenterModule {

    @Provides
    MainPresenter provideMainPresenter(MainPresenter presenter) {
        return presenter;
    }
}

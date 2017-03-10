package com.cooksdev.dagger2sample.presentation.view.presenter;


import com.cooksdev.dagger2sample.domain.GetUserUseCase;
import com.cooksdev.dagger2sample.presentation.core.presenter.BasePresenter;
import com.cooksdev.dagger2sample.presentation.core.view.BaseActivity;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class MainPresenter extends BasePresenter<BaseActivity> {

    @Inject
    GetUserUseCase userUseCase;

    public MainPresenter(GetUserUseCase userUseCase) {
        this.userUseCase = userUseCase;
    }
}

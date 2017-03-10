package com.cooksdev.dagger2sample.presentation.core.presenter;


import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.cooksdev.dagger2sample.presentation.core.view.BaseActivity;

public class BasePresenter<View> {
    private View view;

    @Nullable
    public final View getView() {
        return view;
    }

    public void setView(@NonNull View view) {
        this.view = view;
    }

}

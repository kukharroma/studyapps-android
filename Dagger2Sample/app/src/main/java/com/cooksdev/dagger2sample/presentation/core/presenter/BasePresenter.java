package com.cooksdev.dagger2sample.presentation.core.presenter;


import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

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

package com.cook.mvc_mvp_mvvp.mvp;

import com.cook.mvc_mvp_mvvp.mvp.impl.MvpModel;

/**
 * Created by roma on 16.02.16.
 */
public interface MvpIView {
    void showModel(MvpModel mvpModel);
    void hideModel(MvpModel mvpModel);
}

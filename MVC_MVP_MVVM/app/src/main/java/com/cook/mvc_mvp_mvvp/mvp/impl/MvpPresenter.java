package com.cook.mvc_mvp_mvvp.mvp.impl;

import com.cook.mvc_mvp_mvvp.mvp.MvpIPresenter;
import com.cook.mvc_mvp_mvvp.mvp.MvpIView;

/**
 * Created by roma on 16.02.16.
 */
public class MvpPresenter implements MvpIPresenter{

    private MvpIView view;

    public MvpPresenter(MvpIView view) {
        this.view = view;
    }

    @Override
    public void showModel() {
        MvpModel mvpModel = new MvpModel();
        mvpModel.setName("name");
        mvpModel.setAge(15);
        view.showModel(mvpModel);
    }

    @Override
    public void hideModel() {
        MvpModel mvpModel = new MvpModel();
        mvpModel.setName("name");
        mvpModel.setAge(15);
        view.hideModel(mvpModel);
    }
}

package com.cook.mvc_mvp_mvvp.mvp.impl;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.cook.mvc_mvp_mvvp.R;
import com.cook.mvc_mvp_mvvp.mvp.MvpIView;


/**
 * Created by roma on 16.02.16.
 */
public class MvpActivity extends AppCompatActivity implements MvpIView{

    private MvpPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mvp_activity);
        presenter = new MvpPresenter(this);
    }

    public void onShowClick(View view){
        presenter.showModel();
    }

    public void onHideClick(View view){
        presenter.hideModel();
    }

    @Override
    public void showModel(MvpModel mvpModel) {
        // show model
    }

    @Override
    public void hideModel(MvpModel mvpModel) {
        // hide model
    }
}

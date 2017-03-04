package com.luxurystyle.fragmentsbehaviour;


import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class TestFragment extends Fragment {

    @LayoutRes
    private int layoutRes;
    private static final String layout_res_key = "layout_res";

    public static TestFragment newInstance(@LayoutRes int layoutRes) {
        Bundle args = new Bundle();
        args.putInt(layout_res_key, layoutRes);

        TestFragment fragment = new TestFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.e(this.getClass().getSimpleName(), "onAttach()");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(this.getClass().getSimpleName(), "onCreate()");
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.e(this.getClass().getSimpleName(), "onCreateView()");
        return inflater.inflate(getArguments().getInt(layout_res_key), container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.e(this.getClass().getSimpleName(), "onCreate()");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.e(this.getClass().getSimpleName(), "onStart()");
    }



    @Override
    public void onStop() {
        super.onStop();
        Log.e(this.getClass().getSimpleName(), "onStop()");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(this.getClass().getSimpleName(), "onDestroy()");
    }
}

package com.itheima.mvplayer.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by jiajia on 2017/1/15.
 */

public abstract class BaseFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(getLayoutResId(),null);
        //绑定root的控件,BaseFragment的子类就不用再a绑定
        ButterKnife.bind(this,root);
        init();
        return root;
    }

    protected void init() {

    }


    public abstract int getLayoutResId();
}

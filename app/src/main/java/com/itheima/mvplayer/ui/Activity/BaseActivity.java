package com.itheima.mvplayer.ui.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by jiajia on 2017/1/15.
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getLayoutResID());
        //绑定View控件
        ButterKnife.bind(this);

        init();
    }

    /**
     * 子类如果要做初始化，可以覆写该方法
     *
     * 做Activity通用初始化
     */
    protected void init() {
    }

    /**
     * 子类必须去实现该方法，返回一个布局的资源id
     * @return
     */
    public abstract int getLayoutResID();
}

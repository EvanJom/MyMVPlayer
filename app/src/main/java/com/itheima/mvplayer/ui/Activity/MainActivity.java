package com.itheima.mvplayer.ui.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.itheima.mvplayer.R;

/**
 * 一.Splash界面
 * 1.设置图片适应屏幕
 * 2.清单界面主题全屏
 * --改写主题样式Theme.AppCompat.Light.NoActionBar,使其无NoActionBar;
 * 3.主题界面的图片进入退出动画;
 *
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}

package com.itheima.mvplayer.ui.Activity;


import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.itheima.mvplayer.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SplashActivity extends BaseActivity {

    @BindView(R.id.splash_image)
    ImageView mSplashImage;

    @Override
    public int getLayoutResID() {
        return R.layout.activity_splash;
    }

    @Override
    protected void init() {
        super.init();
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.splash_anim);
        //设置动画监听器,在动画开启之前
        animation.setAnimationListener(mAnimationListener);
        mSplashImage
                .startAnimation(animation);


    }

    private Animation.AnimationListener mAnimationListener = new Animation.AnimationListener() {
        @Override
        public void onAnimationStart(Animation animation) {

        }

        @Override
        public void onAnimationEnd(Animation animation) {
            Intent intent = new Intent(SplashActivity.this,MainActivity.class);
            startActivity(intent);
            //设置页面跳转的进入进出渐变效果
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
            finish();

        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}

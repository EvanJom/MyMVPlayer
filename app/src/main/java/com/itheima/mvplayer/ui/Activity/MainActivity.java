package com.itheima.mvplayer.ui.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.itheima.mvplayer.R;
import com.itheima.mvplayer.factory.FragmentFactory;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 一.Splash界面
 * 1.设置图片适应屏幕
 * 2.清单界面主题全屏
 * --改写主题样式Theme.AppCompat.Light.NoActionBar,使其无NoActionBar;
 * 3.主题界面的图片进入退出动画;
 * 二.主界面
 * 1.ActionBar栏创建菜单onCreateOptionsMenu,及点击事件(跳转到设置界面)
 * 2.底部Tab导航(开源库)
 * --确定tab,以及actionbar和底部颜色
 * --确定Tab选中和不选中的颜色
 * 3.布局的FrameLayout由四个xxxFragment来提供(使用FragmentManager来替换内容),每个xxxFragment由工厂提供唯一;
 * 1.创建四个xxxFragment类及工厂
 */
public class MainActivity extends BaseActivity {

    @BindView(R.id.main_fragment_container)
    FrameLayout mMainFragmentContainer;
    @BindView(R.id.main_bottomBar)
    BottomBar   mMainBottomBar;
    private FragmentManager mSupportFragmentManager;

    @Override
    public int getLayoutResID() {
        return R.layout.activity_main;
    }

    //在OnCreate的View视图之后
    @Override
    protected void init() {
        super.init();
        mSupportFragmentManager = getSupportFragmentManager();
        //设置Tab监听器
        mMainBottomBar.setOnTabSelectListener(mOnTabSelectListener);
    }

    private OnTabSelectListener mOnTabSelectListener = new OnTabSelectListener() {

        @Override
        public void onTabSelected(@IdRes int tabId) {
            FragmentTransaction fragmentTransaction = mSupportFragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.main_fragment_container, FragmentFactory.getInstance().getFragment(tabId));
            fragmentTransaction.commit();
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //通过id来区分不同菜单按钮的点击事件
        switch (item.getItemId()) {
            case R.id.setting:
                Intent intent = new Intent(this, SettingActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }


}

package com.itheima.mvplayer.factory;

import android.support.v4.app.Fragment;

import com.itheima.mvplayer.R;
import com.itheima.mvplayer.ui.fragment.HomeFragment;
import com.itheima.mvplayer.ui.fragment.MVFragment;
import com.itheima.mvplayer.ui.fragment.VbangFragment;
import com.itheima.mvplayer.ui.fragment.YueDanFragment;

/**
 * Created by jiajia on 2017/1/15.
 */
/**
 * 工厂模式， 更加不同条件（不同的输入），生产出不同的对象
 */

public class FragmentFactory {
    //单例模式，一个app中只维护一个实例（对象）
    private static FragmentFactory mFragmentFactory;
    //内存缓存 类的成员变量，存在内存当中
    private Fragment        mHomeFragment;
    private Fragment        mMVFragment;
    private Fragment        mVbangFragment;
    private Fragment        mYueDanFragment;


    private FragmentFactory() {
    }

    public static FragmentFactory getInstance() {
        if (mFragmentFactory == null) {
            synchronized (FragmentFactory.class) {
                if (mFragmentFactory == null) {
                    mFragmentFactory = new FragmentFactory();

                }
            }
        }
        return mFragmentFactory;
    }

    public Fragment getFragment(int tabId) {
        switch (tabId) {
            case R.id.tab_home:
                return getHomeFragment();
            case R.id.tab_mv:
                return getMVFragment();
            case R.id.tab_vbang:
                return getVbangFragment();
            case R.id.tab_yuedan:
                return getYueDanFragment();
        }
        return null;
    }

    private Fragment getHomeFragment() {

        if (mHomeFragment == null) {
            mHomeFragment = new HomeFragment();
        }
        return mHomeFragment;
    }

    private Fragment getMVFragment() {

        if (mMVFragment == null) {
            mMVFragment = new MVFragment();
        }
        return mMVFragment;
    }

    private Fragment getVbangFragment() {

        if (mVbangFragment == null) {
            mVbangFragment = new VbangFragment();
        }
        return mVbangFragment;
    }

    private Fragment getYueDanFragment() {

        if (mYueDanFragment == null) {
            mYueDanFragment = new YueDanFragment();
        }
        return mYueDanFragment;
    }


}

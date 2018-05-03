package com.rjr.mddemo.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.rjr.mddemo.BaseFragment;

import java.util.List;

/**
 * Created by Administrator on 2018/5/3.
 */

public class MyPageAdapter extends FragmentPagerAdapter {

    private List<BaseFragment> list;

    public MyPageAdapter(FragmentManager fm, List<BaseFragment> list) {
        super(fm);
        this.list = list;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}

package com.sandy.blog.resume.base;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.sandy.blog.resume.R;
import com.sandy.blog.resume.ui.adapter.BasePagerAdapter;

import butterknife.BindView;

/**
 * Created by Sandy Luo on 2017/1/29.
 */

public abstract class BasePagerFragment extends BaseFragment {

    @BindView(R.id.tab_layout)
    TabLayout mTabLayout;
    @BindView(R.id.pager)
    ViewPager mPager;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_blog;
    }

    @Override
    public void initView() {
    }

    @Override
    public void initData() {
        BasePagerAdapter basePagerAdapter = new BasePagerAdapter(getChildFragmentManager(), getActivity(), mTabLayout, mPager);
        setupAdapter(basePagerAdapter);

    }

    protected abstract void setupAdapter(BasePagerAdapter basePagerAdapter);

    protected Bundle getBundle(String args) {
        Bundle bundle = new Bundle();
        bundle.putString("key", args);
        return bundle;
    }


}

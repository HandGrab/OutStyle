package com.sandy.blog.resume.ui.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import com.sandy.blog.resume.model.PagerModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Sandy Luo on 2017/1/29.
 */

public class BasePagerAdapter extends FragmentStatePagerAdapter {

    private Context mContext;

    private List<PagerModel> mTabs = new ArrayList<>();
    private Map<String, Fragment> mFragments = new HashMap<>();
    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    public BasePagerAdapter(FragmentManager fragmentManager, Context context, TabLayout tabLayout, ViewPager viewPager) {
        super(fragmentManager);
        this.mContext = context;
        this.mTabLayout = tabLayout;
        this.mViewPager = viewPager;
        mViewPager.setAdapter(this);
        this.mTabLayout.setupWithViewPager(mViewPager);
        this.mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
    }

    @Override
    public Fragment getItem(int position) {
        PagerModel info = mTabs.get(position);
        Fragment fragment = mFragments.get(info.tag);
        if (fragment == null) {
            fragment = Fragment.instantiate(mContext, info.clazz.getName(), info.bundle);
            // 避免重复创建而进行缓存
            mFragments.put(info.tag, fragment);
        }

        return fragment;
    }

    @Override
    public int getCount() {
        return mTabs.size();
    }

    public void addTab(String title, String tag, Class<?> clazz, Bundle args) {
        PagerModel pagerModel = new PagerModel(title, tag, clazz, args);
        addFragment(pagerModel);
    }

    private void addFragment(PagerModel info) {
        if (info == null) {
            return;
        }
        mTabs.add(info);
        notifyDataSetChanged();
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return mTabs.get(position).getTitle();
    }
}

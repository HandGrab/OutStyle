package com.sandy.blog.resume.ui.fragment;

import com.sandy.blog.resume.R;
import com.sandy.blog.resume.base.BasePagerFragment;
import com.sandy.blog.resume.ui.adapter.BasePagerAdapter;

/**
 * Created by Sandy Luo on 2017/1/30.
 */

public class SkillPagerFragment extends BasePagerFragment {
    @Override
    protected void setupAdapter(BasePagerAdapter basePagerAdapter) {
        basePagerAdapter.addTab(mResource.getString(R.string.android_knowledge),
                "android_knowledge", DemoFragment.class, getBundle("安卓基础"));
        basePagerAdapter.addTab(mResource.getString(R.string.android_view),
                "android_view", DemoFragment.class, getBundle("界面"));
        basePagerAdapter.addTab(mResource.getString(R.string.android_storage),
                "android_storage", DemoFragment.class, getBundle("存储"));
        basePagerAdapter.addTab(mResource.getString(R.string.android_communication),
                "android_communication", DemoFragment.class, getBundle("通信"));
        basePagerAdapter.addTab(mResource.getString(R.string.android_design_model),
                "android_design_model", DemoFragment.class, getBundle("设计模式"));

    }
}

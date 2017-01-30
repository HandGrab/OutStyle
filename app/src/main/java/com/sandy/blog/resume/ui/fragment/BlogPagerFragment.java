package com.sandy.blog.resume.ui.fragment;

import com.sandy.blog.resume.base.BasePagerFragment;
import com.sandy.blog.resume.bundle.BlogBundle;
import com.sandy.blog.resume.bundle.BundleMarket;
import com.sandy.blog.resume.ui.adapter.BasePagerAdapter;

/**
 * Created by Sandy Luo on 2017/1/29.
 */

public class BlogPagerFragment extends BasePagerFragment {

    @Override
    protected void setupAdapter(BasePagerAdapter basePagerAdapter) {
        basePagerAdapter.addTab("六边形进度条", "magical_progress_bar", BlogContentFragment.class,
                BundleMarket.getMarket().getBlogBundle(BlogBundle.MAGICAL_PROGRESS_BAR));
        basePagerAdapter.addTab("GreenDao的使用", "use_green_dao", BlogContentFragment.class,
                BundleMarket.getMarket().getBlogBundle(BlogBundle.USE_GREEN_DAO));
    }
}

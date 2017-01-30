package com.sandy.blog.resume.mvp.present;

import com.sandy.blog.resume.R;
import com.sandy.blog.resume.mvp.view.IHomeView;
import com.sandy.blog.resume.ui.fragment.BlogPagerFragment;
import com.sandy.blog.resume.ui.fragment.ResumeFragment;

/**
 * Created by Sandy Luo on 2017/1/30.
 */

public class IHomePresentImpl implements IHomePresent {

    private IHomeView iHomeView;

    public IHomePresentImpl(IHomeView iHomeView) {
        this.iHomeView = iHomeView;
    }

    @Override
    public void showFragment(int resId) {
        switch (resId) {
            case R.id.nav_resume:
                iHomeView.showFragment(new ResumeFragment());
                break;
            case R.id.nav_blog:
                iHomeView.showFragment(new BlogPagerFragment());
                break;
            case R.id.nav_news:
                iHomeView.showFragment(new ResumeFragment());
                break;
            case R.id.nav_connect:
                iHomeView.showFragment(new ResumeFragment());
                break;
        }
    }
}

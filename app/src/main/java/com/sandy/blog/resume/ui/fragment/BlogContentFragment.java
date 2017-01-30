package com.sandy.blog.resume.ui.fragment;

import android.os.Bundle;
import android.webkit.WebView;

import com.sandy.blog.resume.R;
import com.sandy.blog.resume.base.BaseFragment;
import com.sandy.blog.resume.bundle.BlogBundle;
import com.sandy.blog.resume.bundle.BundleKey;

import butterknife.BindView;

/**
 * Created by Sandy Luo on 2017/1/30.
 */

public class BlogContentFragment extends BaseFragment{

    @BindView(R.id.blog_web_view)
    WebView mBlogWebView;
    private int blogFlag;

    @Override
    protected void processBeforeInitView() {
        super.processBeforeInitView();
        Bundle bundle = getArguments();
        blogFlag = bundle.getInt(BundleKey.BLOG);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_blog_content;
    }

    @Override
    public void initView() {
        mBlogWebView.getSettings().setJavaScriptEnabled(true);
    }

    @Override
    protected void initListener() {
    }

    @Override
    public void initData() {
        switch (blogFlag) {
            case BlogBundle.MAGICAL_PROGRESS_BAR:
                mBlogWebView.loadUrl("http://www.jianshu.com/p/fad5f4c2a3e8");
                break;
            case BlogBundle.USE_GREEN_DAO:
                mBlogWebView.loadUrl("http://www.jianshu.com/p/f080a372a0a1");
                break;
        }

    }


}

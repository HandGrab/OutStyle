package com.sandy.blog.resume.ui.fragment;

import android.os.Bundle;
import android.widget.TextView;

import com.sandy.blog.resume.R;
import com.sandy.blog.resume.base.BaseFragment;

import butterknife.BindView;

/**
 * Created by Sandy Luo on 2017/1/30.
 */

public class DemoFragment extends BaseFragment {

    @BindView(R.id.tv)
    TextView mTv;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_demo;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {
        Bundle bundle = getArguments();
        String content = bundle.getString("key");
        mTv.setText(content);
    }

}


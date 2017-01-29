package com.sandy.blog.resume.ui.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.sandy.blog.resume.R;
import com.sandy.blog.resume.base.BaseFragment;
import com.sandy.blog.resume.data.DataHelper;
import com.sandy.blog.resume.model.HomeModel;
import com.sandy.blog.resume.ui.adapter.HomeAdapter;

import java.util.List;

import butterknife.BindView;

/**
 * Created by Sandy Luo on 2017/1/27.
 */

public class HomeFragment extends BaseFragment {

    @BindView(R.id.home_content_rv)
    RecyclerView mHomeContentRv;

    private List<HomeModel> mData;
    private HomeAdapter mHomeAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_resume;
    }

    @Override
    public void initView() {
        mHomeContentRv.setLayoutManager(new LinearLayoutManager(mContext));
    }

    @Override
    public void initData() {
        mData = DataHelper.getInstance().getHomeData();
        mHomeAdapter = new HomeAdapter(mContext, mData);
        mHomeContentRv.setAdapter(mHomeAdapter);
    }


}

package com.sandy.blog.resume.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.sandy.blog.resume.ui.UIInterface;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Sandy Luo on 2016/12/8.
 */

public abstract class BaseFragment extends Fragment implements UIInterface {
    protected String TAG = getClass().getSimpleName();

    protected Context mContext;
    protected View mView;
    private Unbinder unbinder;


    public BaseFragment() {
;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
        processBeforeInitView();
    }

    protected void processBeforeInitView() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (getLayoutId() != -1) {
            mView = inflater.inflate(getLayoutId(), null);
            unbinder = ButterKnife.bind(this, mView);
        }
        return mView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        initData();
        initListener();
    }


    protected void initListener() {
    }

    protected int getLayoutId() {
        return -1;
    }

    /**
     * 调准到另外一个Activity
     *
     * @param clazz 对应的字节码
     */
    protected void skipAnotherActivity(Class<?> clazz) {
        Intent intent = new Intent(mContext, clazz);
        ;
        startActivity(intent);
    }

    protected void skipAnotherActivity(Bundle bundle, Class<?> clazz) {
        Intent intent = new Intent(mContext, clazz);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    protected void showToast(String msg) {
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (unbinder != null) {
            unbinder.unbind();
        }
    }
}

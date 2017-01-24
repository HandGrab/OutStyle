package com.sandy.blog.resume.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TextView;

import com.sandy.blog.resume.R;
import com.sandy.blog.resume.app.AppManager;
import com.sandy.blog.resume.ui.UIInterface;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Sandy Luo on 2017/1/24.
 */

public abstract class BaseActivity extends AppCompatActivity implements UIInterface {

    public String TAG = getClass().getSimpleName();
    private Unbinder unbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(TAG, "onCreate");
        AppManager.getAppManager().addActivity(this);
        processBeforeInitView();
        if (getLayoutId() != -1) {
            setContentView(getLayoutId());
            unbinder = ButterKnife.bind(this);
        }

        if (hasTitle()) {
            initBackBar();
        }

        initView();
        initData();
        initListener();
    }

    /**
     * 在界面初始化前处理
     */
    protected void processBeforeInitView() {
    }

    /**
     * 通过xml填充布局
     */
    protected int getLayoutId() {
        return -1;
    }

    /**
     * 是否有标题栏
     */
    private boolean hasTitle() {
        return findViewById(R.id.title_bar) != null;
    }

    /**
     * 初始化标题栏
     */
    protected void initBackBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.title_bar);
        TextView title = (TextView) findViewById(R.id.tv_title);
        if (setCenterTitle() != -1) {
            title.setText(setCenterTitle());
        }

        if (setTitleColor() != -1) {
            toolbar.setBackgroundColor(setTitleColor());
        }

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    /**
     * 设置中央title的颜色
     */
    private int setCenterTitle() {
        return -1;
    }

    /**
     * 设置title颜色
     */
    protected int setTitleColor() {
        return -1;
    }

    /**
     * 初始化监听
     */
    protected void initListener() {
    }


    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(TAG, "onRestoreInstanceState");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
        AppManager.getAppManager().finishActivity();
        if (unbinder != null) {
            unbinder.unbind();
        }
    }


}


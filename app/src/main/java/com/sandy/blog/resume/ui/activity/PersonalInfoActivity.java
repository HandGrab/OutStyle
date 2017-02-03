package com.sandy.blog.resume.ui.activity;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.sandy.blog.resume.R;
import com.sandy.blog.resume.base.BaseActivity;

import butterknife.BindView;

/**
 * Created by Sandy Luo on 2017/1/29.
 */

public class PersonalInfoActivity extends BaseActivity implements AppBarLayout.OnOffsetChangedListener {

    @BindView(R.id.personal_title)
    Toolbar mPersonalTitle;
    @BindView(R.id.personal_image)
    ImageView mPersonalImage;
    @BindView(R.id.personal_collapsing_toolbar)
    CollapsingToolbarLayout mPersonalCollapsingToolbar;
    @BindView(R.id.personal_user_icon)
    ImageView mPersonalUserIcon;
    @BindView(R.id.personal_app_bar)
    AppBarLayout mPersonalAppBar;

    private static final int PERCENTAGE_TO_ANIMATE_AVATAR = 20;

    private boolean mIsAvatarShown = true;

    private int mMaxScrollSize;


    @Override
    protected void processBeforeInitView() {
        super.processBeforeInitView();
        hideStatusBar();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_personal_info;
    }

    @Override
    public void initView() {
        mPersonalCollapsingToolbar.setTitle("呵呵");
    }

    @Override
    public void initData() {
    }

    @Override
    protected void initListener() {
        super.initListener();
        mPersonalAppBar.addOnOffsetChangedListener(this);
    }

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
        if (mMaxScrollSize == 0)
            mMaxScrollSize = appBarLayout.getTotalScrollRange();

        int percentage = (Math.abs(verticalOffset)) * 100 / mMaxScrollSize;

        if (percentage >= PERCENTAGE_TO_ANIMATE_AVATAR && mIsAvatarShown) {
            mIsAvatarShown = false;
            mPersonalUserIcon.animate().scaleY(0).scaleX(0).setDuration(200).start();
        }

        if (percentage <= PERCENTAGE_TO_ANIMATE_AVATAR && !mIsAvatarShown) {
            mIsAvatarShown = true;

            mPersonalUserIcon.animate()
                    .scaleY(1).scaleX(1)
                    .start();
        }
    }


}

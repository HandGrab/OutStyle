package com.sandy.blog.resume.ui.activity;

import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.sandy.blog.resume.R;
import com.sandy.blog.resume.base.BaseActivity;
import com.sandy.blog.resume.mvp.present.IHomePresentImpl;
import com.sandy.blog.resume.mvp.view.IHomeView;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Sandy Luo on 2017/1/24.
 */

public class HomeActivity extends BaseActivity implements IHomeView, NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.home_bar)
    Toolbar mHomeBar;
    @BindView(R.id.home_fab)
    FloatingActionButton mHomeFab;
    @BindView(R.id.home_navigation_view)
    NavigationView mHomeNavigationView;
    @BindView(R.id.home_drawer_layout)
    DrawerLayout mHomeDrawerLayout;
    private IHomePresentImpl iHomePresent;

    @Override
    protected int getLayoutId() {
        return R.layout.home_activity;
    }

    @Override
    public void initView() {
        setSupportActionBar(mHomeBar);
    }

    @Override
    public void initData() {
        iHomePresent = new IHomePresentImpl(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mHomeDrawerLayout, mHomeBar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mHomeDrawerLayout.setDrawerListener(toggle);
        toggle.syncState();
        mHomeNavigationView.setCheckedItem(R.id.nav_resume);
        iHomePresent.showFragment(R.id.nav_resume);

    }

    @Override
    protected void initListener() {
        mHomeNavigationView.setNavigationItemSelectedListener(this);
    }

    @OnClick(R.id.home_fab)
    public void onClick() {

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        mHomeDrawerLayout.closeDrawer(GravityCompat.START);
        iHomePresent.showFragment(item.getItemId());
        return true;
    }


    @Override
    public void showFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.content_main, fragment).commit();
    }
}

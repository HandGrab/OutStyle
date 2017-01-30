package com.sandy.blog.resume.ui.activity;

import com.sandy.blog.resume.R;
import com.sandy.blog.resume.base.BaseActivity;
import com.sandy.blog.resume.ui.fragment.SkillPagerFragment;

/**
 * Created by Sandy Luo on 2017/1/30.
 */

public class PersonalSkillActivity extends BaseActivity{


    @Override
    protected int getLayoutId() {
        return R.layout.activity_personal_kill;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.personal_skill_content, new SkillPagerFragment())
                .commit();
    }
}

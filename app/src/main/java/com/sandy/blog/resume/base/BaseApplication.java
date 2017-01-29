package com.sandy.blog.resume.base;

import android.app.Application;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by Sandy Luo on 2017/1/24.
 */

public class BaseApplication extends Application {

    private static Context mContext;

    @Override
    public void onCreate(){
        super.onCreate();
        mContext = getApplicationContext();
        Fresco.initialize(this);
    }

    public static Context getContext() {
        return mContext;
    }

    /**
     * 设置主题样式
     */
    public void setThemeRes(int themeId) {
        setTheme(themeId);
    }
}

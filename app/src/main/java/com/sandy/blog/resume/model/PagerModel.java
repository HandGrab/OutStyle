package com.sandy.blog.resume.model;

import android.os.Bundle;

/**
 * Created by Sandy Luo on 2017/1/29.
 */

public class PagerModel {
    public String tag;
    public String title;
    public Class<?> clazz;
    public Bundle bundle;

    public PagerModel(String title, String tag, Class<?> clazz, Bundle bundle) {
        this.title = title;
        this.tag = tag;
        this.clazz = clazz;
        this.bundle = bundle;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Class<?> getClazz() {
        return clazz;
    }

    public void setClazz(Class<?> clazz) {
        this.clazz = clazz;
    }

    public Bundle getBundle() {
        return bundle;
    }

    public void setBundle(Bundle bundle) {
        this.bundle = bundle;
    }
}
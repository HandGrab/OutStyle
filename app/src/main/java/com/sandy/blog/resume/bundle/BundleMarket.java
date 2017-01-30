package com.sandy.blog.resume.bundle;

import android.os.Bundle;

/**
 * Created by Sandy Luo on 2017/1/30.
 */

public class BundleMarket {

    private static BundleMarket bundleMarket;

    public static BundleMarket getMarket() {
        if (bundleMarket == null) {
            bundleMarket = new BundleMarket();
        }
        return bundleMarket;
    }

    /**
     * 获取博客的Bundle
     *
     * @param value 对应的值
     */
    public Bundle getBlogBundle(int value) {
        Bundle bundle = new Bundle();
        bundle.putInt(BundleKey.BLOG, value);
        return bundle;
    }


}

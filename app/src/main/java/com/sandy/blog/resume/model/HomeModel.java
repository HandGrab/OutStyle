package com.sandy.blog.resume.model;

/**
 * Created by Sandy Luo on 2017/1/27.
 */

public class HomeModel {
    /**
     * 资源文件的id
     */
    private int ImageRes;

    /**
     * 对应的tag
     */
    private String itemTag;


    public HomeModel(int imageRes, String itemTag) {
        ImageRes = imageRes;
        this.itemTag = itemTag;
    }

    public int getImageRes() {
        return ImageRes;
    }

    public void setImageRes(int imageRes) {
        ImageRes = imageRes;
    }

    public String getItemTag() {
        return itemTag;
    }

    public void setItemTag(String itemTag) {
        this.itemTag = itemTag;
    }
}

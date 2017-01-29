package com.sandy.blog.resume.data;

import android.content.res.Resources;

import com.sandy.blog.resume.R;
import com.sandy.blog.resume.base.BaseApplication;
import com.sandy.blog.resume.model.HomeModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sandy Luo on 2017/1/27.
 */

public class DataHelper {

    private Resources resources = BaseApplication.getContext().getResources();

    private static DataHelper instance;

    public static DataHelper getInstance(){
        if(instance == null){
            instance = new DataHelper();
        }
        return instance;
    }

    public List<HomeModel> getHomeData() {
        List<HomeModel> data = new ArrayList<>();
        data.add(new HomeModel(R.mipmap.user, resources.getString(R.string.base_info)));
        data.add(new HomeModel(R.mipmap.folder,resources.getString(R.string.work_experience)));
        data.add(new HomeModel(R.mipmap.phone, resources.getString(R.string.project_experience)));
        data.add(new HomeModel(R.mipmap.star, resources.getString(R.string.personal_skills)));
        return data;
    }
}

package com.example.news;

import android.app.Application;

import cn.bmob.v3.Bmob;

/**
 * Created by 李志军 on 2017/5/22.
 */

public class NewsApplication extends Application{

    public void onCreate(){
        super.onCreate();
        Bmob.initialize(this,"3c0991156eb3611d2c58569bbc2bb2de");
    }
}

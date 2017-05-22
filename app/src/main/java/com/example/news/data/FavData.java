package com.example.news.data;

import cn.bmob.v3.BmobObject;

/**
 * Created by 李志军 on 2017/5/22.
 */

public class FavData extends BmobObject{
    String phone;
    String newsKey;
    String newsTitle;
    String newsUrl;
    boolean ifFav;
}

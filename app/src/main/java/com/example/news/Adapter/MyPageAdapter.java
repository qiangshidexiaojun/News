package com.example.news.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.news.Fragment.NewsFragment;

import java.util.ArrayList;

/**
 * Created by 李志军 on 2017/5/18.
 */
public class MyPageAdapter extends FragmentPagerAdapter{

    private ArrayList<NewsFragment>mFragmentArrayList;
    private ArrayList<String>mTitleList;


    public MyPageAdapter(FragmentManager fm,ArrayList<NewsFragment>fragmentArrayList,ArrayList<String>titleList) {
        super(fm);
        this.mFragmentArrayList = fragmentArrayList;
        this.mTitleList = titleList;
    }

    @Override
    public Fragment getItem(int position) {
        if(position < mFragmentArrayList.size()){
            return mFragmentArrayList.get(position);
        }
        return null;
    }

    @Override
    public int getCount() {
        if(mFragmentArrayList == null){
            return 0;
        }
        return mFragmentArrayList.size();
    }

    public CharSequence getPageTitle(int position){
        if(mTitleList != null && position < mTitleList.size()){
            return mTitleList.get(position);
        }
        return  "notitle";
    }

}

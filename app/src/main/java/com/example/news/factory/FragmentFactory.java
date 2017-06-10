package com.example.news.factory;

import android.support.v4.app.Fragment;

import com.example.news.Fragment.JokeFragment;
import com.example.news.Fragment.MyFragment;
import com.example.news.Fragment.WeatherFragment;
import com.example.news.R;
import com.example.news.activity.MainActivity;

/**
 * Created by 李志军 on 2017/6/1.
 */

public class FragmentFactory {

    private static FragmentFactory sFragmentFactory;
    private Fragment mConversationFragment;
    private JokeFragment mJokeFragment;
    private MainActivity mMainActivity;
    private MyFragment mMyFragment;
    private WeatherFragment mWeatherFragment;

    private FragmentFactory(){

    }

    public static FragmentFactory getInstance(){
        if(sFragmentFactory == null){
            synchronized (FragmentFactory.class){
                if(sFragmentFactory == null){
                    sFragmentFactory = new FragmentFactory();
                }
            }
        }
        return sFragmentFactory;
    }

    public Fragment getFragment(int tabId) {
        switch (tabId) {
            /*case R.id.tab_news:
                return getMainActivity();*/
            case R.id.tab_weather:
                return getWeatherFragment();
            case R.id.tab_joke:
                return getJokeFragment();
            case R.id.tab_me:
                return getMyFragment();
        }
        return null;
    }

    public MainActivity getMainActivity() {
        if(mMainActivity == null){
            mMainActivity = new MainActivity();
        }
        return mMainActivity;
    }

    public WeatherFragment getWeatherFragment() {
        if(mWeatherFragment == null){
            mWeatherFragment = new WeatherFragment();
        }
        return mWeatherFragment;
    }

    public JokeFragment getJokeFragment() {
        if(mJokeFragment == null){
            mJokeFragment = new JokeFragment();
        }
        return mJokeFragment;
    }

    public Fragment getMyFragment() {
        if(mMyFragment == null){
            mMyFragment = new MyFragment();
        }
        return mMyFragment;
    }
}

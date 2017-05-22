package com.example.news.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.news.Adapter.MyPageAdapter;
import com.example.news.Fragment.NewsFragment;
import com.example.news.R;

import java.util.ArrayList;

public class MainActivity extends FragmentActivity {
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private MyPageAdapter mPageAdapter;
    private ArrayList<NewsFragment> mFragmentArrayList = new ArrayList<NewsFragment>();
    private ArrayList<String> mTitleList = new ArrayList<String>();

    private TextView mTitle;
    private ImageView search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initFragmentArrayList();
        initTitleList();

        mTabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);

        mPageAdapter = new MyPageAdapter(getSupportFragmentManager(), mFragmentArrayList, mTitleList);
        mViewPager.setAdapter(mPageAdapter);
        mViewPager.setOffscreenPageLimit(4);

        mTabLayout.setupWithViewPager(mViewPager);


        mTitle = (TextView) findViewById(R.id.title);
        mTitle.setText("News");
        search = (ImageView) findViewById(R.id.search);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "搜索中...", Toast.LENGTH_LONG).show();
            }
        });


    }

    private void initTitleList() {
        mTitleList.add("头条");
        mTitleList.add("娱乐");
        mTitleList.add("体育");
        mTitleList.add("科技");
    }

    private void initFragmentArrayList() {

        NewsFragment ftop = new NewsFragment();
        Bundle bundletop = new Bundle();
        bundletop.putInt("NEWSTYPE",1);
        ftop.setArguments(bundletop);

        NewsFragment fyule = new NewsFragment();
        Bundle bundleyule = new Bundle();
        bundleyule.putInt("NEWSTYPE",2);
        fyule.setArguments(bundleyule);

        NewsFragment ftiyu = new NewsFragment();
        Bundle bundletiyu = new Bundle();
        bundletiyu.putInt("NEWSTYPE",3);
        ftiyu.setArguments(bundletiyu);

        NewsFragment fkeji = new NewsFragment();
        Bundle bundlekeji = new Bundle();
        bundlekeji.putInt("NEWSTYPE",4);
        fkeji.setArguments(bundlekeji);

        mFragmentArrayList.add(ftop);
        mFragmentArrayList.add(fyule);
        mFragmentArrayList.add(ftiyu);
        mFragmentArrayList.add(fkeji);


    }
}

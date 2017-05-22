package com.example.news.Adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.news.activity.ReadActivity;
import com.example.news.data.NewsData;
import com.example.news.R;

import java.util.List;

/**
 * Created by 李志军 on 2017/5/18.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsViewHolder>{

    private List<NewsData.ResultBean.NewsBean> mNewsList;

    public  NewsAdapter(List<NewsData.ResultBean.NewsBean> newsList){
        this.mNewsList = newsList;
    }


    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news,parent,false);
        NewsViewHolder holder = new NewsViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final NewsViewHolder holder, int position) {
        final NewsData.ResultBean.NewsBean news = mNewsList.get(position);
        holder.titleView.setText(news.getTitle());
        Glide.with(holder.imgView.getContext())
                .load(news.getThumbnail_pic_s())
                .into(holder.imgView);

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = news.getUrl();
                Intent intent = new Intent(holder.view.getContext(), ReadActivity.class);
                intent.putExtra(ReadActivity.URL_EXTRA,url);
                intent.putExtra(ReadActivity.KEY_EXTRA,news.getUniquekey());
                intent.putExtra(ReadActivity.TITLE_EXTRA,news.getTitle());
                holder.view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mNewsList.size();
    }

    public void changeData(List<NewsData.ResultBean.NewsBean> newsList){
        this.mNewsList = newsList;
        notifyDataSetChanged();
    }
}

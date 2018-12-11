package com.example.haoliu.youtubeappp.Adaters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.haoliu.youtubeappp.Model.YoutubeDataModel;
import com.example.haoliu.youtubeappp.R;

import java.util.ArrayList;

public class VideoPostAdapter extends RecyclerView.Adapter<VideoPostAdapter.YoutubePostHolder> {

    private ArrayList<YoutubeDataModel> dataSet;
    private Context mContext = null;

    public VideoPostAdapter(ArrayList<YoutubeDataModel> dataSet, Context mContext) {
        this.dataSet = dataSet;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public YoutubePostHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.youtube_post_layout, viewGroup, false);
        YoutubePostHolder postHolder = new YoutubePostHolder(view);
        return postHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull YoutubePostHolder youtubePostHolder, int i) {
        TextView textViewTitle = youtubePostHolder.textViewTitle;
        TextView textViewDes = youtubePostHolder.textViewDes;
        TextView textViewDate = youtubePostHolder.textViewDate;
        ImageView ImageThumb = youtubePostHolder.ImageThumb;
        YoutubeDataModel Object = dataSet.get(i);
        textViewTitle.setText(Object.getTitle());
        textViewTitle.setText(Object.getDescription());
        textViewTitle.setText(Object.getPublishedAt());

    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public static class YoutubePostHolder extends RecyclerView.ViewHolder {
        TextView textViewTitle;
        TextView textViewDes;
        TextView textViewDate;
        ImageView ImageThumb;


        public YoutubePostHolder(@NonNull View itemView) {
            super(itemView);
            this.textViewTitle = (TextView) itemView.findViewById(R.id.textViewTitle);
            this.textViewDes = (TextView) itemView.findViewById(R.id.textViewDes);
            this.textViewDate = (TextView) itemView.findViewById(R.id.textViewDate);
            this.ImageThumb = (ImageView) itemView.findViewById(R.id.ImageThumb);
        }
    }
}

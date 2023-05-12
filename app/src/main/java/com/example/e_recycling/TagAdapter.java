package com.example.e_recycling;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TagAdapter extends RecyclerView.Adapter<TagAdapter.ViewHolder> {
    private List<Tag> mTagList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView tagImage;

        public ViewHolder(View view){
            super(view);
            tagImage=(ImageView) view.findViewById(R.id.tag_image);
        }
    }

    public TagAdapter(List<Tag> tagList){
        mTagList=tagList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.tag_item,parent,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder,int position){
        Tag tag=mTagList.get(position);
        holder.tagImage.setImageResource(tag.getImageId());
    }

    @Override
    public int getItemCount(){
        return mTagList.size();
    }

}

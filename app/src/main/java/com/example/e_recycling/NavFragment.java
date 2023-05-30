package com.example.e_recycling;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NavFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view =inflater.inflate(R.layout.nav_fragment,container,false);
        RecyclerView recyclerView=(RecyclerView) view.findViewById(R.id.nav);
        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        TagAdapter adapter=new TagAdapter(getTags());
        recyclerView.setAdapter(adapter);
        return  view;

    }

     private List<Tag> getTags(){
         LinearLayout.LayoutParams params1=new LinearLayout.LayoutParams(120,120);
         LinearLayout.LayoutParams params2=new LinearLayout.LayoutParams(180,180);
        List<Tag> tagList=new ArrayList<>();
        Tag favorites=new Tag(R.drawable.vector1,View.VISIBLE,params1,"Favorite");
        tagList.add(favorites);
        Tag news=new Tag(R.drawable.vector2,View.VISIBLE,params1,"Search");
        tagList.add(news);
        Tag main=new Tag(R.drawable.vector3,View.GONE,params2,"");
        tagList.add(main);
        Tag location=new Tag(R.drawable.vector4,View.VISIBLE,params1,"Station");
        tagList.add(location);
        Tag personalCenter=new Tag(R.drawable.vector5,View.VISIBLE,params1,"Me");
        tagList.add(personalCenter);
        return tagList;
    }
    class TagAdapter extends RecyclerView.Adapter<TagAdapter.ViewHolder> {
        private List<Tag> mTagList;
        class ViewHolder extends RecyclerView.ViewHolder{
            ImageView tagImage;
            TextView tagText;

            public ViewHolder(View view){
                super(view);
                tagImage=(ImageView) view.findViewById(R.id.tag_image);
                tagText=(TextView) view.findViewById(R.id.tag_text);

            }
        }

        public TagAdapter(List<Tag> tagList){
            mTagList=tagList;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
            View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.tag_item,parent,false);
            ViewHolder holder=new ViewHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position){
            Tag tag=mTagList.get(position);
            holder.tagText.setText(tag.getContent());
            holder.tagText.setVisibility(tag.getTextVisibility());
            holder.tagImage.setLayoutParams(tag.getParams());
            holder.tagImage.setImageResource(tag.getImageId());
        }

        @Override
        public int getItemCount(){
            return mTagList.size();
        }

    }
}

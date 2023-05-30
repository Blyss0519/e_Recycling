package com.example.e_recycling;

import android.widget.LinearLayout;

public class Tag {
    private int imageId;
    private LinearLayout.LayoutParams params;
    private int textVisibility;
    private String content;
    public Tag(int imageId,int textVisibility,String content){
        this.imageId=imageId;
        this.textVisibility=textVisibility;
        this.content=content;
    }

    public Tag(int imageId,int textVisibility,LinearLayout.LayoutParams params,String content){
        this.imageId=imageId;
        this.textVisibility=textVisibility;
        this.params=params;
        this.content=content;
    }


    public int getImageId() {
        return imageId;
    }
    public int getTextVisibility(){return textVisibility;}
    public LinearLayout.LayoutParams getParams() {
        return params;
    }

    public String getContent() {
        return content;
    }
}

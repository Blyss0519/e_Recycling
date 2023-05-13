package com.example.e_recycling;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.security.cert.CertificateRevokedException;
import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {
    private List<Tag> tagList=new ArrayList<>();
    public static final int TAKE_PHOTO=1;
    private ImageView picture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main2_layout);
        initsTags();
        RecyclerView recyclerView=(RecyclerView) findViewById(R.id.nav);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        TagAdapter adapter=new TagAdapter(tagList);
        recyclerView.setAdapter(adapter);
    }

    public void initsTags(){
        Tag favorites=new Tag(R.drawable.vector1);
        tagList.add(favorites);
        Tag news=new Tag(R.drawable.vector2);
        tagList.add(news);
        Tag main=new Tag(R.drawable.vector3);
        tagList.add(main);
        Tag location=new Tag(R.drawable.vector4);
        tagList.add(location);
        Tag personalCenter=new Tag(R.drawable.vector5);
        tagList.add(personalCenter);
    }
}

package com.example.e_recycling;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageButton;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {
    private List<Tag> tagList=new ArrayList<>();
    public static final int TAKE_PHOTO=1;
    private Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main2_layout);
        initsTags();
        ImageButton takePhoto=(ImageButton) findViewById(R.id.take_photo);
        ImageButton picture=(ImageButton) findViewById(R.id.choose_from_album);
        RecyclerView recyclerView=(RecyclerView) findViewById(R.id.nav);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        TagAdapter adapter=new TagAdapter(tagList);
        recyclerView.setAdapter(adapter);
        takePhoto.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //创建File对象，用于储存拍照后的图片
                File outputImage = new File(getExternalCacheDir(),
                        "output_img.jpg");
                try{
                    if(outputImage.exists()){
                        outputImage.delete();
                    }
                    outputImage.createNewFile();
                }catch (IOException e){
                    e.printStackTrace();
                }
                if(Build.VERSION.SDK_INT>=24){
                    imageUri = FileProvider.getUriForFile(Main2Activity.this,"com.example.cameraalbumtest.fileprovider",outputImage);
                }else{
                    imageUri =Uri.fromFile(outputImage);
                }
                //启动相机程序
                Intent intent =new Intent("android.media.action.IMAGE_CAPTURE");
                intent.putExtra(MediaStore.EXTRA_OUTPUT,imageUri);
                startActivityForResult(intent,TAKE_PHOTO);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        switch(requestCode){
            case TAKE_PHOTO:
                if(resultCode== RESULT_OK){
                    try{
                        //将拍摄的照片作为参数传入图像识别方法
                        Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(imageUri));
                        //将拍摄的照片在图像识别结果界面显示出来
                    }catch (FileNotFoundException e){
                        e.printStackTrace();
                    }
                }
        }
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

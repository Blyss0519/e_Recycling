package com.example.e_recycling;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class camera_MainActivity<uri> extends AppCompatActivity {
    private VideoView mVideoView;
    private Button playBtn, stopBtn;
    MediaController mMediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.hide();
        }
        //为ImageButton的点击事件注册一个监听器
        ImageView bt_search = findViewById(R.id.img2);
        ImageView bt_favorate = findViewById(R.id.img1);
        ImageView bt_station = findViewById(R.id.img4);


        //外部类
        bt_search.setOnClickListener(new View.OnClickListener() {
            @Override
            //匿名内部类，每当点击icon时，就会执行监听器中的onClick()方法
            public void onClick(View v) {
                //创建一个意图对象
                Intent intent = new Intent();
                //传上下文。当前语境中的上下文为MainActivity.this
                intent.setClass(camera_MainActivity.this,MainActivity2.class);
                startActivity(intent);
            }
        });
        //外部类
        bt_favorate.setOnClickListener(new View.OnClickListener() {
            @Override
            //匿名内部类，每当点击icon时，就会执行监听器中的onClick()方法
            public void onClick(View v) {
                //创建一个意图对象
                Intent intent = new Intent();
                //传上下文。当前语境中的上下文为MainActivity.this
                intent.setClass(camera_MainActivity.this,MainActivity3.class);
                startActivity(intent);
            }
        });
        //外部类
        bt_station.setOnClickListener(new View.OnClickListener() {
            @Override
            //匿名内部类，每当点击icon时，就会执行监听器中的onClick()方法
            public void onClick(View v) {
                //创建一个意图对象
                Intent intent = new Intent();
                //传上下文。当前语境中的上下文为MainActivity.this
                intent.setClass(camera_MainActivity.this,MainActivity4.class);
                startActivity(intent);
            }
        });

        mVideoView = new VideoView(this);
        mVideoView = (VideoView) findViewById(R.id.video);
        mMediaController = new MediaController(this);
        playBtn = (Button) findViewById(R.id.playbutton);
        stopBtn = (Button) findViewById(R.id.stopbutton);
        playBtn.setOnClickListener(new mClick());
        stopBtn.setOnClickListener(new mClick());

    }
    class mClick implements View.OnClickListener {

        public void onClick(View v) {
            String uri = "android.resource://" + getPackageName() + "/" + R.raw.video;
            mVideoView.setVideoURI(Uri.parse(uri));
            mMediaController.setMediaPlayer(mVideoView);
            mVideoView.setMediaController(mMediaController);
            if (v == playBtn) {
                mVideoView.start();
            } else if (v == stopBtn) {
                mVideoView.stopPlayback();
            }
        }
    }


}
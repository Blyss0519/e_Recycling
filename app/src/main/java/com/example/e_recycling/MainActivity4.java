package com.example.e_recycling;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.station_page);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.hide();
        }
        //为ImageButton的点击事件注册一个监听器
        ImageView bt_camera = findViewById(R.id.img7);
        ImageView bt_search = findViewById(R.id.img6);
        ImageView bt_favorite = findViewById(R.id.img5);

        //外部类
        bt_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            //匿名内部类，每当点击icon时，就会执行监听器中的onClick()方法
            public void onClick(View v) {
                //创建一个意图对象
                Intent intent = new Intent();
                //传上下文。当前语境中的上下文为MainActivity.this
                intent.setClass(MainActivity4.this,MainActivity.class);
                startActivity(intent);
            }
        });
        //外部类
        bt_search.setOnClickListener(new View.OnClickListener() {
            @Override
            //匿名内部类，每当点击icon时，就会执行监听器中的onClick()方法
            public void onClick(View v) {
                //创建一个意图对象
                Intent intent = new Intent();
                //传上下文。当前语境中的上下文为MainActivity.this
                intent.setClass(MainActivity4.this,MainActivity2.class);
                startActivity(intent);
            }
        });
        //外部类
        bt_favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            //匿名内部类，每当点击icon时，就会执行监听器中的onClick()方法
            public void onClick(View v) {
                //创建一个意图对象
                Intent intent = new Intent();
                //传上下文。当前语境中的上下文为MainActivity.this
                intent.setClass(MainActivity4.this,MainActivity3.class);
                startActivity(intent);
            }
        });
    }
}
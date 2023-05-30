package com.example.e_recycling;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import org.litepal.tablemanager.Connector;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        handler.sendEmptyMessageDelayed(0,1000);
        Connector.getDatabase();


    }

    //创建匿名内部类
    private Handler handler=new Handler(){

        @Override
        public void handleMessage(Message msg){
            super.handleMessage(msg);
            getWelcome();
        }
    };

    //启动WelcomeActivity
    public void getWelcome(){
        Intent intent=new Intent(MainActivity.this, PersonalCenterActivity.class);
//        Intent intent=new Intent(MainActivity.this,WelcomeActivity.class);
        startActivity(intent);
        finish();
    }

}

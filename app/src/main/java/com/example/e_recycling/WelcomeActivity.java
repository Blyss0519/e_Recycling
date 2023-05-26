package com.example.e_recycling;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_layout);
        ImageButton button1=(ImageButton) findViewById(R.id.login_by_tel);
        ImageButton button2=(ImageButton) findViewById(R.id.login_by_wechat);
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent=new Intent(WelcomeActivity.this,Login1Activity.class);
                startActivity(intent);
            }
        });
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent=new Intent(WelcomeActivity.this,Login2Activity.class);
                startActivity(intent);
            }
        });
    }
}

package com.example.e_recycling;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.opengl.ETC1;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import org.litepal.LitePal;

import java.util.List;

public class Login1Activity extends AppCompatActivity {
    private EditText telEdit;
    private EditText passwordEdit;
    private ImageButton login;
    private List<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login1_layout);
        telEdit=(EditText) findViewById(R.id.tel);
        passwordEdit=(EditText) findViewById(R.id.password);
        login=(ImageButton) findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View v){
               String tel=telEdit.getText().toString();
               String password=passwordEdit.getText().toString();
               users= LitePal.where("tel=?",tel).find(User.class);
               //输入错误，重新输入
               if(!isValid(tel,password)){
                   Toast.makeText(Login1Activity.this,"Phone number or password is invalid",Toast.LENGTH_SHORT).show();
                   telEdit.setText("");
                   passwordEdit.setText("");

               }
               //用户不存在且密码和手机号是合规的，注册并登入
               else if(users.isEmpty()){
                   addData(tel,password);
                   Intent intent=new Intent(Login1Activity.this,Main2Activity.class);
                   startActivity(intent);
                   finish();
               }
               //存在用户且密码正确，登入
               else if(isCorrect(users.get(0),password)){
                   Intent intent=new Intent(Login1Activity.this,Main2Activity.class);
                   startActivity(intent);
                   finish();
               }

           }
        });
    }

    //添加新用户
    public void addData(String tel,String password){
        User newUser=new User();
        newUser.setTel(tel);
        newUser.setPassword(password);
        newUser.save();
    }

    //电话号码要是11位数字，密码要8-16位
    public boolean isValid(String tel,String password){
        return (tel.matches("[0-9]{11}")&&password.matches(".{8,16}"));
    }

    //判断密码是否正确
    public boolean isCorrect(User u,String password){
        return u.getPassword().equals(password);
    }
}

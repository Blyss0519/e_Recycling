package com.example.e_recycling;

import org.litepal.crud.LitePalSupport;

public class User extends LitePalSupport {
    private String tel;
    private String password;

    public String getTel() {
        return tel;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}

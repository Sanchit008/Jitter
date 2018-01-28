package com.example.hp.smartcafe.Model;

/**
 * Created by Hp on 19-01-2018.
 */

public class User {
    private String name;
    private  String Password;
    private  String Phone;
    public User() {
    }

    public User(String name, String password) {
        this.name = name;
        Password = password;

    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}

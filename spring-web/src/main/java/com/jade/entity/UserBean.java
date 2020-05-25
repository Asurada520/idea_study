package com.jade.entity;

import java.io.Serializable;

public class UserBean implements Serializable {
    private static final long serialVersionUID = -2409586345788916824L;

    private String name;
    private String password;
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean validatePassword(String password){

        if(this.password.equals(password)){
            return true;
        }else{
            return false;
        }
    }

}

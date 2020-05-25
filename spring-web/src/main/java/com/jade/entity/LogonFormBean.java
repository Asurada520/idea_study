package com.jade.entity;

import java.util.Hashtable;

public class LogonFormBean {

    private String name;
    private String password;

    private Hashtable errors = new Hashtable();


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

    public boolean validate() {
        boolean allOK = true;

        if (name.trim().equals("")) {
            errors.put("name", "Please input your name");
            allOK = false;
        }
        if (password.length() > 10 || password.length() < 6) {
            errors.put("password", "password must have 6-10 characters.");
            allOK = false;
        }

        return allOK;
    }

    public void setErrorMsg(String error, String errorMsg) {
        if (error != null && errorMsg != null) {
            errors.put(error, errorMsg);
        }
    }

    public String getErrorMsg(String error) {
        String errorMsg = (String) errors.get(error);
        return errorMsg == null ? "" : errorMsg;
    }
}

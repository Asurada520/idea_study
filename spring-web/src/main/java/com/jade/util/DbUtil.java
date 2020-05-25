package com.jade.util;

import com.jade.entity.UserBean;

import java.util.Hashtable;

public class DbUtil {

    private static DbUtil instance =  new DbUtil();
    private Hashtable users = new Hashtable();

    private DbUtil() {

        UserBean user1 = new UserBean();
        user1.setName("zxx");
        user1.setPassword("123456");
        user1.setEmail("zxx@126.com");
        users.put("zxx",user1);

        UserBean user2 = new UserBean();
        user2.setName("flx");
        user2.setPassword("987654");
        user2.setEmail("flx@126.com");
        users.put("flx",user2);

    }

    public  UserBean getUser(String userName){
        UserBean  userBean = (UserBean)users.get(userName);
        return userBean;
    }

    public static DbUtil getInstance(){
        return instance;
    }

}

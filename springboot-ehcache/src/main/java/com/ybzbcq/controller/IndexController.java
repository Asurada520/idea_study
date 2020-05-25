package com.ybzbcq.controller;


import com.ybzbcq.ehcache.MapEHCache;
import com.ybzbcq.entity.Users;
import com.ybzbcq.service.UserService;
import org.springframework.cache.CacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/business/")
public class IndexController {

    @Autowired
    private UserService userService;

    @Autowired
    private MapEHCache<String, Object> cache;

    @Autowired
    private CacheManager cacheManager;

    @RequestMapping("getInfo")
    public Object getInfo(){
        List<Users> user = userService.getUser(1);
        return user;
    }

    @RequestMapping("get")
    public Object get(String key){
        Object value = cache.get(key);
        return value;
    }

    @RequestMapping("put")
    public Object put(String key, String value){
        cache.put(key, value);
        return "success";
    }

    @RequestMapping("/remoKey")
    public void remoKey() {
        cacheManager.getCache("userCache").clear();
    }

}

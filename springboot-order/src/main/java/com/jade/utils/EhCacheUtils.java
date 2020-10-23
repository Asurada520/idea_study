package com.jade.utils;

import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class EhCacheUtils {

//    @Autowired
//    private CacheManager cacheManager;

    @Autowired
    EhCacheCacheManager ehCacheCacheManager;

    /**
     * cacheName 和 key 区别 就是 redis中的db库 组
     * @param cacheName cache 名称
     * @param key 键
     * @param value 值
     */
    public void put(String cacheName, String key,Object value){
//        Collection<String> cacheNames = cacheManager.getCacheNames();
//        ehCacheCacheManager.getCache(cacheName).put(key,value);
        Cache cache = ehCacheCacheManager.getCacheManager().getCache(cacheName);
        Element element = new Element(key, value);
        cache.put(element);

    }

    public Object get(String cacheName, String key){
        Cache cache = ehCacheCacheManager.getCacheManager().getCache(cacheName);
        Element element = cache.get(key);
        return element == null?null:element.getObjectValue();
    }

    public void remove(String cacheName, String key){
        Cache cache = ehCacheCacheManager.getCacheManager().getCache(cacheName);
        cache.remove(key);
    }



}

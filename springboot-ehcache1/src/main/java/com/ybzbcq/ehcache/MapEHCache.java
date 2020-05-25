package com.ybzbcq.ehcache;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class MapEHCache<K, V> {

    private Map<K,V> ehCacheMap = new ConcurrentHashMap<K,V>();

    public void put(K k,V v){
        ehCacheMap.put(k,v);
    }

    public V get(K k){
        return ehCacheMap.get(k);
    }

    public void remove(K k){
        ehCacheMap.remove(k);
    }

}

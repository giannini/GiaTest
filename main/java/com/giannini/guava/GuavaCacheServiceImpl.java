package com.giannini.guava;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Created by Fenglin on 2017/5/13.
 */
public class GuavaCacheServiceImpl {


    private LoadingCache<String, Long> nodeIdCache;

    public GuavaCacheServiceImpl() {
        nodeIdCache = CacheBuilder.newBuilder().maximumSize(2000).
                expireAfterAccess(30, TimeUnit.MINUTES).
                build(new CacheLoader<String, Long>() {
            public Long load(String s) throws Exception {
                return null;
            }
        });

    }

    public Long get(String key) throws ExecutionException {
        return nodeIdCache.get(key);
    }

    public void put(String key, Long val) {
        nodeIdCache.put(key, val);
    }

    public void delete(String key) {
        nodeIdCache.invalidate(key);

    }

    public boolean exist(String key) {
        return nodeIdCache.getIfPresent(key) == null;
    }

    public Long putIfAbsent(String key, Long val) {
        synchronized (nodeIdCache) {
            return nodeIdCache.asMap().putIfAbsent(key, val);
        }
    }

}

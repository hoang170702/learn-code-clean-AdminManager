package com.demo.invokingmethod.configuration;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.TimeUnit;

public class CacheManager {
    public static final String PRODUCT = "product";
    public static final String CATEGORY = "category";
    public static final String USER = "user";

    public static  Cache<String, String> cacheSession = CacheBuilder.newBuilder().maximumSize(1000).expireAfterAccess(1,TimeUnit.DAYS).build();
}

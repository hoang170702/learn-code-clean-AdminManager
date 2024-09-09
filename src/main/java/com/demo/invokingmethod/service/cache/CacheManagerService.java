package com.demo.invokingmethod.service.cache;

import com.demo.invokingmethod.model.admin.Parameter;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class CacheManagerService implements ICacheManagerService {
    @Override
    public LoadingCache<String, Parameter> loadingCache() {
        try {
            return CacheBuilder.newBuilder()
                    .maximumSize(10)
                    .expireAfterAccess(1, TimeUnit.MINUTES)
                    .refreshAfterWrite(1, TimeUnit.SECONDS)
                    .build(new CacheLoader<>() {
                        @Override
                        public Parameter load(String key) throws Exception {
                            return null;
                        }
                    });
        } catch (Exception e) {
            log.error("Init cache failed: {}", e.getMessage());
            throw e;
        }
    }
}

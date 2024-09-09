package com.demo.invokingmethod.service.cache;

import com.demo.invokingmethod.model.admin.Parameter;
import com.google.common.cache.LoadingCache;

public interface ICacheManagerService {
    LoadingCache<String, Parameter> loadingCache();
}

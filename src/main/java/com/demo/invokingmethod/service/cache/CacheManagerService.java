package com.demo.invokingmethod.service.cache;

import com.demo.invokingmethod.configuration.CacheManager;
import com.demo.invokingmethod.model.Category;
import com.demo.invokingmethod.model.Product;
import com.demo.invokingmethod.model.User;
import com.demo.invokingmethod.model.admin.Parameter;
import com.demo.invokingmethod.repository.CategoryRepository;
import com.demo.invokingmethod.repository.ProductRepository;
import com.demo.invokingmethod.repository.UserRepository;
import com.demo.invokingmethod.repository.model.CategoryEntity;
import com.demo.invokingmethod.repository.model.ProductEntity;
import com.demo.invokingmethod.repository.model.UserEntity;
import com.demo.invokingmethod.utils.ConfigStatus;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CacheManagerService implements ICacheManagerService {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    @Autowired
    public CacheManagerService(CategoryRepository categoryRepository, ProductRepository productRepository, UserRepository userRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

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
                            return loadParamByKey(key);
                        }
                    });
        } catch (Exception e) {
            log.error("Init cache failed: {}", e.getMessage());
            throw e;
        }
    }

    private Parameter loadParamByKey(String key) {
        Parameter.ParameterBuilder parameterBuilder = Parameter.builder();
        switch (key) {
            case CacheManager.CATEGORY:
                List<Category> categories = loadCategoryByCache();
                if (!categories.isEmpty()) {
                    parameterBuilder.categories(categories);
                }
                break;
            case CacheManager.USER:
                List<User> users = loadUserByCache();
                if (!users.isEmpty()) {
                    parameterBuilder.users(users);
                }
                break;
            case CacheManager.PRODUCT:
                List<Product> products = loadProductByCache();
                if (!products.isEmpty()) {
                    parameterBuilder.products(products);
                }
                break;
            default:
                throw new RuntimeException("Invalid parameter type: " + key);
        }
        return parameterBuilder.build();
    }


    private List<Category> loadCategoryByCache() {
        List<CategoryEntity> categoryEntityList = categoryRepository.findAllByStatus(ConfigStatus.ACTIVE);
        if (!CollectionUtils.isEmpty(categoryEntityList)) {
            return categoryEntityList.stream()
                    .map(
                            t -> Category.builder()
                                    .id(t.getId())
                                    .name(t.getName())
                                    .build()
                    )
                    .collect(Collectors.toList());
        }
        return Collections.EMPTY_LIST;
    }

    private List<User> loadUserByCache() {
        List<UserEntity> userEntities = userRepository.findAllByStatus(ConfigStatus.ACTIVE);
        if (!CollectionUtils.isEmpty(userEntities)) {
            return userEntities.stream()
                    .map(
                            t -> User.builder()
                                    .id(t.getId())
                                    .fullName(t.getFullName())
                                    .email(t.getEmail())
                                    .build()
                    )
                    .collect(Collectors.toList());
        }
        return Collections.EMPTY_LIST;
    }

    private List<Product> loadProductByCache() {
        List<ProductEntity> productEntities = productRepository.findAllByStatus(ConfigStatus.ACTIVE);
        if (!CollectionUtils.isEmpty(productEntities)) {
            return productEntities.stream()
                    .map(
                            t -> Product.builder()
                                    .id(t.getId())
                                    .price(t.getPrice())
                                    .category(t.getCategory())
                                    .build()
                    )
                    .collect(Collectors.toList());
        }
        return Collections.EMPTY_LIST;
    }


}

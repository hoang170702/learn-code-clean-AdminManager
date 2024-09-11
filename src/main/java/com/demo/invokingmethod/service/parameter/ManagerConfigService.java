package com.demo.invokingmethod.service.parameter;

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
import com.demo.invokingmethod.service.cache.ICacheManagerService;
import com.demo.invokingmethod.utils.ConfigStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Slf4j
public class ManagerConfigService implements IManagerConfigService {
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final ICacheManagerService iCacheManagerService;

    @Autowired
    public ManagerConfigService(CategoryRepository categoryRepository, ProductRepository productRepository, UserRepository userRepository, ICacheManagerService iCacheManagerService) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
        this.iCacheManagerService = iCacheManagerService;
    }

    @Transactional
    @Override
    public void createOrUpdateCategory(Category category, Boolean isDel) {
        CategoryEntity categoryEntity;
        try {
            if (category.getId() != null) {
                categoryEntity = categoryRepository.findById(category.getId()).orElseThrow(Exception::new);
                if (isDel) {
                    categoryRepository.deleteCategory(category.getId());
                    return;
                }
                categoryEntity.setStatus(category.getStatus());
            } else {
                categoryEntity = new CategoryEntity();
                categoryEntity.setStatus(ConfigStatus.ACTIVE);
            }
            categoryEntity.setName(category.getName());
            categoryRepository.save(categoryEntity);

        } catch (Exception e) {
            e.printStackTrace();
            log.error("Error when create or update category: {}", e.getMessage());
        }
    }

    @Transactional
    @Override
    public void createOrUpdateProduct(Product product, Boolean isDel) {
        ProductEntity productEntity;
        try {
            if (product.getId() != null) {
                productEntity = productRepository.findById(product.getId()).orElseThrow(Exception::new);
                if (isDel) {
                    productRepository.deleteProduct(product.getId());
                    return;
                }
                productEntity.setStatus(product.getStatus());
            } else {
                productEntity = new ProductEntity();
                productEntity.setStatus(ConfigStatus.ACTIVE);
            }
            productEntity.setName(product.getName());
            productEntity.setPrice(product.getPrice());
            productEntity.setCategory(product.getCategory());

            productRepository.save(productEntity);

        } catch (Exception e) {
            e.printStackTrace();
            log.error("Error when create or update product: {}", e.getMessage());
        }
    }

    @Transactional
    @Override
    public void CreateOrUpdateUser(User user, Boolean isDel) {
        UserEntity userEntity;
        try {
            if (user.getId() != null) {
                userEntity = userRepository.findById(user.getId()).orElseThrow(Exception::new);
                if (isDel) {
                    userRepository.deleteUser(user.getId());
                    return;
                }
                userEntity.setStatus(user.getStatus());
            } else {
                userEntity = new UserEntity();
                userEntity.setStatus(ConfigStatus.ACTIVE);
            }
            userEntity.setEmail(user.getEmail());
            userEntity.setFullName(user.getFullName());
            userRepository.save(userEntity);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Error when create or update user: {}", e.getMessage());
        }
    }

    @Transactional
    @Override
    public Parameter getParameter(String key) {
        try {
            return iCacheManagerService.loadingCache().getUnchecked(key);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Error when get parameter: {}", e.getMessage());
        }
        return null;
    }
}

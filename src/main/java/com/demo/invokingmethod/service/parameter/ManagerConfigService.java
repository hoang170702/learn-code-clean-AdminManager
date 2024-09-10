package com.demo.invokingmethod.service.parameter;

import com.demo.invokingmethod.model.Category;
import com.demo.invokingmethod.model.Product;
import com.demo.invokingmethod.model.User;
import com.demo.invokingmethod.model.admin.Parameter;
import com.demo.invokingmethod.repository.CategoryRepository;
import com.demo.invokingmethod.repository.ProductRepository;
import com.demo.invokingmethod.repository.UserRepository;
import com.demo.invokingmethod.repository.model.CategoryEntity;
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

    @Autowired
    public ManagerConfigService(CategoryRepository categoryRepository, ProductRepository productRepository, UserRepository userRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
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
        try {

        } catch (Exception e) {
            e.printStackTrace();
            log.error("Error when create or update product: {}", e.getMessage());
        }
    }

    @Transactional
    @Override
    public void CreateOrUpdateUser(User user, Boolean isDel) {
        try {

        } catch (Exception e) {
            e.printStackTrace();
            log.error("Error when create or update user: {}", e.getMessage());
        }
    }

    @Transactional
    @Override
    public Parameter getParameter(String key) {
        try {

        } catch (Exception e) {
            e.printStackTrace();
            log.error("Error when get parameter: {}", e.getMessage());
        }
        return null;
    }
}

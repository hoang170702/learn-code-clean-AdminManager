package com.demo.invokingmethod.service.parameter;

import com.demo.invokingmethod.model.Category;
import com.demo.invokingmethod.model.Product;
import com.demo.invokingmethod.model.User;
import com.demo.invokingmethod.model.admin.Parameter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ManagerConfigService implements IManagerConfigService {
    @Override
    public void createOrUpdateCategory(Category category, Boolean isDel) {
        try {

        } catch (Exception e) {
            e.printStackTrace();
            log.error("Error when create or update category: {}", e.getMessage());
        }
    }

    @Override
    public void createOrUpdateProduct(Product product, Boolean isDel) {
        try {

        } catch (Exception e) {
            e.printStackTrace();
            log.error("Error when create or update product: {}", e.getMessage());
        }
    }

    @Override
    public void CreateOrUpdateUser(User user, Boolean isDel) {
        try {

        } catch (Exception e) {
            e.printStackTrace();
            log.error("Error when create or update user: {}", e.getMessage());
        }
    }

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

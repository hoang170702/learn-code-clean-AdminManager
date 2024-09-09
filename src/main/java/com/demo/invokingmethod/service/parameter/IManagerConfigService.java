package com.demo.invokingmethod.service.parameter;

import com.demo.invokingmethod.model.Category;
import com.demo.invokingmethod.model.Product;
import com.demo.invokingmethod.model.User;
import com.demo.invokingmethod.model.admin.Parameter;

public interface IManagerConfigService {
    void createOrUpdateCategory(Category category, Boolean isDel);

    void createOrUpdateProduct(Product product, Boolean isDel);

    void CreateOrUpdateUser(User user, Boolean isDel);

    Parameter getParameter(String key);
}

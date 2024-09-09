package com.demo.invokingmethod.model.admin;

import com.demo.invokingmethod.model.Category;
import com.demo.invokingmethod.model.Product;
import com.demo.invokingmethod.model.User;
import lombok.*;

import java.util.List;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Parameter {
    private List<Category> categories;
    private List<Product> products;
    private List<User> users;
}

package com.demo.invokingmethod.repository;

import com.demo.invokingmethod.repository.model.Category;
import com.demo.invokingmethod.repository.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}

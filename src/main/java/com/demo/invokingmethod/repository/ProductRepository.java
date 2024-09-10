package com.demo.invokingmethod.repository;

import com.demo.invokingmethod.repository.model.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    @Modifying
    @Query(nativeQuery = true,value = "update products set status = 'INACTIVE' where id =:id")
    void deleteProduct(Long id);
}

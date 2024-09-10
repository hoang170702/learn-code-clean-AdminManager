package com.demo.invokingmethod.repository;

import com.demo.invokingmethod.repository.model.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
    @Modifying
    @Query(nativeQuery = true, value = "UPDATE categories SET status = 'INACTIVE' WHERE ID = :id")
    void deleteCategory(Long id);
}

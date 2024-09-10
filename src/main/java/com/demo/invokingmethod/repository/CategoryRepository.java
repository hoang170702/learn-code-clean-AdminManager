package com.demo.invokingmethod.repository;

import com.demo.invokingmethod.repository.model.CategoryEntity;
import com.demo.invokingmethod.utils.ConfigStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
    @Modifying
    @Query(nativeQuery = true, value = "UPDATE categories SET status = 'INACTIVE' WHERE ID = :id")
    void deleteCategory(Long id);

    List<CategoryEntity> findAllByStatus(ConfigStatus status);
}

package com.demo.invokingmethod.repository;

import com.demo.invokingmethod.repository.model.UserEntity;
import com.demo.invokingmethod.utils.ConfigStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    @Modifying
    @Query(nativeQuery = true, value = "update users set status = 'INACTIVE' WHERE id = :id")
    void deleteUser(Long id);

    List<UserEntity> findAllByStatus(ConfigStatus status);
}

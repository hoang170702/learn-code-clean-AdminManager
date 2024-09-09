package com.demo.invokingmethod.repository;

import com.demo.invokingmethod.repository.model.Category;
import com.demo.invokingmethod.repository.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}

package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Annotation to tell Spring that this is a bean of type repository - bridge to the database
public interface UserRepository extends JpaRepository<User, Long> { // JpaRepository provides CRUD operations for the entity class User with its primary key of type Long

}

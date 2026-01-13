package com.jpaproject.jpa_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpaproject.jpa_project.model.User;



@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUsername(String username);
}
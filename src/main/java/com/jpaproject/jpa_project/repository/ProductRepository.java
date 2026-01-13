package com.jpaproject.jpa_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpaproject.jpa_project.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}

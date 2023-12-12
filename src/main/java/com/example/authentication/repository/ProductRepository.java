package com.example.authentication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.authentication.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

}

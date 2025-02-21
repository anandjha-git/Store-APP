package com.storeapp.repository;

import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.storeapp.entities.Product;

@Repository(value = "productRepository")
@Scope("singleton")
public interface ProductRepository extends JpaRepository<Product, String> {
}

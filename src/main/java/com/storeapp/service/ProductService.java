package com.storeapp.service;

import com.storeapp.entities.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    public List<Product> getProducts();
    public Product getProductById(String id);
    public Product createProduct(Product product);
    public Product updateProduct(Product product);
    public void deleteProductById(String id);
}

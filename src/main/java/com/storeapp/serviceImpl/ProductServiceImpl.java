package com.storeapp.serviceImpl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.storeapp.entities.Product;
import com.storeapp.repository.ProductRepository;
import com.storeapp.service.ProductService;

@Service(value = "productService")
@Scope("singleton")
@Transactional
public class ProductServiceImpl implements ProductService {
	@Autowired
	@Qualifier("productRepository")
	private ProductRepository productRepository;

	@Override
	public List<Product> getProducts() {
		return productRepository.findAll();
	}

	@Override
	public Product getProductById(String id) {
		try {
			return productRepository.findById(id).get();
		} catch (NoSuchElementException e) {
			return null;
		}
	}

	@Override
	public Product createProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public Product updateProduct(Product product) {
		return productRepository.saveAndFlush(product);
	}

	@Override
	public void deleteProductById(String id) {
		productRepository.deleteById(id);
	}
}

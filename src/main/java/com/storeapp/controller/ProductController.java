package com.storeapp.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.storeapp.entities.Product;
import com.storeapp.service.ProductService;

@RestController(value = "productController")
@Scope("request")
@RequestMapping("/storeapp")
public class ProductController {

	@Autowired
	@Qualifier("productService")
	private ProductService productService;

	@GetMapping("/products")
	public ResponseEntity<List<Product>> getProducts() {

		return new ResponseEntity<List<Product>>(productService.getProducts(), HttpStatus.OK);
	}

	@PostMapping("/product")
	public ResponseEntity<Product> addProduct(@RequestBody Product product) {
		if (product.getId() == null || product.getId().isEmpty()) {
			product.setId(UUID.randomUUID().toString()); // Generate an ID if missing
		}
		return new ResponseEntity<Product>(productService.createProduct(product), HttpStatus.CREATED);
	}

	@GetMapping("/product/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public Product getProduct(@PathVariable("id") String id) {
		return productService.getProductById(id);
	}

	@PutMapping("/product")
	@ResponseStatus(code = HttpStatus.OK)
	public Product updateProduct(@RequestBody Product product) {
		return productService.updateProduct(product);
	}

	@DeleteMapping("/product/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteProductById(@PathVariable("id") String id) {
		productService.deleteProductById(id);
	}

}

package com.example.authentication.service;

import java.util.List;

import com.example.authentication.entity.Product;

public interface ProductService {
	 Product saveProduct(Product product);
	 List<Product> fetchAllProducts();
	 Product fetchProduct(int id);
}

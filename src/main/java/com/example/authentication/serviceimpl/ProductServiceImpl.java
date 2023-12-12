package com.example.authentication.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.authentication.entity.Product;
import com.example.authentication.repository.ProductRepository;
import com.example.authentication.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepo;
	@Override
	public Product saveProduct(Product product) {
		// TODO Auto-generated method stub
		return productRepo.save(product);
	}

	@Override
	public List<Product> fetchAllProducts() {
		// TODO Auto-generated method stub
		return productRepo.findAll();
	}

	@Override
	public Product fetchProduct(int id) {
		// TODO Auto-generated method stub
		return productRepo.findById(id).orElse(null);
	}

}

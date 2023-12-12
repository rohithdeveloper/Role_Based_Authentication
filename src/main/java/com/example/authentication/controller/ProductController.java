package com.example.authentication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.authentication.entity.Product;
import com.example.authentication.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome to springboot security";
	}
	@PostMapping("/send")
	public Product saveProducts(@RequestBody Product product) {
		return productService.saveProduct(product);
	}
	
	@PreAuthorize("hasRole('ROLE_USER')")
	//@Secured("ROLE_USER")
	@GetMapping("/product/fetchAll")
	public List<Product> fetchProducts(){
		List<Product> list=productService.fetchAllProducts();
		return list;
	}
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/product/fetch/{id}")
	public Product fetchProductById(@PathVariable int id){
		return productService.fetchProduct(id);
	}
	
}

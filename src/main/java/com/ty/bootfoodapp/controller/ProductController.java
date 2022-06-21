package com.ty.bootfoodapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ty.bootfoodapp.dto.Products;
import com.ty.bootfoodapp.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	ProductService productService;

	@PostMapping("/products")
	public Products saveProducts(@RequestBody Products products) {
		return productService.saveProducts(products);
	}

	@GetMapping("/products")
	public List<Products> getAllProducts() {
		return productService.getAllProducts();
	}

	@GetMapping("/products/{id}")
	public Products getProductById(@PathVariable int id) {
		return productService.getProductById(id);

	}

	@PutMapping("/products/{id}")
	public Products updateProducts(@RequestBody Products products, @PathVariable int id) {
		return productService.updateProduct(products, id);

	}

	@DeleteMapping("/product")
	public Products deleteProduct(@RequestBody Products products, @PathVariable int id) {
		return productService.deleProduct(id);
	}
}

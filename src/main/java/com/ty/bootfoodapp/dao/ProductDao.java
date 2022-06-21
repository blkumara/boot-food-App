package com.ty.bootfoodapp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.ty.bootfoodapp.dto.Products;
import com.ty.bootfoodapp.repository.ProductRepository;

@Repository
public class ProductDao {

	@Autowired
	ProductRepository productRepository;

	public Products saveProducts(@RequestBody Products products) {
		return productRepository.save(products);
	}

	public List<Products> getAll() {
		return productRepository.findAll();
	}

	public Products getProductById(@PathVariable int id) {
		Optional<Products> optional = productRepository.findById(id);
		if (optional.isEmpty()) {
			return null;
		} else {
			return optional.get();
		}
	}

	public Products updateProduct(@RequestBody Products products, @PathVariable int id) {
		Optional<Products> optional = productRepository.findById(id);
		if (optional.isEmpty()) {
			return null;
		} else {
			return productRepository.save(products);
		}
	}

	public Products deleProduct(@PathVariable int id) {
		Optional<Products> optional = productRepository.findById(id);
		if (optional.isEmpty()) {
			return null;
		} else {
			Products products = optional.get();
			productRepository.delete(products);
			return products;
		}
	}

}

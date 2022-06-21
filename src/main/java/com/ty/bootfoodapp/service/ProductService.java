package com.ty.bootfoodapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ty.bootfoodapp.dao.ProductDao;
import com.ty.bootfoodapp.dto.Products;

@Service

public class ProductService {

	@Autowired
	ProductDao productDao;

	public Products saveProducts(Products products) {
		return productDao.saveProducts(products);
	}

	public List<Products> getAllProducts() {
		return productDao.getAll();

	}

	public Products getProductById(int id) {
		return productDao.getProductById(id);
	}

	public Products updateProduct(Products products, int id) {
		return productDao.updateProduct(products, id);
	}

	public Products deleProduct(int id) {
		return productDao.deleProduct(id);
	}
}

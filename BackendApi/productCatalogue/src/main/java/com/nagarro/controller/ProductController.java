package com.nagarro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.entity.Product;
import com.nagarro.service.ProductService;

/**
 * This class implements the required apis for product
 * @author saumyaawasthi
 * 
 *
 */
@RestController
@CrossOrigin
public class ProductController {
	@Autowired
	private ProductService service;

	/*
	 * This API is used to get the product with help of productId
	 * 
	 * @Param productId
	 * 
	 * @Return Product
	 */
	@GetMapping("/getProductById/{id}")
	public Product getProductById(@PathVariable("id") String productCode) throws Exception {
		try {
			return this.service.getProduct(productCode);
		} catch (Exception e) {
			throw new Exception("FETCHING_FAILED");
		}
	}

}

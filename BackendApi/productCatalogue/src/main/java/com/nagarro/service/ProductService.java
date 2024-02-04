package com.nagarro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.entity.Product;
import com.nagarro.repository.ProductRepository;
import com.nagarro.serviceInterface.ProductServiceInterface;

/**
 * Here we are using Product Service to store, retrieve, and count the products.
 * @author saumyaawasthi
 * 
 *
 */
@Service
public class ProductService implements ProductServiceInterface {
	@Autowired
	private ProductRepository repo;

	/**
	 * This method is used to save product
	 */
	@Override
	public Product saveProduct(Product product) {
		Product productObj = repo.save(product);
		return productObj;
	}

	/**
	 * This method is used to get product with help of productCode
	 */
	@Override
	public Product getProduct(String productCode) {

		Product productObj = repo.findByProductCode(productCode);
		return productObj;
	}

	/**
	 * This method is used to save review
	 */
	@Override
	public void updateProductReview(Product product) {
		repo.save(product);
	}

	/**
	 * This method is used to count product
	 */
	@Override
	public Long countAllProduct() {
		return repo.count();
	}

}
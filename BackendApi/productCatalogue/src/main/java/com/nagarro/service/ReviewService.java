package com.nagarro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.entity.Product;
import com.nagarro.entity.Reviews;
import com.nagarro.repository.ReviewRepository;
import com.nagarro.serviceInterface.ReviewServiceInterface;

/**
 * ReviewService class implements all the methods of ReviewServiceInterface interface . 
 * @author saumyaawasthi
 *
 */
@Service
public class ReviewService implements ReviewServiceInterface {

	@Autowired
	private ReviewRepository repo;

	/**
	 * This method is used to get list of review
	 */
	@Override
	public List<Reviews> getAllReview(Product product) {
		return repo.findByProduct(product)
	}

	/**
	 * This method is used to get all count review
	 */

	@Override
	public Long countAllReview() {
		return repo.count();
	}

	/**
	 * This method is used to get average of review rating
	 */
	@Override
	public Double getAverage(Product product) {
		return repo.getAverage(product);
	}
}

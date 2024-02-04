package com.nagarro.serviceInterface;

import java.util.List;
/**
 * Here we have created an Interface which contains methods to  retrieve, and count the reviews given by the user.
 * 
 *
 */

import com.nagarro.entity.Product;
import com.nagarro.entity.Reviews;

public interface ReviewServiceInterface {

	public List<Reviews> getAllReview(Product product);

	public Long countAllReview();

	public Double getAverage(Product product);
}

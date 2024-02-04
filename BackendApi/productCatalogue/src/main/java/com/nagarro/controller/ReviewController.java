package com.nagarro.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.entity.Product;
import com.nagarro.entity.Reviews;
import com.nagarro.model.Model;
import com.nagarro.service.ProductService;
import com.nagarro.service.RegistrationService;
import com.nagarro.service.ReviewService;;

/**
 * This class implements all the functionalities associated with review given by
 * a user.
 * 
 * @author saumyaawasthi
 *
 */
@RestController
@CrossOrigin
public class ReviewController {

	@Autowired
	private ReviewService reviewService;
	@Autowired
	private ProductService productService;
	@Autowired
	private RegistrationService registrationService;

	/*
	 * This API is used to get allReview with respect productId
	 * 
	 * @Param productId
	 * 
	 * @Return List<Reviews>
	 */
	@GetMapping("/getAllReview/{id}")
	public List<Reviews> getAllReview(@PathVariable(value = "id") String id) throws Exception {
		List<Reviews> results;
		try {
			Product productObj = productService.getProduct(id);
			results = reviewService.getAllReview(productObj);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return results;
	}

	/*
	 * This API is used to store the reviews with respect prodductId
	 * 
	 * @Param peoductId
	 * 
	 * @Return nothing
	 */
	@PutMapping("/insertReview/{id}")
	public void insertReview(@RequestBody Reviews review, @PathVariable(value = "id") String id) throws Exception {
		Product product;
		List<Reviews> review1;
		try {
			product = productService.getProduct(id);
			review1 = product.getReviews();
			review1.add(review);
			review.setProduct(product);
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
			Date date = new Date();
			review.setDate(dateFormat.format(date));
			productService.updateProductReview(product);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * This API is used to get stats details
	 * 
	 * @Param nothing
	 * 
	 * @Return Model
	 */
	@GetMapping("/getstats")
	public Model getStats() throws Exception {
		Model model = new Model();
		try {
			model.countUsers = registrationService.countAllRegistrated();
			model.countReviews = reviewService.countAllReview();
			model.countPosts = productService.countAllProduct();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return model;
	}

	/*
	 * This API is used to get the average of all rating
	 * 
	 * @Param productId
	 * 
	 * @Return Integer
	 */
	@GetMapping("/getAvgRating/{id}")
	public Integer getAvgRating(@PathVariable("id") String productCode) throws Exception {
		if (productCode == null) {
			throw new Exception("Id is null!Please try again");
		}
		Product product = null;
		try {
			product = this.productService.getProduct(productCode);
		} catch (Exception e) {
			throw new Exception("Product not found");
		}
		Double average = this.reviewService.getAverage(product);
		if (average == null) {
			return 0;
		}
		double avg = average;
		return (int) avg;
	}
}

package com.nagarro.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
/**
 * This class is used to create Review entity consisting of required attributes 
 * associated with the reviews given by a user.
 * 
 *@author saumyaawasthi
 */
@Entity
public class Reviews {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int reviewId;

	@ManyToOne
	@JoinColumn
	@JsonIgnore
	private Product product;
	private String review;
	private String date;
	private int rating;
	private String userName;
	private String heading;

	public Reviews() {
		super();
	}

	public Reviews(int reviewId, Product product, String review, String date, int rating, String userName,
			String heading) {
		super();
		this.reviewId = reviewId;
		this.product = product;
		this.review = review;
		this.date = date;
		this.rating = rating;
		this.userName = userName;
		this.heading = heading;
	}

	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getHeading() {
		return heading;
	}

	public void setHeading(String heading) {
		this.heading = heading;
	}

}

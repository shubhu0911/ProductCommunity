package com.nagarro.model;

/**
 * This class is used to create model entity and implement the required attributes.
 * @author saumyaawasthi
 *
 */
public class Model {
	public long countUsers;
	public long countReviews;
	public long countPosts;

	public Model() {
		super();

	}

	public Model(long countUsers, long countReviews, long countPosts) {
		super();
		this.countUsers = countUsers;
		this.countReviews = countReviews;
		this.countPosts = countPosts;
	}

}

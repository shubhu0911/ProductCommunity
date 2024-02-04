package com.nagarro.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.*;

/**
 *This class is used to create Product entity consisting of required attributes associated with the Product.
 * @author saumyaawasthi
 *
 */
@Entity
public class Product {
	@Id
	@Column(unique = true, columnDefinition = "VARCHAR(64)")
	private String productCode;
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private List<Reviews> reviews = new ArrayList<Reviews>();
	private String productName;
	private String brand;
	private int price;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(String productCode, List<Reviews> reviews, String productName, String brand, int price) {
		super();
		this.productCode = productCode;
		this.reviews = reviews;
		this.productName = productName;
		this.brand = brand;
		this.price = price;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public List<Reviews> getReviews() {
		return reviews;
	}

	public void setReviews(List<Reviews> reviews) {
		this.reviews = reviews;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}

package com.nagarro.serviceInterface;

import java.util.List;

import com.nagarro.entity.Product;

/**
 * Here we have created an Interface which contains methods to search the products.
 * @author saumyaawasthi
 *
 */

public interface SearchProductServiceInterface {

	public List<Product> getProductListBySearch(String search);

	public List<Product> searchPrice(int min, int max, String brand);
	
	

}

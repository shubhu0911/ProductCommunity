package com.nagarro.serviceInterface;

import com.nagarro.entity.Product;
import java.util.*;

/**
 * Here we have created an Interface which contains methods to store, retrieve,
 * and count the products.
 * 
 * @author saumyaawasthi
 *
 */
public interface ProductServiceInterface {

	public Product saveProduct(Product product);

	public Product getProduct(String productCode);

	public void updateProductReview(Product product);

	public Long countAllProduct();

}

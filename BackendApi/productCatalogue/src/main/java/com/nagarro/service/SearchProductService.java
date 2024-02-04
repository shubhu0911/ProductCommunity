package com.nagarro.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nagarro.entity.Product;
import com.nagarro.repository.SearchProductRepository;
import com.nagarro.serviceInterface.SearchProductServiceInterface;
/**
 * SearchProductService class implements all the methods of SearchProductService Interface interface . 
 * @author saumyaawasthi
 *
 */
@Service
public class SearchProductService implements SearchProductServiceInterface {

	@Autowired
	private SearchProductRepository repo;
	
	/**
	 * This method is used to get list of product based on search
	 */
	@Override
	public List<Product> getProductListBySearch(String search) {
		return repo.findBySearch(search);
	}
	
	/**
	 * This method is used to get list of product based on price range given by user
	 */
	@Override
	public List<Product> searchPrice(int min, int max, String brand) {
		// TODO Auto-generated method stub
		return repo.searchPrice(min, max,brand);
	}

}

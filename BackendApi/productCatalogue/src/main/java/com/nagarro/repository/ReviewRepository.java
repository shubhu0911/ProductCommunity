package com.nagarro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nagarro.entity.Product;
import com.nagarro.entity.Reviews;

/**
 * Here we are using JpaRepository interface to use CRUD functionality . 
 * @author saumyaawasthi
 *
 */
public interface ReviewRepository extends JpaRepository<Reviews, Integer> {
	public List<Reviews> findByProduct(Product product);

	@Query("select avg(r.rating) from Reviews r where r.product=:product")
	public Double getAverage(@Param("product") Product product);
}

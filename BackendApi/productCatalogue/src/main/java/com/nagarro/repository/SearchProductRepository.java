package com.nagarro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.nagarro.entity.Product;

/**
 * This repository interface extends JpaRepository. Here, we are using
 * the @Query annotation to create a custom query to find all products and
 * filter the products on the basis of given price range.
 * 
 * @author saumyaawasthi
 *
 */

@Repository
public interface SearchProductRepository extends JpaRepository<Product, Integer> {

	@Query("SELECT p from Product p Where INSTR(Concat(p.productCode,p.brand,p.productName),:search)>0 or INSTR(Concat(p.productCode,p.productName,p.brand),:search)>0 or INSTR(Concat(p.brand,p.productCode,p.productName),:search)>0 or INSTR(Concat(p.brand,p.productName,p.productCode),:search)>0 or INSTR(Concat(p.productName,p.productCode,p.brand),:search)>0 or INSTR(Concat(p.productName,p.brand,p.productCode),:search)>0 ")
	public List<Product> findBySearch(@Param("search") String search);

	@Query("from Product where price between :min and :max and brand = :brand")
	public List<Product> searchPrice(@Param("min") int min, @Param("max") int max , @Param("brand") String brand);

}

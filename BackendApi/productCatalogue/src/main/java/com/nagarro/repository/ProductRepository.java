package com.nagarro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nagarro.entity.Product;

/***
 * The ProductRepository extends from the JpaRepository. It provides the type of
 * the entity and of its primary key.
 * @author saumyaawasthi
 * 
 *
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

	public Product findByProductCode(String ProductCode);

}

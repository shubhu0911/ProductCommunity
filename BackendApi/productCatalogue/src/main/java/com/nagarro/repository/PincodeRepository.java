package com.nagarro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.entity.Pincode;

/***
 * The PincodeRepository extends from the JpaRepository. It provides the type of
 * the entity and of its primary key.
 * @author saumyaawasthi
 * 
 *
 */

@Repository
public interface PincodeRepository extends JpaRepository<Pincode, Long> {

	public Pincode findByPincode(Long pincode);

}

package com.nagarro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.nagarro.entity.User;

/***
 * The RegistrationRepository extends from the JpaRepository. It provides the
 * type of the entity and of its primary key.
 * @author saumyaawasthi
 *
 *
 */

@Repository
public interface RegistrationRepository extends JpaRepository<User, Integer> {

	public User findByEmailId(String emailId);

	public User findByEmailIdAndPassword(String emailId, String password);
}

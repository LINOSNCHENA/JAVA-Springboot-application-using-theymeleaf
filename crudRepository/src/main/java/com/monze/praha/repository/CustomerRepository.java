package com.monze.praha.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import com.monze.praha.model.Customerentity;

@Repository
public interface CustomerRepository extends CrudRepository<Customerentity, Long> {
	@Query("SELECT X FROM Customerentity X WHERE CONCAT(X.firstname, ' ', X.lastname, ' ', X.email) LIKE %?1%")
	 List<Customerentity> findByLastname(String keyword);
	 //  List<CustomerEntity> findByLastname(String lastname);
	// User findByEmailAddress(String emailAddress);
}

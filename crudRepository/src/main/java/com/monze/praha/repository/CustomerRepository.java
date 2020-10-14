package com.monze.praha.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.monze.praha.model.CustomerEntity;

@Repository
public interface CustomerRepository extends CrudRepository<CustomerEntity, Long> {
	@Query("SELECT contactX FROM CustomerEntity contactX WHERE CONCAT(contactX.first_name, ' ', contactX.last_name, ' ', contactX.email) LIKE %?1%")
	 List<CustomerEntity> findByLastname(String lastname);
	// User findByEmailAddress(String emailAddress);
}

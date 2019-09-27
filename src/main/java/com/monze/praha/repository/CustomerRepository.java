package com.monze.praha.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.monze.praha.model.CustomerEntity;

@Repository
public interface CustomerRepository 
			extends CrudRepository<CustomerEntity, Long> 
			{
}

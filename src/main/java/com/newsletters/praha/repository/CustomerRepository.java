package com.newsletters.praha.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.newsletters.praha.model.CustomerEntity;

@Repository
public interface CustomerRepository 
			extends CrudRepository<CustomerEntity, Long> 
			{
}

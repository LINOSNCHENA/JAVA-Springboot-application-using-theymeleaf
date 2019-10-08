package com.monze.praha.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.monze.praha.exception.RecordNotFoundException;
import com.monze.praha.model.CustomerEntity;
import com.monze.praha.repository.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	CustomerRepository repository;	
public List<CustomerEntity> readCustomers()										// service #1
	{	List<CustomerEntity> result = (List<CustomerEntity>) repository.findAll();
		if(result.size() > 0) {	return result;		 } 
		else {return new ArrayList<CustomerEntity>(); }
	}
																				 
public CustomerEntity readOneCustomer(Long id) throws RecordNotFoundException   	
	{	Optional<CustomerEntity> customer = repository.findById(id);
		if(customer.isPresent()) {return customer.get();	}
		else {
		throw new RecordNotFoundException("No Customer record exist for given id");	}
	}																		  	  // service #2

public CustomerEntity createOrUpdateCustomer(CustomerEntity entity) 	         		 
	{	if(entity.getId()  == null) 
		{	entity = repository.save(entity);			return entity;	} 
	else 
		{Optional<CustomerEntity> customer = repository.findById(entity.getId());
		if(customer.isPresent()) 
		{	CustomerEntity newEntity = customer.get();					
			newEntity.setFirstName(entity.getFirstName());
			newEntity.setLastName(entity.getLastName());
			newEntity.setEmail(entity.getEmail());	
			newEntity = repository.save(newEntity);					
			return newEntity;	} 
		else {entity = repository.save(entity);	return entity;}
		}
	} 																	     	// service #3
}
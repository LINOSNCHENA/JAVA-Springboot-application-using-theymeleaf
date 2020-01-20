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
	CustomerRepository repositoryIoC;		                                // IoC vs DI
public List<CustomerEntity> readCustomers()											
	{	List<CustomerEntity> result = (List<CustomerEntity>) repositoryIoC.findAll();
		if(result.size() > 0) {	return result;		 } 
		else {return new ArrayList<CustomerEntity>(); }
	}																	    // service #1
																				 
public CustomerEntity readOneCustomer(Long id) throws RecordNotFoundException   	
	{	Optional<CustomerEntity> customer = repositoryIoC.findById(id);
		if(customer.isPresent()) {return customer.get();	}
		else {
		throw new RecordNotFoundException("No Customer record exist for given id");	}
	}																    	// service #2

public CustomerEntity creatingCustomer(CustomerEntity entity) 	         		 
	{	if(entity.getId()  == null) 
		{	entity = repositoryIoC.save(entity);			return entity;	} 
	else 
		{Optional<CustomerEntity> customer = repositoryIoC.findById(entity.getId());
		if(customer.isPresent()) 
		{	CustomerEntity newEntity = customer.get();					
			newEntity.setFirstName(entity.getFirstName());
			newEntity.setLastName(entity.getLastName());
			newEntity.setEmail(entity.getEmail());	
			newEntity = repositoryIoC.save(newEntity);  	return newEntity;	} 	
		else {entity = repositoryIoC.save(entity);			return entity;		}
		}
	} 																	     	// service #3
    public void deleteEmployeeById(Long id) throws RecordNotFoundException
    {  Optional<CustomerEntity> participant = repositoryIoC.findById(id);
     if(participant.isPresent())
		{   repositoryIoC.deleteById(id);   } 
	 else {throw new RecordNotFoundException("No such record exist in the database"); }
    }																			// service #4
}
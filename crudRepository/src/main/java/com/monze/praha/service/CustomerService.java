package com.monze.praha.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.monze.praha.exception.RecordNotFoundException;
import com.monze.praha.model.Customerentity;
import com.monze.praha.repository.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	CustomerRepository repositoryIoC;

	public Customerentity creatingCustomer(Customerentity entity) {
		if (entity.getId() == null) {
			entity = repositoryIoC.save(entity);
			return entity;
		} else {
			Optional<Customerentity> customer = repositoryIoC.findById(entity.getId());
			if (customer.isPresent()) {
				Customerentity newEntity = customer.get();
				newEntity.setFirstname(entity.getFirstname());
				newEntity.setLastname(entity.getLastname());
				newEntity.setEmail(entity.getEmail());
				newEntity = repositoryIoC.save(newEntity);
				return newEntity;
			} else {
				entity = repositoryIoC.save(entity);
				return entity;
			}
		}
	} // service #1 & sevice #3

	public List<Customerentity> readCustomers(String keyword) {
		List<Customerentity> result;
		
		if(keyword!=null)
		{
		result= (List<Customerentity>) repositoryIoC.findByLastname(keyword);
		}
		else{result= (List<Customerentity>) repositoryIoC.findAll();}


		if (result.size() > 0) {
			return result;
		} else {
			return new ArrayList<Customerentity>();
		}
	} // service #2A

	public Customerentity readOneCustomer(Long id) throws RecordNotFoundException {
		Optional<Customerentity> customer = repositoryIoC.findById(id);
		if (customer.isPresent()) {
			return customer.get();
		} else {
			throw new RecordNotFoundException("No such record exist for given id");
		}
	} // service #2B

	public void deleteEmployeeById(Long id) throws RecordNotFoundException {
		Optional<Customerentity> participant = repositoryIoC.findById(id);
		if (participant.isPresent()) {
			repositoryIoC.deleteById(id);
		} else {
			throw new RecordNotFoundException("No such record exist in the database");
		}
	} // service #4
}
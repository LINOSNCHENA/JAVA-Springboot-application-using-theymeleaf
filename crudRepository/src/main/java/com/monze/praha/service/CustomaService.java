package com.monze.praha.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.monze.praha.exception.RecordNotFoundException;
import com.monze.praha.model.Customa;
import com.monze.praha.repository.CustomaRepository;

@Service
public class CustomaService {
	@Autowired
	CustomaRepository repositoryIoC;

	public Customa creatingCustomer(Customa entity) {
		if (entity.getId() == null) {
			entity = repositoryIoC.save(entity);
			return entity;
		} else {
			Optional<Customa> customer = repositoryIoC.findById(entity.getId());
			if (customer.isPresent()) {
				Customa newEntity = customer.get();
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

	public List<Customa> readCustomers(String keyword) {
		List<Customa> result;
		
		if(keyword!=null)
		{
		result= (List<Customa>) repositoryIoC.findByLastname(keyword);
		}
		else{result= (List<Customa>) repositoryIoC.findAll();}


		if (result.size() > 0) {
			return result;
		} else {
			return new ArrayList<Customa>();
		}
	} // service #2A

	public Customa readOneCustomer(Long id) throws RecordNotFoundException {
		Optional<Customa> customer = repositoryIoC.findById(id);
		if (customer.isPresent()) {
			return customer.get();
		} else {
			throw new RecordNotFoundException("No such record exist for given id");
		}
	} // service #2B

	public void deleteEmployeeById(Long id) throws RecordNotFoundException {
		Optional<Customa> participant = repositoryIoC.findById(id);
		if (participant.isPresent()) {
			repositoryIoC.deleteById(id);
		} else {
			throw new RecordNotFoundException("No such record exist in the database");
		}
	} // service #4
}
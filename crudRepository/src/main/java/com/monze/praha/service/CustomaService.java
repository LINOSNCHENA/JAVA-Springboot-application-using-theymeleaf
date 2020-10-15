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
	long zed = 0;
	public void save(Customa Contact) {
		repositoryIoC.save(Contact);
	}
	
	public Customa get(Long id) {
		return repositoryIoC.findById(id).get();
	}
	
	public Customa readOneCustomer(Long id) throws RecordNotFoundException {
		System.out.println(" ======== ZED firstr: " + zed + " is identity NUMBER INDENTITY ZED =========\n");
		Optional<Customa> customer = repositoryIoC.findById(id);
		if (customer.isPresent()) {
			System.out.println("\n ================== READONE-CUSTOMER ========================================\n");
			zed = id;
			System.out.println(" ======== ZED second: " + zed + " is identity NUMBER INDENTITY ZED =========\n");
			System.out.println(" Employee number: " + customer.get().getId() + " is IDENTITY =========\n");
			System.out.println(" Employee number: " + customer.get().getLastname() + " is name =========\n");
			System.out.println(" Employee number: " + customer.get() + " is foundOne =========\n");
			System.out.println("====================================================================\n");
			return customer.get();
		} else {
			throw new RecordNotFoundException("No such record exist for given id");
		}
	}
	// service #1 Creating

	public Customa creatingCustomer(Customa customaX) {
		if (customaX.getId() == null) {
			// if (customaX.getLastname() != null) {
			System.out.println("\n ================== CREATE ONE ========================================\n");
			System.out.println(" Employee number: " + customaX.getLastname() + " is CREATED 1=========\n");
			System.out.println(" Employee number: " + customaX.getId() + " is CREATED 1=========\n");
			System.out.println("====================================================================\n");
			customaX = repositoryIoC.save(customaX);
			return customaX;
		} else {

			System.out.println("\n ================== UPDATE ONE ========================================\n");
			System.out.println(" Employee number: " + customaX.getLastname() + " is EDITED 2=========\n");
			System.out.println(" Employee number: " + customaX.getId() + " is EDITED 2=========\n");
			System.out.println("======================END ==============================================\n");
			Optional<Customa> customerAvailable = repositoryIoC.findById(customaX.getId());
			if (customerAvailable.isPresent()) {
				Customa newEntity = customerAvailable.get();

				newEntity.setFirstname(customaX.getFirstname());
				newEntity.setLastname(customaX.getLastname());
				newEntity.setEmail(customaX.getEmail());
				newEntity.setId(customaX.getId());
				newEntity = repositoryIoC.save(newEntity);
				return newEntity;
			} else {
				System.out.println("\n ================== UPDATE-EDIT ========================================\n");
				System.out.println(" Employee number: " + customaX.getLastname() + " is THIRD =========\n");
				System.out.println(" Employee number: " + customaX.getFirstname() + " is THIRD =========\n");
				System.out.println(" Employee number: " + customaX.getId() + " is THIRD =========\n");
				System.out.println("=======================END=========================================\n");
				customaX = repositoryIoC.save(customaX);
				return customaX;
			}
		}
	} // service #2 & sevice #3

	public List<Customa> readCustomers(String keyword) {
		List<Customa> result;
		if (keyword != null) {
			result = (List<Customa>) repositoryIoC.findByLastname(keyword);
		} else {
			result = (List<Customa>) repositoryIoC.findAll();
		}
		System.out.println("\n ================== LOADING MANY ========================================\n");
		System.out.println(" Employee number: " + result + " is many =========\n");
		System.out.println("====================================================================\n");
		if (result.size() > 0) {
			return result;
		} else {
			return new ArrayList<Customa>();
		}
	} // service #2B: readOne

	public void deleteEmployeeById(Long id) throws RecordNotFoundException {
		Optional<Customa> participant = repositoryIoC.findById(id);
		if (participant.isPresent()) {

			System.out.println("\n ==================DELETE ===========================================\n");
			long zed = id;
			System.out.println(" Employee number: " + zed + " is deleted =========\n");
			System.out.println("====================================================================\n");
			repositoryIoC.deleteById(id);
		} else {
			throw new RecordNotFoundException("No such record exist in the database");
		}
	}
}
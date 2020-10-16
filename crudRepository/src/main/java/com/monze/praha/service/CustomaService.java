package com.monze.praha.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.monze.praha.exception.RecordNotFoundException;
import com.monze.praha.model.Customa;
import com.monze.praha.repository.CustomaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomaService {
	@Autowired
	CustomaRepository repo;

	public Customa createOrEditCustoma(Customa customaX) {
		if (customaX.getId() == null) { // create Customa NEW ID
			customaX = repo.save(customaX);
			System.out.println("\n ==============================CREATED ONE =========================\n");
			System.out.println("     LastName of records : " + customaX.getLastName() + "\n");
			return customaX;
		} else { // Update Customa
			Optional<Customa> customaY = repo.findById(customaX.getId());
			if (customaY.isPresent()) {
				Customa customaZ = customaY.get();
				customaZ.setFirstName(customaX.getFirstName());
				customaZ.setLastName(customaX.getLastName());
				customaZ.setEmail(customaX.getEmail());
				customaZ = repo.save(customaZ);
				System.out.println("\n ==============================UPDATED ONE =========================\n");
				System.out.println("     LastName of records : " + customaZ.getLastName() + "\n");
				return customaZ;
			} else { // Create customa for MISSING ID
				customaX = repo.save(customaX);
				System.out.println("\n ==============================CREATE TWO =========================\n");
				System.out.println("     LastName of records : " + customaX.getLastName() + "\n");
				return customaX;
			}
		}
	}

	public List<Customa> readAllRecords(String keyword) {
		List<Customa> result;
		if (keyword != null) {
			result = (List<Customa>) repo.findCustoma(keyword);
		} else {
			result = (List<Customa>) repo.findAll();
		}
		if (result.size() > 0) {
			System.out.println("\n ========================= PRESENT RECORDS ===========================\n");
			System.out.println("     Total number of records : " + result.size() + "\n");
			return result;
		} else {
			System.out.println("\n =========================== ABSENT RECORDS ===========================\n");
			System.out.println("     Total number of records : " + result.size() + "\n");
			return new ArrayList<Customa>();
		}
	}

	public Customa recordToUpdate(Long id) throws RecordNotFoundException {
		Optional<Customa> customaX = repo.findById(id);
		if (customaX.isPresent()) {
			System.out.println("\n ============================= TobeUpDated =========================\n");
			System.out.println("     Update records ID : " + customaX.get().getId() + "");
			System.out.println("     Update lastname   : " + customaX.get().getLastName() + "\n");
			return customaX.get();
		} else {
			throw new RecordNotFoundException("No such record exist for given id");
		}
	}

	public void deleteCustomaID(Long id) throws RecordNotFoundException {
		Optional<Customa> customaX = repo.findById(id);
		if (customaX.isPresent()) {
			System.out.println("\n ============================= TobeDeleted =========================\n");
			System.out.println("     Deleted records ID : " + customaX.get().getId() + "");
			System.out.println("     Deleted lastname   : " + customaX.get().getLastName() + "\n");
			repo.deleteById(id);
		} else {
			throw new RecordNotFoundException("No such record exist in the database");
		}
	}
}
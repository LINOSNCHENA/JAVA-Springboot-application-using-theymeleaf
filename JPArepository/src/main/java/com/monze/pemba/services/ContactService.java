package com.monze.pemba.services;

import java.util.List;

import com.monze.pemba.controllers.ContactRepository;
import com.monze.pemba.model.Contact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService {
	@Autowired
	private ContactRepository repo;
	
	public List<Contact> listAll(String keyword) {
		if (keyword != null) {
			return repo.search(keyword);
		}
		return repo.findAll();
	}
	
	public void save(Contact Contact) {
		repo.save(Contact);
	}
	
	public Contact get(Long id) {
		return repo.findById(id).get();
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
}


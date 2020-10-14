package com.monze.pemba.controllers;

import java.util.List;

import com.monze.pemba.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ContactRepository extends JpaRepository<Contact, Long> {
	@Query("SELECT contactX FROM Contact contactX WHERE CONCAT(contactX.name, ' ', contactX.mobile, ' ', contactX.office, ' ', contactX.stars) LIKE %?1%")
	public List<Contact> search(String keyword);
}

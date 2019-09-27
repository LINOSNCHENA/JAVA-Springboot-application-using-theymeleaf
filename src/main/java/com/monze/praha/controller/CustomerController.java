package com.monze.praha.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.GetMapping;
import com.monze.praha.exception.RecordNotFoundException;
import com.monze.praha.model.CustomerEntity;
import com.monze.praha.service.CustomerService;

@Controller
@RequestMapping("/")
public class CustomerController 
{
	@Autowired
	CustomerService service;

//http://localhost:8080
	@RequestMapping
	public String getAllCustomers(Model model) 
	{ List<CustomerEntity> list = service.getAllCustomers();
		model.addAttribute("customers", list);
		return "customerDisplays";
	}
// http://localhost:8080/edit[id]
	@GetMapping(path = {"/edit", "/edit/{id}"})
	public String editCustomerById(Model model, @PathVariable("id") Optional<Long> id) 
							throws RecordNotFoundException 
	{
		if (id.isPresent()) {
			CustomerEntity entity = service.getCustomerById(id.get());
			model.addAttribute("customer", entity);
		} else {
			model.addAttribute("customer", new CustomerEntity());
		}
		return "customerAddition";
	}
	

// http://localhost:8080/createCustomer

@RequestMapping(path = "/createCustomer",method = { RequestMethod.PUT, RequestMethod.POST })
	public String createOrUpdateCustomer(CustomerEntity customer) 
	{
		service.createOrUpdateCustomer(customer);
		return "redirect:/";
	}
}

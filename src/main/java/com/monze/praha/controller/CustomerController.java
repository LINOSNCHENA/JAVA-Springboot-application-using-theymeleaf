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
{	@Autowired
	CustomerService service;

//http://localhost:8080/
@RequestMapping
	public String readCustomers(Model model) 
	{ List<CustomerEntity> list = service.readCustomers();
		model.addAttribute("customers", list);	return "customerDisplays";	} // current searchings

// http://localhost:8080/edit[id]
@GetMapping(path = {"/ones", "/ones/{id}"})		// First and second versioning
	public String readCustomerById(Model model, @PathVariable("id") Optional<Long> id) 
		throws RecordNotFoundException 
	   {if (id.isPresent()) {
			CustomerEntity entity = service.readOneCustomer(id.get());
			model.addAttribute("customer", entity);		} 
		else {	model.addAttribute("customer", new CustomerEntity());	}
		return "customerAddition";}

// http://localhost:8080/createCustomer
@RequestMapping(path = "/createCustomer",	method = { RequestMethod.PUT, RequestMethod.POST })
	public String createCustomer(CustomerEntity customer)  // jumps out of recreate to redirect
	{	service.creatingCustomer(customer);		 return "redirect:/";	}

// http://localhost:8080/delete/[;id]
@RequestMapping(path = "/delete/{id}")
public String deleteEmployeeById(Model model, @PathVariable("id") Long id)
    throws RecordNotFoundException
    {   service.deleteEmployeeById(id);      		     return "redirect:/";    }
}

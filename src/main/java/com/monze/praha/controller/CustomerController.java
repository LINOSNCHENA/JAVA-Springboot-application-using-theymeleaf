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
	CustomerService serviceIoC;

//http://localhost:8080/		            #1
@RequestMapping
	public String readCustomers(Model participantX) 
	{ List<CustomerEntity> list = serviceIoC.readCustomers();
		participantX.addAttribute("customers", list);	
		return "customerDisplays";	
	} 												// Current searchings

// http://localhost:8080/edit[id]		    #2
@GetMapping(path = {"/added", "/added/{id}"})		// First and second versioning
	public String readCustomerById(Model participantX, @PathVariable("id") Optional<Long> id) 
		throws RecordNotFoundException 
	   {if (id.isPresent()) {
			CustomerEntity entity = serviceIoC.readOneCustomer(id.get());
			participantX.addAttribute("customer", entity);		} 
		else {	participantX.addAttribute("customer", new CustomerEntity());	}
		return "customerAddition";}

// http://localhost:8080/createCustomer		#3
@RequestMapping(path = "/createCustomer",	method = { RequestMethod.PUT, RequestMethod.POST })
	public String createCustomer(CustomerEntity participantX)  // Jumps out of recreate to redirect
	{	serviceIoC.creatingCustomer(participantX);		 
		return "redirect:/";	
	}

// http://localhost:8080/delete/[;id]		#4
@RequestMapping(path = "/delete/{id}")
public String deleteEmployeeById(Model model, @PathVariable("id") Long id)
    throws RecordNotFoundException
	{   serviceIoC.deleteEmployeeById(id);      		    
		 return "redirect:/";    
	}														// Delete
}

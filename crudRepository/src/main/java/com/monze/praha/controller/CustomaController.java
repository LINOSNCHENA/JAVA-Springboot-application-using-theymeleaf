package com.monze.praha.controller;

import java.util.List;
import java.util.Optional;
import com.monze.praha.exception.RecordNotFoundException;
import com.monze.praha.model.Customa;
import com.monze.praha.service.CustomaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class CustomaController {
	@Autowired
	CustomaService serviceIoC;
	///////////////////////////////////////////////////////////////////////////////////////////////
	@RequestMapping(path = "/createdCustomer", method = { RequestMethod.PUT, RequestMethod.POST })
	public String createCustomer(Customa customaX) 
	{
		serviceIoC.creatingCustomer(customaX);
		return "redirect:/";
		//return "editContact";
	}

	@GetMapping(path = { "/added", "/added/{id}" })
	public String readCustomerById(Model customaX, @PathVariable("id") Optional<Long> id)
			throws RecordNotFoundException {
	//	if (id.isPresent()) {
			Customa entity = serviceIoC.readOneCustomer(id.get());
			customaX.addAttribute("customer", entity);
	//	} else {
		//	customaX.addAttribute("customer", new Customa());
	//	}
		return "addContact";
	}

	// @GetMapping(path = { "/added", "/added/{id}" })
	// public String readCustomerById2(Model customaX, @PathVariable("id") Optional<Long> id)
	// 		throws RecordNotFoundException {
	// 	if (id.isPresent()) {
	// 		Customa entity = serviceIoC.readOneCustomer(id.get());
	// 		customaX.addAttribute("customer", entity);
	// 	} else {
	// 		customaX.addAttribute("customer", new Customa());
	// 	}
	// 	return "addContact";
	// }

	///////////////////////////////////////////////////////////////////////////////////////////////

	@RequestMapping
	public String readCustomers(Model customaX, @Param("keyword") String keyword) {
		List<Customa> customaList = serviceIoC.readCustomers(keyword);
		customaX.addAttribute("customaList", customaList);
		customaX.addAttribute("keyword", keyword);
		return "listContacts";
	}

	@RequestMapping(path = "/delete/{id}")
	public String deleteEmployeeById(Model model, @PathVariable("id") Long id) throws RecordNotFoundException
	 {
		serviceIoC.deleteEmployeeById(id);
		return "redirect:/";
	}
}

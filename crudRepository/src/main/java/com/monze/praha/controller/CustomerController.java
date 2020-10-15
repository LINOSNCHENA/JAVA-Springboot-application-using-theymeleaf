package com.monze.praha.controller;

import java.util.List;
import java.util.Optional;

import com.monze.praha.exception.RecordNotFoundException;
import com.monze.praha.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.monze.praha.model.Customerentity;

@Controller
@RequestMapping("/")
public class CustomerController {
	@Autowired
	CustomerService serviceIoC;

	@RequestMapping(path = "/createCustomer", method = { RequestMethod.PUT, RequestMethod.POST })
	public String createCustomer(Customerentity participantX) {
		serviceIoC.creatingCustomer(participantX);
		return "redirect:/";
	}

	@RequestMapping
	public String readCustomers(Model participantX,@Param("keyword") String keyword) {
		List<Customerentity> customers = serviceIoC.readCustomers(keyword);
		participantX.addAttribute("customers", customers);
		//participantX.addAttribute("listContacts", list);
		participantX.addAttribute("keyword", keyword);
		return "listContacts";
	}

	@GetMapping(path = { "/added", "/added/{id}" })
	public String readCustomerById(Model participantX, @PathVariable("id") Optional<Long> id)
			throws RecordNotFoundException {
		if (id.isPresent()) {
			Customerentity entity = serviceIoC.readOneCustomer(id.get());
			participantX.addAttribute("customer", entity);
		} else {
			participantX.addAttribute("customer", new Customerentity());
		}
		return "addContact";
	}

	@RequestMapping(path = "/delete/{id}")
	public String deleteEmployeeById(Model model, @PathVariable("id") Long id) throws RecordNotFoundException {
		serviceIoC.deleteEmployeeById(id);
		return "redirect:/";
	}
}

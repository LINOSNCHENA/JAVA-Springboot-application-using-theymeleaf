package com.monze.pemba.controllers;

import java.util.List;

import com.monze.pemba.model.Contact;
import com.monze.pemba.services.ContactService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {
	@Autowired
	private ContactService service;

	@RequestMapping("/")
	public String viewHomePage(Model model, @Param("keyword") 
	String keyword) {
		List<Contact> listContacts = service.listAll(keyword);
		model.addAttribute("listContacts", listContacts);
		model.addAttribute("keyword", keyword);

		return "list";
	}

	@RequestMapping("/new")
	public String showNewContactForm(Model model) {
		Contact Contact = new Contact();
		model.addAttribute("Contact", Contact);

		return "create";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveContact(@ModelAttribute("Contact") Contact Contact) {
		service.save(Contact);

		return "redirect:/";
	}

	@RequestMapping("/edit/{id}")
	public ModelAndView showEditContactForm(@PathVariable(name = "id") Long id) {
		ModelAndView mav = new ModelAndView("edit");

		Contact Contact = service.get(id);
		mav.addObject("Contact", Contact);

		return mav;
	}

	@RequestMapping("/delete/{id}")
	public String deleteContact(@PathVariable(name = "id") Long id) {
		service.delete(id);

		return "redirect:/";
	}
}

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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class CustomaController {
	@Autowired
	CustomaService serviceIoC;

	///////////////////////////////////////////////////////////////////////////////////////////////
	@GetMapping(path = { "/added", "/added/{id}" }) // with and without id
	public String readCustomerById(Model customaX, @PathVariable("id") Optional<Long> id)
			throws RecordNotFoundException {
		if (id.isPresent()) {
			Customa entity = serviceIoC.recordToUpdate(id.get());
			customaX.addAttribute("customer", entity);
			System.out.print("\n ======================PRESENT===============\n ");
			System.out.print("\n ====================== " + entity.getId() + " ===============\n ");
			System.out.print("\n ======================PRESENT===============\n ");
			return "editContact";
		} else {
			customaX.addAttribute("customer", new Customa());
			System.out.print("\n ======================ABSENT===============\n");
			System.out.print("\n =====================" + id + "===============\n");
			System.out.print("\n ======================ABSENT===============\n");
			return "addContact";
		}
		//return "addContact";
	}

	@RequestMapping("/new")
	public String showNewContactForm(Model model) {
		Customa Contact = new Customa();
		model.addAttribute("Customa", Contact);
		return "create";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveContact(@ModelAttribute("Customa") Customa Contact) {
		serviceIoC.save(Contact);
		return "redirect:/";
	}

	@RequestMapping("/edit/{id}")
	public ModelAndView showEditContactForm(@PathVariable(name = "id") Long id) {
		ModelAndView mav = new ModelAndView("edit");

		Customa Customa = serviceIoC.get(id);
		mav.addObject("Customa", Customa);

		return mav;
	}

	///////////////////////////////////////////////////////////////////////////////////////////////

	@RequestMapping(path = "/createdCustomer", method = { RequestMethod.PUT, RequestMethod.POST })
	public String createOrUpdate(Customa customaX) {
		serviceIoC.createOrEditCustoma(customaX);
		return "redirect:/";
	}

	@RequestMapping(path = "/delete/{id}")
	public String deleteCustomaID(Model model, @PathVariable("id") Long id) throws RecordNotFoundException {
		serviceIoC.deleteCustomaID(id);
		return "redirect:/";
	}

	@RequestMapping
	public String readAllRecords(Model customaX, @Param("keyword") String keyword) {
		List<Customa> customaList = serviceIoC.readAllRecords(keyword);
		customaX.addAttribute("customaList", customaList);
		customaX.addAttribute("keyword", keyword);
		return "listContacts";
	}
	//////////////////////////////////////////////////////////////////////////////////////////////
}

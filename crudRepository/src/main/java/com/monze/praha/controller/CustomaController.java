package com.monze.praha.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.GetMapping;
import com.monze.praha.exception.RecordNotFoundException;
import com.monze.praha.model.Customa;
import com.monze.praha.service.CustomaService;

@Controller
@RequestMapping("/")
public class CustomaController {
	@Autowired
	CustomaService serva;

	@RequestMapping(path = "/createOrUpdate", method = { RequestMethod.PUT, RequestMethod.POST })
	public String createOrUpdate(Customa objX) {
		serva.createOrEditCustoma(objX);
		return "redirect:/";
	}

	@RequestMapping
	public String readAllRecords(Model objX, @Param("keyword") String keyword) {
		List<Customa> customaData = serva.readAllRecords(keyword);
		objX.addAttribute("customaData", customaData);
		objX.addAttribute("keyword", keyword);
		return "listContacts";
	}

	@GetMapping(path = { "/added", "/added/{id}" })
	public String updateCustoma(Model objX, @PathVariable("id") Optional<Long> id)
			throws RecordNotFoundException {
		if (id.isPresent()) {
			Customa entity = serva.recordToUpdate(id.get());
			objX.addAttribute("customer", entity);
		} else {
			objX.addAttribute("customer", new Customa());
		}
		return "addContact";
	}

	@RequestMapping(path = "/delete/{id}")
	public String deleteCustomaID(Model model, @PathVariable("id") Long id) throws RecordNotFoundException {
		serva.deleteCustomaID(id);
		return "redirect:/";
	}
}

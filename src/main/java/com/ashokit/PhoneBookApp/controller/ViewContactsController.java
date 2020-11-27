package com.ashokit.PhoneBookApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ashokit.PhoneBookApp.model.ContactPojo;
import com.ashokit.PhoneBookApp.service.ContactService;

@Controller
public class ViewContactsController {

	@Autowired private ContactService cs;
	
	/*here we must use only @RequestParam as parameter to get id from "Form" 
	if we use "@PathVariable/@PathParam" we won't get id(i.e we get id =null)
	
*/	@GetMapping("/editContact")
	public String handleEditHyprLnk(@RequestParam("cid") Integer id, Model m){	
		ContactPojo editablePojo = cs.editGetContactById(id);
		
		m.addAttribute("contactpojo", editablePojo);
		
		return "displayIndex";
	}	// edit contact data in ContactInfoController i.e to edit contact
	
	
	@GetMapping("/deleteContact")
	public String handleDeleteHyprLnk(@RequestParam("contactid") Integer id, RedirectAttributes redattr){
		cs.deleteContactById(id);
		
		redattr.addFlashAttribute("delMsg", "Contact deleted succesfully");
		return "redirect:viewAll";
	}	// delete contact
	
	public String handleAddNewContactHyprLnk(){
		return null;
	}	// link to ContactInfoController
}

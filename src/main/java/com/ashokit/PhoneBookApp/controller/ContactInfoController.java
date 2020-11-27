package com.ashokit.PhoneBookApp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ashokit.PhoneBookApp.model.ContactPojo;
import com.ashokit.PhoneBookApp.service.ContactService;

@Controller
public class ContactInfoController {

	// 1st day=====================================

	/*
	 * @GetMapping("/") public String diaplayIndexForm(){ return "displayIndex"; }
	 * // to display Form
	 * 
	 * public String handleSubmitBtn(ContactPojo c,Model m){ return null; } // Form
	 * submission
	 * 
	 * public String handleViewAllHyprLnk(Model m){ return null; } // link to
	 * ViewContactsController
	 */

	// 2nd day======================================
/*	@Autowired
	private ContactService cs;

	@GetMapping("/")
	public String diaplayIndexForm(Model m) {
		ContactPojo cp = new ContactPojo();
		m.addAttribute("contactpojo", cp);
		return "displayIndex";
	} // to display Form

	@PostMapping("/saveContact")
	public String handleSubmitBtn(@ModelAttribute("contactpojo") ContactPojo c, Model m) {
		boolean isSaved = cs.saveContact(c);

		if (isSaved) {
			m.addAttribute("sccMsg", "Contact saved successfully");
		} else
			m.addAttribute("errMsg", "Failed to save Contact");

		return "displayIndex";
	} // Form submission

	public String handleViewAllHyprLnk(Model m) {
		return null;
	} // link to ViewContactsController
*/	
//	-------------------------------------------------------------------------------------
	
//	assignment "double posting" resolve
	
	
	Logger l=LoggerFactory.getLogger(ContactInfoController.class);
	
	@Autowired
	private ContactService cs;

	/*@GetMapping({"/","loadFormAgain"})
	public String diaplayIndexForm(Model m) {
		ContactPojo cp = new ContactPojo();
		m.addAttribute("contactpojo", cp);
		return "displayIndex";
	} // to display Form

	@PostMapping("/saveContact")
	public String handleSubmitBtn(@ModelAttribute("contactpojo") ContactPojo c, Model m) {
	
	l.info("Form submitted  :: "+c);
		boolean isSaved = cs.saveContact(c);

		if (isSaved) {
			m.addAttribute("sccMsg", "Contact saved successfully");
		} else
			m.addAttribute("errMsg", "Failed to save Contact");

		return "redirect:formResubmission";
	} // Form submission
	
//	form resubmission
	
	@GetMapping("/formResubmission")
	public String resolveResubmission(Model m) {
		l.info("formResubmission method called");
//		ContactPojo cp = new ContactPojo();
//		m.addAttribute("contactpojo", cp);
		m.addAttribute("contactpojo", new ContactPojo());
		return "displayIndex";
	}*/

	/*public String handleViewAllHyprLnk(Model m) {
		return null;
	} // link to ViewContactsController
*/	
//	========  before form resubmission "msg" got printed
	/*========  after form resubmission success msg not printed due to Model scope to resolve
				we can use RedirectAttribute (RedirectAttributes for sending data from one method to another method)*/
	
	/*@GetMapping({"/","loadFormAgain"})
	public String diaplayIndexForm(Model m) {
		ContactPojo cp = new ContactPojo();
		m.addAttribute("contactpojo", cp);
		return "displayIndex";
	} // to display Form

	@PostMapping("/saveContact")
	public String handleSubmitBtn(@ModelAttribute("contactpojo") ContactPojo c, RedirectAttributes rattr) {
		l.info("Form submitted  :: "+c);
		boolean isSaved = cs.saveContact(c);

		if (isSaved) {
			rattr.addFlashAttribute("sccMsg", "Contact saved successfully");
		} else
			rattr.addFlashAttribute("errMsg", "Failed to save Contact");

		return "redirect:formResubmission";
	} // Form submission
	
//	form resubmission
	
	@GetMapping("/formResubmission")
	public String resolveResubmission(Model m) {
		l.info("formResubmission method called");
//		ContactPojo cp = new ContactPojo();
//		m.addAttribute("contactpojo", cp);
		m.addAttribute("contactpojo", new ContactPojo());
		return "displayIndex";
	}*/
	
//	==================3rd Day
	
	@GetMapping({"/","loadFormAgain"})
	public String diaplayIndexForm(Model m) {
		ContactPojo cp = new ContactPojo();
		m.addAttribute("contactpojo", cp);
		return "displayIndex";
	} // to display Form

	@PostMapping("/saveContact")
	public String handleSubmitBtn(@ModelAttribute("contactpojo") ContactPojo c, RedirectAttributes rattr) {
		l.info("Form submitted  :: "+c);
		boolean isSaved = cs.saveContact(c);

		if (isSaved) {
			if(c.getCid()!=null)
				rattr.addFlashAttribute("sccMsg", "Contact Upadated successfully");
			else
				rattr.addFlashAttribute("sccMsg", "Contact saved successfully");
		} else
			rattr.addFlashAttribute("errMsg", "Failed to save Contact");

		return "redirect:formResubmission";
	} // Form submission
	
//	form resubmission
	
	@GetMapping("/formResubmission")
	public String resolveResubmission(Model m) {
		l.info("formResubmission method called");
		m.addAttribute("contactpojo", new ContactPojo());
		return "displayIndex";
	}
	
	@GetMapping("/viewAll")
	public String handleViewAllHyprLnk(Model m) {
		l.info("getting all contacts:::::::");
		List<ContactPojo> listOfPojo=cs.getAllContacts();
		
		m.addAttribute("allContacts", listOfPojo);
		
		return "viewAllContacts";
	} // link to ViewContactsController
	
}

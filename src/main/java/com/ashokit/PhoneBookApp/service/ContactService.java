package com.ashokit.PhoneBookApp.service;

import java.util.List;

import com.ashokit.PhoneBookApp.model.ContactPojo;

public interface ContactService {

	//for first form
	public boolean saveContact(ContactPojo c);
	public List<ContactPojo> getAllContacts();
	
	//for second form
	public ContactPojo editGetContactById(Integer id);
	public boolean updateContact(ContactPojo c);
	public boolean deleteContactById(int id);
	
}

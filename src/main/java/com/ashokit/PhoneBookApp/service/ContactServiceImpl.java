package com.ashokit.PhoneBookApp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashokit.PhoneBookApp.dto.ContactDtlsEntity;
import com.ashokit.PhoneBookApp.model.ContactPojo;
import com.ashokit.PhoneBookApp.repository.ContactDtlsRepository;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactDtlsRepository repo;

	@Override
	public boolean saveContact(ContactPojo c) {

		ContactDtlsEntity contactEntity = new ContactDtlsEntity();

//		Copying properties from model to entity
		BeanUtils.copyProperties(c, contactEntity); // 1 way
//			======OR=========
//		2nd way

		/*
		 * contactEntity.setCemail(c.getContactEmail());
		 * contactEntity.setCname(c.getContactName());
		 * contactEntity.setCnumber(c.getContactNum());
		 */

		ContactDtlsEntity savedEntity = repo.save(contactEntity);

//		1st way to retun
		/*
		 * if(savedEntity.getCid()!=null) return true; else return false;
		 */
//		2nd way to return 

		/*
		 * boolean isSaved = false; if(savedEntity.getCid()!=null) isSaved=true; return
		 * isSaved;
		 */

//		3rd way to return 
		return savedEntity.getCid() != null;
	}

	@Override
	public List<ContactPojo> getAllContacts() {
		List<ContactPojo> pojoList = new ArrayList<>();

		List<ContactDtlsEntity> entityList = repo.findAll();
		entityList.forEach(entity -> {
			ContactPojo pojo = new ContactPojo();
			BeanUtils.copyProperties(entity, pojo);
			pojoList.add(pojo);
		});

		return pojoList;
	}

	@Override
	public ContactPojo editGetContactById(Integer id) {
//		ContactPojo contactPojo=null;
		Optional<ContactDtlsEntity> optionalEntity = repo.findById(id);
		if (optionalEntity.isPresent()) {
			ContactDtlsEntity entity = optionalEntity.get();
			ContactPojo contactPojo = new ContactPojo();
			BeanUtils.copyProperties(entity, contactPojo);
			return contactPojo;
		}
		return null;
	}

	@Override
	public boolean updateContact(ContactPojo c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteContactById(int id) {
		repo.deleteById(id);
		return true;
	}
}

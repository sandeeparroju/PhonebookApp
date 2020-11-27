package com.ashokit.PhoneBookApp.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="Contacts_Table")
public class ContactDtlsEntity {

	@Id
	@GeneratedValue
	@Column(name="contact_id")
	private Integer cid;
	

	@Column(name="contact_email")
	private String cemail;
	
	@Column(name="contact_name")
	private String cname;
	
	
	@Column(name="contact_number")
	private Long cnumber;
}

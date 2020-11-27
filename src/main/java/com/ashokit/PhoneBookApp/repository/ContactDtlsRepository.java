package com.ashokit.PhoneBookApp.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashokit.PhoneBookApp.dto.ContactDtlsEntity;


public interface ContactDtlsRepository extends JpaRepository<ContactDtlsEntity, Serializable> {

}

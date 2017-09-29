package com.phoenixtreeroot.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long id;
	
	@Column(name = "first_name")
	public String firstName;	
	@Column(name = "last_name")
	public String lastName;	
	@Column(name = "e_mail", unique = true, nullable=false)
	public String email;	
	@JsonIgnore
	@Column(nullable=false)
	public String password;
	@Temporal(TemporalType.TIMESTAMP)
	private Date created;
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastLogin;
		
}

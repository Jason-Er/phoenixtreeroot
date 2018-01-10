package com.phoenixtreeroot.model.system;

import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.JoinColumn;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="sys_user")
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
	@Column(unique = true, nullable=false)
	public String cel;
	// @JsonIgnore
	@Column(nullable=false)
	public String password;
	@Column(nullable=false)
	public boolean enabled = false;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date created;
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastLogin;
		
	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "sys_users_roles", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    public Collection<Role> roles;
}

package com.phoenixtreeroot.model.script;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.phoenixtreeroot.model.system.User;

@Entity
@Table(name="script_play")
public class Play {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	public Long id;
	
	@Column(nullable=false)
	public String name;
	
	@ManyToOne
	public User playwright;
	
	@Column(name = "playwright_id", insertable = false, updatable = false)
	public Long playwrightId;
	
	@OneToMany(mappedBy = "play", cascade = CascadeType.ALL)
	@JsonManagedReference
	public List<Scene> scenes;
	
	@OneToMany(mappedBy = "play", cascade = CascadeType.ALL)
	@JsonManagedReference
	public List<Role> cast;

}

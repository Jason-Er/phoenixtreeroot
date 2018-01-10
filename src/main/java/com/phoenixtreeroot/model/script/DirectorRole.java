package com.phoenixtreeroot.model.script;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.phoenixtreeroot.model.system.Privilege;
import com.phoenixtreeroot.model.system.User;

@Entity
@Table(name="director_role")
public class DirectorRole {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long id;
	
	@Column(name = "first_name")
    public String firstName;

    @Column(name = "last_name")
    public String lastName;

    public String description;
    
    @ManyToOne(optional = false, fetch = FetchType.EAGER)	
	@JsonBackReference
	public DirectorPlay stagePlay;        
	@Column(name = "stage_play_id", insertable = false, updatable = false)
	public Long stagePlayId;
		
	@ManyToOne(optional = false, fetch = FetchType.EAGER)	
	@JsonBackReference
	public User user;	
	@Column(name = "user_id", insertable = false, updatable = false)
	public Long userId;
	
	@ManyToMany
    @JoinTable(name = "director_role_privileges", joinColumns = @JoinColumn(name = "director_role_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "privilege_id", referencedColumnName = "id"))
    public Collection<Privilege> permissions;
}

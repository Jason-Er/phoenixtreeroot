package com.phoenixtreeroot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="stage_role")
public class StageRole {
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
	public StagePlay stagePlay;        
	@Column(name = "stage_play_id", insertable = false, updatable = false)
	public Long stagePlayId;
		
	@ManyToOne(optional = false, fetch = FetchType.EAGER)	
	@JsonBackReference
	public User user;	
	@Column(name = "user_id", insertable = false, updatable = false)
	public Long userId;
     
}

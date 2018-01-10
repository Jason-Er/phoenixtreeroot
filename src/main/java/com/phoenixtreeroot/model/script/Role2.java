package com.phoenixtreeroot.model.script;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="script_role")
public class Role2 {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long id;
	
	@Column(name = "first_name")
    public String firstName;

    @Column(name = "last_name")
    public String lastName;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)	
	@JsonBackReference
	public Play play;
        
	@Column(name = "play_id", insertable = false, updatable = false)
	public Long playId;	
    
    public String description;
		
}

package com.phoenixtreeroot.model.script;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="script_line")
public class Line {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long id;

	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JsonBackReference
	public Scene scene;
		
	@Column(name = "scene_id", insertable = false, updatable = false)
	public Long sceneId;		
	
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JsonBackReference
	public Role2 role;
		
	@Column(name = "role_id", insertable = false, updatable = false)
	public Long roleId;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable=false)
	public LineType type;
	
	@Column(name = "stage_direction")
    public String stageDirection;
	
	@Column(nullable=false)
	public String dialogue;
	
	

}

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
import com.phoenixtreeroot.common.type.LineType;

@Entity
@Table(name="director_line")
public class DirectorLine {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long id;
	
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JsonBackReference
	public DirectorScene stageScene;
		
	@Column(name = "stage_scene_id", insertable = false, updatable = false)
	public Long stageSceneId;
	
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JsonBackReference
	public DirectorRole stageRole;

	@Column(name = "stage_role_id", insertable = false, updatable = false)
	public Long stageRoleId;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable=false)
	public LineType type;
	
	@Column(name = "stage_direction")
    public String stageDirection;
	
	@Column(nullable=false)
	public String dialogue;
	
	@Column(name = "begin_time")
	public float beginTime;
	
	@Column(name = "audio_url")
	public String audioURL;
		
}

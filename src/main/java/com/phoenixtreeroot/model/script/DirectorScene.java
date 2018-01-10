package com.phoenixtreeroot.model.script;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="director_scene")
public class DirectorScene {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long id;

	@ManyToOne(optional = false, fetch = FetchType.EAGER)	
	@JsonBackReference
	public DirectorPlay stagePlay;	
	@Column(name = "stage_play_id", insertable = false, updatable = false)
	public Long stagePlayId;
	
	@OneToMany(mappedBy = "stageScene", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonManagedReference
	public List<DirectorLine> stageLines;
	
	@Column(name = "act_ordinal")
	public Long actOrdinal;
	public Long ordinal;
		
	public String setting;
	@Column(name = "at_rise")
	public String atrise;
	
	@Column(name = "action_script")
	public String actionScript;
	
	@Column(name = "setting_url")
	public String settingURL;
	
	@Column(name = "bgm_url")
	public String backgroundMusicURL;

}

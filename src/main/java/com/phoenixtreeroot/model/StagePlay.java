package com.phoenixtreeroot.model;

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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="stage_play")
public class StagePlay {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	public Long id;
	
	@Column(nullable=false)
	public String name;
	
	@Column(name = "poster_url")
	public String posterURL;	
	public String briefIntro;
	
	@ManyToOne
	@JsonIgnore
	public Play play;
	@Column(name = "play_id", insertable = false, updatable = false)
	public Long playId;
	
	@ManyToOne
	public User director;	
	@Column(name = "director_id", insertable = false, updatable = false)
	public Long directorId;
	
	@ManyToOne
	public Stage stage;
	@Column(name = "stage_id", insertable = false, updatable = false)
	public long stageId;
	
	@OneToMany(mappedBy = "stagePlay", cascade = CascadeType.ALL)
	@JsonManagedReference
	public List<StageScene> scenes;
	
	@OneToMany(mappedBy = "stagePlay", cascade = CascadeType.ALL)
	@JsonManagedReference
	public List<StageRole> cast;
	
}

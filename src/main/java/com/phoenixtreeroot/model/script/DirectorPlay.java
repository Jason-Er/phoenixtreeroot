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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;
import com.phoenixtreeroot.model.label.View;
import com.phoenixtreeroot.model.system.User;

@Entity
@Table(name="director_play")
public class DirectorPlay {
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
	public WriterPlay play;
	@Column(name = "play_id", insertable = false, updatable = false)	
	public Long playId;
	
	@ManyToOne
	@JsonView(View.StagePlay.class)
	public User director;
	@Column(name = "director_id", insertable = false, updatable = false)
	public Long directorId;
	
	@ManyToOne	
	@JsonView(View.StagePlay.class)
	public Stage stage;
	@Column(name = "stage_id", insertable = false, updatable = false)
	public long stageId;
	
	@OneToMany(mappedBy = "stagePlay", cascade = CascadeType.ALL)
	@JsonManagedReference
	@JsonView(View.StagePlay.class)
	public List<DirectorScene> scenes;
	
	@OneToMany(mappedBy = "stagePlay", cascade = CascadeType.ALL)
	@JsonManagedReference
	@JsonView(View.StagePlay.class)
	public List<DirectorRole> cast;
	
}

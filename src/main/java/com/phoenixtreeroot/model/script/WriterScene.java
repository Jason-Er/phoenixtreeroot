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
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="writer_scene")
public class WriterScene {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long id;

	@ManyToOne(optional = false, fetch = FetchType.EAGER)	
	@JsonBackReference
	public WriterPlay play;
	
	@Column(name = "play_id", insertable = false, updatable = false)
	public Long playId;
	
	@OneToMany(mappedBy = "scene", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonManagedReference
	public List<WriterLine> lines;
	
	@Column(name = "act_ordinal")
	public Long actOrdinal;
	public Long ordinal;
		
	public String setting;
	@Column(name = "at_rise")
	public String atrise;	
	
}

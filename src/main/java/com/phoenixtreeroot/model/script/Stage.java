package com.phoenixtreeroot.model.script;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="script_stage")
public class Stage {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long id;
	
	public float length;
	public float width;
	
	@Column(name = "setting_height")
	public float settingHeight;
}

package com.phoenixtreeroot.model.script;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.phoenixtreeroot.model.system.Privilege;

@Entity
@Table(name="script_stage_role_permissions")
public class StageRolePermissions {	
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
	
	@OneToOne(targetEntity = StageRole.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "stage_role_id")
	public StageRole stageRole;	
	
	@ManyToMany
    @JoinTable(name = "script_stage_role_privileges", joinColumns = @JoinColumn(name = "stage_role_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "privilege_id", referencedColumnName = "id"))
    public Collection<Privilege> permissions;
		
}

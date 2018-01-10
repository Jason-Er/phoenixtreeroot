package com.phoenixtreeroot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.phoenixtreeroot.model.system.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
	Role findByName(String name);	
}

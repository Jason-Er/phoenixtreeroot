package com.phoenixtreeroot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.phoenixtreeroot.model.system.Role;
import com.phoenixtreeroot.repository.RoleRepository;

@Service("roleService")
@Transactional
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository repository;
	
	@Override
	public void saveRole(Role role) {
		repository.save(role);		
	}

	@Override
	public Role findByName(String name) {		
		return repository.findByName(name);
	}

}

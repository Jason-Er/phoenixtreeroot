package com.phoenixtreeroot.service;

import com.phoenixtreeroot.model.system.Role;

public interface RoleService {
	void saveRole(Role role);
	Role findByName(String name);
}

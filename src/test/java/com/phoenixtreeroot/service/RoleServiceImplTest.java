package com.phoenixtreeroot.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.phoenixtreeroot.model.system.Role;
import com.phoenixtreeroot.model.system.RoleType;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleServiceImplTest {
	
	@Autowired
    private RoleService roleService;
	
	@Test
    public void testFindByName() {
		Role role = roleService.findByName(RoleType.AUDIENCE.name());
		assertNotNull(role);
	}
	
}

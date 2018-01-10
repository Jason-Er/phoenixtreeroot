package com.phoenixtreeroot.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.phoenixtreeroot.exception.UserAlreadyExistException;
import com.phoenixtreeroot.model.system.Role;
import com.phoenixtreeroot.model.system.RoleType;
import com.phoenixtreeroot.model.system.User;
import com.phoenixtreeroot.repository.RoleRepository;
import com.phoenixtreeroot.repository.UserRepository;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;

	@Autowired
    private RoleRepository roleRepository;
	
	@Override
	public User findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}	

	@Override
	public User findByEmail(String email) {		
		return userRepository.findByEmail(email);
	}
	
	@Override
	public User findByCel(String cel) {
		return userRepository.findByCel(cel);		
	}

	@Override
	public void saveUser(User user) {		
		userRepository.save(user);
	}

	@Override
	public void deleteUserById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllUsers() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> findAllUsers() {		
		return userRepository.findAll();
	}

	@Override
	public Page<User> findByPage(Pageable var1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isUserExist(User user) {		
		return (userRepository.findByEmail(user.email) != null || userRepository.findByCel(user.cel) != null);
	}

	@Override
	public User registerNewUserAccount(User user) throws UserAlreadyExistException {
		if( isUserExist(user) ) {
			throw new UserAlreadyExistException("There is an account with that email adress: " + user.email);
		}
		Role role = roleRepository.findByName(RoleType.AUDIENCE.name());		
		user.roles = Arrays.asList(role);		
		return userRepository.save(user);
	}

}

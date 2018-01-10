package com.phoenixtreeroot.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.phoenixtreeroot.exception.UserAlreadyExistException;
import com.phoenixtreeroot.model.system.User;

public interface UserService {
	
	User registerNewUserAccount(User user) throws UserAlreadyExistException;
	
	User findById(Long id);

	User findByEmail(String email);
	
	User findByCel(String cel);

	void saveUser(User user);

	void deleteUserById(Long id);

	void deleteAllUsers();

	List<User> findAllUsers();

	Page<User> findByPage(Pageable var1);

	boolean isUserExist(User user);
}

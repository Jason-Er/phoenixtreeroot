package com.phoenixtreeroot.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.phoenixtreeroot.common.type.TokenType;
import com.phoenixtreeroot.exception.UserAlreadyExistException;
import com.phoenixtreeroot.model.system.User;

public interface UserService {
	
	User registerNewUserAccount(User user) throws UserAlreadyExistException;
	
	void createVerificationTokenForUser(User user, String token);
	
	TokenType validateVerificationToken(String token);
	
	User findByToken(String verificationToken);
	
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

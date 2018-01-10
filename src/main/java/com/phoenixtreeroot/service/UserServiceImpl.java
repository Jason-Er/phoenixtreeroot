package com.phoenixtreeroot.service;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.phoenixtreeroot.common.type.RoleType;
import com.phoenixtreeroot.common.type.TokenType;
import com.phoenixtreeroot.exception.UserAlreadyExistException;
import com.phoenixtreeroot.model.system.Role;
import com.phoenixtreeroot.model.system.User;
import com.phoenixtreeroot.model.system.VerificationToken;
import com.phoenixtreeroot.repository.RoleRepository;
import com.phoenixtreeroot.repository.UserRepository;
import com.phoenixtreeroot.repository.VerificationTokenRepository;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;

	@Autowired
    private RoleRepository roleRepository;
	
	@Autowired
    private VerificationTokenRepository verificationTokenRepository;
	
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

	@Override
	public void createVerificationTokenForUser(User user, String token) {
		final VerificationToken myToken = new VerificationToken(token, user);
		verificationTokenRepository.save(myToken);
		
	}

	@Override
	public TokenType validateVerificationToken(String token) {
		final VerificationToken verificationToken = verificationTokenRepository.findByToken(token);
        if (verificationToken == null) {
            return TokenType.INVALID;
        }

        final User user = verificationToken.user;
        final Calendar cal = Calendar.getInstance();
        if ((verificationToken.expiryDate.getTime() - cal.getTime().getTime()) <= 0) {
        	verificationTokenRepository.delete(verificationToken);
            return TokenType.EXPIRED;
        }

        user.enabled = true;
        // tokenRepository.delete(verificationToken);
        userRepository.save(user);
        return TokenType.VALID;		
	}

	@Override
	public User findByToken(String verificationToken) {
		final VerificationToken token = verificationTokenRepository.findByToken(verificationToken);
        if (token != null) {
            return token.user;
        }
        return null;
	}

}

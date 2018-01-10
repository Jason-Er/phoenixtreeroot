package com.phoenixtreeroot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.phoenixtreeroot.model.system.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String email);
	User findByCel(String cel);
}

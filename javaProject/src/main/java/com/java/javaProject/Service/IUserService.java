package com.java.javaProject.Service;

import java.util.Optional;

import com.java.javaProject.Entity.User;

public interface IUserService {
	boolean registerUser(String username, String password);
	Optional<User> authenticateUser(String username, String password);
	Optional<User> findByUsername(String username);
	boolean registerUser(User user);
}

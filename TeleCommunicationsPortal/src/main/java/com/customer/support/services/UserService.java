package com.customer.support.services;

import com.customer.support.entities.User;

public interface UserService {

	public String signUp(User user);
	public Iterable<User> getAllUsers();
	public String signIn(String userMail , String password);
}

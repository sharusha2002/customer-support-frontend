package com.customer.support.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.customer.support.entities.User;

public interface UserRepository extends JpaRepository<User,Integer>{

	public Optional<User> findByUserMail(String userMail);
}

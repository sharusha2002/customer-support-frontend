package com.customer.support.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.customer.support.entities.UserIssue;

public interface UserIssueRepository extends JpaRepository<UserIssue,String>{

}

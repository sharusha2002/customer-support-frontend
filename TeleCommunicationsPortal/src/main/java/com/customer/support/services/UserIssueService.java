package com.customer.support.services;

import com.customer.support.entities.UserIssue;

public interface UserIssueService {
	public void raiseIssue(UserIssue userIssue, Integer loggedInUserId);
	
}

package com.customer.support.services;
import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.support.entities.User;
import com.customer.support.entities.UserIssue;
import com.customer.support.repositories.UserIssueRepository;



@Service
public class UserIssueServiceImpl implements UserIssueService {
	
	private UserIssueRepository repository;
	
	@Autowired
	IssueTicketService issueTicketService;
	
	@Autowired
	public void setRepository(UserIssueRepository repository) {
		this.repository = repository;
	}

	@Override
	public void raiseIssue(UserIssue userIssue , Integer loggedInUserId) {
		long millis=System.currentTimeMillis();
		Date currentDate = new Date(millis);
		userIssue.setIssueDate(currentDate);
	
		userIssue.setUser(new User(loggedInUserId));
		
		repository.save(userIssue);
		//System.out.println(userIssue.getIssueId());
		issueTicketService.generateTicket(userIssue.getIssueId());
		
		}

}

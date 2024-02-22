package com.customer.support.services;

import com.customer.support.entities.IssueTicket;
import com.customer.support.entities.IssueTicket.TicketStatus;
import com.customer.support.entities.UserIssue;
import com.customer.support.repositories.IssueTicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Calendar;

@Service
public class IssueTicketServiceImpl implements IssueTicketService {
 
	private IssueTicketRepository repository;
	
	@Autowired
	public IssueTicketServiceImpl(IssueTicketRepository repository) {
		this.repository = repository;
	}

	@Override
	public void generateTicket(String userIssueId) {
		IssueTicket issueTicket = new IssueTicket();
		issueTicket.setTicketStatus(TicketStatus.RAISED);
		
		UserIssue userIssue = new UserIssue();
		userIssue.setIssueId(userIssueId);
		issueTicket.setUserIssue(userIssue);
		
		long millis = System.currentTimeMillis();
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, 3);
		Date expectedDate = new Date(calendar.getTimeInMillis());
		issueTicket.setExpectedResolutionDate(expectedDate);
		
		Date currentDate = new Date(millis);
		issueTicket.setIssueDate(currentDate);
		
		repository.save(issueTicket);
	}
}

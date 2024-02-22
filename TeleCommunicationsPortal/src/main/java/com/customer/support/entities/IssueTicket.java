package com.customer.support.entities;

import java.util.Date;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;

@Entity
public class IssueTicket {

	public enum TicketStatus {
		RAISED, ONPROCESS, RESOLVED
	}

	@Id
	private String ticketId;

	@PrePersist
	public void generateTicketId() {
		this.ticketId = UUID.randomUUID().toString().substring(2, 13);
	}
	private Date issueDate;
	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}
	
	@Enumerated(EnumType.STRING)
	private TicketStatus ticketStatus;

	private Date expectedResolutionDate;

	@OneToOne
	private UserIssue userIssue;

	public IssueTicket() {

	}

	public String getTicketId() {
		return ticketId;
	}

	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}

	public TicketStatus getTicketStatus() {
		return ticketStatus;
	}

	public void setTicketStatus(TicketStatus ticketStatus) {
		this.ticketStatus = ticketStatus;
	}

	public Date getExpectedResolutionDate() {
		return expectedResolutionDate;
	}

	public void setExpectedResolutionDate(Date expectedResolutionDate) {
		this.expectedResolutionDate = expectedResolutionDate;
	}

	public UserIssue getUserIssue() {
		return userIssue;
	}

	public void setUserIssue(UserIssue userIssue) {
		this.userIssue = userIssue;
	}

	public IssueTicket(String ticketId, Date issueDate, TicketStatus ticketStatus, Date expectedResolutionDate,
			UserIssue userIssue) {
		super();
		this.ticketId = ticketId;
		this.issueDate = issueDate;
		this.ticketStatus = ticketStatus;
		this.expectedResolutionDate = expectedResolutionDate;
		this.userIssue = userIssue;
	}
	
	

	


}

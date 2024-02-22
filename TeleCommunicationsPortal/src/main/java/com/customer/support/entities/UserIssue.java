package com.customer.support.entities;

import java.sql.Date;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import lombok.Data;
@Entity
public class UserIssue {

	@Id
	private String issueId;
	
	
	@PrePersist
	public void generateIssueId() {
		this.issueId="Issue-"+UUID.randomUUID().toString().substring(2, 13);
	}
	
	private String issueType;
	
	private String issueDescription;
	
	
	private Date issueDate;
	
	
	@ManyToOne
	private User user;
	
	
	public UserIssue() {
		
	}
	public String getIssueId() {
		return issueId;
	}


	public void setIssueId(String issueId) {
		this.issueId = issueId;
	}


	public String getIssueType() {
		return issueType;
	}


	public void setIssueType(String issueType) {
		this.issueType = issueType;
	}


	public String getIssueDescription() {
		return issueDescription;
	}


	public void setIssueDescription(String issueDescription) {
		this.issueDescription = issueDescription;
	}


	public Date getIssueDate() {
		return issueDate;
	}


	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public UserIssue(String issueType, String issueDescription, Date issueDate,Integer userId) {
		this.issueType = issueType;
		this.issueDescription = issueDescription;
		this.issueDate = issueDate;
		this.user = new User(userId);
	}
	
	public UserIssue(String issueId) {
		
		this.issueId =issueId;
	}


	@Override
	public String toString() {
		return "UserIssue [issueId=" + issueId + ", issueType=" + issueType + ", issueDescription="
				+ issueDescription + ", issueDate=" + issueDate + ", user=" + user + "]";
	}
	
}


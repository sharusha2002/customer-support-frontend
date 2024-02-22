package com.customer.support;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.customer.support.entities.IssueTicket;

@SpringBootApplication
public class TeleCommunicationsPortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(TeleCommunicationsPortalApplication.class, args);
	}

	@Bean
	IssueTicket genIssueTicket() {
		return new IssueTicket();
	}

}

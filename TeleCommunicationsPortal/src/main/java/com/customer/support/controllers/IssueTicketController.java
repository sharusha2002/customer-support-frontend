package com.customer.support.controllers;

import com.customer.support.services.IssueTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class IssueTicketController {

    private final IssueTicketService issueTicketService;

    @Autowired
    public IssueTicketController(IssueTicketService issueTicketService) {
        this.issueTicketService = issueTicketService;
    }

    @PostMapping("/generateTicket")
    public ResponseEntity<String> generateTicket(@RequestBody String userIssueId) {
        try {
            issueTicketService.generateTicket(userIssueId);
            return new ResponseEntity<>("Ticket generated successfully", HttpStatus.CREATED);
        } catch (IllegalArgumentException illegalArgumentException) {
            return new ResponseEntity<>(illegalArgumentException.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to generate ticket: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

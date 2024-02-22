package com.customer.support.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.customer.support.entities.UserIssue;
import com.customer.support.services.UserIssueService;

@RestController
@RequestMapping("api/v1")
public class UserIssueController {
    
    @Autowired
    UserIssueService userIssueService;
    
    @PostMapping("/issue")
    public ResponseEntity<?> raiseIssue(@RequestBody UserIssue userIssue, @RequestParam Integer loggedInUserId) {
        try {
            userIssueService.raiseIssue(userIssue, loggedInUserId);
            return new ResponseEntity<>("Issue raised successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to raise issue: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

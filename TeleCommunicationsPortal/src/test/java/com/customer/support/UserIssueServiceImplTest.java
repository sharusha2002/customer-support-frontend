package com.customer.support;

import static org.mockito.Mockito.*;

import java.sql.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.customer.support.entities.User;
import com.customer.support.entities.UserIssue;
import com.customer.support.repositories.UserIssueRepository;
import com.customer.support.services.IssueTicketService;
import com.customer.support.services.UserIssueServiceImpl;

public class UserIssueServiceImplTest {

    @Mock
    private UserIssueRepository repository;

    @Mock
    private IssueTicketService issueTicketService;

    @InjectMocks
    private UserIssueServiceImpl userIssueService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testRaiseIssue() {
        // Given
        UserIssue userIssue = new UserIssue();
        userIssue.setIssueDescription("Test issue description");
        int loggedInUserId = 1;

        // When
        userIssueService.raiseIssue(userIssue, loggedInUserId);

        // Then
        verify(repository, times(1)).save(userIssue);
        verify(issueTicketService, times(1)).generateTicket(userIssue.getIssueId());
    }
}

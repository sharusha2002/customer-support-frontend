package com.customer.support;

import static org.mockito.Mockito.*;

import java.sql.Date;
import java.util.Calendar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.customer.support.entities.IssueTicket;
import com.customer.support.entities.IssueTicket.TicketStatus;
import com.customer.support.entities.UserIssue;
import com.customer.support.repositories.IssueTicketRepository;
import com.customer.support.services.IssueTicketServiceImpl;

public class IssueTicketServiceImplTest {

    @Mock
    private IssueTicketRepository repository;

    @InjectMocks
    private IssueTicketServiceImpl issueTicketService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGenerateTicket() {
        // Given
        String userIssueId = "123";
        
        // Mocking current date
        Date currentDate = new Date(System.currentTimeMillis());
        // Mocking expected resolution date (3 days from current date)
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.add(Calendar.DATE, 3);
        Date expectedDate = new Date(calendar.getTimeInMillis());
        
        // When
        issueTicketService.generateTicket(userIssueId);

        // Then
        verify(repository, times(1)).save(any(IssueTicket.class));
        
        
    }
}

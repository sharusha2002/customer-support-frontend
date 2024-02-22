package com.customer.support.repositories;

import com.customer.support.entities.IssueTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IssueTicketRepository extends JpaRepository<IssueTicket, String> {
}

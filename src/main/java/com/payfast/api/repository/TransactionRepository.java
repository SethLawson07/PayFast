package com.payfast.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.payfast.api.models.Transaction;

import java.time.LocalDateTime;
import java.util.List;


public interface TransactionRepository extends JpaRepository<Transaction,Long> {
    
    List<Transaction> findByAccountId(Long accountId);

    List<Transaction> findByCreateAtBetween(LocalDateTime startDate, LocalDateTime endDate);
}

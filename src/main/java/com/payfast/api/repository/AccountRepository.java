package com.payfast.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.payfast.api.models.Account;
import java.util.List;
import com.payfast.api.models.enums.AccountType;
import java.time.LocalDateTime;



public interface AccountRepository extends JpaRepository<Account,Long> {
    
    Optional<Account> findByAccountNumber(String accountNumber);

    List<Account> findByAccountType(AccountType accountType);

    List<Account> findByClientId(Long clientId);

    List<Account> findByCreateAtBetween(LocalDateTime startDate,LocalDateTime endDate);
}

package com.payfast.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.payfast.api.models.Account;
import com.payfast.api.repository.AccountRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountService {
    
    private AccountRepository accountRepository;

    public Account createAccount(Account newAccount){
       return accountRepository.save(newAccount);
    }

    public List<Account> getAccounts(){
        return accountRepository.findAll();
    }

    public Optional<Account> getAccountById(Long id){
        return accountRepository.findById(id);
    }

    public Account updateStatus(Long id){
        Optional<Account> account = accountRepository.findById(id);

        if (account.isPresent()) {
            Account account2 = account.get();
            account2.setStatus(!account2.getStatus());
            return account2;
        }

        throw new RuntimeException("Account not found");
    }


}

package com.payfast.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.payfast.api.models.Transaction;
import com.payfast.api.repository.TransactionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TransactionService {
    
    private TransactionRepository transactionRepository;

    public Transaction createTransaction(Transaction newTransaction){
        return transactionRepository.save(newTransaction);
    }

    public List<Transaction> getTransactions(){
        return transactionRepository.findAll();
    }

    public Optional<Transaction> getTransactionById(Long id){
        return transactionRepository.findById(id);
    }

    public Transaction UpdateTransaction(Long id){
        Optional<Transaction> transaction = transactionRepository.findById(id);

        if (transaction.isPresent()) {
            Transaction transaction2 = transaction.get();
            transaction2.setStatus(!transaction2.getStatus());
        }

        throw new RuntimeException("Transaction not found");
    }

}

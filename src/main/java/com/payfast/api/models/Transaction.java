package com.payfast.api.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.payfast.api.models.enums.TransactionType;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "transactions")
public class Transaction {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

    @Column(nullable = false)
    private LocalDateTime createAt;

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;
}

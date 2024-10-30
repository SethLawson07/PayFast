package com.payfast.api.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.payfast.api.models.enums.AccountType;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="accounts")
public class Account {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String accountNumber;

    @Column(nullable = false)
    private BigDecimal balance;

    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    @Column(nullable = false)
    private LocalDateTime createAt;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @OneToMany(mappedBy = "account",cascade = CascadeType.ALL)
    private List<Transaction> transactions;




}

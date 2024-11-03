package org.elmekki.accountservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.elmekki.accountservice.enumes.AccountType;
import org.elmekki.accountservice.model.Customer;

import java.time.LocalDate;
@Data
@Entity
@Builder
@AllArgsConstructor @NoArgsConstructor

public class BankAccount {
    @Id
    private String accountId;
    private double balance;
    private LocalDate openingDate;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType type;
    @Transient
    private Customer customer;
    private Long customerId;


}

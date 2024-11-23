package com.sahilg.banking.accounts.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class Accounts {

    @Id
    private Long accountNumber ;
    private Long customerId;
    private String account_type;
    private String branch ;
}

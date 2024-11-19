package com.sahilg.banking.accounts.dto;

import lombok.Data;

@Data
public class AccountsDTO {
    private Long accountNumber ;
    private String account_type;
    private String branch ;
}

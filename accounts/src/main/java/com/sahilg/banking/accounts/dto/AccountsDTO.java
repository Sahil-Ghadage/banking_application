package com.sahilg.banking.accounts.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class AccountsDTO {

    @NotEmpty(message = "AccountNumber can not be a null or empty")
    @Pattern(regexp="(^$|[0-9]{10})",message = "AccountNumber must be 10 digits")
    private Long accountNumber ;

    @NotEmpty(message = "AccountType can not be a null or empty")
    private String account_type;

    @NotEmpty(message = "Branch can not be a null or empty")
    private String branch ;
}

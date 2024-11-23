package com.sahilg.banking.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Schema(
        name = "Accounts",
        description = "Schema to hold Account information"
)
public class AccountsDTO {

    @NotEmpty(message = "AccountNumber can not be a null or empty")
    @Pattern(regexp="(^$|[0-9]{10})",message = "AccountNumber must be 10 digits")
    @Schema(
            description = "Account Number", example = "1234567890"
    )
    private Long accountNumber ;

    @NotEmpty(message = "AccountType can not be a null or empty")
    @Schema(
            description = "Account type", example = "Savings"
    )
    private String account_type;

    @NotEmpty(message = "Branch can not be a null or empty")
    @Schema(
            description = "Bank Branch", example = "Mumbai"
    )
    private String branch ;
}

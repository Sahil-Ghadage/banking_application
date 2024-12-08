package com.sahilg.banking.accounts.dto;

import com.sahilg.banking.accounts.dto.AccountsDTO;
import com.sahilg.banking.accounts.dto.CardsDTO;
import com.sahilg.banking.accounts.dto.LoansDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(
        name = "CustomerDetails",
        description = "Schema to hold Customer, Account, Cards and Loans information"
)
public class CustomerDetailsDTO {

    @Schema(
            description = "Name of the customer", example = "Dummy Cust"
    )
    @NotEmpty(message = "Name can not be a null or empty")
    @Size(min = 5, max = 30, message = "The length of the customer name should be between 5 and 30")
    private String name;

    @Schema(
            description = "Email address of the customer", example = "mail@demo.com"
    )
    @NotEmpty(message = "Email address can not be a null or empty")
    @Email(message = "Email address should be a valid value")
    private String email;

    @Schema(
            description = "Mobile Number of the customer", example = "1234567890"
    )
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits")
    private String mobileNumber;

    @Schema(
            description = "Account details of the Customer"
    )
    private AccountsDTO accountsDto;

    @Schema(
            description = "Loans details of the Customer"
    )
    private LoansDTO loansDto;

    @Schema(
            description = "Cards details of the Customer"
    )
    private CardsDTO cardsDto;


}
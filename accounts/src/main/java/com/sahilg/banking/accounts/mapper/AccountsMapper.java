package com.sahilg.banking.accounts.mapper;

import com.sahilg.banking.accounts.dto.AccountsDTO;
import com.sahilg.banking.accounts.entity.Accounts;


public class AccountsMapper {
    /**
     *
     * @param accounts
     * @param accountsDto
     * @return
     * DTO conversion from Accounts Entity to AccountsDTO
     */
    public static AccountsDTO mapToAccountsDto(Accounts accounts, AccountsDTO accountsDto) {
        accountsDto.setAccountNumber(accounts.getAccountNumber());
        accountsDto.setAccount_type(accounts.getAccount_type());
        accountsDto.setBranch(accounts.getBranch());
        return accountsDto;
    }

    /**
     *
     * @param accountsDto
     * @param accounts
     * @return
     * DTO conversion from AccountsDTO to Accounts Entity
     */
    public static Accounts mapToAccounts(AccountsDTO accountsDto, Accounts accounts) {
        accounts.setAccountNumber(accountsDto.getAccountNumber());
        accounts.setAccount_type(accountsDto.getAccount_type());
        accounts.setBranch(accountsDto.getBranch());
        return accounts;
    }
}

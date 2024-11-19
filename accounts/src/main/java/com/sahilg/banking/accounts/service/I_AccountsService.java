package com.sahilg.banking.accounts.service;

import com.sahilg.banking.accounts.dto.CustomerDTO;

public interface I_AccountsService {

    void createAccount(CustomerDTO customerDto);

    CustomerDTO fetchAccount(String mobileNumber);

    boolean updateAccount(CustomerDTO customerDto);

    boolean deleteAccount(String mobileNumber);

}

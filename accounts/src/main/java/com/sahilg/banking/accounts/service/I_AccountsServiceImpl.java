package com.sahilg.banking.accounts.service;

import com.sahilg.banking.accounts.dto.CustomerDTO;
import org.springframework.stereotype.Service;

@Service
public class I_AccountsServiceImpl implements I_AccountsService{
    @Override
    public void createAccount(CustomerDTO customerDto) {

    }

    @Override
    public CustomerDTO fetchAccount(String mobileNumber) {
        return null;
    }

    @Override
    public boolean updateAccount(CustomerDTO customerDto) {
        return false;
    }

    @Override
    public boolean deleteAccount(String mobileNumber) {
        return false;
    }
}

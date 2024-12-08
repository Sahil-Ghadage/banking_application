package com.sahilg.banking.accounts.service;

import com.sahilg.banking.accounts.dto.CustomerDetailsDTO;

public interface I_CustomersService {

    /**
     *
     * @param mobileNumber - Input Mobile Number
     * @return Customer Details based on a given mobileNumber
     */
    CustomerDetailsDTO fetchCustomerDetails(String mobileNumber);
}

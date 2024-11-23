package com.sahilg.banking.loans.service;

import com.sahilg.banking.loans.dto.LoansDTO;

public interface I_LoansService {

    void createLoan(String mobileNumber);

    LoansDTO fetchLoan(String mobileNumber);

    boolean updateLoan(LoansDTO loansDto);

    boolean deleteLoan(String mobileNumber);
}

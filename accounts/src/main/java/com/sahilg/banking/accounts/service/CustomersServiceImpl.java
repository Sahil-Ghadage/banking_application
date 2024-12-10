package com.sahilg.banking.accounts.service;

import com.sahilg.banking.accounts.dto.AccountsDTO;
import com.sahilg.banking.accounts.dto.CardsDTO;
import com.sahilg.banking.accounts.dto.CustomerDetailsDTO;
import com.sahilg.banking.accounts.dto.LoansDTO;
import com.sahilg.banking.accounts.entity.Accounts;
import com.sahilg.banking.accounts.entity.Customer;
import com.sahilg.banking.accounts.exception.ResourceNotFoundException;
import com.sahilg.banking.accounts.mapper.AccountsMapper;
import com.sahilg.banking.accounts.mapper.CustomerMapper;
import com.sahilg.banking.accounts.repository.AccountsRepository;
import com.sahilg.banking.accounts.repository.CustomerRepository;
import com.sahilg.banking.accounts.service.client.CardsFeignClient;
import com.sahilg.banking.accounts.service.client.LoansFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CustomersServiceImpl implements I_CustomersService{

    @Autowired
    private AccountsRepository accountsRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CardsFeignClient cardsFeignClient;
    @Autowired
    private LoansFeignClient loansFeignClient;


    @Override
    public CustomerDetailsDTO fetchCustomerDetails(String mobileNumber, String correlationId) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber)
        );
        Accounts accounts = accountsRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(
                () -> new ResourceNotFoundException("Account", "customerId", customer.getCustomerId().toString())
        );

        CustomerDetailsDTO customerDetailsDto = CustomerMapper.mapToCustomerDetailsDto(customer, new CustomerDetailsDTO());
        customerDetailsDto.setAccountsDto(AccountsMapper.mapToAccountsDto(accounts, new AccountsDTO()));

        ResponseEntity<LoansDTO> loansDtoResponseEntity = loansFeignClient.fetchLoanDetails(correlationId,mobileNumber);
        customerDetailsDto.setLoansDto(loansDtoResponseEntity.getBody());

        ResponseEntity<CardsDTO> cardsDtoResponseEntity = cardsFeignClient.fetchCardDetails(correlationId,mobileNumber);
        customerDetailsDto.setCardsDto(cardsDtoResponseEntity.getBody());

        return customerDetailsDto;
    }
}

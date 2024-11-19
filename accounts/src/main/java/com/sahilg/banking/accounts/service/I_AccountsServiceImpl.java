package com.sahilg.banking.accounts.service;

import com.sahilg.banking.accounts.dto.AccountsDTO;
import com.sahilg.banking.accounts.dto.CustomerDTO;
import com.sahilg.banking.accounts.entity.Accounts;
import com.sahilg.banking.accounts.entity.Customer;
import com.sahilg.banking.accounts.exception.CustomerAlreadyExistsException;
import com.sahilg.banking.accounts.exception.ResourceNotFoundException;
import com.sahilg.banking.accounts.mapper.AccountsMapper;
import com.sahilg.banking.accounts.mapper.CustomerMapper;
import com.sahilg.banking.accounts.repository.AccountsRepository;
import com.sahilg.banking.accounts.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class I_AccountsServiceImpl implements I_AccountsService{

    @Autowired
    private AccountsRepository accountsRepository;
   @Autowired
    private CustomerRepository customerRepository;
    @Override
    public void createAccount(CustomerDTO customerDto) {

        Customer customer = CustomerMapper.mapToCustomer(customerDto, new Customer());
        Optional<Customer> optionalCustomer = customerRepository.findByMobileNumber(customerDto.getMobileNumber());
        if(optionalCustomer.isPresent()) {
            throw new CustomerAlreadyExistsException("Customer already registered with given Mobile Number "
                    +customerDto.getMobileNumber());
        }
        Customer savedCustomer = customerRepository.save(customer);
        accountsRepository.save(createNewAccount(savedCustomer));
    }

    private Accounts createNewAccount(Customer customer) {
        Accounts newAccount = new Accounts();
        newAccount.setCustomerId(customer.getCustomerId());
        long randomAccNumber = 1000000000L + new Random().nextInt(900000000);

        newAccount.setAccountNumber(randomAccNumber);
        newAccount.setAccount_type("SAVINGS");
        newAccount.setBranch("Mumbai");
        return newAccount;
    }
    @Override
    public CustomerDTO fetchAccount(String mobileNumber) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber)
        );
        Accounts accounts = accountsRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(
                () -> new ResourceNotFoundException("Account", "customerId", customer.getCustomerId().toString())
        );
        CustomerDTO customerDto = CustomerMapper.mapToCustomerDto(customer, new CustomerDTO());
        customerDto.setAccountsDto(AccountsMapper.mapToAccountsDto(accounts, new AccountsDTO()));
        return customerDto;
    }

    @Override
    public boolean updateAccount(CustomerDTO customerDto) {
        boolean isUpdated = false;
        AccountsDTO accountsDto = customerDto.getAccountsDto();
        if(accountsDto !=null ){
            Accounts accounts = accountsRepository.findById(accountsDto.getAccountNumber()).orElseThrow(
                    () -> new ResourceNotFoundException("Account", "AccountNumber", accountsDto.getAccountNumber().toString())
            );
            AccountsMapper.mapToAccounts(accountsDto, accounts);
            accounts = accountsRepository.save(accounts);

            Long customerId = accounts.getCustomerId();
            Customer customer = customerRepository.findById(customerId).orElseThrow(
                    () -> new ResourceNotFoundException("Customer", "CustomerID", customerId.toString())
            );
            CustomerMapper.mapToCustomer(customerDto,customer);
            customerRepository.save(customer);
            isUpdated = true;
        }
        return  isUpdated;
    }


    @Override
    public boolean deleteAccount(String mobileNumber) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber)
        );
        accountsRepository.deleteByCustomerId(customer.getCustomerId());
        customerRepository.deleteById(customer.getCustomerId());
        return true;
    }
}

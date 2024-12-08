package com.sahilg.banking.accounts.mapper;

import com.sahilg.banking.accounts.dto.CustomerDTO;
import com.sahilg.banking.accounts.dto.CustomerDetailsDTO;
import com.sahilg.banking.accounts.entity.Customer;

public class CustomerMapper {

    /**
     *
     * @param customer
     * @param customerDto
     * @return
     *  DTO conversion from Customer Entity to CustomerDTO
     */
    public static CustomerDTO mapToCustomerDto(Customer customer, CustomerDTO customerDto) {
        customerDto.setName(customer.getName());
        customerDto.setEmail(customer.getEmail());
        customerDto.setMobileNumber(customer.getMobileNumber());
        return customerDto;
    }

    public static CustomerDetailsDTO mapToCustomerDetailsDto(Customer customer, CustomerDetailsDTO customerDetailsDto) {
        customerDetailsDto.setName(customer.getName());
        customerDetailsDto.setEmail(customer.getEmail());
        customerDetailsDto.setMobileNumber(customer.getMobileNumber());
        return customerDetailsDto;
    }


    /**
     *
     * @param customerDto
     * @param customer
     * @return
     *  DTO conversion from AccountsDTO to Customer Entity
     */
    public static Customer mapToCustomer(CustomerDTO customerDto, Customer customer) {
        customer.setName(customerDto.getName());
        customer.setEmail(customerDto.getEmail());
        customer.setMobileNumber(customerDto.getMobileNumber());
        return customer;
    }
}

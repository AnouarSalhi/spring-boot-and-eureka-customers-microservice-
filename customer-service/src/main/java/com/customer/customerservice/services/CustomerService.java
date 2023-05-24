package com.customer.customerservice.services;

import com.customer.customerservice.dto.CustomerRequestDto;
import com.customer.customerservice.dto.CustomerResponseDto;

import java.util.List;

public interface CustomerService {
    CustomerResponseDto save(CustomerRequestDto customerRequestDto);
    CustomerResponseDto getCustomer(String id);
    CustomerResponseDto update(CustomerRequestDto customerRequestDto);
    List<CustomerResponseDto> listCustomers();

}

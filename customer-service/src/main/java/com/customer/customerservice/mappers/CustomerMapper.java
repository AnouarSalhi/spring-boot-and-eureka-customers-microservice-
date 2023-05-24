package com.customer.customerservice.mappers;

import com.customer.customerservice.dto.CustomerRequestDto;
import com.customer.customerservice.dto.CustomerResponseDto;
import com.customer.customerservice.entities.Customer;
import org.mapstruct.Mapper;
import org.springframework.beans.BeanUtils;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerResponseDto customerToCustomerResponseDto(Customer customer);
    Customer customerRequestDtoToCustomer(CustomerRequestDto customerRequestDto);
}

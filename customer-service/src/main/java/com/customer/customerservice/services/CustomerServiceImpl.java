package com.customer.customerservice.services;

import com.customer.customerservice.dto.CustomerRequestDto;
import com.customer.customerservice.dto.CustomerResponseDto;
import com.customer.customerservice.entities.Customer;
import com.customer.customerservice.mappers.CustomerMapper;
import com.customer.customerservice.repositories.CustomerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;
    private CustomerMapper customerMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public CustomerResponseDto save(CustomerRequestDto customerRequestDto) {

        Customer customer=new Customer();
        BeanUtils.copyProperties(customerRequestDto,customer);
        customer.setId(UUID.randomUUID().toString());
        Customer savedCustomer= customerRepository.save(customer);
        CustomerResponseDto customerResponceDto=customerMapper.customerToCustomerResponseDto(savedCustomer);
        BeanUtils.copyProperties(savedCustomer,customerResponceDto);
        return customerResponceDto;
    }

    @Override
    public CustomerResponseDto getCustomer(@RequestParam String id) {
        Customer customer=customerRepository.findById(id).get();

        CustomerResponseDto customerResponseDto=customerMapper.customerToCustomerResponseDto(customer);
        System.out.println(customerMapper.customerToCustomerResponseDto(customer).toString());
        return customerResponseDto;
    }

    @Override
    public CustomerResponseDto update(CustomerRequestDto customerRequestDto) {
        Customer customer=customerMapper.customerRequestDtoToCustomer(customerRequestDto);
        customer.setId(UUID.randomUUID().toString());
        Customer updatedCustomer=customerRepository.save(customer);
        CustomerResponseDto customerResponseDto=customerMapper.customerToCustomerResponseDto(updatedCustomer);
        return customerResponseDto;
    }

    @Override
    public List<CustomerResponseDto> listCustomers() {

        List<Customer> customers=customerRepository.findAll();
        List<CustomerResponseDto> customerResponseDtos=customers
                .stream()
                .map(
                        customer -> customerMapper.customerToCustomerResponseDto(customer)
                )
                .collect(Collectors.toList());
        return customerResponseDtos;
    }
}

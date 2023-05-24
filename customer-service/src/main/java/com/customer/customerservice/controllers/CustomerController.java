package com.customer.customerservice.controllers;

import com.customer.customerservice.dto.CustomerRequestDto;
import com.customer.customerservice.dto.CustomerResponseDto;
import com.customer.customerservice.services.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController {
    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @GetMapping("/customers")
    public List<CustomerResponseDto> customers(){
        return customerService.listCustomers();
    }
    @PostMapping("/customers")
    public CustomerResponseDto save(@RequestBody CustomerRequestDto customerRequestDto){
        return customerService.save(customerRequestDto);
    }
    @GetMapping("/customers/{id}")
    public CustomerResponseDto getCustomer(@PathVariable String id){
        return customerService.getCustomer(id);
    }
}




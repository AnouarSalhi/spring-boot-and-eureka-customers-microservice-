package com.customer.customerservice;

import com.customer.customerservice.dto.CustomerRequestDto;
import com.customer.customerservice.dto.CustomerResponseDto;
import com.customer.customerservice.services.CustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
        System.out.println("welcome azzmer");

    }
    @Bean
    CommandLineRunner start(CustomerService customerService){
        return  args -> {

            customerService.save(new CustomerRequestDto("dj3nnj43fhr","iuh","u"));


        };
    }
}

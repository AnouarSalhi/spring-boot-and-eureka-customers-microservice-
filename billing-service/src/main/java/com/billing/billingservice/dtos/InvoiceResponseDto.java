package com.billing.billingservice.dtos;

import com.billing.billingservice.entities.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data @AllArgsConstructor @NoArgsConstructor
public class InvoiceResponseDto {
    private String id;
    private Date date;
    private Double amount;
    private Customer customer;
}

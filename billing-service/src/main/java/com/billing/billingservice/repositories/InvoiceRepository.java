package com.billing.billingservice.repositories;

import com.billing.billingservice.entities.Customer;
import com.billing.billingservice.entities.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InvoiceRepository extends JpaRepository<Invoice,String> {
    List<Invoice> findByCustomerId(String id);
}

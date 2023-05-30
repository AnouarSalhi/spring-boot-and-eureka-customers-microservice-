package com.billing.billingservice.controllers;

import com.billing.billingservice.dtos.InvoiceRequestDto;
import com.billing.billingservice.dtos.InvoiceResponseDto;
import com.billing.billingservice.services.InvoiceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/api")
@RestController
public class InvoiceController {
    private InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping("/invoices")
    public List<InvoiceResponseDto> invoices(){
        return invoiceService.invoices();
    }
    @GetMapping("invoices/{id}")
    public InvoiceResponseDto getInvoiceById(@PathVariable String id){
        return invoiceService.invoiceById(id);
    }
    @PostMapping("invoices")
    public InvoiceResponseDto addInvoice(@RequestBody InvoiceRequestDto invoiceRequestDto){
        return invoiceService.addInvoice(invoiceRequestDto);
    }
}

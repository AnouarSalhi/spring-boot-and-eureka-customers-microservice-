package com.billing.billingservice.mappers;

import com.billing.billingservice.dtos.InvoiceRequestDto;
import com.billing.billingservice.dtos.InvoiceResponseDto;
import com.billing.billingservice.entities.Invoice;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InvoiceMapper {
 Invoice invoiceRespnseDtoToInvoice(InvoiceRequestDto invoiceRequestDto);
 InvoiceResponseDto invoiceToInvoiceResponseDto(Invoice invoice);
}

package com.msedcl.billing_backend.service;

import com.msedcl.billing_backend.entity.Invoice;
import com.msedcl.billing_backend.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillingService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    public Invoice saveInvoice(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAll();
    }

    // नवीन: आयडीनुसार डेटाबेसमधून बिल काढणे
    public void deleteInvoice(Long id) {
        invoiceRepository.deleteById(id);
    }
}
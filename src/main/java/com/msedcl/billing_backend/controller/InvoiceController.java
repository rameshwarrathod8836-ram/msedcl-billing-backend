package com.msedcl.billing_backend.controller;

import com.msedcl.billing_backend.entity.Invoice;
import com.msedcl.billing_backend.service.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/invoices")
@CrossOrigin(origins = "http://localhost:5173")
public class InvoiceController {

    @Autowired
    private BillingService billingService;

    @PostMapping
    public ResponseEntity<Invoice> createInvoice(@RequestBody Invoice invoice) {
        Invoice saved = billingService.saveInvoice(invoice);
        return ResponseEntity.ok(saved);
    }

    @GetMapping
    public List<Invoice> getAllInvoices() {
        return billingService.getAllInvoices();
    }

    // नवीन: बिल डिलीट करण्यासाठी API
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteInvoice(@PathVariable Long id) {
        billingService.deleteInvoice(id);
        return ResponseEntity.ok("Deleted successfully");
    }
}
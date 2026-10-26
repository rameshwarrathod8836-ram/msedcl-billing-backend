package com.msedcl.billing_backend.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "invoices")
@Getter
@Setter
@NoArgsConstructor
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String invoiceNo;
    private LocalDate invoiceDate;
    
    private String agencyName;
    private String gstNo;
    private String panNo;

    private String loaNo;
    private LocalDate loaDate;
    private String division;
    private String subDivision;

    private BigDecimal subTotal;
    private BigDecimal cgstPercent;
    private BigDecimal sgstPercent;
    private BigDecimal cgstAmount;
    private BigDecimal sgstAmount;
    private BigDecimal grandTotal;

    @OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<BillItem> items = new ArrayList<>();
}
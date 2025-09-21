package com.app.boot.gst.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
public class InvoiceDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long invoiceDetailsId;
    private String invoiceNumber;
    private Date invoiceDate;
    private Date dueDate;
    private String supplyType;
    private Boolean reverseCharge;
    private String transportationMode;
    private String poReference;
}

package com.app.boot.gst.entities;

import jakarta.persistence.Entity;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
public class BuyerDetails {
    private String legalName;
    private String gstIn;
    private String placeOfSupply;
    private BillingAddress billingAddress;
}

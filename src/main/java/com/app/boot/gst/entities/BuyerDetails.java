package com.app.boot.gst.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
public class BuyerDetails {
    @Id
    private Long buyerDetailsId;
    private String legalName;
    private String gstIn;
    private String placeOfSupply;
    @OneToOne
    @JoinColumn(name = "billingAddressId")
    private BillingAddress billingAddress;
}

package com.app.boot.gst.entities;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
public class BuyerDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long buyerDetailsId;
    private String legalName;
    private String gstIn;
    private String placeOfSupply;
    @OneToOne
    @JoinColumn(name = "billingAddressId")
    private BillingAddress billingAddress;
}

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
public class SellerDetails {
    @Id
    private Long sellerDetailsId;
    private String legalName;
    private String gstIn;
    private String phone;
    private String email;
    @OneToOne
    @JoinColumn(name = "addressId")
    private Address address;
    private String placeOfSupply;
}

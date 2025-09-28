package com.app.boot.gst.entities;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
public class SellerDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

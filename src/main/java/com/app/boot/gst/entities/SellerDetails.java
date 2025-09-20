package com.app.boot.gst.entities;

import jakarta.persistence.Entity;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
public class SellerDetails {
    private String legalName;
    private String gstIn;
    private String phone;
    private String email;
    private Address address;
    private String placeOfSupply;
}

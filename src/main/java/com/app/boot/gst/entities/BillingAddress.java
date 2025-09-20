package com.app.boot.gst.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
public class BillingAddress {
    @Id
    private Long billingAddressId;
    private String street;
    private String city;
    private String state;
    private String pinCode;
}

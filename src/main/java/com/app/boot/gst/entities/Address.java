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
public class Address {
    @Id
    private Long addressId;
    private String street;
    private String city;
    private String state;
    private String pinCode;
}

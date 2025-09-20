package com.app.boot.gst.entities;

import jakarta.persistence.Entity;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
public class Address {
    private String street;
    private String city;
    private String state;
    private String pinCode;
}

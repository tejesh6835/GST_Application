package com.app.boot.gst.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
public class LineItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lineItemsId;
    private String description;
    private String hsnOrSac;
    private Integer quantity;
    private Double unitPrice;
    private Double rate;
    private Double discount;
    private Double gst;
}

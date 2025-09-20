package com.app.boot.gst.entities;

import jakarta.persistence.Entity;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
public class LineItems {
    private String description;
    private String hsnOrSac;
    private Integer quantity;
    private Double unitPrice;
    private Double gstRate;
    private Double discount;
    private Double gstDiscount;
}

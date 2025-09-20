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
public class LineItems {
    @Id
    private Long lineItemsId;
    private String description;
    private String hsnOrSac;
    private Integer quantity;
    private Double unitPrice;
    private Double gstRate;
    private Double discount;
    private Double gstDiscount;
}

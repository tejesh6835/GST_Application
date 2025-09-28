package com.app.boot.gst.entities;

import jakarta.persistence.*;
import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
public class SubTotal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subTotalId;
    private Double taxableValue;
    private Double cgstAmount;
    private Double sgstAmount;
    private Double igstAmount;
    private Double lineItemTotal;
}

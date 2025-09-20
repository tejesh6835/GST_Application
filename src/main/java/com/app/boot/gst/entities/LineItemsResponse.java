package com.app.boot.gst.entities;

import jakarta.persistence.Entity;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
public class LineItemsResponse {
    private Double taxableValue;
    private Double cgstAmount;
    private Double sgstAmount;
    private Double igstAmount;
    private Double lineItemTotal;
}

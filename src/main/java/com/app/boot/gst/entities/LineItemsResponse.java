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
public class LineItemsResponse {
    @Id
    private Long lineItemsResponseId;
    private Double taxableValue;
    private Double cgstAmount;
    private Double sgstAmount;
    private Double igstAmount;
    private Double lineItemTotal;
}

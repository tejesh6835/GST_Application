package com.app.boot.gst.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class SubTotalResponseDto {
    private Double taxableValue;
    private Double cgstAmount;
    private Double sgstAmount;
    private Double igstAmount;
    private Double lineItemTotal;
}

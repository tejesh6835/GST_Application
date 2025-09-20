package com.app.boot.gst.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
public class SubTotal {
    @Id
    private Long subTotalId;
    @OneToOne
    @JoinColumn(name = "lineItemsResponseId")
    private LineItemsResponse lineItems;
}

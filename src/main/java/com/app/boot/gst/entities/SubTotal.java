package com.app.boot.gst.entities;

import jakarta.persistence.Entity;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
public class SubTotal {
    private List<LineItemsResponse> lineItems;
}

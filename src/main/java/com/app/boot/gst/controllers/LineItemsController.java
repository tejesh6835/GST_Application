package com.app.boot.gst.controllers;

import com.app.boot.gst.dto.AddLineItemResponseDto;
import com.app.boot.gst.entities.LineItems;
import com.app.boot.gst.services.LineItemsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("gst/lineItems")
@RequiredArgsConstructor
public class LineItemsController {

    private final LineItemsService lineItemsService;

    @PostMapping("/addLineItem")
    public AddLineItemResponseDto addLineItem(@RequestBody LineItems lineItem) {
        return ResponseEntity.ok(lineItemsService.addLineItem(lineItem)).getBody();
    }
}

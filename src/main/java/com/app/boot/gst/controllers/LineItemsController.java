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

import java.util.List;

@RestController
@RequestMapping("gst/lineItems")
@RequiredArgsConstructor
public class LineItemsController {

    private final LineItemsService lineItemsService;

//    @PostMapping("/saveLineItems")
//    public String saveLineItems(@RequestBody List<LineItems> lineItem) {
//        lineItemsService.saveLineItems(lineItem);
//        return "Line item added successfully!";
//    }

    @PostMapping("/addLineItem")
    public AddLineItemResponseDto addLineItem(@RequestBody LineItems lineItem) {
        lineItemsService.addLineItem(lineItem);
        return ResponseEntity.ok(lineItemsService.addLineItem(lineItem)).getBody();
    }

}

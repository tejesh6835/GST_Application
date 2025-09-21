package com.app.boot.gst.services;

import com.app.boot.gst.dto.AddLineItemResponseDto;
import com.app.boot.gst.entities.LineItems;

import java.util.List;

public interface LineItemsService {

//    void saveLineItems(List<LineItems> lineItem);

    AddLineItemResponseDto addLineItem(LineItems lineItem);
}

package com.app.boot.gst.servicesimpl;


import com.app.boot.gst.dto.AddLineItemResponseDto;
import com.app.boot.gst.dto.SubTotalResponseDto;
import com.app.boot.gst.entities.LineItems;
import com.app.boot.gst.entities.LineItemsResponse;
import com.app.boot.gst.entities.SubTotal;
import com.app.boot.gst.repositories.LineItemsRepo;
import com.app.boot.gst.repositories.LineItemsResponseRepo;
import com.app.boot.gst.services.LineItemsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class LineItemsServiceImpl implements LineItemsService {

    private final LineItemsRepo lineItemsRepo;
    private final LineItemsResponseRepo lineItemsResponseRepo;

    List<LineItems> lineItemsList = new ArrayList<>();
    List<LineItemsResponse> lineItemsResponseList = new ArrayList<>();
//
//    @Override
//    public void saveLineItems(List<LineItems> lineItems) {
//          lineItemsRepo.saveAll(lineItems);
////        List<LineItemsResponse> calculateLineItemTotals = calculateLineItemTotals(lineItems);
//    }

    @Override
    public AddLineItemResponseDto addLineItem(LineItems lineItem) {

        lineItemsList.add(lineItem);
        LineItemsResponse lineItemsResponse = calculateLineItemTotals(lineItem);

        lineItemsResponseList.add(lineItemsResponse);

        SubTotal subTotal = calculateSubTotals(lineItemsResponseList);

        return AddLineItemResponseDto.builder()
                .taxableValue(lineItemsResponse.getTaxableValue())
                .cgstAmount(lineItemsResponse.getCgstAmount())
                .sgstAmount(lineItemsResponse.getSgstAmount())
                .lineItemTotal(lineItemsResponse.getLineItemTotal())
                .subTotalResponseDto(buildSubTotalResponseDto(subTotal))
                .build();
    }

    private SubTotalResponseDto buildSubTotalResponseDto(SubTotal subTotal) {
        return SubTotalResponseDto.builder()
                .taxableValue(subTotal.getTaxableValue())
                .cgstAmount(subTotal.getCgstAmount())
                .sgstAmount(subTotal.getSgstAmount())
                .lineItemTotal(subTotal.getLineItemTotal())
                .build();
    }

    private SubTotal calculateSubTotals(List<LineItemsResponse> lineItemsResponse) {
        Double subTotal = 0.0;
        Double subTaxableValue = 0.0;
        Double subCgstAmount = 0.0;
        Double subSgstAmount = 0.0;

        for (LineItemsResponse item : lineItemsResponse) {
            subTotal += item.getLineItemTotal();
            subTaxableValue += item.getTaxableValue();
            subCgstAmount += item.getCgstAmount();
            subSgstAmount += item.getSgstAmount();
        }
        return SubTotal.builder()
                .taxableValue(subTaxableValue)
                .cgstAmount(subCgstAmount)
                .sgstAmount(subSgstAmount)
                .lineItemTotal(subTotal)
                .build();
    }

    private LineItemsResponse calculateLineItemTotals(LineItems lineItem) {

        double price = lineItem.getQuantity() * lineItem.getRate(); //200
        double taxbleValue = price - (price * lineItem.getDiscount() / 100.0); //180

        double gstCal = lineItem.getGst() / 2.0; //5

        double cgstAmount = lineItem.getQuantity() * lineItem.getRate() * (gstCal / 100.0);  //10
        double sgstAmount = lineItem.getQuantity() * lineItem.getRate() * (gstCal / 100.0); //10

        Double lineItemTotal = taxbleValue + cgstAmount + sgstAmount;

            return LineItemsResponse.builder()
                    .taxableValue(taxbleValue)
                    .cgstAmount(cgstAmount)
                    .sgstAmount(sgstAmount)
                    .lineItemTotal(lineItemTotal)
                    .build();
    }
}

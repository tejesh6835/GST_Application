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

    private static List<LineItems> lineItemsList = new ArrayList<>();
    private static List<LineItemsResponse> lineItemsResponseList = new ArrayList<>();

    @Override
    public AddLineItemResponseDto addLineItem(LineItems lineItem) {

        lineItemsList.add(lineItem);
        LineItemsResponse lineItemsResponse = Boolean.TRUE.equals(lineItem.getIsIgstIncluded()) ? calculateLineItemTotalsIgst(lineItem) : calculateLineItemTotals(lineItem);

        lineItemsResponseList.add(lineItemsResponse);

        SubTotal subTotal = calculateSubTotals(lineItemsResponseList);

        return AddLineItemResponseDto.builder()
                .taxableValue(lineItemsResponse.getTaxableValue())
                .cgstAmount(lineItemsResponse.getCgstAmount())
                .sgstAmount(lineItemsResponse.getSgstAmount())
                .igstAmount(lineItemsResponse.getIgstAmount())
                .lineItemTotal(lineItemsResponse.getLineItemTotal())
                .subTotalResponseDto(buildSubTotalResponseDto(subTotal))
                .build();
    }

    private LineItemsResponse calculateLineItemTotalsIgst(LineItems lineItem) {
        double price = lineItem.getQuantity() * lineItem.getRate();
        double taxbleValue = price - (price * lineItem.getDiscount() / 100.0);

        double igstCal = lineItem.getGst();

        double igstAmount = price * (igstCal / 100.0);

        Double lineItemTotal = taxbleValue + igstAmount;

        return LineItemsResponse.builder()
                .taxableValue(taxbleValue)
                .cgstAmount(0.0)
                .sgstAmount(0.0)
                .igstAmount(igstAmount)
                .lineItemTotal(lineItemTotal)
                .build();
    }

    private SubTotalResponseDto buildSubTotalResponseDto(SubTotal subTotal) {
        return SubTotalResponseDto.builder()
                .taxableValue(subTotal.getTaxableValue())
                .cgstAmount(subTotal.getCgstAmount())
                .sgstAmount(subTotal.getSgstAmount())
                .igstAmount(subTotal.getIgstAmount())
                .lineItemTotal(subTotal.getLineItemTotal())
                .build();
    }

    private SubTotal calculateSubTotals(List<LineItemsResponse> lineItemsResponse) {
        Double subTotal = 0.0;
        Double subTaxableValue = 0.0;
        Double subCgstAmount = 0.0;
        Double subSgstAmount = 0.0;
        Double subIgstAmount = 0.0;

        for (LineItemsResponse item : lineItemsResponse) {
            subTotal += item.getLineItemTotal();
            subTaxableValue += item.getTaxableValue();
            subCgstAmount += item.getCgstAmount();
            subSgstAmount += item.getSgstAmount();
            subIgstAmount += item.getIgstAmount();
        }
        return SubTotal.builder()
                .taxableValue(subTaxableValue)
                .cgstAmount(subCgstAmount)
                .sgstAmount(subSgstAmount)
                .igstAmount(subIgstAmount)
                .lineItemTotal(subTotal)
                .build();
    }

    private LineItemsResponse calculateLineItemTotals(LineItems lineItem) {

        double price = lineItem.getQuantity() * lineItem.getRate();
        double taxbleValue = price - (price * lineItem.getDiscount() / 100.0);

        double gstCal = lineItem.getGst() / 2.0;

        double cgstAmount = price * (gstCal / 100.0);
        double sgstAmount = price * (gstCal / 100.0);

        Double lineItemTotal = taxbleValue + cgstAmount + sgstAmount;

            return LineItemsResponse.builder()
                    .taxableValue(taxbleValue)
                    .cgstAmount(cgstAmount)
                    .sgstAmount(sgstAmount)
                    .igstAmount(0.0)
                    .lineItemTotal(lineItemTotal)
                    .build();
    }
}

package com.inditex.aplicacion.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PricingResponse {
    private int productId;
    private int brandId;
    private String priceList;
    private LocalDate startDate;
    private LocalDate endDate;
    private float price;
    private String curr;
}


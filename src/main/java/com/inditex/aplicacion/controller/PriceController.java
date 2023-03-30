package com.inditex.aplicacion.controller;

import com.inditex.aplicacion.model.Price;
import com.inditex.aplicacion.response.PriceResponse;
import com.inditex.aplicacion.service.PriceService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping("/pricing")
public class PriceController {
    private final PriceService priceService;

    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    @GetMapping
    public ResponseEntity<PriceResponse> getPrice(@RequestParam("applicationDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime applicationDate,
                                                  @RequestParam("productId") Long productId,
                                                  @RequestParam("brandId") Integer brandId) {
        Optional<Price> price = priceService.getPrice(applicationDate, productId, brandId);
        if (price.isPresent()) {
            PriceResponse response = new PriceResponse(price.get().getProductId(),
                    price.get().getBrandId(), price.get().getPriceList(), price.get().getStartDate(),
                    price.get().getEndDate(), price.get().getPrice(), price.get().getCurrency());
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}


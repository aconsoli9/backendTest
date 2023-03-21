package com.inditex.aplicacion.controller;

import com.inditex.aplicacion.model.Pricing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.inditex.aplicacion.repository.PricingRepository;
import com.inditex.aplicacion.response.PricingResponse;

import java.time.LocalDate;
import java.util.List;

@RestController
public class PricingController {
    @Autowired
    private PricingRepository pricingRepository;

    @GetMapping("/pricing")
    public ResponseEntity<PricingResponse> getPricing(
            @RequestParam("applicationDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate applicationDate,
            @RequestParam("productId") int productId,
            @RequestParam("brandId") int brandId) {
        List<Pricing> pricings = pricingRepository.findByStartDateLessThanEqualAndEndDateGreaterThanEqualAndProductIdAndBrandIdOrderByPriorityDesc(
                applicationDate, applicationDate, productId, brandId);
        if (pricings.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Pricing pricing = pricings.get(0);
        PricingResponse response = new PricingResponse(
                pricing.getProductId(), pricing.getBrandId(), pricing.getPriceList(),
                pricing.getStartDate(), pricing.getEndDate(), pricing.getPrice(), pricing.getCurr());
        return ResponseEntity.ok(response);
    }
}


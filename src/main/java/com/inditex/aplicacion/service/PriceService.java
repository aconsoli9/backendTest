package com.inditex.aplicacion.service;

import com.inditex.aplicacion.model.Price;
import com.inditex.aplicacion.repository.PriceRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class PriceService {
    private final PriceRepository priceRepository;

    public PriceService(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    public Optional<Price> getPrice(LocalDateTime applicationDate, Long productId, Integer brandId) {
        return priceRepository.findByStartDateLessThanEqualAndEndDateGreaterThanEqualAndProductIdAndBrandIdOrderByPriorityDesc(
                applicationDate, applicationDate, productId, brandId).stream().findFirst();
    }
}

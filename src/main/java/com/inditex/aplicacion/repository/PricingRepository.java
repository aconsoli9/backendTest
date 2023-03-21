package com.inditex.aplicacion.repository;

import com.inditex.aplicacion.model.Pricing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PricingRepository extends JpaRepository<Pricing, Long> {
    List<Pricing> findByStartDateLessThanEqualAndEndDateGreaterThanEqualAndProductIdAndBrandIdOrderByPriorityDesc(
            LocalDate startDate, LocalDate endDate, int productId, int brandId);
}


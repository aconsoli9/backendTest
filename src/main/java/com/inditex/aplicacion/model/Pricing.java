package com.inditex.aplicacion.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pricing {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int brandId;
    private LocalDate startDate;
    private LocalDate endDate;
    private String priceList;
    private int productId;
    private int priority;
    private float price;
    private String curr;
}

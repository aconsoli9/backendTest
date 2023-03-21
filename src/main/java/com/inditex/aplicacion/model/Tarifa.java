package com.inditex.aplicacion.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Tarifa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    @ManyToOne
    private Producto producto;
    @ManyToOne
    private Cadena cadena;
    private BigDecimal precio;
}

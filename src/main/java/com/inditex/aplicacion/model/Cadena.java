package com.inditex.aplicacion.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Cadena {
    @Id
    private Long id;
    private String nombre;
}

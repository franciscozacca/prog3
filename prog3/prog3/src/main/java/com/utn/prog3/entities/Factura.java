
package com.utn.prog3.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int numero;
    private double descuento;
    private enum formaPago;
    private int total;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "fecha")
    private Date fecha;
}

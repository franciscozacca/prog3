
package com.utn.prog3.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Domicilio implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String calle;
    private String numero;
    private String localidad;
}

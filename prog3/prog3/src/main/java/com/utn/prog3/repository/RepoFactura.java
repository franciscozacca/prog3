
package com.utn.prog3.repository;

import com.utn.prog3.entities.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoFactura extends JpaRepository<Factura, Long>{
    
}

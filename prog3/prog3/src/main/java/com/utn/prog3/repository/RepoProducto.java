
package com.utn.prog3.repository;

import com.utn.prog3.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoProducto extends JpaRepository<Producto, Long> {
    
}

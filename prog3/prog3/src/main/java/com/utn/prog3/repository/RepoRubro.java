
package com.utn.prog3.repository;

import com.utn.prog3.entities.Rubro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoRubro extends JpaRepository<Producto, Long> {
    
}


package com.utn.prog3.repository;

import com.utn.prog3.entities.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoDomicilio extends JpaRepository<Domicilio, Long>{
    
}

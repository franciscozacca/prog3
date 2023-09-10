package com.utn.prog3.repository;

import com.utn.prog3.entities.DetallePedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoDetallePedido extends JpaRepository<DetallePedido, Long>{
    
}


package com.utn.prog3.repository;

import com.utn.prog3.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoPedido extends JpaRepository<Pedido, Long>{
    
}

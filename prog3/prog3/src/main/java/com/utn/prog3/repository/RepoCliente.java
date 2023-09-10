
package com.utn.prog3.repository;

import com.utn.prog3.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoCliente extends JpaRepository<Cliente, Long>{
    
}

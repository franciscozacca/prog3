
package com.utn.prog3.repository;

import com.utn.prog3.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoUsuario extends JpaRepository<Usuario, Long> {
    
}

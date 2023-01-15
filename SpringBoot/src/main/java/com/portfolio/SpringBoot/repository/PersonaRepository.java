package com.portfolio.SpringBoot.repository;

import com.portfolio.SpringBoot.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //mapeamos como repositorio
// la interface extience de JpaRepository (que maneja repositorio JPA)
// en los parametros <> deben ir: <clase a persistir, tipo´de dato de su ID>

public interface PersonaRepository extends JpaRepository <Persona, Long>{
    
}

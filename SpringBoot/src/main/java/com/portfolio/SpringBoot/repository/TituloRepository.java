package com.portfolio.SpringBoot.repository;

import com.portfolio.SpringBoot.model.Titulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TituloRepository extends JpaRepository<Titulo, Long>{
    
}

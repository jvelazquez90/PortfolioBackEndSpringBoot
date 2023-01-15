package com.portfolio.SpringBoot.repository;

import com.portfolio.SpringBoot.model.Habilidades;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabilidadesRepository extends JpaRepository<Habilidades, Long>{
    
}

package com.portfolio.SpringBoot.repository;

import com.portfolio.SpringBoot.model.Aptitudes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AptitudesRepository extends JpaRepository<Aptitudes, Long> {
    
}

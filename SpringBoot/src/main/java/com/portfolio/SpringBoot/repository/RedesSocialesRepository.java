package com.portfolio.SpringBoot.repository;

import com.portfolio.SpringBoot.model.RedesSociales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RedesSocialesRepository extends JpaRepository<RedesSociales, Long>{
    
}

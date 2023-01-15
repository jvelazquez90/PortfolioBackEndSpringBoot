package com.portfolio.SpringBoot.repository;

import com.portfolio.SpringBoot.model.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepository extends JpaRepository<Email, Long>{
    
}

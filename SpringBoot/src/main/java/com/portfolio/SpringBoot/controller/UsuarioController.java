package com.portfolio.SpringBoot.controller;

import com.portfolio.SpringBoot.model.Persona;
import com.portfolio.SpringBoot.repository.PersonaRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("contactos")
@AllArgsConstructor

public class UsuarioController {
    private final PersonaRepository personaRepository;
    
    @GetMapping
    public List<Persona> listPersonas(){
        return personaRepository.findAll();
    }
}

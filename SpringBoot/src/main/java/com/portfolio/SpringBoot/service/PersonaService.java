package com.portfolio.SpringBoot.service;

import com.portfolio.SpringBoot.model.Persona;
import com.portfolio.SpringBoot.repository.PersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService implements IPersonaService{
    
    @Autowired
    private PersonaRepository personaRepository;

    //--------------------------------------------------------------------------
    @Override
    public List<Persona> getPersonas() {
        List<Persona> listaPersonas = personaRepository.findAll();
        return listaPersonas;
    }
    
    //--------------------------------------------------------------------------
    @Override
    public void savePersona(Persona persona) {
        personaRepository.save(persona);
    }
    
    //--------------------------------------------------------------------------
    @Override
    public void deletePersona(Long id) {
        personaRepository.deleteById(id);
    }
    
    //--------------------------------------------------------------------------
    @Override
    public Persona findPersona(Long id) {
        Persona persona = personaRepository.findById(id).orElse(null);
        return persona;
    }
        
}

package com.portfolio.SpringBoot.controller;

import com.portfolio.SpringBoot.model.Persona;
import com.portfolio.SpringBoot.service.PersonaService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonaController {
    
    @Autowired
    
    private PersonaService interfacePersona;

    //--------------------------------------------------------------------------
    @GetMapping("/personas/get")
    
    public List<Persona> getPersonas(){
        return interfacePersona.getPersonas();
    }

    //--------------------------------------------------------------------------
    @GetMapping("/personas/obtener/{id}")
    public Persona findPersona(@PathVariable Long id){
        Persona persona = interfacePersona.findPersona(id);
        return persona;
    }
    
    //--------------------------------------------------------------------------
    @PostMapping("/personas/crear")
    
    public void createPersona(@RequestBody Persona persona){
        interfacePersona.savePersona(persona);
        
        // devuelve un string avisando si creo correctamente
        //return "La persona fue creada correctamente";
    }
    
    //--------------------------------------------------------------------------
    @DeleteMapping("/personas/borrar/{id}")
    
    public void deletePersona(@PathVariable Long id){
        interfacePersona.deletePersona(id);
        
        // devuelve un string avisando si elimino correctamente
        //return "La persona fue eliminada correctamente";
    }
    
    //--------------------------------------------------------------------------
    @PutMapping("/personas/editar/{id}")
    
    public void editPersona(     @PathVariable Long id,@RequestBody Persona per)
    {
        // busco la persona en cuestion
        Persona persona = interfacePersona.findPersona(id);

        // esto tambien puede ir en service
        // para desacoplar mejor aun el codigo en un nuevo metodo
        persona.setNombre(per.getNombre());
        persona.setApellido(per.getApellido());
        persona.setFechaNacimiento(per.getFechaNacimiento());
        persona.setNacionalidad(per.getNacionalidad());
        persona.setSexo(per.getSexo());
        persona.setLugarResidencia(per.getLugarResidencia());
        persona.setTelefono(per.getTelefono());
        persona.setAcercaDe(per.getAcercaDe());

        interfacePersona.savePersona(persona);

        // retorna la nueva persona
        //return persona;
    }
    
}

package com.portfolio.SpringBoot.controller;

import com.portfolio.SpringBoot.model.Persona;
import com.portfolio.SpringBoot.service.IPersonaService;
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
    
    private IPersonaService interfacePersona;

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
    
    public String createPersona(@RequestBody Persona persona){
        interfacePersona.savePersona(persona);
        
        // devuelve un string avisando si creo correctamente
        return "La persona fue creada correctamente";
    }
    
    //--------------------------------------------------------------------------
    @DeleteMapping("/personas/borrar/{id}")
    
    public String deletePersona(@PathVariable Long id){
        interfacePersona.deletePersona(id);
        
        // devuelve un string avisando si elimino correctamente
        return "La persona fue eliminada correctamente";
    }
    
    //--------------------------------------------------------------------------
    @PutMapping("/personas/editar/{id}")
    
    public Persona editPersona(     @PathVariable Long id,
                                    @RequestParam ("nombre") String nuevoNombre,
                                    @RequestParam ("apellido") String nuevoApellido,
                                    @RequestParam ("fecha_nacimiento") Date nuevaFechaNacimiento,
                                    @RequestParam ("nacionalidad") String nuevaNacionalidad,
                                    @RequestParam ("sexo") char nuevoSexo,
                                    @RequestParam ("lugar_residencia") String nuevoLugarResidencia,
                                    @RequestParam ("telefono") String nuevoTelefono,
                                    @RequestParam ("acerca_de") String nuevoAcercaDe
            ){
    // busco la persona en cuestion
    Persona persona = interfacePersona.findPersona(id);
    
    // esto tambien puede ir en service
    // para desacoplar mejor aun el codigo en un nuevo metodo
    persona.setApellido(nuevoApellido);
    persona.setNombre(nuevoApellido);
    persona.setFechaNacimiento(nuevaFechaNacimiento);
    persona.setNacionalidad(nuevaNacionalidad);
    persona.setSexo(nuevoSexo);
    persona.setLugarResidencia(nuevoLugarResidencia);
    persona.setTelefono(nuevoTelefono);
    persona.setAcercaDe(nuevoAcercaDe);
    
    interfacePersona.savePersona(persona);
    
    // retorna la nueva persona
    return persona;
    }
    
}

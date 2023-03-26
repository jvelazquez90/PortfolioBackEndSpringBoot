package com.portfolio.SpringBoot.controller;

import com.portfolio.SpringBoot.model.Aptitudes;
import com.portfolio.SpringBoot.service.AptitudesService;
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
public class AptitudController {
    
    @Autowired
    private AptitudesService interfaceAptitudes;

    //--------------------------------------------------------------------------
    @GetMapping("/aptitudes/get")
    
    public List<Aptitudes> getAptitudes(){
        return interfaceAptitudes.getAptitudes();
    }
    
    //--------------------------------------------------------------------------
    @GetMapping("/aptitudes/obtener/{id}")
    public Aptitudes findAptitudes(@PathVariable Long id){
        Aptitudes aptitudes = interfaceAptitudes.findAptitud(id);
        return aptitudes;
    }
    
    //--------------------------------------------------------------------------
    @PostMapping("/aptitudes/crear")
    
    public void createAptitudes(@RequestBody Aptitudes aptitud){
        interfaceAptitudes.saveAptitudes(aptitud);
        
        // devuelve un string avisando si creo correctamente
        //return "La aptitud fue creada correctamente";
    }
    
    //--------------------------------------------------------------------------
    @DeleteMapping("/aptitudes/borrar/{id}")
    
    public void deleteAptitud(@PathVariable Long id){
        interfaceAptitudes.deleteAptitud(id);
        
        // devuelve un string avisando si elimino correctamente
        //return "La aptitud fue eliminada correctamente";
    }
    
    //--------------------------------------------------------------------------
    @PutMapping("/aptitudes/editar/{id}")
    
    public void editPersona( @PathVariable Long id, @RequestBody Aptitudes apt)
    {
        // busco la persona en cuestion
        Aptitudes aptitud = interfaceAptitudes.findAptitud(id);

        // esto tambien puede ir en service
        // para desacoplar mejor aun el codigo en un nuevo metodo
        aptitud.setNombre(apt.getNombre());
        aptitud.setClasificacion(apt.getClasificacion());

        interfaceAptitudes.saveAptitudes(aptitud);

        // retorna la nueva persona
        //return aptitud;
    }
    
    
}

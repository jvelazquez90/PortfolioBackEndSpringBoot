package com.portfolio.SpringBoot.controller;

import com.portfolio.SpringBoot.model.Educacion;
import com.portfolio.SpringBoot.service.EducacionService;
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
public class EducacionController {
    
    @Autowired
    private EducacionService interfaceEducacion;

    //--------------------------------------------------------------------------
    @GetMapping("/educacion/get")
    
    public List<Educacion> getEducacion(){
        return interfaceEducacion.getEducacion();
    }
    
    //--------------------------------------------------------------------------
    @GetMapping("/educacion/obtener/{id}")
    public Educacion findEducacion(@PathVariable Long id){
        Educacion educacion = interfaceEducacion.findEducacion(id);
        return educacion;
    }
    
    //--------------------------------------------------------------------------
    @PostMapping("/educacion/crear")
    
    public void createEducacion(@RequestBody Educacion educacion){
        interfaceEducacion.saveEducacion(educacion);
        
        // devuelve un string avisando si creo correctamente
        //return "La educacion fue creada correctamente";
    }
    
    //--------------------------------------------------------------------------
    @DeleteMapping("/educacion/borrar/{id}")
    
    public void deleteEducacion(@PathVariable Long id){
        interfaceEducacion.deleteEducacion(id);
        
        // devuelve un string avisando si elimino correctamente
        //return "La educacion fue eliminada correctamente";
    }
    
    //--------------------------------------------------------------------------
    @PutMapping("/educacion/editar/{id}")
    
    public void editEducacio(  @PathVariable Long id, @RequestBody Educacion edu)
    {
        // busco la educacion en cuestion
        Educacion educacion = interfaceEducacion.findEducacion(id);

        // esto tambien puede ir en service
        // para desacoplar mejor aun el codigo en un nuevo metodo
        educacion.setNombreInstitucion(edu.getNombreInstitucion());
        educacion.setFechaIngreso(edu.getFechaIngreso());
        educacion.setFechaEgreso(edu.getFechaEgreso());
        educacion.setLugar(edu.getLugar());

        interfaceEducacion.saveEducacion(educacion);

        // retorna la nueva educacion
        //return educacion;
    }
    
}

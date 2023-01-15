package com.portfolio.SpringBoot.controller;

import com.portfolio.SpringBoot.model.Educacion;
import com.portfolio.SpringBoot.service.IEducacionService;
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
    private IEducacionService interfaceEducacion;

    //--------------------------------------------------------------------------
    @GetMapping("/educacion/obtener")
    
    public List<Educacion> getEducacion(){
        return interfaceEducacion.getEducacion();
    }
    
    //--------------------------------------------------------------------------
    @PostMapping("/educacion/crear")
    
    public String createEducacion(@RequestBody Educacion educacion){
        interfaceEducacion.saveEducacion(educacion);
        
        // devuelve un string avisando si creo correctamente
        return "La educacion fue creada correctamente";
    }
    
    //--------------------------------------------------------------------------
    @DeleteMapping("/educacion/borrar/{id}")
    
    public String deleteEducacion(@PathVariable Long id){
        interfaceEducacion.deleteEducacion(id);
        
        // devuelve un string avisando si elimino correctamente
        return "La educacion fue eliminada correctamente";
    }
    
    //--------------------------------------------------------------------------
    @PutMapping("/educacion/editar/{id}")
    
    public Educacion editEducacio(  @PathVariable Long id,
                                    @RequestParam ("nombre_institucion") String nombreInstitucion,
                                    @RequestParam ("fecha_ingreso") Date nuevaFechaIngreso,
                                    @RequestParam ("fecha_salida") Date nuevaFechaSalida,
                                    @RequestParam ("lugar") String nuevoLugar
            ){
    // busco la educacion en cuestion
    Educacion educacion = interfaceEducacion.findEducacion(id);
    
    // esto tambien puede ir en service
    // para desacoplar mejor aun el codigo en un nuevo metodo
    educacion.setNombreInstitucion(nombreInstitucion);
    educacion.setFechaIngreso(nuevaFechaIngreso);
    educacion.setFechaEgreso(nuevaFechaSalida);
    educacion.setLugar(nuevoLugar);
    
    interfaceEducacion.saveEducacion(educacion);
    
    // retorna la nueva educacion
    return educacion;
    }
    
}

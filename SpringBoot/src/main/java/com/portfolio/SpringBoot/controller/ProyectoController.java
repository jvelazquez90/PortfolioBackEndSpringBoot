
package com.portfolio.SpringBoot.controller;

import com.portfolio.SpringBoot.model.Proyecto;
import com.portfolio.SpringBoot.service.ProyectoService;
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
public class ProyectoController {
    
    @Autowired
    private ProyectoService interfaceProyecto;

    //--------------------------------------------------------------------------
    @GetMapping("/proyecto/get")
    
    public List<Proyecto> getProyecto(){
        return interfaceProyecto.getProyecto();
    }
    
    //--------------------------------------------------------------------------
    @GetMapping("/proyecto/obtener/{id}")
    public Proyecto findProyecto(@PathVariable Long id){
        Proyecto proyecto = interfaceProyecto.findProyecto(id);
        return proyecto;
    }
    
    //--------------------------------------------------------------------------
    @PostMapping("/proyecto/crear")
    
    public void createProyecto(@RequestBody Proyecto proyecto){
        interfaceProyecto.saveProyecto(proyecto);
        
        // devuelve un string avisando si creo correctamente
        //return "El Proyecto fue creada correctamente";
    }
    
    //--------------------------------------------------------------------------
    @DeleteMapping("/proyecto/borrar/{id}")
    
    public void deleteProyecto(@PathVariable Long id){
        interfaceProyecto.deleteProyecto(id);
        
        // devuelve un string avisando si elimino correctamente
        //return "El Proyecto fue eliminada correctamente";
    }
    
    //--------------------------------------------------------------------------
    @PutMapping("/proyecto/editar/{id}")
    
    public void editProyecto(  @PathVariable Long id, @RequestBody Proyecto proy)
    {
        // busco el proyecto en cuestion
        Proyecto proyecto = interfaceProyecto.findProyecto(id);

        // esto tambien puede ir en service
        // para desacoplar mejor aun el codigo en un nuevo metodo
        proyecto.setNombreProyecto(proy.getNombreProyecto());
        proyecto.setDuracion(proy.getDuracion());
        proyecto.setParticipantes(proy.getParticipantes());
        proyecto.setProyectoCol(proy.getProyectoCol());

        interfaceProyecto.saveProyecto(proyecto);

        // retorna el nuevo Proyecto
        //return proyecto;
    }
    
}

package com.portfolio.SpringBoot.controller;

import com.portfolio.SpringBoot.model.Habilidades;
import com.portfolio.SpringBoot.service.HabilidadesService;
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
public class HabilidadesController {
    
    @Autowired
    private HabilidadesService interfaceHabilidades;

    //--------------------------------------------------------------------------
    @GetMapping("/habilidades/get")
    
    public List<Habilidades> getHabilidades(){
        return interfaceHabilidades.getHabilidades();
    }
    
    //--------------------------------------------------------------------------
    @GetMapping("/habilidades/obtener/{id}")
    public Habilidades findHabilidades(@PathVariable Long id){
        Habilidades habilidades = interfaceHabilidades.findHabilidades(id);
        return habilidades;
    }
    
    //--------------------------------------------------------------------------
    @PostMapping("/habilidades/crear")
    
    public void createHabilidades(@RequestBody Habilidades habilidades){
        interfaceHabilidades.saveHabilidades(habilidades);
        
        // devuelve un string avisando si creo correctamente
        //return "La habilidad fue creada correctamente";
    }
    
    //--------------------------------------------------------------------------
    @DeleteMapping("/habilidades/borrar/{id}")
    
    public void deleteHabilidades(@PathVariable Long id){
        interfaceHabilidades.deleteHabilidades(id);
        
        // devuelve un string avisando si elimino correctamente
        //return "La habilidad fue eliminada correctamente";
    }
    
    //--------------------------------------------------------------------------
    @PutMapping("/habilidades/editar/{id}")
    
    public void editHabilidades(     @PathVariable Long id, @RequestBody Habilidades habilidad)
    {
        // busco la habilidad en cuestion
        Habilidades habilidades = interfaceHabilidades.findHabilidades(id);

        // esto tambien puede ir en service
        // para desacoplar mejor aun el codigo en un nuevo metodo
        habilidades.setNombre(habilidad.getNombre());
        habilidades.setPorcentaje(habilidad.getPorcentaje());

        interfaceHabilidades.saveHabilidades(habilidades);

        // retorna la nueva habilidades
        //return habilidades;
    }
    
}

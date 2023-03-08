package com.portfolio.SpringBoot.controller;

import com.portfolio.SpringBoot.model.Experiencia;
import com.portfolio.SpringBoot.service.ExperienciaService;
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
public class ExperienciaController {
    
    @Autowired
    private ExperienciaService interfaceExperiencia;

    //--------------------------------------------------------------------------
    @GetMapping("/experiencia/get")
    
    public List<Experiencia> getExperiencia(){
        return interfaceExperiencia.getExperiencia();
    }
    
    //--------------------------------------------------------------------------
    @GetMapping("/experiencia/obtener/{id}")
    public Experiencia findExperiencia(@PathVariable Long id){
        Experiencia experiencia = interfaceExperiencia.findExperiencia(id);
        return experiencia;
    }
    
    //--------------------------------------------------------------------------
    @PostMapping("/experiencia/crear")
    
    public String createExperiencia(@RequestBody Experiencia experiencia){
        interfaceExperiencia.saveExperiencia(experiencia);
        
        // devuelve un string avisando si creo correctamente
        return "La experiencia fue creada correctamente";
    }
    
    //--------------------------------------------------------------------------
    @DeleteMapping("/experiencia/borrar/{id}")
    
    public String deleteExperiencia(@PathVariable Long id){
        interfaceExperiencia.deleteExperiencia(id);
        
        // devuelve un string avisando si elimino correctamente
        return "La experiencia fue eliminada correctamente";
    }
    
    //--------------------------------------------------------------------------
    @PutMapping("/experiencia/editar/{id}")
    
    public Experiencia editExperiencia(     @PathVariable Long id,
                                            @RequestParam ("nombre_empresa") String nuevaEmpresa,
                                            @RequestParam ("cargo") String nuevoCargo,
                                            @RequestParam ("fecha_ingreso") Date nuevaFechaIngreso,
                                            @RequestParam ("fecha_salida") Date nuevaFechaSalida,
                                            @RequestParam ("es_trabajo_actual") boolean trabajoActual,
                                            @RequestParam ("descripcion") String nuevaDescripcion
            ){
    // busco la experiencia en cuestion
    Experiencia experiencia = interfaceExperiencia.findExperiencia(id);
    
    // esto tambien puede ir en service
    // para desacoplar mejor aun el codigo en un nuevo metodo
    experiencia.setNombreEmpresa(nuevaEmpresa);
    experiencia.setCargo(nuevoCargo);
    experiencia.setFechaIngreso(nuevaFechaIngreso);
    experiencia.setFechaEgreso(nuevaFechaSalida);
    experiencia.setEsTrabajoActual(trabajoActual);
    experiencia.setDescripcion(nuevaDescripcion);
    
    interfaceExperiencia.saveExperiencia(experiencia);
    
    // retorna la nueva experiencia
    return experiencia;
    }
    
}

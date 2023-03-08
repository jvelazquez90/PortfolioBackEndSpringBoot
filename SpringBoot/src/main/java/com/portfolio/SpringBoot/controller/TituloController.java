package com.portfolio.SpringBoot.controller;

import com.portfolio.SpringBoot.model.Titulo;
import com.portfolio.SpringBoot.service.TituloService;
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
public class TituloController {
    
    @Autowired
    private TituloService interfaceTitulo;

    //--------------------------------------------------------------------------
    @GetMapping("/titulo/get")
    
    public List<Titulo> getTitulo(){
        return interfaceTitulo.getTitulo();
    }
    
    //--------------------------------------------------------------------------
    @GetMapping("/titulo/obtener/{id}")
    public Titulo findTitulo(@PathVariable Long id){
        Titulo titulo = interfaceTitulo.findTitulo(id);
        return titulo;
    }
    
    //--------------------------------------------------------------------------
    @PostMapping("/titulo/crear")
    
    public String createtitulo(@RequestBody Titulo titulo){
        interfaceTitulo.saveTitulo(titulo);
        
        // devuelve un string avisando si creo correctamente
        return "El Titulo fue creada correctamente";
    }
    
    //--------------------------------------------------------------------------
    @DeleteMapping("/titulo/borrar/{id}")
    
    public String deleteTitulo(@PathVariable Long id){
        interfaceTitulo.deleteTitulo(id);
        
        // devuelve un string avisando si elimino correctamente
        return "El Titulo fue eliminada correctamente";
    }
    
    //--------------------------------------------------------------------------
    @PutMapping("/titulo/editar/{id}")
    
    public Titulo editTitulo(     @PathVariable Long id,
                                    @RequestParam ("titulo") String nuevoTitulo
            ){
    // busco rl Titulo en cuestion
    Titulo titulo = interfaceTitulo.findTitulo(id);
    
    // esto tambien puede ir en service
    // para desacoplar mejor aun el codigo en un nuevo metodo
    titulo.setTitulo(nuevoTitulo);
    
    interfaceTitulo.saveTitulo(titulo);
    
    // retorna el nuevo titulo
    return titulo;
    }
    
}

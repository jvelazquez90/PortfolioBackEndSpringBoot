package com.portfolio.SpringBoot.controller;

import com.portfolio.SpringBoot.model.RedesSociales;
import com.portfolio.SpringBoot.service.IRedesSocialesService;
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
public class RedesSocialesController {
    
    @Autowired
    private IRedesSocialesService interfaceRedesSociales;

    //--------------------------------------------------------------------------
    @GetMapping("/redesSociales/get")
    
    public List<RedesSociales> getRedesSociales(){
        return interfaceRedesSociales.getRedesSociales();
    }
    
    //--------------------------------------------------------------------------
    @GetMapping("/redesSociales/obtener/{id}")
    public RedesSociales findRedesSociales(@PathVariable Long id){
        RedesSociales redesSociales = interfaceRedesSociales.findRedesSociales(id);
        return redesSociales;
    }
    
    //--------------------------------------------------------------------------
    @PostMapping("/redesSociales/crear")
    
    public String createRedesSociales(@RequestBody RedesSociales redesSociales){
        interfaceRedesSociales.saveRedesSociales(redesSociales);
        
        // devuelve un string avisando si creo correctamente
        return "La Red Social fue creada correctamente";
    }
    
    //--------------------------------------------------------------------------
    @DeleteMapping("/redesSociales/borrar/{id}")
    
    public String deleteRedesSociales(@PathVariable Long id){
        interfaceRedesSociales.deleteRedesSociales(id);
        
        // devuelve un string avisando si elimino correctamente
        return "La Red Social fue eliminada correctamente";
    }
    
    //--------------------------------------------------------------------------
    @PutMapping("/redesSociales/editar/{id}")
    
    public RedesSociales editRedesSociales(     @PathVariable Long id,
                                                @RequestParam ("nombre") String nuevoNombre,
                                                @RequestParam ("link") String nuevoLink
            ){
    // busco la Red Social en cuestion
    RedesSociales redesSociales = interfaceRedesSociales.findRedesSociales(id);
    
    // esto tambien puede ir en service
    // para desacoplar mejor aun el codigo en un nuevo metodo
    redesSociales.setNombre(nuevoNombre);
    redesSociales.setLink(nuevoLink);
    
    interfaceRedesSociales.saveRedesSociales(redesSociales);
    
    // retorna la nueva Red Social
    return redesSociales;
    }
    
}

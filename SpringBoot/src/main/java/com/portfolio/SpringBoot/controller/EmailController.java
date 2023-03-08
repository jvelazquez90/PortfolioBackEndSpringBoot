package com.portfolio.SpringBoot.controller;

import com.portfolio.SpringBoot.model.Email;
import com.portfolio.SpringBoot.service.EmailService;
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
public class EmailController {
    
    @Autowired
    
    private EmailService interfaceEmail;

    //--------------------------------------------------------------------------
    @GetMapping("/email/get")
    
    public List<Email> getPersonas(){
        return interfaceEmail.getEmail();
    }
    
    //--------------------------------------------------------------------------
    @GetMapping("/email/obtener/{id}")
    public Email findPersona(@PathVariable Long id){
        Email email = interfaceEmail.findEmail(id);
        return email;
    }
    
    //--------------------------------------------------------------------------
    @PostMapping("/email/crear")
    
    public String createEmail(@RequestBody Email email){
        interfaceEmail.saveEmail(email);
        
        // devuelve un string avisando si creo correctamente
        return "El email fue creada correctamente";
    }
    
    //--------------------------------------------------------------------------
    @DeleteMapping("/email/borrar/{id}")
    
    public String deleteEmail(@PathVariable Long id){
        interfaceEmail.deleteEmail(id);
        
        // devuelve un string avisando si elimino correctamente
        return "El email fue eliminada correctamente";
    }
    
    //--------------------------------------------------------------------------
    @PutMapping("/email/editar/{id}")
    
    public Email editEmail(     @PathVariable Long id,
                                @RequestParam ("email") String nuevoEmail
            ){
    // busco el email en cuestion
    Email email = interfaceEmail.findEmail(id);
    
    // esto tambien puede ir en service
    // para desacoplar mejor aun el codigo en un nuevo metodo
    email.setEmail(nuevoEmail);
    
    interfaceEmail.saveEmail(email);
    
    // retorna el nuevo email
    return email;
    }
    
}

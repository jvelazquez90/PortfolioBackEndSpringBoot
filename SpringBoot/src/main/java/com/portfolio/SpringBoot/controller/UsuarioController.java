package com.portfolio.SpringBoot.controller;

import com.portfolio.SpringBoot.model.Usuario;
import com.portfolio.SpringBoot.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/user")
//@CrossOrigin(origins="http://localhost:4200")

public class UsuarioController  {
    @Autowired
    private UsuarioRepository userRepo;
    
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody Usuario data) {
        System.out.print("Usuario: " + data.getUser() + "/nPassword: " + data.getPassword());
        Usuario user = userRepo.findByUser(data.getUser());
        
        //System.out.print(user);
        
        if(user.getPassword().equals(data.getPassword()))
            return ResponseEntity.ok(user);
        return (ResponseEntity<?>)ResponseEntity.internalServerError();
    }
}

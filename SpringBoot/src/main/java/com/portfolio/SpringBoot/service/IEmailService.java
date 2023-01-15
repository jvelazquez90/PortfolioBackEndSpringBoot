package com.portfolio.SpringBoot.service;

import com.portfolio.SpringBoot.model.Email;
import java.util.List;


public interface IEmailService {
    
    // metodo para traer todos email
    public List<Email> getEmail();
    
    //--------------------------------------------------------------------------
    // metodo para dar de alta un email
    public void saveEmail(Email email);
    
    //--------------------------------------------------------------------------
    // metodo para borrar un email
    public void deleteEmail(Long id);
    
    //--------------------------------------------------------------------------
    // metodo para encontrar un email
    public Email findEmail(Long id);
    
}

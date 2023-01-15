package com.portfolio.SpringBoot.service;

import com.portfolio.SpringBoot.model.Email;
import com.portfolio.SpringBoot.repository.EmailRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailService implements IEmailService{

    @Autowired
    private EmailRepository emailRepository;
    
//--------------------------------------------------------------------------
    @Override
    public List<Email> getEmail() {
        List<Email> listaEmail = emailRepository.findAll();
        return listaEmail;
    }

    //--------------------------------------------------------------------------
    @Override
    public void saveEmail(Email email) {
        emailRepository.save(email);
    }

    //--------------------------------------------------------------------------
    @Override
    public void deleteEmail(Long id) {
        emailRepository.deleteById(id);
    }

    //--------------------------------------------------------------------------
    @Override
    public Email findEmail(Long id) {
        Email buscarEmail = emailRepository.findById(id).orElse(null);
        return buscarEmail;
    }
    
}

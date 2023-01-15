package com.portfolio.SpringBoot.service;

import com.portfolio.SpringBoot.model.Educacion;
import com.portfolio.SpringBoot.repository.EducacionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducacionService implements IEducacionService{
    
    @Autowired
    private EducacionRepository educacionRepository;
    
    //--------------------------------------------------------------------------
    @Override
    public List<Educacion> getEducacion() {
        List<Educacion> listaEducacion = educacionRepository.findAll();
        return listaEducacion;
    }

    //--------------------------------------------------------------------------
    @Override
    public void saveEducacion(Educacion educacion) {
        educacionRepository.save(educacion);
    }

    //--------------------------------------------------------------------------
    @Override
    public void deleteEducacion(Long id) {
        educacionRepository.deleteById(id);
    }

    //--------------------------------------------------------------------------
    @Override
    public Educacion findEducacion(Long id) {
        Educacion buscarEducacion = educacionRepository.findById(id).orElse(null);
        return buscarEducacion;
    }
    
}

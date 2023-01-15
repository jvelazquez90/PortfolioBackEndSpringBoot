package com.portfolio.SpringBoot.service;

import com.portfolio.SpringBoot.model.Experiencia;
import com.portfolio.SpringBoot.repository.ExperienciaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienciaService implements IExperienciaService{

    @Autowired
    private ExperienciaRepository experienciaRepository;
    
    //--------------------------------------------------------------------------
    @Override
    public List<Experiencia> getExperiencia() {
        List<Experiencia> listaExperiencia = experienciaRepository.findAll();
        return listaExperiencia;
    }

    //--------------------------------------------------------------------------
    @Override
    public void saveExperiencia(Experiencia experiencia) {
        experienciaRepository.save(experiencia);
    }

    //--------------------------------------------------------------------------
    @Override
    public void deleteExperiencia(Long id) {
        experienciaRepository.deleteById(id);
    }

    //--------------------------------------------------------------------------
    @Override
    public Experiencia findExperiencia(Long id) {
        Experiencia buscarExperiencia = experienciaRepository.findById(id).orElse(null);
        return buscarExperiencia;
    }
    
}

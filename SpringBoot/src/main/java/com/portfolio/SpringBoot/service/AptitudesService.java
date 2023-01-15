package com.portfolio.SpringBoot.service;

import com.portfolio.SpringBoot.model.Aptitudes;
import com.portfolio.SpringBoot.repository.AptitudesRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AptitudesService implements IAptitudesService{

    @Autowired
    private AptitudesRepository aptitudesRepository;
    
    //--------------------------------------------------------------------------
    @Override
    public List<Aptitudes> getAptitudes() {
        List<Aptitudes> listaAptitudes = aptitudesRepository.findAll();
        return listaAptitudes;
    }

    //--------------------------------------------------------------------------
    @Override
    public void saveAptitudes(Aptitudes aptitud) {
        aptitudesRepository.save(aptitud);
    }

    //--------------------------------------------------------------------------
    @Override
    public void deleteAptitud(Long id) {
        aptitudesRepository.deleteById(id);
    }

    //--------------------------------------------------------------------------s
    @Override
    public Aptitudes findAptitud(Long id) {
        Aptitudes aptitud = aptitudesRepository.findById(id).orElse(null);
        return aptitud;
    }
    
}

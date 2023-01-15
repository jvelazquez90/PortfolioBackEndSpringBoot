package com.portfolio.SpringBoot.service;

import com.portfolio.SpringBoot.model.Habilidades;
import com.portfolio.SpringBoot.repository.HabilidadesRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HabilidadesService implements IHabilidadesService{

    @Autowired
    private HabilidadesRepository habilidadesRepository;
    
    //--------------------------------------------------------------------------
    @Override
    public List<Habilidades> getHabilidades() {
        List<Habilidades> listaHabilidades = habilidadesRepository.findAll();
        return listaHabilidades;
    }

    //--------------------------------------------------------------------------
    @Override
    public void saveHabilidades(Habilidades habilidades) {
        habilidadesRepository.save(habilidades);
    }

    //--------------------------------------------------------------------------
    @Override
    public void deleteHabilidades(Long id) {
        habilidadesRepository.deleteById(id);
    }

    //--------------------------------------------------------------------------
    @Override
    public Habilidades findHabilidades(Long id) {
        Habilidades buscarHabilidad = habilidadesRepository.findById(id).orElse(null);
        return buscarHabilidad;
    }
    
}

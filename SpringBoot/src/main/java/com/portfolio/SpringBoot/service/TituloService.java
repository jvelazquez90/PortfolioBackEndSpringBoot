package com.portfolio.SpringBoot.service;

import com.portfolio.SpringBoot.model.Titulo;
import com.portfolio.SpringBoot.repository.TituloRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TituloService implements ITituloService{

    @Autowired
    private TituloRepository tituloRepository;
    
    //--------------------------------------------------------------------------
    @Override
    public List<Titulo> getTitulo() {
        List<Titulo> listaTitulos = tituloRepository.findAll();
        return listaTitulos;
    }

    //--------------------------------------------------------------------------
    @Override
    public void saveTitulo(Titulo titulo) {
        tituloRepository.save(titulo);
    }

    //--------------------------------------------------------------------------
    @Override
    public void deleteTitulo(Long id) {
        tituloRepository.deleteById(id);
    }

    //--------------------------------------------------------------------------
    @Override
    public Titulo findTitulo(Long id) {
        Titulo buscarTitulo = tituloRepository.findById(id).orElse(null);
        return buscarTitulo;
    }
    
}

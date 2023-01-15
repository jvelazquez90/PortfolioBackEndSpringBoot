package com.portfolio.SpringBoot.service;

import com.portfolio.SpringBoot.model.Proyecto;
import com.portfolio.SpringBoot.repository.ProyectoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProyectoService implements IProyectoService{

    @Autowired
    private ProyectoRepository proyectoRepository;
    
    //--------------------------------------------------------------------------
    @Override
    public List<Proyecto> getProyecto() {
        List<Proyecto> listaProyecto = proyectoRepository.findAll();
        return listaProyecto;
    }

    //--------------------------------------------------------------------------
    @Override
    public void saveProyecto(Proyecto proyecto) {
        proyectoRepository.save(proyecto);
    }

    //--------------------------------------------------------------------------
    @Override
    public void deleteProyecto(Long id) {
        proyectoRepository.deleteById(id);
    }

    //--------------------------------------------------------------------------
    @Override
    public Proyecto findProyecto(Long id) {
        Proyecto buscarProyecto = proyectoRepository.findById(id).orElse(null);
        return buscarProyecto;
    }
    
}

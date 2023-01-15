package com.portfolio.SpringBoot.service;

import com.portfolio.SpringBoot.model.Proyecto;
import java.util.List;


public interface IProyectoService {
    
    // metodo para traer todos los proyecto
    public List<Proyecto> getProyecto();
    
    //--------------------------------------------------------------------------
    // metodo para dar de alta un proyecto
    public void saveProyecto(Proyecto proyecto);
    
    //--------------------------------------------------------------------------
    // metodo para borrar un proyecto
    public void deleteProyecto(Long id);
    
    //--------------------------------------------------------------------------
    // metodo para encontrar un proyecto
    public Proyecto findProyecto(Long id);
    
}

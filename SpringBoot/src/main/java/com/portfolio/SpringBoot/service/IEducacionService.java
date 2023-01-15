package com.portfolio.SpringBoot.service;

import com.portfolio.SpringBoot.model.Educacion;
import java.util.List;


public interface IEducacionService {
    
    // metodo para traer todas las educaciones
    public List<Educacion> getEducacion();
    
    //--------------------------------------------------------------------------
    // metodo para dar de alta una educacion
    public void saveEducacion(Educacion educacion);
    
    //--------------------------------------------------------------------------
    // metodo para borrar una educacion
    public void deleteEducacion(Long id);
    
    //--------------------------------------------------------------------------
    // metodo para encontrar una educacion
    public Educacion findEducacion(Long id);
    
}

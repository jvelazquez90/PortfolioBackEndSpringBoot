package com.portfolio.SpringBoot.service;

import com.portfolio.SpringBoot.model.Experiencia;
import java.util.List;


public interface IExperienciaService {
    
    // metodo para traer todas las experiencias
    public List<Experiencia> getExperiencia();
    
    //--------------------------------------------------------------------------
    // metodo para dar de alta una experiencia
    public void saveExperiencia(Experiencia experiencia);
    
    //--------------------------------------------------------------------------
    // metodo para borrar una experiencia
    public void deleteExperiencia(Long id);
    
    //--------------------------------------------------------------------------
    // metodo para encontrar una experiencia
    public Experiencia findExperiencia(Long id);
    
}

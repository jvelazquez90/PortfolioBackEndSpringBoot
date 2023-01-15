package com.portfolio.SpringBoot.service;

import com.portfolio.SpringBoot.model.Habilidades;
import java.util.List;


public interface IHabilidadesService {
    
    // metodo para traer todas las habilidades
    public List<Habilidades> getHabilidades();
    
    //--------------------------------------------------------------------------
    // metodo para dar de alta una phabilidad
    public void saveHabilidades(Habilidades habilidades);
    
    //--------------------------------------------------------------------------
    // metodo para borrar una habilidad
    public void deleteHabilidades(Long id);
    
    //--------------------------------------------------------------------------
    // metodo para encontrar una habilidad
    public Habilidades findHabilidades(Long id);
    
}

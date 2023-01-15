package com.portfolio.SpringBoot.service;

import com.portfolio.SpringBoot.model.Aptitudes;
import java.util.List;
import org.springframework.stereotype.Service;


public interface IAptitudesService {
    
    // metodo para traer todas las aptitudes
    public List<Aptitudes> getAptitudes();
    
    //--------------------------------------------------------------------------
    // metodo para dar de alta una aptitud
    public void saveAptitudes(Aptitudes aptitud);
    
    //--------------------------------------------------------------------------
    // metodo para borrar una aptitud
    public void deleteAptitud(Long id);
    
    //--------------------------------------------------------------------------
    // metodo para encontrar una aptitud
    public Aptitudes findAptitud(Long id);
    
}

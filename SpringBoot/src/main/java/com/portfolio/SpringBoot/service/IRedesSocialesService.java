package com.portfolio.SpringBoot.service;

import com.portfolio.SpringBoot.model.RedesSociales;
import java.util.List;

public interface IRedesSocialesService {
    
    // metodo para traer todas las redes sociales
    public List<RedesSociales> getRedesSociales();
    
    //--------------------------------------------------------------------------
    // metodo para dar de alta una red social
    public void saveRedesSociales(RedesSociales redesSociales);
    
    //--------------------------------------------------------------------------
    // metodo para editar una red social
    public void save(RedesSociales redesSociales);
    
    //--------------------------------------------------------------------------
    // metodo para borrar una red social
    public void deleteRedesSociales(Long id);
    
    //--------------------------------------------------------------------------
    // metodo para encontrar una red social
    public RedesSociales findRedesSociales(Long id);
    
}

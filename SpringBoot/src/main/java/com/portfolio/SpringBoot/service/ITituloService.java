package com.portfolio.SpringBoot.service;

import com.portfolio.SpringBoot.model.Titulo;
import java.util.List;


public interface ITituloService {
    
    // metodo para traer todas los titulos
    public List<Titulo> getTitulo();
    
    //--------------------------------------------------------------------------
    // metodo para dar de alta un titulo
    public void saveTitulo(Titulo titulo);
    
    //--------------------------------------------------------------------------
    // metodo para borrar un titulo
    public void deleteTitulo(Long id);
    
    //--------------------------------------------------------------------------
    // metodo para encontrar un titulo
    public Titulo findTitulo(Long id);
    
}

package com.portfolio.SpringBoot.service;

import com.portfolio.SpringBoot.model.RedesSociales;
import com.portfolio.SpringBoot.repository.RedesSocialesRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RedesSocialesService implements IRedesSocialesService{

    @Autowired
    private RedesSocialesRepository redesSocialesRepository;
    
    final String[] nombresRedesComunicacion = {
            "Discord",
            "Facebook",
            "GitHub",
            "Gmail",
            "Instagram",
            "LinkedIn",
            "Skype",
            "Teams",
            "Telegram",
            "Twitter",
            "WhatApp",
            "Youtube"
        };
        
        final String[] linkRedesComunicacion = {
            
            "discord.png",
            "facebook.png",
            "github.png",
            "gmail.png",
            "instagram.png",
            "linkedin.png",
            "skype.png",
            "teams.png",
            "telegram.png",
            "twitter.png",
            "whatsapp.png",
            "youtube.png"
        };
    
    //--------------------------------------------------------------------------
    @Override
    public List<RedesSociales> getRedesSociales() {
        List<RedesSociales> listaRedesSociales = redesSocialesRepository.findAll();
        return listaRedesSociales;
    }

    //--------------------------------------------------------------------------
    @Override
    public void saveRedesSociales(RedesSociales rs) {
        
        RedesSociales redSocial = new RedesSociales();
        
        String assets = "assets/redes-sociales/";
        
        for(int i = 0; i < nombresRedesComunicacion.length; i++){
            if(rs.getNombre().equals(nombresRedesComunicacion[i]))
            {
                redSocial.setNombre(rs.getNombre());
                redSocial.setImagen(assets + linkRedesComunicacion[i]);
            }
        }
        
        redSocial.setLink(rs.getLink());
        
        
        redesSocialesRepository.save(redSocial);
    }
    
    //--------------------------------------------------------------------------
    @Override
    public void save(RedesSociales rs) {
        redesSocialesRepository.save(rs);
    }

    //--------------------------------------------------------------------------
    @Override
    public void deleteRedesSociales(Long id) {
        redesSocialesRepository.deleteById(id);
    }

    //--------------------------------------------------------------------------
    @Override
    public RedesSociales findRedesSociales(Long id) {
        RedesSociales buscarRedSocial = redesSocialesRepository.findById(id).orElse(null);
        return buscarRedSocial;
    }
}

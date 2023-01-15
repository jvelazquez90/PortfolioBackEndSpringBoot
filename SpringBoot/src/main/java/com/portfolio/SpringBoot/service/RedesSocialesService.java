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
    
    //--------------------------------------------------------------------------
    @Override
    public List<RedesSociales> getRedesSociales() {
        List<RedesSociales> listaRedesSociales = redesSocialesRepository.findAll();
        return listaRedesSociales;
    }

    //--------------------------------------------------------------------------
    @Override
    public void saveRedesSociales(RedesSociales redesSociales) {
        redesSocialesRepository.save(redesSociales);
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

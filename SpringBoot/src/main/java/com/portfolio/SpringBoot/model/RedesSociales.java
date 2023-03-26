package com.portfolio.SpringBoot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name="redes_sociales")

public class RedesSociales {
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;
    
    @Column(name = "nombre", length = 45)
    private String nombre;
    
    @Column(name = "link", length = 100)
    private String link;
    
    // TODO: puede fallar porque no es el mismo tipo de dato
    @Column(name = "imagen")
    private String imagen;
    
    // muchas redes sociales pueden pertenecer a una pesona
    //@ManyToOne
    @JoinColumn(name = "persona_id")
    private int persona_id = 1;
}

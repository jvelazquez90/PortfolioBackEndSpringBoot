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
@Table(name="aptitudes")

public class Aptitudes {
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;
    
    @Column(name = "nombre", length = 80)
    private String nombre;
    
    @Column(name = "clasificacion", length = 80)
    private String clasificacion;
    
    // muchas aptitudes pueden pertenecer a una pesona
    /*
    @ManyToOne
    @JoinColumn(name = "persona_id")
    Persona persona;
    */
    @Column(name = "persona_id")
    private int persona_id = 1;
}

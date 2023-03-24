package com.portfolio.SpringBoot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name="proyecto")

public class Proyecto {
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;
    
    @Column(name = "nombre", length = 80)
    private String nombreProyecto;
    
    @Column(name = "duracion", length = 45)
    private String duracion;
    
    @Column(name = "participantes", length = 80)
    private String participantes;
    
    @Column(name = "proyectocol", length = 45)
    private String proyectoCol;
    
    /*
    @Column(name = "persona_id")
    private int persona_id = 1;
    */
    
}

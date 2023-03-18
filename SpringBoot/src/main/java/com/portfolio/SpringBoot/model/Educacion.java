package com.portfolio.SpringBoot.model;

import java.util.Date;
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
@Table(name="educacion")

public class Educacion {
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;
    
    @Column(name = "nombre_institucion", length = 255)
    private String nombreInstitucion;
    
    @Column(name = "fecha_ingreso")
    private Date fechaIngreso;
    
    @Column(name = "fecha_salida")
    private Date fechaEgreso;
    
    @Column(name = "lugar", length = 45)
    private String lugar;
    
    @Column(name = "persona_id")
    private int persona_id = 1;
    
    // muchos estudios pueden pertenecer a una pesona
    /*
    @ManyToOne
    @JoinColumn(name = "persona_id")
    Persona persona;
*/
    
}

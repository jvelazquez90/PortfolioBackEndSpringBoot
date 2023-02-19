package com.portfolio.SpringBoot.model;

import java.text.SimpleDateFormat;
import java.util.Date;
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
@Table(name="persona")

public class Persona {
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;
    
    @Column(name = "nombre", length = 45)
    private String nombre;
    
    @Column(name = "apellido", length = 45)
    private String apellido;
    
    @Column(name = "fecha_nacimiento")
    private Date fechaNacimiento;
    
    @Column(name = "nacionalidad", length = 45)
    private String nacionalidad;
    
    @Column(name = "sexo", length = 1)
    private char sexo;
    
    @Column(name = "lugar_residencia", length = 45)
    private String lugarResidencia;
    
    @Column(name = "telefono", length = 45)
    private String telefono;
    
    @Column(name = "foto", length = 100)
    private String foto;
    
    @Column(name = "acerca_de", length = 255)
    private String acercaDe;
    
    @Column(name = "personacol", length = 45)
    private String personaCol;
    
    public String getFechaNacimiento(){
        this.fechaNacimiento.getMonth();
        SimpleDateFormat formato = new SimpleDateFormat("dd MMMM yyyy");
        return formato.format(fechaNacimiento);
    }
}

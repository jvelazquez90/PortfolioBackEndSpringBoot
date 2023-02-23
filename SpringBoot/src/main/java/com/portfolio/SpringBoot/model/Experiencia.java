package com.portfolio.SpringBoot.model;

import java.text.SimpleDateFormat;
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
@Table(name="experiencia")

public class Experiencia {
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;
    
    @Column(name = "nombre_empresa", length = 80)
    private String nombreEmpresa;
    
    @Column(name = "cargo", length = 80)
    private String cargo;
    
    @Column(name = "fecha_ingreso")
    private Date fechaIngreso;
    
    @Column(name = "fecha_salida")
    private Date fechaEgreso;
    
    @Column(name = "imagen")
    private String imagen;
    
    // TODO: fallar porque no es el mismo tipo de datos en la base de datos
    @Column(name = "es_trabajo_actual")
    private boolean esTrabajoActual;
    
    @Column(name = "experienciacol", length = 80)
    private String experienciaCol;
    
    @Column(name = "descripcion", length = 80)
    private String descripcion;
    
    // mucha experiencia pueden pertenecer a una pesona
    @ManyToOne
    @JoinColumn(name = "persona_id")
    Persona persona;
    
    //--------------------------------------------------------------------------
    // Convertir fecha ingreso
    
    public String getFechaIngreso(){
        String nuevaFecha = convertirFechaIngreso().replace(" ", " de ");
        return nuevaFecha;
        
    }
    
    public String convertirFechaIngreso(){
        //this.fechaIngreso.getMonth();
        SimpleDateFormat formato = new SimpleDateFormat("dd MMMM yyyy");
        return formato.format(fechaIngreso);
    }
    
    //--------------------------------------------------------------------------
    // Convertir fecha egreso
    
    public String getFechaEgreso(){
        String nuevaFecha = convertirFechaEgreso().replace(" ", " de ");
        if (nuevaFecha != "")
            return nuevaFecha;
        else
            return "Actualidad";
        
    }
    
    public String convertirFechaEgreso(){
        //this.fechaIngreso.getMonth();
        SimpleDateFormat formato = new SimpleDateFormat("dd MMMM yyyy");
        if(fechaEgreso != null)
            return formato.format(fechaEgreso);
        else
            return "";
    }
}

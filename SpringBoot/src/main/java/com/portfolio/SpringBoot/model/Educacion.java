package com.portfolio.SpringBoot.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
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
import org.springframework.format.annotation.DateTimeFormat;

@Getter @Setter
@Entity
@Table(name="educacion")

public class Educacion {
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;
    
    @Column(name = "nombre_institucion", length = 255)
    private String nombreInstitucion;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "fecha_ingreso")
    private Date fechaIngreso;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
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
    /*
    /*
    public String getFechaIngreso(){
        String nuevaFecha = convertirFecha(this.fechaIngreso);
        return nuevaFecha;
    }
    
    public String getFechaEgreso(){
        String nuevaFecha = convertirFecha(this.fechaIngreso).replace(" ", " de ");
        return nuevaFecha;
    }
    */
    
    /*
    public String convertirFecha(Date fecha){
        fecha.getMonth();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        return formato.format(fecha);
    }
    
    
    public Date setFechaIngreso(String fecha) throws ParseException {
        Date formato = new SimpleDateFormat("dd/MM/yyyy").parse(fecha);
        return formato;
    }
    */
    
    /*
    public Date getFechaIngresoDate(){
        return this.fechaIngreso;
    }
    
    public Date getFechaEgresoDate(){
        return this.fechaEgreso;
    }
    */
}

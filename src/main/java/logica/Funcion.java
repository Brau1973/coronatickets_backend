package logica;

import java.sql.Time;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Funcion{
    @Id
    private String nombre;
    // private String espectaculo; // ?
    private Date fecha;
    private Time horaInicio;
    private String artistas;
    private Date registro;

    public Funcion(){
    }

    public Funcion(String nombre, Date fecha, Time horaInicio, String artistas, Date registro){
	 this.nombre = nombre;
	 // this.espectaculo = espectaculo;
	 this.fecha = fecha;
	 this.horaInicio = horaInicio;
	 this.artistas = artistas;
	 this.registro = registro;
    }

    public String getNombre(){
	 return nombre;
    }

    /*  public String getEspectaculo(){
     return espectaculo;
    }*/

    public Date getFecha(){
	 return fecha;
    }

    public Time getHoraInicio(){
	 return horaInicio;
    }

    public String getArtistas(){
	 return artistas;
    }

    public Date getRegistro(){
	 return registro;
    }

    public void setNombre(String nombre){
	 this.nombre = nombre;
    }

    /* public void setEspectaculo(String espectaculo){
     this.espectaculo = espectaculo;
    }*/

    public void setFecha(Date fecha){
	 this.fecha = fecha;
    }

    public void setHoraInicio(Time horaInicio){
	 this.horaInicio = horaInicio;
    }

    public void setArtistas(String artistas){
	 this.artistas = artistas;
    }

    public void setRegistro(Date registro){
	 this.registro = registro;
    }

}
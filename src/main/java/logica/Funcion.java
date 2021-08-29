package logica;

import java.util.Date;

import datatypes.DtHora;

public class Funcion{
    private String nombre;
    private String espectaculo;
    private Date fecha;
    private DtHora horaInicio;
    private String artistas;
    private Date registro;

    public Funcion(String nombre, String espectaculo, Date fecha, DtHora horaInicio, String artistas, Date registro){
	 this.nombre = nombre;
	 this.espectaculo = espectaculo;
	 this.fecha = fecha;
	 this.horaInicio = horaInicio;
	 this.artistas = artistas;
	 this.registro = registro;
    }

    public String getNombre(){
	 return nombre;
    }

    public String getEspectaculo(){
	 return espectaculo;
    }

    public Date getFecha(){
	 return fecha;
    }

    public Date getHoraInicio(){
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

    public void setEspectaculo(String espectaculo){
	 this.espectaculo = espectaculo;
    }

    public void setFecha(Date fecha){
	 this.fecha = fecha;
    }

    public void setHoraInicio(DtHora horaInicio){
	 this.horaInicio = horaInicio;
    }

    public void setArtistas(String artistas){
	 this.artistas = artistas;
    }

    public void setRegistro(Date registro){
	 this.registro = registro;
    }

}
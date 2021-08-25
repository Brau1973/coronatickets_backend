package logica;

import datatypes.DtFecha;
import datatypes.DtHora;

public class Funcion{
    private String nombre;
    private String espectaculo;
    private DtFecha fecha;
    private DtHora horaInicio;
    private String artistas;
    private DtFecha registro;

    public Funcion(String nombre, String espectaculo, DtFecha fecha, DtHora horaInicio, String artistas, DtFecha registro){
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

    public DtFecha getFecha(){
	 return fecha;
    }

    public DtHora getHoraInicio(){
	 return horaInicio;
    }

    public String getArtistas(){
	 return artistas;
    }

    public DtFecha getRegistro(){
	 return registro;
    }

    public void setNombre(String nombre){
	 this.nombre = nombre;
    }

    public void setEspectaculo(String espectaculo){
	 this.espectaculo = espectaculo;
    }

    public void setFecha(DtFecha fecha){
	 this.fecha = fecha;
    }

    public void setHoraInicio(DtHora horaInicio){
	 this.horaInicio = horaInicio;
    }

    public void setArtistas(String artistas){
	 this.artistas = artistas;
    }

    public void setRegistro(DtFecha registro){
	 this.registro = registro;
    }

}
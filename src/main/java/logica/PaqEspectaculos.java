package logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import datatypes.DtEsp;

public class PaqEspectaculos{
    private String nombre;
    private String descripcion;
    private DtEsp espectaculo;
    private List<Espectaculo> espectaculos;
    private Date fechaInicio;
    private Date fechaFin;
    private int descuento;

    public PaqEspectaculos(String nombre, String descripcion, DtEsp espectaculo, Date fechaInicio, Date fechaFin, int descuento){
	 this.nombre = nombre;
	 this.descripcion = descripcion;
	 this.espectaculo = espectaculo;
	 this.fechaInicio = fechaInicio;
	 this.fechaFin = fechaFin;
	 this.descuento = descuento;
    }

    public PaqEspectaculos(String nombre, String descripcion, Date fechaInicio, Date fechaFin, int descuento){
	 this.nombre = nombre;
	 this.descripcion = descripcion;
	 this.fechaInicio = fechaInicio;
	 this.fechaFin = fechaFin;
	 this.descuento = descuento;
	 this.espectaculos = new ArrayList<Espectaculo>();
    }

    public String getNombre(){
	 return nombre;
    }

    public String getDescripcion(){
	 return descripcion;
    }

    public DtEsp getEspectaculo(){
	 return espectaculo;
    }

    public Date getFechaInicio(){
	 return fechaInicio;
    }

    public Date getFechaFin(){
	 return fechaFin;
    }

    public int getDescuento(){
	 return descuento;
    }

    public void setNombre(String nombre){
	 this.nombre = nombre;
    }

    public void setDescripcion(String descripcion){
	 this.descripcion = descripcion;
    }

    public void setEspectaculo(DtEsp espectaculo){
	 this.espectaculo = espectaculo;
    }

    public void setFechaInicio(Date fechaInicio){
	 this.fechaInicio = fechaInicio;
    }

    public void setFechaFin(Date fechaFin){
	 this.fechaFin = fechaFin;
    }

    public void setDescuento(int descuento){
	 this.descuento = descuento;
    }

    public List<Espectaculo> getEspectaculos(){
	 return espectaculos;
    }

    public void setEspectaculos(List<Espectaculo> espectaculos){
	 this.espectaculos = espectaculos;
    }

    public void addEspectaculo(Espectaculo esp){
	 this.espectaculos.add(esp);
    }
}
package logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;


@Entity
public class PaqueteEspectaculos{
	
	@Id
    private String nombre;
    private String descripcion;
    @OneToMany(orphanRemoval = true)
    @JoinTable(name="EspectaculosXPaquete",
    			joinColumns = @JoinColumn(name="PaqNombre"),
    			inverseJoinColumns = @JoinColumn(name="EspId"))
    private List<Espectaculo> espectaculos = new ArrayList<Espectaculo>();
    private Date fechaInicio;
    private Date fechaFin;
    private Date fechaAlta;
    private int descuento;

    public PaqueteEspectaculos() {};
    
    public PaqueteEspectaculos(String nombre, String descripcion, Date fechaInicio, Date fechaFin, Date fechaAlta, int descuento){
	 this.nombre = nombre;
	 this.descripcion = descripcion;
	 this.fechaInicio = fechaInicio;
	 this.fechaFin = fechaFin;
	 this.fechaAlta = fechaAlta;
	 this.descuento = descuento;
    }

    public String getNombre(){
	 return nombre;
    }

    public String getDescripcion(){
	 return descripcion;
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

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
    
}
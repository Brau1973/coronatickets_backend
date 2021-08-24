package logica;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="Plataforma")
public class Plataforma{
	@Id
    private String nombre;
    private String descripcion;
    private String url;
    
	public Plataforma(String nombre, String descripcion, String url) {

		this.nombre = nombre;
		this.descripcion = descripcion;
		this.url = url;
	}
	
	public Plataforma() {
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}



}

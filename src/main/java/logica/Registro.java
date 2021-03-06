package logica;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Registro{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	
    private float costo;
    private Date fechaRegistro;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Funcion funcion;
	
	public Registro() {
		super();
	}
    
	public Registro(Funcion funcion, Date fechaRegistro, float costo) {
		super();
		this.funcion = funcion;
		this.fechaRegistro = fechaRegistro;
		this.costo = costo;
	}
	
	public Funcion getFuncion() {
		return funcion;
	}

	public void setFuncion(Funcion funcion) {
		this.funcion = funcion;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public float getCosto() {
		return costo;
	}

	public void setCosto(float costo) {
		this.costo = costo;
	}
}
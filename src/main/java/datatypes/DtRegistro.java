package datatypes;

import java.util.Date;

public class DtRegistro {
	private String funcion;
	private Date fechaRegistro;
	private float costo;
	
	public DtRegistro(String funcion, Date fechaRegistro, float costo) {
		super();
		this.funcion = funcion;
		this.fechaRegistro = fechaRegistro;
		this.costo = costo;
	}

	public String getFuncion() {
		return funcion;
	}

	public void setFuncion(String funcion) {
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

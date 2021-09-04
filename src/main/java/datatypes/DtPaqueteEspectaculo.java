package datatypes;

import java.util.Date;

public class DtPaqueteEspectaculo {
	private String nombre;
	private String descripcion;
	private Date fechaInicio;
	private Date fechaFin;
	private Date fechaAlta;
	private int descuento;

	public DtPaqueteEspectaculo(String nombre, String descripcion, Date fechaInicio, Date fechaFin, Date fechaAlta,
			int descuento) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.fechaAlta = fechaAlta;
		this.descuento = descuento;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public int getDescuento() {
		return descuento;
	}
}

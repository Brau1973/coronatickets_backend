package datatypes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DtPaqueteEspectaculos {
	private String nombre;
	private String descripcion;
	private Date fechaInicio;
	private Date fechaFin;
	private Date fechaAlta;
	private int descuento;
	private List<DtEspectaculo> espectaculos = new ArrayList<DtEspectaculo>();
	
	

	public DtPaqueteEspectaculos() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DtPaqueteEspectaculos(String nombre, String descripcion, Date fechaInicio, Date fechaFin, Date fechaAlta, int descuento) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.fechaAlta = fechaAlta;
		this.descuento = descuento;
	}

	public DtPaqueteEspectaculos(String nombre, String descripcion, Date fechaInicio, Date fechaFin, Date fechaAlta,
			int descuento, List<DtEspectaculo> espectaculos) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.fechaAlta = fechaAlta;
		this.descuento = descuento;
		this.espectaculos = espectaculos;
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

	public List<DtEspectaculo> getEspectaculos() {
		return espectaculos;
	}

	public void setEspectaculos(List<DtEspectaculo> espectaculos) {
		this.espectaculos = espectaculos;
	}

}

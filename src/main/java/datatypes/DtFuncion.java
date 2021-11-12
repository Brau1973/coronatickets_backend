package datatypes;

import java.io.Serializable;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DtFuncion implements Serializable {
	private static final long serialVersionUID = 1L;
	private String nombre;
	private Date fecha;
	private Time horaInicio;
	private Date registro;
	private List<String> artistas = new ArrayList<String>();

	public DtFuncion() {
		super();
	}

	public DtFuncion(String nombre, Date fecha, Time horaInicio, Date registro, List<String> artistas) {
		super();
		this.nombre = nombre;
		this.fecha = fecha;
		this.horaInicio = horaInicio;
		this.registro = registro;
		this.artistas = artistas;
	}

	public String getNombre() {
		return nombre;
	}

	public Date getFecha() {
		return fecha;
	}

	public Time getHoraInicio() {
		return horaInicio;
	}

	public Date getRegistro() {
		return registro;
	}

	public List<String> getArtistas() {
		return artistas;
	}

}

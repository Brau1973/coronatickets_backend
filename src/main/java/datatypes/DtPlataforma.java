package datatypes;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DtPlataforma {
	private String nombre;
	private String descripcion;
	private String url;
	private List<DtEspectaculo> espectaculo;

	public DtPlataforma() {
		super();
	}

	public DtPlataforma(String nombre, String descripcion, String url) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.url = url;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public String getUrl() {
		return url;
	}

	public List<DtEspectaculo> getEspectaculo() {
		return espectaculo;
	}

	public void setEspectaculo(List<DtEspectaculo> espectaculo) {
		this.espectaculo = espectaculo;
	}

}

package datatypes;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DtPlataforma {
	private String nombre;
	private String descripcion;
	private String url;
	private String imageName;
	private List<DtEspectaculo> espectaculo;

	public DtPlataforma() {
		super();
	}

	public DtPlataforma(String nombre, String descripcion, String url, String imageName) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.url = url;
		this.imageName = imageName;
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

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

}

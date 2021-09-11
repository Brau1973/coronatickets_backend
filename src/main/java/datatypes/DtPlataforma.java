package datatypes;

import java.util.List;

public class DtPlataforma {
    private String nombre;
    private String descripcion;
    private String url;
    private List<DtEspectaculo> espectaculo; 
    
    public DtPlataforma(String nombre,String descripcion,String url) {
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



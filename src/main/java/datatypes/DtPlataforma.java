package datatypes;

public class DtPlataforma {
    private String nombre;
    private String descripcion;
    private String url;
    
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
}



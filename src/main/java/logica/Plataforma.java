
package logica;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Plataforma{
    @Id
    private String nombre;
    private String descripcion;
    private String url;

    @OneToMany(mappedBy = "plataforma")
    private List<Espectaculo> espectaculo = new ArrayList<>();
    
    public Plataforma(){
	 super();
    }

    public Plataforma(String nombre, String descripcion, String url){
	 super();
	 this.nombre = nombre;
	 this.descripcion = descripcion;
	 this.url = url;
    }

    public String getNombre(){
	 return nombre;
    }

    public void setNombre(String nombre){
	 this.nombre = nombre;
    }

    public String getDescripcion(){
	 return descripcion;
    }

    public void setDescripcion(String descripcion){
	 this.descripcion = descripcion;
    }

    public String getUrl(){
	 return url;
    }

    public void setUrl(String url){
	 this.url = url;
    }

	public List<Espectaculo> getEspectaculo() {
		return espectaculo;
	}

	public void setEspectaculo(List<Espectaculo> espectaculo) {
		this.espectaculo = espectaculo;
	}

}

package logica;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import datatypes.DtEspectaculo;

@Entity
public class Plataforma {
	@Id
	private String nombre;
	private String descripcion;
	private String url;
	private String imageName;

	@OneToMany
	private List<Espectaculo> espectaculo = new ArrayList<>();

	public Plataforma() {
		super();
	}

	public Plataforma(String nombre, String descripcion, String url, String imageName) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.url = url;
		this.imageName = imageName; 
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

/*	public List<DtEspectaculo> getEspectaculo() {
		ArrayList<DtEspectaculo> listaEspectaculos = new ArrayList<>();
		for (Espectaculo e : espectaculo) {
			System.out.println("Espectaculo: " + e.getDtEspectaculo().getNombre());
			listaEspectaculos.add(e.getDtEspectaculo());
		}
		return listaEspectaculos;
	}*/

	public List<Espectaculo> getEspectaculo() { // NO SE DEBERIA USAR 
		return espectaculo;
	}

	/*
	public List<DtEspectaculo> getEspectaculosDt() {
		System.out.println("ENTRO A getEspectaculosDt");
		List<DtEspectaculo> listEspectaculosDt = new ArrayList<DtEspectaculo>();
		for (Espectaculo e : espectaculo) {
			System.out.println("ITERANDO EN :"+e.getNombre());
			DtEspectaculo DtEspec = new DtEspectaculo(e.getArtista(), this.nombre, e.getNombre(), e.getDescripcion(), e.getDuracion(), e.getCantMinEsp(), e.getCantMaxEsp(), e.getUrl(), e.getCosto(), e.getRegistro());
			System.out.println("POST CREACION DT ESPEC");
			listEspectaculosDt.add(DtEspec);
			System.out.println("POST ADD");
		}
		System.out.println("TERMINO EL FOR, PRE RETURN");
		return listEspectaculosDt;
	}
	*/

	public void aniadirEspectaculo(Espectaculo espectaculo) {
		this.espectaculo.add(espectaculo);
	}

	public void setEspectaculo(List<Espectaculo> espectaculo) {
		this.espectaculo = espectaculo;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

}

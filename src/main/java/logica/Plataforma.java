
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

	@OneToMany(mappedBy = "plataforma")
	private List<Espectaculo> espectaculo = new ArrayList<>();

	public Plataforma() {
		super();
	}

	public Plataforma(String nombre, String descripcion, String url) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.url = url;
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

//	public List<DtEspectaculo> getEspectaculo() {
//		ArrayList<DtEspectaculo> listaEspectaculos = new ArrayList<>();
//		for(Espectaculo e:espectaculo) {
//			System.out.println("Espectaculo: " +e.getDtEspectaculo().getNombre());
//			listaEspectaculos.add(e.getDtEspectaculo());
//		}
//		return listaEspectaculos;
//	}

	public List<Espectaculo> getEspectaculo() { // NO SE DEBERIA USAR
		return espectaculo;
	}

	public List<DtEspectaculo> getEspectaculosDt() {
		List<DtEspectaculo> listEspectaculosDt = new ArrayList<DtEspectaculo>();
		for (Espectaculo e : espectaculo) {
			DtEspectaculo DtEspec = new DtEspectaculo(e.getArtista(),e.getPlataforma(),e.getNombre(),e.getDescripcion(),e.getDuracion(),e.getCantMinEsp(),e.getCantMaxEsp(),e.getUrl(),e.getCosto(),e.getRegistro());
			listEspectaculosDt.add(DtEspec);
		}
		return listEspectaculosDt;
	}

	public void setEspectaculo(List<Espectaculo> espectaculo) {
		this.espectaculo = espectaculo;
	}

}

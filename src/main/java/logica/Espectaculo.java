package logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import datatypes.DtEspectaculo;
import datatypes.DtFuncion;
import datatypes.DtPaqueteEspectaculo;

@Entity
public class Espectaculo {
	@Id
	@Column(name = "nomEsp")
	private String nombre;
	@ManyToOne
	@JoinColumn(name = "artista")
	private Artista artista;
	private String descripcion;
	private int duracion;
	private int cantMinEsp;
	private int cantMaxEsp;
	private String url;
	private int costo;
	private Date registro;

	@ManyToMany(mappedBy = "espectaculos")
	private List<PaqueteEspectaculos> paquete = new ArrayList<PaqueteEspectaculos>();

	@OneToMany // (mappedBy = "espectaculo", cascade = CascadeType.ALL)
	private List<Funcion> funciones = new ArrayList<>();

	public Espectaculo() {
		super();
	}

	public Espectaculo(Artista artista, String nombre, String descripcion, int duracion, int cantMinEsp, int cantMaxEsp,
			String url, int costo, Date registro) {
		super();
		this.artista = artista;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.duracion = duracion;
		this.cantMinEsp = cantMinEsp;
		this.cantMaxEsp = cantMaxEsp;
		this.url = url;
		this.costo = costo;
		this.registro = registro;

	}

	public String getArtista() {
		return artista.getNickname();
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public int getDuracion() {
		return duracion;
	}

	public int getCantMinEsp() {
		return cantMinEsp;
	}

	public int getCantMaxEsp() {
		return cantMaxEsp;
	}

	public String getUrl() {
		return url;
	}

	public int getCosto() {
		return costo;
	}

	public Date getRegistro() {
		return registro;
	}

	public List<PaqueteEspectaculos> getPaquete() {
		return paquete;
	}

	public List<Funcion> getFunciones() {
		return funciones;
	}

	public List<PaqueteEspectaculos> getPaquetes() {
		return paquete;
	}

	public void setArtista(Artista artista) {
		this.artista = artista;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public void setCantMinEsp(int cantMinEsp) {
		this.cantMinEsp = cantMinEsp;
	}

	public void setCantMaxEsp(int cantMaxEsp) {
		this.cantMaxEsp = cantMaxEsp;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setCosto(int costo) {
		this.costo = costo;
	}

	public void setRegistro(Date registro) {
		this.registro = registro;
	}

	public void setFunciones(List<Funcion> funciones) {
		this.funciones = funciones;
	}

	public void setPaquete(List<PaqueteEspectaculos> paquete) {
		this.paquete = paquete;
	}

	public void agregarFuncion(Funcion funcion) {
		this.funciones.add(funcion);
	}

	public boolean funcionYaRegistrada(String nombreFuncion) {
		int i = 0;
		Funcion funcion;
		boolean encontre = false;
		while ((i < this.funciones.size()) && (!encontre)) {
			funcion = funciones.get(i);
			if (funcion.getNombre().equals(nombreFuncion)) {
				encontre = true;
			}
			i++;
		}
		return encontre;
	}

//	public DtEspectaculo getDtEspectaculo(){
//		return new DtEspectaculo(this.artista.getNickname(),this.nombre,this.descripcion,this.duracion,this.cantMinEsp,this.cantMaxEsp,this.url,this.costo,this.registro);
//	}

	public void agregarPaquete(PaqueteEspectaculos paquete) {
		if (this.paquete == null) {
			this.paquete = new ArrayList<PaqueteEspectaculos>();
		}
		this.paquete.add(paquete);
	}

	public List<DtFuncion> getFuncionesDt() {
		List<DtFuncion> listFuncionesDt = new ArrayList<DtFuncion>();
		for (Funcion f : funciones) {
			List<String> artistas = new ArrayList<String>();
			for (Artista a : f.getArtistas()) {
				artistas.add(a.getNickname());
			}
			DtFuncion DtFuncion = new DtFuncion(f.getNombre(), f.getFecha(), f.getHoraInicio(), f.getRegistro(),
					artistas);
			listFuncionesDt.add(DtFuncion);
		}
		return listFuncionesDt;
	}
	
	public List<DtPaqueteEspectaculo> getPaqueteEspectaculoDt() {
		List<DtPaqueteEspectaculo> listPaquetesDt = new ArrayList<DtPaqueteEspectaculo>();
		for (PaqueteEspectaculos p : paquete) {
			List<DtEspectaculo> espectaculos = new ArrayList<DtEspectaculo>();
			for (Espectaculo e : p.getEspectaculos()) {
			    DtEspectaculo dtEspec = new DtEspectaculo(e.getArtista(),p.getNombre(),e.getNombre(),e.getDescripcion(),e.getDuracion(),e.getCantMinEsp(),e.getCantMaxEsp(),e.getUrl(),e.getCosto(),e.getRegistro());
			    espectaculos.add(dtEspec);
			}
			DtPaqueteEspectaculo dtPaqueteEspectaculo = new DtPaqueteEspectaculo(p.getNombre(), p.getDescripcion(), p.getFechaInicio(), p.getFechaFin(),p.getFechaAlta(),p.getDescuento());
			dtPaqueteEspectaculo.setEspectaculos(espectaculos);
			listPaquetesDt.add(dtPaqueteEspectaculo);
		}
		return listPaquetesDt;
	}
}
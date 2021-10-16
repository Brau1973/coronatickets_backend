package logica;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

//import datatypes.DtHora;

@Entity
public class Funcion{
	@Id
	private String nombre;
	private Date fecha;
	private Time horaInicio;
	private Date registro;

	@ManyToMany(cascade = CascadeType.ALL)
	private List<Artista> artistas = new ArrayList<Artista>();

	@OneToMany(mappedBy = "funcion", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Registro> registros = new ArrayList<>();

	@Lob
	@Column(name = "imagen")
	private byte[] imagen;

	public Funcion(){
		super();
	}

	public Funcion(String nombre, Date fecha, Time horaInicio, Date registro, List<Artista> artistas, byte[] imagen){
		this.nombre = nombre;
		this.fecha = fecha;
		this.horaInicio = horaInicio;
		this.registro = registro;
		this.artistas = artistas;
		this.imagen = imagen;
	}

	public String getNombre(){
		return nombre;
	}

	public Date getFecha(){
		return fecha;
	}

	public Time getHoraInicio(){
		return horaInicio;
	}

	public List<Artista> getArtistas(){
		return artistas;
	}

	public Date getRegistro(){
		return registro;
	}

	public byte[] getImagen(){
		return imagen;
	}

	public void setNombre(String nombre){
		this.nombre = nombre;
	}

	public void setFecha(Date fecha){
		this.fecha = fecha;
	}

	public void setHoraInicio(Time horaInicio){
		this.horaInicio = horaInicio;
	}

	public void setArtistas(List<Artista> artistas){
		this.artistas = artistas;
	}

	public void setRegistro(Date registro){
		this.registro = registro;
	}

	public void agregarRegistro(Registro registro){
		this.registros.add(registro);
	}

	public void setImagen(byte[] imagen){
		this.imagen = imagen;
	}

	// public List<Registro> getRegistros() {
	// return registros;
	// }
	//
	// public void setRegistros(List<Registro> registros) {
	// this.registros = registros;
	// }

}
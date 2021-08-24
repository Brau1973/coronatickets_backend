package logica;

import java.util.ArrayList;
import java.util.List;

public class PaqEspectaculos {
	private String nombre;
	private String descripcion;
	private DtEsp espectaculo;
	private List<Espectaculo> espectaculos;
	private DtFecha fechaInicio;
	private DtFecha fechaFin;
	private int descuento;

	public PaqEspectaculos(String nombre, String descripcion, DtEsp espectaculo, DtFecha fechaInicio, DtFecha fechaFin, int descuento) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.espectaculo = espectaculo;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.descuento = descuento;
	}

	public PaqEspectaculos(String nombre, String descripcion, DtFecha fechaInicio, DtFecha fechaFin, int descuento) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.descuento = descuento;
		this.espectaculos = new ArrayList<Espectaculo>();
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public DtEsp getEspectaculo() {
		return espectaculo;
	}

	public DtFecha getFechaInicio() {
		return fechaInicio;
	}

	public DtFecha getFechaFin() {
		return fechaFin;
	}

	public int getDescuento() {
		return descuento;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setEspectaculo(DtEsp espectaculo) {
		this.espectaculo = espectaculo;
	}

	public void setFechaInicio(DtFecha fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public void setFechaFin(DtFecha fechaFin) {
		this.fechaFin = fechaFin;
	}

	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}

	public List<Espectaculo> getEspectaculos() {
		return espectaculos;
	}

	public void setEspectaculos(List<Espectaculo> espectaculos) {
		this.espectaculos = espectaculos;
	}
	
	public void addEspectaculo(Espectaculo esp) {
		this.espectaculos.add(esp);
	}
}
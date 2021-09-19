//package logica;
//
//import java.util.Date;
//
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.IdClass;
//import javax.persistence.ManyToOne;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;
//
//import persistencia.RegistroID;
//
//@Entity
//@IdClass(RegistroID.class)
//public class Registro{
//	
//	@Temporal(TemporalType.DATE)
//    private Date fechaRegistro;
//	
//    private float costo;
//	
//	@Id
//	@ManyToOne
//	private Espectador espectador;
//	
//	@Id
//	@ManyToOne
//	private Funcion funcion;
//	
//	public Registro() {
//		super();
//	}
//    
//	public Registro(Espectador espectador, Funcion funcion, Date fechaRegistro, float costo) {
//		super();
//		this.espectador = espectador;
//		this.funcion = funcion;
//		this.fechaRegistro = fechaRegistro;
//		this.costo = costo;
//	}
//	
//	public Espectador getEspectador() {
//		return espectador;
//	}
//
//	public void setEspectador(Espectador espectador) {
//		this.espectador = espectador;
//	}
//
//	public Funcion getFuncion() {
//		return funcion;
//	}
//
//	public void setFuncion(Funcion funcion) {
//		this.funcion = funcion;
//	}
//
//	public Date getFechaRegistro() {
//		return fechaRegistro;
//	}
//
//	public void setFechaRegistro(Date fechaRegistro) {
//		this.fechaRegistro = fechaRegistro;
//	}
//
//	public float getCosto() {
//		return costo;
//	}
//
//	public void setCosto(float costo) {
//		this.costo = costo;
//	}
//}
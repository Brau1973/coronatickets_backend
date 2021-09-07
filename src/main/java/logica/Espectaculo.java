package logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import datatypes.DtEspectaculo;

@Entity
public class Espectaculo{
    @Id
    @Column(name = "nomEsp")
    private String nombre;
    @ManyToOne
    @JoinColumn(name = "artista")
    private Artista artista;
    @ManyToOne
    private Plataforma plataforma;
    private String descripcion;
    private int duracion;
    private int cantMinEsp;
    private int cantMaxEsp;
    private String url;
    private int costo;
    private Date registro;

    @ManyToMany(mappedBy = "espectaculos")
    private List<PaqueteEspectaculos> paquete = new ArrayList<PaqueteEspectaculos>();

    @OneToMany(mappedBy = "espectaculo", cascade = CascadeType.ALL)
    private List<Funcion> funciones = new ArrayList<>();

	public Espectaculo(){
	 super();
    }

    public Espectaculo(Artista artista, Plataforma plataforma, String nombre, String descripcion, int duracion, int cantMinEsp, int cantMaxEsp, String url, int costo, Date registro){
	 super();
	 this.artista = artista;
	 this.plataforma = plataforma;
	 this.nombre = nombre;
	 this.descripcion = descripcion;
	 this.duracion = duracion;
	 this.cantMinEsp = cantMinEsp;
	 this.cantMaxEsp = cantMaxEsp;
	 this.url = url;
	 this.costo = costo;
	 this.registro = registro;
    }

    public String getArtista(){
	 return artista.getNickname();
    }

    public String getPlataforma(){
	 return plataforma.getNombre();
    }

    public String getNombre(){
	 return nombre;
    }

    public String getDescripcion(){
	 return descripcion;
    }

    public int getDuracion(){
	 return duracion;
    }

    public int getCantMinEsp(){
	 return cantMinEsp;
    }

    public int getCantMaxEsp(){
	 return cantMaxEsp;
    }

    public String getUrl(){
	 return url;
    }

    public int getCosto(){
	 return costo;
    }

    public Date getRegistro(){
	 return registro;
    }
    
    public List<PaqueteEspectaculos> getPaquete() {
		return paquete;
	}

    public List<Funcion> getFunciones(){
	 return funciones;
    }

    public List<PaqueteEspectaculos> getPaquetes(){
	 return paquete;
    }


    public void setArtista(Artista artista){
	 this.artista = artista;
    }

    public void setPlataforma(Plataforma plataforma){
	 this.plataforma = plataforma;
    }

    public void setNombre(String nombre){
	 this.nombre = nombre;
    }

    public void setDescripcion(String descripcion){
	 this.descripcion = descripcion;
    }

    public void setDuracion(int duracion){
	 this.duracion = duracion;
    }

    public void setCantMinEsp(int cantMinEsp){
	 this.cantMinEsp = cantMinEsp;
    }

    public void setCantMaxEsp(int cantMaxEsp){
	 this.cantMaxEsp = cantMaxEsp;
    }

    public void setUrl(String url){
	 this.url = url;
    }

    public void setCosto(int costo){
	 this.costo = costo;
    }

    public void setRegistro(Date registro){
	 this.registro = registro;
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
		boolean encontre=false;
		while ((i < this.funciones.size()) && (!encontre)) {
			funcion=funciones.get(i);
		    if (funcion.getNombre().equals(nombreFuncion)) {
		    	encontre=true;
		    }	
		    i++;
		}
		return encontre;
	}
	
	public DtEspectaculo getDtEspectaculo(){
		return new DtEspectaculo(null,null,this.nombre,this.descripcion,this.duracion,this.cantMinEsp,this.cantMaxEsp,this.url,this.costo,this.registro);
	}

    public void setFunciones(List<Funcion> funciones){
	 this.funciones = funciones;
    }

    public void setPaquetes(List<PaqueteEspectaculos> paquete){
	 this.paquete = paquete;
    }
}
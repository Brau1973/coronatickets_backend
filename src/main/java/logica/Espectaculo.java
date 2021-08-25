package logica;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Espectaculo{
    @Id
    private String artista;
    private String plataforma;
    private String nombre;
    private String descripcion;
    private int duracion;
    private int cantMinEsp;
    private int cantMaxEsp;
    private String url;
    private int costo;
    // private DtFecha registro;

    // @OneToMany(mappedBy = "funciones", cascade = CascadeType.ALL, orphanRemoval = true)
    // private List<Funcion> funciones = new ArrayList<>();

    // Necesitamos un constructor vacio para Hibernate
    public Espectaculo(){
	 super();
    }

    public Espectaculo(String artista, String plataforma, String nombre, String descripcion, int duracion, int cantMinEsp, int cantMaxEsp, String url, int costo){
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
	 // this.registro = registro;
    }

    public String getArtista(){
	 return artista;
    }

    public String getPlataforma(){
	 return plataforma;
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

    /*
    public DtFecha getRegistro(){
    	 return registro;
    }
    */
    public void setArtista(String artista){
	 this.artista = artista;
    }

    public void setPlataforma(String plataforma){
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
    /*
    public void setRegistro(DtFecha registro){
    	 this.registro = registro;
    }*/

}
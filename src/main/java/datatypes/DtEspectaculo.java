package datatypes;

import java.util.Date;

public class DtEspectaculo{
    private String artista;
    private String plataforma;
    private String nombre;
    private String descripcion;
    private int duracion;
    private int cantMin;
    private int cantMax;
    private String url;
    private int costo;
    private Date registro;

    public DtEspectaculo(String artista, String plataforma, String nombre, String descripcion, int duracion, int cantMin, int cantMax, String url, int costo, Date registro){
	 super();
	 this.artista = artista;
	 this.plataforma = plataforma;
	 this.nombre = nombre;
	 this.descripcion = descripcion;
	 this.duracion = duracion;
	 this.cantMin = cantMin;
	 this.cantMax = cantMax;
	 this.url = url;
	 this.costo = costo;
	 this.registro = registro;
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

    public int getCantMin(){
	 return cantMin;
    }

    public int getCantMax(){
	 return cantMax;
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

    /*
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
    
    public void setRegistro(Date registro){
    	 this.registro = registro;
    }*/
}
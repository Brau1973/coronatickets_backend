package datatypes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
   
  private List<DtPaqueteEspectaculo> paquetes = new ArrayList<DtPaqueteEspectaculo>();
  private List<DtFuncion> funciones = new ArrayList<DtFuncion>();
	
    public DtEspectaculo(String artista,String plataforma,String nombre, String descripcion, int duracion, int cantMin, int cantMax, String url, int costo, Date registro){
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

    public String getArtista() {
		return artista;
	}

	public String getPlataforma() {
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
    
    public List<DtPaqueteEspectaculo> getPaquetes(){
    return paquetes;
 }
    
    public List<DtFuncion> getFunciones(){
        return funciones;
     }  

public void setPaquetes(List<DtPaqueteEspectaculo> paquete){
    this.paquetes = paquete;
}

public void setFunciones(List<DtFuncion> funcion){
    this.funciones = funcion;
}


}
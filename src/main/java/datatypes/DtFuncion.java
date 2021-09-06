package datatypes;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import logica.Artista;
import logica.Espectaculo;

public class DtFuncion {
    private String nombre;
    private Date fecha;
    private Time horaInicio;
	private Date registro;
    private String espectaculo;
    private List<String> artistas = new ArrayList<String>();

    
    public DtFuncion(String nombre, Date fecha, Time horaInicio, Date registro,String espectaculo,List<String> artistas){
	 this.nombre = nombre;
	 this.fecha = fecha;
	 this.horaInicio = horaInicio;
	 this.registro = registro;
	 this.espectaculo = espectaculo;
	 this.artistas = artistas;
	 
    }


	public String getNombre() {
		return nombre;
	}


	public Date getFecha() {
		return fecha;
	}


	public Time getHoraInicio() {
		return horaInicio;
	}


	public Date getRegistro() {
		return registro;
	}
	
    public String getEspectaculo() {
		return espectaculo;
	}

	public List<String> getArtistas() {
		return artistas;
	}
	
}

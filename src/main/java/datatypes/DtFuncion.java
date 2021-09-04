package datatypes;

import java.sql.Time;
import java.util.Date;

public class DtFuncion {
    private String nombre;
    private Date fecha;
    private Time horaInicio;
    private Date registro;

    
    public DtFuncion(String nombre, Date fecha, Time horaInicio, Date registro){
	 this.nombre = nombre;
	 this.fecha = fecha;
	 this.horaInicio = horaInicio;
	 this.registro = registro;
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
	
}

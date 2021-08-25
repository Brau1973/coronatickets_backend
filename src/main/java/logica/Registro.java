package logica;

import java.util.Date;

public class Registro{
    private Date fecha;

    public Registro(Date fecha){
	 this.fecha = fecha;
    }

    public Date getfecha(){
	 return fecha;
    }

    public void setfecha(Date fecha){
	 this.fecha = fecha;
    }
}
package logica;

import java.util.Date;

public class Compra{
    private Date fecha;

    public Compra(Date fecha){
	 this.fecha = fecha;
    }

    public Date getfecha(){
	 return fecha;
    }

    public void setfecha(Date fecha){
	 this.fecha = fecha;
    }
}
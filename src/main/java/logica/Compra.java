package logica;

import datatypes.DtFecha;

public class Compra{
    private DtFecha fecha;

    public Compra(DtFecha fecha){
	 this.fecha = fecha;
    }

    public DtFecha getfecha(){
	 return fecha;
    }

    public void setfecha(DtFecha fecha){
	 this.fecha = fecha;
    }
}
package logica;

import datatypes.DtFecha;

public class Registro{
    private DtFecha fecha;

    public Registro(DtFecha fecha){
	 this.fecha = fecha;
    }

    public DtFecha getfecha(){
	 return fecha;
    }

    public void setfecha(DtFecha fecha){
	 this.fecha = fecha;
    }
}
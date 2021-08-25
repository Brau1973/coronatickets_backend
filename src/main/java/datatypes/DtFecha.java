package datatypes;

public class DtFecha{
    private int dia;
    private int mes;
    private int anio;

    public DtFecha(int dia, int mes, int anio){
	 this.dia = dia;
	 this.mes = mes;
	 this.anio = anio;
    }

    public int getDia(){
	 return dia;
    }

    public int getMes(){
	 return mes;
    }

    public int getAnio(){
	 return anio;
    }
}
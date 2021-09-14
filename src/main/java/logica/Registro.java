package logica;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity 
public class Registro{
    private Date fecha;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    
    public Registro() {
    	
    }
    
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
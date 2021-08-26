package persistencia;

import java.io.Serializable;

//********   Ver **********//  79S 

// No es una entidad, debe implementar serializable
public class InscripcionID implements Serializable{
    private static final long serialVersionUID = 1L;

    private int clase;
    private String socio;

    // Tiene que tener constructor por defecto
    public InscripcionID(){
	 super();
    }

    // Tiene que implementar los getters y setters
    public int getClase(){
	 return clase;
    }

    public void setClase(int clase){
	 this.clase = clase;
    }

    public String getSocio(){
	 return socio;
    }

    public void setSocio(String socio){
	 this.socio = socio;
    }

    // Tiene que tener los metodos hashCode y equals
    @Override
    public int hashCode(){
	 final int prime = 31;
	 int result = 1;
	 result = prime * result + clase;
	 result = prime * result + ((socio == null) ? 0 : socio.hashCode());
	 return result;
    }

    @Override
    public boolean equals(Object obj){
	 if(this == obj)
	     return true;
	 if(obj == null)
	     return false;
	 if(getClass() != obj.getClass())
	     return false;
	 InscripcionID other = (InscripcionID) obj;
	 if(clase != other.clase)
	     return false;
	 if(socio == null){
	     if(other.socio != null)
		  return false;
	 }else if(!socio.equals(other.socio))
	     return false;
	 return true;
    }

}

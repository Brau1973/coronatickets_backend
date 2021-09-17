package persistencia;

import java.io.Serializable;
import java.util.Objects;

// No es una entidad, debe implementar serializable
public class RegistroID implements Serializable{
    private static final long serialVersionUID = 1L;

    private String espectador;
    private String funcion;

    // Tiene que tener constructor por defecto
    public RegistroID(){
	 super();
    }

    // Tiene que implementar los getters y setters
    public String getEspectador(){
	 return espectador;
    }

    public void setEspectador(String espectador){
	 this.espectador = espectador;
    }

    public String getFuncion(){
	 return funcion;
    }

    public void setFuncion(String funcion){
	 this.funcion = funcion;
    }

	@Override
	public int hashCode() {
		return Objects.hash(espectador, funcion);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RegistroID other = (RegistroID) obj;
		return Objects.equals(espectador, other.espectador) && Objects.equals(funcion, other.funcion);
	}

    
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((espectador == null) ? 0 : espectador.hashCode());
//		result = prime * result + ((funcion == null) ? 0 : funcion.hashCode());
//		return result;
//	}
//    
//    @Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		RegistroID other = (RegistroID) obj;
//		if (espectador != other.espectador)
//			return false;
//		if (funcion == null) {
//			if (other.funcion != null)
//				return false;
//		} else if (!funcion.equals(other.funcion))
//			return false;
//		return true;
//	}
}

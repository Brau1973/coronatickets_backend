package logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Espectador extends Usuario{
	
	@OneToMany(mappedBy="espectador",cascade=CascadeType.ALL,orphanRemoval=true)
	private List<Registro> registros = new ArrayList<>();
	
    public Espectador(){
	 super();
    }
	
    public Espectador(String nickname, String nombre, String apellido, String email, Date fNacimiento){
	 super(nickname, nombre, apellido, email, fNacimiento);
    }

	public List<Registro> getRegistros() {
		return registros;
	}

	public void setRegistros(List<Registro> registros) {
		this.registros = registros;
	}
}
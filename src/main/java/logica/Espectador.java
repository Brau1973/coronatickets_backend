package logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Espectador extends Usuario{

	
	@OneToMany
	private List<Registro> registros = new ArrayList<>();
	
    public Espectador(){
	 super();
    }
    
	
    public Espectador(String nickname, String nombre, String apellido, String email, Date fNacimiento, String contrasenia){
	 super(nickname, nombre, apellido, email, fNacimiento, contrasenia);
    }

	public List<Registro> getRegistros() {
		return registros;
	}

	public void setRegistros(List<Registro> registros) {
		this.registros = registros;
	}
	
	public void agregarRegistro(Registro registro) {
		this.registros.add(registro);
	}
	
}
package logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Espectador extends Usuario{

	
	@OneToMany // (mappedBy = "espectaculo", cascade = CascadeType.ALL)
	private List<Registro> registros = new ArrayList<>();
	
    public Espectador(String nickname, String nombre, String apellido, String email, Date fNacimiento, String contrasenia){
	 super(nickname, nombre, apellido, email, fNacimiento, contrasenia);
    }

    public Espectador(){
	 super();
    }
    
    

}
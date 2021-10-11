package logica;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Espectador extends Usuario{
    public Espectador(String nickname, String nombre, String apellido, String email, Date fNacimiento, String contrasenia){
	 super(nickname, nombre, apellido, email, fNacimiento, contrasenia);
    }

    public Espectador(){
	 super();
    }

}
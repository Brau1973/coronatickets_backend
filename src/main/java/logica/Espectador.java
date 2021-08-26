package logica;

import java.util.Date;

public class Espectador extends Usuario{
    public Espectador(String nickname, String nombre, String apellido, String email, Date fNacimiento){
	 super(nickname, nombre, apellido, email, fNacimiento);
    }
}
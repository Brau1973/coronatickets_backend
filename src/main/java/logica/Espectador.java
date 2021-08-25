package logica;

import datatypes.DtFecha;

public class Espectador extends Usuario{
    public Espectador(String nickname, String nombre, String apellido, String email, DtFecha fNacimiento){
	 super(nickname, nombre, apellido, email, fNacimiento);
    }
}
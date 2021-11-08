package datatypes;

import java.util.Date;
import java.util.List;

@SuppressWarnings("serial")
public class DtEspectador extends DtUsuario{

	public DtEspectador(String nickname, String nombre, String apellido, String email, Date fNacimiento, String contrasenia, byte[] imagen, List<String> seguidos, List<String> seguidores){
		super(nickname, nombre, apellido, email, fNacimiento, seguidos, seguidores, contrasenia, imagen);

	}
}

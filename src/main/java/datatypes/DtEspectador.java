package datatypes;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DtEspectador extends DtUsuario {
	private static final long serialVersionUID = 1L;
	public DtEspectador() {
		super();
	}

	public DtEspectador(String nickname, String nombre, String apellido, String email, Date fNacimiento, List<String> seguidos, List<String> seguidores, String contrasenia, byte[] imagen) {
		super(nickname, nombre, apellido, email, fNacimiento, seguidos, seguidores, contrasenia, imagen);
	}

}

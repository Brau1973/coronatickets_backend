package datatypes;

import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DtArtista extends DtUsuario {
	private static final long serialVersionUID = 1L;
	private String descripcion;
	private String biografia;
	private String link;
	
	public DtArtista() {
		super();
	}
	public DtArtista(String nickname, String nombre, String apellido, String email, Date fNacimiento, List<String> seguidos, List<String> seguidores, String contrasenia, String imageName, String descripcion, String biografia, String link) {
		super(nickname, nombre, apellido, email, fNacimiento, seguidos, seguidores, contrasenia, imageName);
		this.descripcion = descripcion;
		this.biografia = biografia;
		this.link = link;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public String getBiografia() {
		return biografia;
	}

	public String getLink() {
		return link;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion= descripcion;
	}

	public void setBiografia(String biografia) {
		this.biografia=biografia;
	}

	public void setLink(String link) {
		this.link=link;
	}
}
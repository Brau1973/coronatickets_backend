package datatypes;

import java.util.Date;

public class DtArtista extends DtUsuario{
	private String descripcion;
    private String biografia;
    private String link;
    
	public DtArtista(String nickname, String nombre, String apellido, String email, Date fNacimiento,
			String descripcion, String biografia, String link) {
		super(nickname, nombre, apellido, email, fNacimiento);
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
}

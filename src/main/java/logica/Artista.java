package logica;

public class Artista extends Usuario {
    private String descripcion;
    private String biografia;
    private String link;

    public Artista(String nickname, String nombre, String apellido, String email, DtFecha fNacimiento, String descripcion, String biografia, String link) {
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

    public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
    }

    public void setBiografia(String biografia) {
	this.biografia = biografia;
    }

    public void setLink(String link) {
	this.link = link;
    }
}

package datatypes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Lob;

public class DtUsuario implements Serializable {
	private static final long serialVersionUID = 1L;
	private String nickname;
	private String nombre;
	private String apellido;
	private String email;
	private Date fNacimiento;
	private List<String> seguidos = new ArrayList<String>();
	private List<String> seguidores = new ArrayList<String>();
	private String contrasenia;
	private String imageName;
	
	public DtUsuario() {
		super();
	}
	
	public DtUsuario(String nickname, String nombre, String apellido, String email, Date fNacimiento, List<String> seguidos, List<String> seguidores, String contrasenia, String imageName) {
		super();
		this.nickname = nickname;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.fNacimiento = fNacimiento;
		this.seguidos = seguidos;
		this.seguidores = seguidores;
		this.contrasenia = contrasenia;
		this.setImageName(imageName);
	}

	public String getNickname() {
		return nickname;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getEmail() {
		return email;
	}

	public Date getfNacimiento() {
		return fNacimiento;
	}

	public List<String> getSeguidos() {
		return seguidos;
	}

	public List<String> getSeguidores() {
		return seguidores;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setfNacimiento(Date fNacimiento) {
		this.fNacimiento = fNacimiento;
	}

	public void setSeguidos(List<String> seguidos) {
		this.seguidos = seguidos;
	}

	public void setSeguidores(List<String> seguidores) {
		this.seguidores = seguidores;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

}

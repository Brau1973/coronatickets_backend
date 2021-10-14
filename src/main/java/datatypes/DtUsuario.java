package datatypes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DtUsuario implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String nickname;
    private String nombre;
    private String apellido;
    private String email;
    private Date fNacimiento;
    private List<String> seguidos = new ArrayList<String>();
	private List<String> seguidores = new ArrayList<String>();
    private String contrasenia;
    
	public DtUsuario(String nickname, String nombre, String apellido, String email, Date fNacimiento,
			List<String> seguidos, List<String> seguidores,String contrasenia) {

		super();
		this.nickname = nickname;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.fNacimiento = fNacimiento;
		this.seguidos = seguidos;
		this.seguidores = seguidores;
		this.contrasenia = contrasenia;

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
}

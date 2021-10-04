package datatypes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DtUsuario {
	private static String nickname;
    private String nombre;
    private String apellido;
    private static String email;
    private Date fNacimiento;
	private List<String> seguidos = new ArrayList<String>();
	private List<String> seguidores = new ArrayList<String>();
    
	public DtUsuario(String nickname, String nombre, String apellido, String email, Date fNacimiento,
			List<String> seguidos, List<String> seguidores) {
		super();
		this.nickname = nickname;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.fNacimiento = fNacimiento;
		this.seguidos = seguidos;
		this.seguidores = seguidores;
	}
	public static String getNickname() {
		return nickname;
	}
	public String getNombre() {
		return nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public static String getEmail() {
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
}

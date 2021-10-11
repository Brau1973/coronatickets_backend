package datatypes;

import java.util.Date;

public class DtUsuario {
	private static String nickname;
    private String nombre;
    private String apellido;
    private static String email;
    private Date fNacimiento;
    private String contrasenia;
    
	public DtUsuario(String nickname, String nombre, String apellido, String email, Date fNacimiento, String contrasenia) {
		super();
		this.nickname = nickname;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.fNacimiento = fNacimiento;
		this.contrasenia = contrasenia;
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
	public String getContrasenia() {
		return contrasenia;
	}
}

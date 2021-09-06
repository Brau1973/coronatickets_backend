package datatypes;

import java.util.Date;

public class DtUsuario {
	private String nickname;
    private String nombre;
    private String apellido;
    private String email;
    private Date fNacimiento;
    
	public DtUsuario(String nickname, String nombre, String apellido, String email, Date fNacimiento) {
		super();
		this.nickname = nickname;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.fNacimiento = fNacimiento;
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
}

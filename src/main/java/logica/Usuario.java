package logica;

public class Usuario {
    private String nickname;
    private String nombre;
    private String apellido;
    private String email;
    private DtFecha fNacimiento;

    public Usuario(String nickname, String nombre, String apellido, String email, DtFecha fNacimiento) {
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

    public DtFecha getfNacimiento() {
	return fNacimiento;
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

    public void setfNacimiento(DtFecha fNacimiento) {
	this.fNacimiento = fNacimiento;
    }
}
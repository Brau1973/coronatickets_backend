package logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)

public class Usuario {
	@Id
	private String nickname;
	private String nombre;
	private String apellido;
	private String email;
	private Date fNacimiento;
	private String contrasenia;

	@ManyToMany(cascade = CascadeType.ALL)
	private List<Usuario> seguidos = new ArrayList<Usuario>();

	@ManyToMany(mappedBy = "seguidos")
	private List<Usuario> seguidores = new ArrayList<Usuario>();

	public Usuario(String nickname, String nombre, String apellido, String email, Date fNacimiento, String contrasenia) {
		super();
		this.nickname = nickname;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.fNacimiento = fNacimiento;
		this.contrasenia = contrasenia;
	
	}

	public Usuario() {
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
	
	public List<Usuario> getSeguidos() {
		return seguidos;
	}

	public void setSeguidos(List<Usuario> seguidos) {
		this.seguidos = seguidos;
	}

	public List<Usuario> getSeguidores() {
		return seguidores;
	}

	public void setSeguidores(List<Usuario> seguidores) {
		this.seguidores = seguidores;
	}

	// Modificar los seguidos
	public void seguirUsuario(Usuario u) {
		if (!this.seguidos.contains(u)) {
			this.seguidos.add(u);
			u.agregarSeguidor(this);
		}
	}

	public void dejarSeguirUsuario(Usuario u) {
		this.seguidos.remove(u);
		u.quitarSeguidor(this);
	}

	// Modificar los seguidores
	public void agregarSeguidor(Usuario u) {
		if (!this.seguidores.contains(u)) {
			this.seguidores.add(u);
		}
	}

	public void quitarSeguidor(Usuario u) {
		this.seguidores.remove(u);
	}
		 
	public void setContrasenia(String contrasenia){
		   this.contrasenia = contrasenia;
				   }
	

}
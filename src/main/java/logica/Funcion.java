package logica;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

//import datatypes.DtHora;

@Entity
public class Funcion{
    @Id
    private String nombre;
    private Date fecha;
    private Time horaInicio;
    private Date registro;
    @ManyToOne
    private Espectaculo espectaculo;
<<<<<<< HEAD
    @OneToMany(orphanRemoval = true)
    @JoinTable(name = "FuncionXArtistas", joinColumns = @JoinColumn(name = "nombre"), inverseJoinColumns = @JoinColumn(name = "nickname"))
    private List<Artista> artistas = new ArrayList<Artista>();

    public Funcion(String nombre, Date fecha, Time horaInicio, Date registro, Espectaculo espectaculo, List<Artista> artistas){
=======

    @ManyToMany(cascade = CascadeType.ALL)
    // @JoinTable(name = "FuncionXArtistas", joinColumns = @JoinColumn(name = "nombre"), inverseJoinColumns = @JoinColumn(name = "nickname"))
    private List<Artista> artistas = new ArrayList<Artista>();

    public Funcion(String nombre, Date fecha, Time horaInicio, Date registro, List<Artista> artistas){
>>>>>>> 6c8a5d938bb3ef6d18e666bd22ba8210faea9619
	 this.nombre = nombre;
	 this.fecha = fecha;
	 this.horaInicio = horaInicio;
	 this.registro = registro;
<<<<<<< HEAD
	 this.espectaculo = espectaculo;
=======
>>>>>>> 6c8a5d938bb3ef6d18e666bd22ba8210faea9619
	 this.artistas = artistas;
    }

    public Funcion(){
    }

    public String getNombre(){
	 return nombre;
    }

    public Espectaculo getEspectaculo(){
	 return espectaculo;
    }

    public Date getFecha(){
	 return fecha;
    }

    public Time getHoraInicio(){
	 return horaInicio;
    }


    public List<Artista> getArtistas(){
	 return artistas;
    }

    public Date getRegistro(){
	 return registro;
    }

    public void setNombre(String nombre){
	 this.nombre = nombre;
    }


    public void setEspectaculo(Espectaculo espectaculo){
	 this.espectaculo = espectaculo;
	 espectaculo.agregarFuncion(this);
    }

    public void setFecha(Date fecha){
	 this.fecha = fecha;
    }

    public void setHoraInicio(Time horaInicio){
	 this.horaInicio = horaInicio;
    }

    public void setArtistas(List<Artista> artistas){
	 this.artistas = artistas;
    }

    public void setRegistro(Date registro){
	 this.registro = registro;
    }

}
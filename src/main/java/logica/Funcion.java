package logica;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

//import datatypes.DtHora;

@Entity
public class Funcion{
    @Id
    private String nombre;
    @ManyToOne
    private Espectaculo espectaculo;
    private Date fecha;
    private Time horaInicio;
    @OneToMany(orphanRemoval = true)
    @JoinTable(name = "FuncionXArtistas", joinColumns = @JoinColumn(name = "nombre"), inverseJoinColumns = @JoinColumn(name = "nickname"))
    private List<Artista> artistas = new ArrayList<Artista>();
    private Date registro;

    public Funcion(String nombre, Espectaculo espectaculo, Date fecha, Time horaInicio, List<Artista> artistas, Date registro){
	 this.nombre = nombre;
	 this.espectaculo = espectaculo;
	 this.fecha = fecha;
	 this.horaInicio = horaInicio;
	 this.artistas = artistas;
	 this.registro = registro;
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
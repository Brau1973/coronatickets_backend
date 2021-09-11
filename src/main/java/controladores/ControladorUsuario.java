package controladores;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

import datatypes.DtArtista;
import datatypes.DtEspectador;
import datatypes.DtUsuario;
import excepciones.UsuarioRepetidoExcepcion;
import interfaces.Fabrica;
import interfaces.IControladorUsuario;
import logica.Artista;
import logica.Espectador;
import logica.Usuario;
import manejadores.ManejadorUsuario;
import persistencia.Conexion;

public class ControladorUsuario implements IControladorUsuario{
 

	public ControladorUsuario(){
	 super();
    }

    public void altaUsuario(DtUsuario dtu ) throws UsuarioRepetidoExcepcion{
	 ManejadorUsuario mU = ManejadorUsuario.getInstancia();
	 
	 if(mU.buscarUsuario(DtUsuario.getNickname()) != null){
	     throw new UsuarioRepetidoExcepcion("El nickname esta en uso");
	 }else if(mU.buscarUsuario(DtUsuario.getEmail()) != null){
	     throw new UsuarioRepetidoExcepcion("El email esta en uso");
	 }
	     if(dtu instanceof DtArtista){
		  Usuario usuario = new Artista (dtu.getNickname(),dtu.getNombre(),dtu.getApellido(),dtu.getEmail(),dtu.getfNacimiento(),((DtArtista) dtu).getDescripcion(),((DtArtista) dtu).getBiografia(),((DtArtista) dtu).getLink()); 
		  mU.altaUsuario(usuario);
	     }
	     if(dtu instanceof DtEspectador){
	
		  Usuario usuario = new Espectador (dtu.getNickname(),dtu.getNombre(),dtu.getApellido(),dtu.getEmail(),dtu.getfNacimiento()); 
		  mU.altaUsuario(usuario);
	     }
	   
	 }



    public void modificarUsuario(Usuario nuevo){
	 ManejadorUsuario mU = ManejadorUsuario.getInstancia();
	 Conexion conexion = Conexion.getInstancia();
	 EntityManager em = conexion.getEntityManager();
	 em.getTransaction().begin();
	 em.persist(mU.buscarUsuario(nuevo.getNickname()));
	 em.merge(nuevo);
	 em.getTransaction().commit();
    }

    public Usuario obtenerUsuario(String nickname){
	 ManejadorUsuario mU = ManejadorUsuario.getInstancia();
	 return mU.buscarUsuario(nickname);
    }

    public Artista obtenerArtista(String nickname){
	 ManejadorUsuario mU = ManejadorUsuario.getInstancia();
	 return mU.buscarArtista(nickname);
    }

    public List<Usuario> listarUsuarios(){
	 ManejadorUsuario mU = ManejadorUsuario.getInstancia();
	 return mU.obtenerUsuario();
    }

    public List<Artista> listarArtistas(){
	 ManejadorUsuario mU = ManejadorUsuario.getInstancia();
	 return mU.listarArtistas();
    }
    
    public List<DtArtista> listarArtistasDt(){
	 ManejadorUsuario mU = ManejadorUsuario.getInstancia();
	 List<DtArtista> listArtistasDt = new ArrayList<DtArtista>();
	 List<Artista> listArtistas = new ArrayList<Artista>();
	 listArtistas = mU.listarArtistas();
   	 for(Artista a :listArtistas){
   		 DtArtista dtArtista = new DtArtista(a.getNickname(),a.getNombre(),a.getApellido(),a.getEmail(),a.getfNacimiento(),a.getDescripcion(),a.getBiografia(),a.getLink());
   		 listArtistasDt.add(dtArtista);
   	 }
   	 return listArtistasDt;
    }
}
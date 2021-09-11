package interfaces;

import java.util.List;

import datatypes.DtArtista;
import datatypes.DtEspectador;
import datatypes.DtUsuario;
import excepciones.UsuarioRepetidoExcepcion;
import logica.Artista;
import logica.Usuario;

public interface IControladorUsuario{
    public void altaUsuario(DtUsuario u) throws UsuarioRepetidoExcepcion;

    public void modificarUsuario(Usuario nuevo);

    public Usuario obtenerUsuario(String nickname);
    
    public List<Artista> listarArtistas();

    public List<Usuario> listarUsuarios();

    public Artista obtenerArtista(String nickname);
    
    public List<DtArtista> listarArtistasDt();
}
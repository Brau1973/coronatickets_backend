package interfaces;

import java.util.List;

import datatypes.DtUsuario;
import excepciones.UsuarioRepetidoExcepcion;
import logica.Artista;
import logica.Espectador;
import logica.Usuario;

public interface IControladorUsuario{
    public void altaUsuario(DtUsuario u) throws UsuarioRepetidoExcepcion;

    public void modificarUsuario(Usuario nuevo);

    public Usuario obtenerUsuario(String nickname);

    public Artista obtenerArtista(String nickname);
    
    public List<String> listarNicknameUsuarios();
    
    public List<String> listarNicknameArtistas();
    
    public List<String> listarNicknameEspectadores();
    
    public void seguirUsuario(String nicknameUsuario, String nicknameUsuarioASeguir);
    
    public void dejarDeSeguirUsuario(String nicknameUsuario, String nicknameUsuarioADejarDeSeguir);
    
    public List<String> listarNicknameUsuariosNoSeguidos(String nickname);
}
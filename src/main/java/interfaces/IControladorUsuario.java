package interfaces;

import excepciones.UsuarioRepetidoExcepcion;
import logica.Usuario;

public interface IControladorUsuario{
    public void altaUsuario(Usuario u) throws UsuarioRepetidoExcepcion;

    public void modificarUsuario(Usuario nuevo);

    public Usuario obtenerUsuario(String nickname);

    public String[] listarUsuarios();
}
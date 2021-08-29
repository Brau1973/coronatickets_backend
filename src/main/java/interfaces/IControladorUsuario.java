package interfaces;

import excepciones.UsuarioRepetidoExcepcion;
import logica.Usuario;

public interface IControladorUsuario{
    public void altaUsuario(Usuario u) throws UsuarioRepetidoExcepcion;

    public String[] listarUsuarios();
}
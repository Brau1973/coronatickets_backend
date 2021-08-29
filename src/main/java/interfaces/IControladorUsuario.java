package interfaces;

import excepciones.UsuarioRepetidoExcepcion;
import logica.Usuario;

//import datatypes.DtEspectaculo;
//import excepciones.EspectaculoRepetidoExcepcion;

public interface IControladorUsuario{
   public void altaUsuario(Usuario u) throws UsuarioRepetidoExcepcion;
  

 
}
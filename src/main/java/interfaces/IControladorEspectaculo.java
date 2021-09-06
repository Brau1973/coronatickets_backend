package interfaces;

import java.util.List;

import datatypes.DtEspectaculo;
import excepciones.EspectaculoRepetidoExcepcion;
import excepciones.FuncionYaRegistradaEnEspectaculoExcepcion;
import logica.Espectaculo;

public interface IControladorEspectaculo{
    public void altaEspectaculo(DtEspectaculo dte) throws EspectaculoRepetidoExcepcion;

    public List<Espectaculo> listarEspectaculos();

    public Espectaculo obtenerEspectaculo(String nombre);
<<<<<<< HEAD
    // public String[] listarArtistas();
=======
    
    //public void agregarFuncion(String nombreEspectaculo,String nombreFuncion) throws FuncionYaRegistradaEnEspectaculoExcepcion;
>>>>>>> 6c8a5d938bb3ef6d18e666bd22ba8210faea9619
}
package controladores;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import datatypes.DtFuncion;
import excepciones.FuncionRepetidaExcepcion;
import interfaces.Fabrica;
import interfaces.IControladorEspectaculo;
import interfaces.IControladorFuncion;
import logica.Espectaculo;
import interfaces.IControladorUsuario;
import logica.Artista;
import logica.Funcion;
import logica.Plataforma;
import manejadores.ManejadorEspectaculo;
import manejadores.ManejadorFuncion;
import manejadores.ManejadorPlataforma;
import persistencia.Conexion;
import manejadores.ManejadorPlataforma;

public class ControladorFuncion implements IControladorFuncion{

    public ControladorFuncion(){
	 super();
    }

    /*@Override
    public void altaFuncion(Funcion funcion) throws FuncionRepetidaExcepcion{
	 ManejadorFuncion mF = ManejadorFuncion.getInstancia();
	 mF.agregarFuncion(funcion);
    }*/
    
    public void altaFuncion(DtFuncion dtFuncion) throws FuncionRepetidaExcepcion {
		ManejadorFuncion mF = ManejadorFuncion.getInstancia();
		//Funcion funcion = mF.buscarFuncion(dtFuncion.getNombre());
//     if (funcion != null)
//         throw new FuncionRepetidaExcepcion("La Funcion "+ dtFuncion.getNombre() + "ya esta registrada");
		IControladorUsuario iconU = Fabrica.getInstancia().getIControladorUsuario();
		List<Artista> artistas = new ArrayList<Artista>();
		dtFuncion.getArtistas().forEach((a) -> {
			artistas.add(iconU.obtenerArtista(a));

		});
		
		Funcion funcionACrear = new Funcion(dtFuncion.getNombre(), dtFuncion.getFecha(), dtFuncion.getHoraInicio(),
				dtFuncion.getRegistro(), artistas);
		
		IControladorEspectaculo iconE = Fabrica.getInstancia().getIControladorEspectaculo();
		funcionACrear.setEspectaculo(iconE.obtenerEspectaculo(dtFuncion.getEspectaculo()));
		
		mF.agregarFuncion(funcionACrear);
	}
    
    public List<Funcion> listarFunciones(){
   	 ManejadorFuncion mF = ManejadorFuncion.getInstancia();
   	 return mF.obtenerFunciones();
       }
    
    public Funcion obtenerFuncion(String nombre){
   	 ManejadorFuncion mF = ManejadorFuncion.getInstancia();
   	 return mF.buscarFuncion(nombre);
       }
    
    public List<Funcion> obtenerFuncionBD(String espectaculo){
     	 ManejadorFuncion mF = ManejadorFuncion.getInstancia();
     	 return mF.obtenerFuncionesBD(espectaculo);
         }
 
    // @Override
    // public String[] listarPlataformas() {
    // ArrayList<String> plataformas;
    // ManejadorFuncion mF = ManejadorFuncion.getInstancia();
    // plataformas = mF.obtenerPlataforma();
    // String[] plataformas_ret = new String[plataformas.size()];
    // int i=0;
    // for(String id:plataformas) {
    // plataformas_ret[i] = id;
    // i++;
    // }
    // return plataformas_ret;
    // }

    // @Override
    // public Plataforma[] listarPlataformas() {
    // ArrayList<String> plataformas;
    // ManejadorFuncion mF = ManejadorFuncion.getInstancia();
    // plataformas = mF.obtenerPlataforma();
    // String[] plataformas_ret = new String[plataformas.size()];
    // int i=0;
    // for(String id:plataformas) {
    // plataformas_ret[i] = id;
    // i++;
    // }
    // return plataformas_ret;
    // }

    // @Override
    // public String[] listarEspectaculos(String plataforma) {
    // ArrayList<String> espectaculos;
    // ManejadorFuncion mF = ManejadorFuncion.getInstancia();
    // espectaculos = mF.obtenerEspectaculo(plataforma);
    // String[] espectaculos_ret = new String[espectaculos.size()];
    // int i=0;
    // for(String id:espectaculos) {
    // espectaculos_ret[i] = id;
    // i++;
    // }
    // return espectaculos_ret;
    // }
    //
}
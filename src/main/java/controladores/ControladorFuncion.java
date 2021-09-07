package controladores;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

import datatypes.DtFuncion;
import excepciones.FuncionRepetidaExcepcion;
import excepciones.FuncionYaRegistradaEnEspectaculoExcepcion;
import interfaces.Fabrica;
import interfaces.IControladorEspectaculo;
import interfaces.IControladorFuncion;
import interfaces.IControladorUsuario;
import logica.Artista;
import logica.Espectaculo;
import logica.Funcion;
import logica.Plataforma;
import manejadores.ManejadorEspectaculo;
import manejadores.ManejadorFuncion;
import persistencia.Conexion;
import manejadores.ManejadorPlataforma;

public class ControladorFuncion implements IControladorFuncion {

	public ControladorFuncion() {
		super();
	}

	public void altaFuncion(DtFuncion dtFuncion) throws FuncionYaRegistradaEnEspectaculoExcepcion {
		IControladorEspectaculo iconE = Fabrica.getInstancia().getIControladorEspectaculo();
		Espectaculo espectaculo = iconE.obtenerEspectaculo(dtFuncion.getEspectaculo());
		
		if(espectaculo.funcionYaRegistrada(dtFuncion.getNombre())){
			throw new FuncionYaRegistradaEnEspectaculoExcepcion("La Funcion" + dtFuncion.getNombre() + " ya esta registrada en el espectaculo " + espectaculo.getNombre());
		}else {
			ManejadorFuncion mF = ManejadorFuncion.getInstancia();
			IControladorUsuario iconU = Fabrica.getInstancia().getIControladorUsuario();
			List<Artista> artistas = new ArrayList<Artista>();
			dtFuncion.getArtistas().forEach((a) -> {
				artistas.add(iconU.obtenerArtista(a));
			});
			Funcion funcionACrear = new Funcion(dtFuncion.getNombre(), dtFuncion.getFecha(), dtFuncion.getHoraInicio(),
					dtFuncion.getRegistro(), artistas);
			funcionACrear.setEspectaculo(espectaculo);
			mF.agregarFuncion(funcionACrear);
		}
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
}

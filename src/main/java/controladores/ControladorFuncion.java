package controladores;

import java.util.ArrayList;

import interfaces.IControladorFuncion;
import manejadores.ManejadorFuncion;

public class ControladorFuncion implements IControladorFuncion{
    public ControladorFuncion(){
	 super();
    }

<<<<<<< HEAD
public class ControladorFuncion implements IControladorFuncion {
	
	public ControladorFuncion(){
		 super();
	}
	
	@Override
	public String[] listarPlataformas() {
		ArrayList<String> plataformas;
		ManejadorFuncion mF = ManejadorFuncion.getInstancia();
		plataformas = mF.obtenerPlataforma();
		String[] plataformas_ret = new String[plataformas.size()];
		int i=0;
		for(String id:plataformas) {
			plataformas_ret[i] = id;
			i++;
		}
		return plataformas_ret;
	}
	
	@Override
	public String[] listarEspectaculos(String plataforma) {
		ArrayList<String> espectaculos;
		ManejadorFuncion mF = ManejadorFuncion.getInstancia();
		espectaculos = mF.obtenerEspectaculo(plataforma);
		String[] espectaculos_ret = new String[espectaculos.size()];
		int i=0;
		for(String id:espectaculos) {
			espectaculos_ret[i] = id;
			i++;
		}
		return espectaculos_ret;
	}
=======
    @Override
    public String[] listarPlataformas(){
	 ArrayList<String> plataformas;
	 ManejadorFuncion mP = ManejadorFuncion.getInstancia();
	 plataformas = mP.obtenerPlataforma();
	 String[] plataformas_ret = new String[plataformas.size()];
	 int i = 0;
	 for(String id :plataformas){
	     plataformas_ret[i] = id;
	     i++;
	 }
	 return plataformas_ret;
    }
>>>>>>> dc7e2420eff0c3daa510f3581c081ef71d3dd9a0

}

package controladores;

import excepciones.FuncionRepetidaExcepcion;
import interfaces.IControladorFuncion;
import logica.Funcion;
import manejadores.ManejadorFuncion;

public class ControladorFuncion implements IControladorFuncion{

    public ControladorFuncion(){
	 super();
    }

    @Override
    public void altaFuncion(Funcion funcion) throws FuncionRepetidaExcepcion{
	 ManejadorFuncion mF = ManejadorFuncion.getInstancia();
	 mF.agregarFuncion(funcion);
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

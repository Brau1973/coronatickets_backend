package presentacion;

import interfaces.Fabrica;

public class Principal{
    public static void main(String[] args){
	 FrmPrincipal frmInicio = new FrmPrincipal();
	 frmInicio.setVisible(true);
	 
	 //Fabrica.getInstancia().getIControladorEspectaculo().listarEspectaculos();
	 
    }
}
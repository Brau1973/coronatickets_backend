package presentacion;

import java.awt.EventQueue;

public class Principal {
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPrincipal frame = new FrmPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}

//public class Principal{
//    public static void main(String[] args){
//	 FrmPrincipal frmInicio = new FrmPrincipal();
//	 frmInicio.setVisible(true);
// Fabrica.getInstancia().getIControladorEspectaculo().listarEspectaculos();
//    }
//}
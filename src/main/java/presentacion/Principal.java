package presentacion;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import logica.Plataforma;
import logica.Espectaculo;

public class Principal{
	public static void main(String[] args){
	 FrmPrincipal frmInicio = new FrmPrincipal();
	 frmInicio.setVisible(true);
    }
}
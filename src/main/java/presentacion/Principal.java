package presentacion;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import logica.Plataforma;

public class Principal{
    private static EntityManagerFactory emf;
    private static EntityManager em;

    public static void main(String[] args){
	 emf = Persistence.createEntityManagerFactory("bd_coronaTickets");
	 em = emf.createEntityManager();
	 Plataforma plataforma = new Plataforma("Plataforma", "Apto18", "nuit.com");
	 em.getTransaction().begin();
	 em.persist(plataforma);
	 em.getTransaction().commit();

	 /*	 emf = Persistence.createEntityManagerFactory("bd_coronaTickets");
	 em = emf.createEntityManager();
	 Espectaculo espectaculo = new Espectaculo("aaaa", "Apto18", "nuit.com", "nuit.com", 1, 2, 3, "nuit.com", 8);
	 em.getTransaction().begin();
	 em.persist(espectaculo);
	 em.getTransaction().commit();*/

	 em.close();
	 emf.close();
	 FrmPrincipal frmInicio = new FrmPrincipal();
	 frmInicio.setVisible(true);
    }
}
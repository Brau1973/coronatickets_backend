package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import javax.xml.transform.OutputKeys;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import datatypes.DtPlataforma;
import excepciones.PlataformaRepetidaExcepcion;
import interfaces.Fabrica;
import interfaces.IControladorPlataforma;
import logica.Plataforma;

public class PlataformasTest {

	IControladorPlataforma iconPlat = Fabrica.getInstancia().getIControladorPlataforma();
	DtPlataforma dt;
	
	@Before
	public void beforeTest() {
		dt = new DtPlataforma("Plataforma1Test", "Descripcion", "Url");
	}
	
	@Test
	public void altaPlataformaTest() {
		try {
			dt = new DtPlataforma("Plataforma1Test", "Descripcion", "Url");
			iconPlat.altaPlataforma(dt);
			Plataforma dtBd = iconPlat.buscarPlataforma(dt.getNombre());
			assertEquals(dt.getNombre(),dtBd.getNombre());
		} catch (PlataformaRepetidaExcepcion e) {
			fail("Plataforma repetida");
		}
	}
	
	@After
	public void afterTest() {
		
	}
}

package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import javax.xml.transform.OutputKeys;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import datatypes.DtPlataforma;
import excepciones.PlataformaRepetidaExcepcion;
import interfaces.Fabrica;
import interfaces.IControladorPlataforma;
import logica.Plataforma;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class APlataformasTest {

	IControladorPlataforma iconPlat = Fabrica.getInstancia().getIControladorPlataforma();
	DtPlataforma dt;
	
	@Test
	@Order(1)
	public void altaPlataformaTest() throws PlataformaRepetidaExcepcion {
		
			dt = new DtPlataforma("Plataforma1Test", "Descripcion", "Url");
			iconPlat.altaPlataforma(dt);
			Plataforma dtBd = iconPlat.buscarPlataforma(dt.getNombre());
			assertEquals(dt.getNombre(),dtBd.getNombre());
		
	}
	@Test
	@Order(2)
	public void listarPlataformaTest() throws PlataformaRepetidaExcepcion {
	
			dt = new DtPlataforma("Plataforma3Test", "Descripcion", "Url");
			iconPlat.altaPlataforma(dt);
			dt = new DtPlataforma("Plataforma4Test", "Descripcion", "Url");
			iconPlat.altaPlataforma(dt);
			dt = new DtPlataforma("Plataforma5Test", "Descripcion", "Url");
			iconPlat.altaPlataforma(dt);
			List<String> listastr = iconPlat.listarPlataformasStr();
			List<DtPlataforma> lstDtPlat = iconPlat.listarPlataformas();
			assertTrue(
			(listastr.size() == lstDtPlat.size()) &&
			((listastr.stream().anyMatch(a -> (a == "Plataforma3Test")))&& 
			(listastr.stream().anyMatch(a -> (a == "Plataforma4Test")))&& 
			(listastr.stream().anyMatch(a -> (a == "Plataforma5Test"))))	
			);
	
			
		
	}
////	@Order(value = 3)
//	@Test(expected = PlataformaRepetidaExcepcion.class)
//	public void plataformaRepetidaTest() throws PlataformaRepetidaExcepcion {
//		
//			dt = new DtPlataforma("Plataforma6Test", "Descripcion", "Url");
//			iconPlat.altaPlataforma(dt);
//			dt = new DtPlataforma("Plataforma6Test", "Descripcion", "Url");
//			iconPlat.altaPlataforma(dt);
//			
//	}
////	
}

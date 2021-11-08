package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.List;

import javax.xml.transform.OutputKeys;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Order;

import datatypes.DtPlataforma;
import excepciones.PlataformaRepetidaExcepcion;
import interfaces.Fabrica;
import interfaces.IControladorPlataforma;
import logica.Plataforma;

public class PlataformasTest {

	IControladorPlataforma iconPlat = Fabrica.getInstancia().getIControladorPlataforma();
	DtPlataforma dt;
	
	
	@Test
	public void altaPlataformaTest() throws PlataformaRepetidaExcepcion {
		
			dt = new DtPlataforma("Plataforma2Test", "Descripcion", "Url");
			iconPlat.altaPlataforma(dt);
			Plataforma dtBd = iconPlat.buscarPlataforma(dt.getNombre());
			assertEquals(dt.getNombre(),dtBd.getNombre());
		
	}

	@Test
	public void listarPlataformaTest() throws PlataformaRepetidaExcepcion {
	
			dt = new DtPlataforma("Plataforma3Test", "Descripcion", "Url");
			iconPlat.altaPlataforma(dt);
			dt = new DtPlataforma("Plataforma4Test", "Descripcion", "Url");
			iconPlat.altaPlataforma(dt);
			dt = new DtPlataforma("Plataforma5Test", "Descripcion", "Url");
			iconPlat.altaPlataforma(dt);
			List<DtPlataforma> lista = iconPlat.listarPlataformas();
			List<String> listastr = iconPlat.listarPlataformasStr();
			assertTrue(
			((lista.stream().anyMatch(a -> (a.getNombre() == "Plataforma3Test")))&& 
			(lista.stream().anyMatch(a -> (a.getNombre() == "Plataforma4Test")))&& 
			(lista.stream().anyMatch(a -> (a.getNombre() == "Plataforma5Test")))) && 
			((listastr.stream().anyMatch(a -> (a == "Plataforma3Test")))&& 
			(listastr.stream().anyMatch(a -> (a == "Plataforma4Test")))&& 
			(listastr.stream().anyMatch(a -> (a == "Plataforma5Test"))))	
			);
	
			
		
	}
	@Test(expected = PlataformaRepetidaExcepcion.class)
	public void plataformaRepetidaTest() throws PlataformaRepetidaExcepcion {
		
			dt = new DtPlataforma("Plataforma6Test", "Descripcion", "Url");
			iconPlat.altaPlataforma(dt);
			dt = new DtPlataforma("Plataforma6Test", "Descripcion", "Url");
			iconPlat.altaPlataforma(dt);
			
	}
	
}

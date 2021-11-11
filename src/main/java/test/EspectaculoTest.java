package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Timer;

import javax.xml.transform.OutputKeys;

import org.hibernate.mapping.Array;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import datatypes.DtArtista;
import datatypes.DtEspectaculo;
import datatypes.DtEspectador;
import datatypes.DtFuncion;
import datatypes.DtPlataforma;
import datatypes.DtRegistro;
import excepciones.PlataformaRepetidaExcepcion;
import interfaces.Fabrica;
import interfaces.IControladorEspectaculo;
import interfaces.IControladorFuncion;
import interfaces.IControladorPlataforma;
import interfaces.IControladorRegistro;
import interfaces.IControladorUsuario;
import logica.Plataforma;

public class EspectaculoTest {

	IControladorPlataforma iconPlataforma = Fabrica.getInstancia().getIControladorPlataforma();
	DtPlataforma dtPla;
	IControladorUsuario iconUsuario = Fabrica.getInstancia().getIControladorUsuario();
	DtArtista dtArt;
	DtEspectador dtEspectador;
	IControladorEspectaculo iconEspectaculo = Fabrica.getInstancia().getIControladorEspectaculo();
	DtEspectaculo dtEsp;
	IControladorFuncion iconFuncion = Fabrica.getInstancia().getIControladorFuncion();
	DtFuncion dtFunc;
	IControladorRegistro iconRegistro = Fabrica.getInstancia().getIControladorRegistro();
	DtRegistro dtReg;
	
	
	
	
	
	@Test
	public void altaRegistro(){
			try {
			dtPla = new DtPlataforma("nombrePlataforma", "descripcionPlataforma", "urlPlataforma");
			iconPlataforma.altaPlataforma(dtPla);
					
			dtArt = new DtArtista("nicknameArtista", "nombreArtista", "apellidoArtista", "email@Artista", new Date (), "contraseniaArtista", null,null,null,
				"descripcionArtista", "biografiaArtista", "linkArtista");
			iconUsuario.altaUsuario(dtArt);
			
			dtEspectador = new DtEspectador("nicknameEspectador", "nombreEspectador", "apellidoEspectador", "email@Espectador", new Date (), "contraseniaEspectador", null,null,null);
				iconUsuario.altaUsuario(dtEspectador);
			
			dtEsp = new DtEspectaculo(dtArt.getNombre(), dtPla.getNombre(), "nombreEspectaculo", "descripcionEspectaculo", 58, 50, 200, "urlEspectaculo", 150, new Date());
			iconEspectaculo.altaEspectaculo(dtEsp, dtPla.getNombre());
			
			dtFunc = new DtFuncion("nombreFuncion", new Date(), new Time(02,05,55), new Date(), new ArrayList<String>());
			iconFuncion.altaFuncion(dtFunc, dtEsp.getNombre(), null); 
					
			
			dtReg = new DtRegistro(dtFunc.getNombre(), new Date(), 150);
			iconRegistro.altaRegistro(dtReg, dtEspectador.getNickname());
			
			//DtRegistro dtRegistro = iconRegistro. buscarPlataforma(dt.getNombre());
			//DtRegistro dtRegistro = iconRegistro. buscarPlataforma(dt.getNombre());
		//	assertEquals(dt.getNombre(),dtBd.getNombre());
			assertTrue(true);
			//TODO
			}catch(Exception e) {
				e.printStackTrace();
				assertTrue(false);
			}
	}
	
	
}

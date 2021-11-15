package test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Timer;

import javax.xml.transform.OutputKeys;

import org.hibernate.mapping.Array;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

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
import logica.Funcion;
import logica.Plataforma;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FFuncionTest {

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
	@Order(15)
	public void altaRegistro(){
			try {
			dtPla = new DtPlataforma("nombrePlataformaFuncion", "descripcionPlataformaFuncion", "urlPlataformaFuncion");
			iconPlataforma.altaPlataforma(dtPla);
					
			dtArt = new DtArtista("nicknameArtistaFuncion", "nombreArtistaFuncion", "apellidoArtistaFuncion", "email@ArtistaFuncion", new Date (), "contraseniaArtistaRegistro", null,null,null,
				"descripcionArtistaFuncion", "biografiaArtistaFuncion", "linkArtistaFuncion");
			iconUsuario.altaDtArtista(dtArt);
			
			dtEspectador = new DtEspectador("nicknameEspectadorFuncion", "nombreEspectadorFuncion", "apellidoEspectadorFuncion", "email@EspectadorFuncion", new Date (), "contraseniaEspectadorFuncion", null,null,null);
			iconUsuario.altaUsuario(dtEspectador);
			
			dtEsp = new DtEspectaculo(dtArt.getNickname(), dtPla.getNombre(), "nombreEspectaculoFuncion", "descripcionEspectaculoFuncion", 58, 50, 200, "urlEspectaculoFuncion", 150, new Date());
			iconEspectaculo.altaEspectaculo(dtEsp, dtPla.getNombre());
			
			dtFunc = new DtFuncion("nombreFuncionFuncion", new Date(), new Time(02,05,55), new Date(), new ArrayList<String>());
			iconFuncion.altaFuncion(dtFunc, dtEsp.getNombre(), null); 
					
			DtFuncion dtFunc2 = new DtFuncion("nombreFuncionFuncion2", new Date(), new Time(02,05,55), new Date(), new ArrayList<String>());
			iconFuncion.altaFuncion(dtFunc2, dtEsp.getNombre(), null); 
			boolean testOK = true;
			List<DtFuncion> lstFunc = iconFuncion.listarFunciones(dtEsp.getNombre());
			
			List<String> lstFunc = iconFuncion.getFuncionesVigentesRegistradasPorEspectador(dtEsp.getNombre());
			if(lstFunc.isEmpty()){
				testOK = false;
			}

			if (lstFunc.size() != 2) {
				testOK = false;
			}
			Funcion dtF = iconFuncion.obtenerFuncion(dtFunc2.getNombre());
			if(dtF == null ) {
				testOK = false;
			}
			
			assertTrue(testOK);
			}catch(Exception e) {
				e.printStackTrace();
				assertTrue(false);
			}
	}
	
	
}

package test;


import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import datatypes.DtArtista;
import datatypes.DtEspectaculo;
import datatypes.DtEspectador;
import datatypes.DtFuncion;
import datatypes.DtPlataforma;
import datatypes.DtRegistro;
import interfaces.Fabrica;
import interfaces.IControladorEspectaculo;
import interfaces.IControladorFuncion;
import interfaces.IControladorPlataforma;
import interfaces.IControladorRegistro;
import interfaces.IControladorUsuario;
import logica.Espectaculo;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CEspectaculoTest {

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
	
	
	
	
	@Order(12)
	@Test
	public void altaEspectaculo(){
			try {
			dtPla = new DtPlataforma("nombrePlataformaEspectaculo", "descripcionPlataformaEspectaculo", "urlPlataformaEspectaculo");
			iconPlataforma.altaPlataforma(dtPla);
					
			dtArt = new DtArtista("nicknameArtistaEspectaculo", "nombreArtistaEspectaculo", "apellidoArtistaEspectaculo", "email@ArtistaEspectaculo", new Date(), "contraseniaArtistaEspectaculo", null,null,null,
				"descripcionArtistaEspectaculo", "biografiaArtistaEspectaculo", "linkArtistaEspectaculo");
			iconUsuario.altaUsuario(dtArt);
			
			dtEsp = new DtEspectaculo(dtArt.getNickname(), dtPla.getNombre(), "nombreEspectaculoEspectaculo", "descripcionEspectaculoEspectaculo", 58, 50, 200, "urlEspectaculoEspectaculo", 150, new Date());
			iconEspectaculo.altaEspectaculo(dtEsp, dtPla.getNombre());
			
			Espectaculo dtEspectac = iconEspectaculo.obtenerEspectaculo(dtEsp.getNombre());

			assertTrue(dtEspectac != null);
			}catch(Exception e) {
				e.printStackTrace();
				assertTrue(false);
			}
	}
	
	@Order(13)
	@Test
	public void listarEspectaculos(){
			try {
			dtPla = new DtPlataforma("nombrePlataformaEspectaculo2", "descripcionPlataformaEspectaculo2", "urlPlataformaEspectaculo2");
			iconPlataforma.altaPlataforma(dtPla);
					
			dtArt = new DtArtista("nicknameArtistaEspectaculo2", "nombreArtistaEspectaculo2", "apellidoArtistaEspectaculo2", "email@ArtistaEspectaculo2", new Date(), "contraseniaArtistaEspectaculo2", null,null,null,
				"descripcionArtistaEspectaculo2", "biografiaArtistaEspectaculo2", "linkArtistaEspectaculo2");
			iconUsuario.altaUsuario(dtArt);
			
			dtEsp = new DtEspectaculo(dtArt.getNickname(), dtPla.getNombre(), "nombreEspectaculoEspectaculo2", "descripcionEspectaculoEspectaculo2", 58, 50, 200, "urlEspectaculoEspectaculo2", 150, new Date());
			iconEspectaculo.altaEspectaculo(dtEsp, dtPla.getNombre());
			
			DtEspectaculo dtEsp1 = new DtEspectaculo(dtArt.getNickname(), dtPla.getNombre(), "nombreEspectaculoEspectaculo3", "descripcionEspectaculoEspectaculo3", 58, 50, 200, "urlEspectaculoEspectaculo3", 150, new Date());
			iconEspectaculo.altaEspectaculo(dtEsp1, dtPla.getNombre());
			
			DtEspectaculo dtEsp2 = new DtEspectaculo(dtArt.getNickname(), dtPla.getNombre(), "nombreEspectaculoEspectaculo4", "descripcionEspectaculoEspectaculo4", 58, 50, 200, "urlEspectaculoEspectaculo4", 150, new Date());
			iconEspectaculo.altaEspectaculo(dtEsp2, dtPla.getNombre());
			
			int largoEspPlat = iconEspectaculo.listarEspectaculos(dtPla.getNombre()).size();
			int largoEspArt = iconEspectaculo.obtenerAllDtEspectaculos(dtArt.getNickname()).size();

			assertTrue((largoEspArt == 3) && (largoEspPlat == 3));
			}catch(Exception e) {
				e.printStackTrace();
				assertTrue(false);
			}
	}
	
}

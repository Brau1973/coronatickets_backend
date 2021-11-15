package test;


import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import datatypes.DtArtista;
import datatypes.DtEspectaculo;
import datatypes.DtEspectador;
import datatypes.DtFuncion;
import datatypes.DtPaqueteEspectaculo;
import datatypes.DtPlataforma;
import datatypes.DtRegistro;
import interfaces.Fabrica;
import interfaces.IControladorEspectaculo;
import interfaces.IControladorFuncion;
import interfaces.IControladorPaquete;
import interfaces.IControladorPlataforma;
import interfaces.IControladorRegistro;
import interfaces.IControladorUsuario;
import logica.Espectaculo;
import logica.PaqueteEspectaculos;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DPaqueteTest {

	IControladorPlataforma iconPlataforma = Fabrica.getInstancia().getIControladorPlataforma();
	DtPlataforma dtPla;
	IControladorPaquete iconPaquete = Fabrica.getInstancia().getIControladorPaquete();
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
	public void altaPaquete(){
		
			try {
			dtPla = new DtPlataforma("nombrePlataformaPaquete", "descripcionPlataformaPaquete", "urlPlataformaPaquete");
			iconPlataforma.altaPlataforma(dtPla);
					
			dtArt = new DtArtista("nicknameArtistaPaquete", "nombreArtistaPaquete", "apellidoArtistaPaquete", "email@ArtistaPaquete", new Date(), "contraseniaArtistaPaquete", null,null,null,
				"descripcionArtistaPaquete", "biografiaArtistaPaquete", "linkArtistaPaquete");
			iconUsuario.altaUsuario(dtArt);
			
			DtEspectaculo dtEsp = new DtEspectaculo(dtArt.getNickname(), dtPla.getNombre(), "nombreEspectaculoPaquete1", "descripcionEspectaculoPaquete", 58, 50, 200, "urlEspectaculoPaquete", 150, new Date());
			iconEspectaculo.altaEspectaculo(dtEsp, dtPla.getNombre());
			
			DtEspectaculo dtEsp1 = new DtEspectaculo(dtArt.getNickname(), dtPla.getNombre(), "nombreEspectaculoPaquete2", "descripcionEspectaculoPaquete1", 58, 50, 200, "urlEspectaculoPaquete1", 150, new Date());
			iconEspectaculo.altaEspectaculo(dtEsp1, dtPla.getNombre());
			
			DtEspectaculo dtEsp2 = new DtEspectaculo(dtArt.getNickname(), dtPla.getNombre(), "nombreEspectaculoPaquete3", "descripcionEspectaculoPaquete2", 58, 50, 200, "urlEspectaculoPaquete2", 150, new Date());
			iconEspectaculo.altaEspectaculo(dtEsp2, dtPla.getNombre());
			
			PaqueteEspectaculos dtPaque = new PaqueteEspectaculos("nombrePaquete", "DescripcionPaquete", new Date(), new Date(), new Date(), 50);
			iconPaquete.altaPaquete(dtPaque);
			
			iconPaquete.agregarEspectaculo(dtPaque.getNombre(), dtEsp.getNombre());
			iconPaquete.agregarEspectaculo(dtPaque.getNombre(), dtEsp1.getNombre());
			iconPaquete.agregarEspectaculo(dtPaque.getNombre(), dtEsp2.getNombre());
			
			Optional<DtPaqueteEspectaculo> opDtPaque = iconPaquete.obtenerPaquetes().stream().filter(p -> (p.getNombre().equals(dtPaque.getNombre()))).findFirst();			
			if(opDtPaque.isPresent()) {
				DtPaqueteEspectaculo dtPEsp = opDtPaque.get();
				if(!dtPEsp.getEspectaculos().isEmpty()) {
				List<String> listastr = dtPEsp.getEspectaculos().stream().map(DtEspectaculo::getNombre).collect(Collectors.toList());
				assertTrue(
						((listastr.stream().anyMatch(a -> (a == dtEsp.getNombre())))&& 
						(listastr.stream().anyMatch(a -> (a == dtEsp1.getNombre())))&& 
						(listastr.stream().anyMatch(a -> (a == dtEsp2.getNombre()))))	
						);
				}else {
					fail("Fallo al obtener los espectaculos");
				}
			}else {
				fail("No se encontro el Paquete");
			}
			
			}catch(Exception e) {
				e.printStackTrace();
				assertTrue(false);
			}
	}
	
//	@Order(12)
//	@Test
//	public void altaEspectaculo(){
//			try {
//			dtPla = new DtPlataforma("nombrePlataformaEspectaculo", "descripcionPlataformaEspectaculo", "urlPlataformaEspectaculo");
//			iconPlataforma.altaPlataforma(dtPla);
//					
//			dtArt = new DtArtista("nicknameArtistaEspectaculo", "nombreArtistaEspectaculo", "apellidoArtistaEspectaculo", "email@ArtistaEspectaculo", new Date(), "contraseniaArtistaEspectaculo", null,null,null,
//				"descripcionArtistaEspectaculo", "biografiaArtistaEspectaculo", "linkArtistaEspectaculo");
//			iconUsuario.altaUsuario(dtArt);
//			
//			dtEsp = new DtEspectaculo(dtArt.getNickname(), dtPla.getNombre(), "nombreEspectaculoEspectaculo", "descripcionEspectaculoEspectaculo", 58, 50, 200, "urlEspectaculoEspectaculo", 150, new Date());
//			iconEspectaculo.altaEspectaculo(dtEsp, dtPla.getNombre());
//			
//			Espectaculo dtEspectac = iconEspectaculo.obtenerEspectaculo(dtEsp.getNombre());
//
//			assertTrue(dtEspectac != null);
//			}catch(Exception e) {
//				e.printStackTrace();
//				assertTrue(false);
//			}
//	}
	
}

package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;


import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.xml.transform.OutputKeys;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;

import datatypes.DtArtista;
import datatypes.DtEspectador;
import datatypes.DtPlataforma;
import datatypes.DtUsuario;
import excepciones.PlataformaRepetidaExcepcion;
import excepciones.UsuarioRepetidoExcepcion;
import interfaces.Fabrica;
import interfaces.IControladorPlataforma;
import interfaces.IControladorUsuario;
import logica.Plataforma;
import logica.Usuario;
@TestMethodOrder(OrderAnnotation.class)
public class UsuarioTest {

	IControladorUsuario iconUsuario = Fabrica.getInstancia().getIControladorUsuario();
	DtEspectador dte;
	DtArtista dta;
	DtUsuario dtu;
	
	@Test
	@Order(4)
	
	
	public void altaUsuarioTest() throws UsuarioRepetidoExcepcion{
		
		dtu = new DtUsuario("nicknameUsuario", "nombreUsuario", "apellidoUsuario", "email@Usuario", new Date(), null,null,"contraseniaUsuario", null);
		iconUsuario.altaUsuario(dtu);
		
		
	
}
	@Test
	public void altaEspectadorTest() throws UsuarioRepetidoExcepcion{
			
			dte = new DtEspectador("nicknameEspectador", "nombreEspectador", "apellidoEspectador", "email@Espectador", new Date(), "contraseniaEspectador", null, null, null);
			iconUsuario.altaDtEspectador(dte);
			Usuario dtBd = iconUsuario.obtenerUsuario(dte.getNickname());
			assertEquals(dte.getNickname(),dtBd.getNickname());
		
	}
	@Test
	@Order(5)
	public void altaArtistaTest() throws UsuarioRepetidoExcepcion{
		
			dta = new DtArtista("nicknameArtista", "nombreArtista", "apellidoArtista", "email@Artista", new Date(), "contraseniaArtista", null, null, null, "descripcionArtista", "biografiaArtista", "linkArtista");
			iconUsuario.altaDtArtista(dta);
			Usuario dtBd = iconUsuario.obtenerUsuario(dta.getNickname());
			Usuario dtBdu = iconUsuario.obtenerArtista(dta.getNickname());
			iconUsuario.modificarUsuario(dtBdu);
			assertEquals(dta.getNickname(),dtBd.getNickname());
			assertEquals(dta.getNickname(),dtBdu.getNickname());
		
	}
	@Test
	@Order(6)
	public void listarNicknameArtistasTest() {

			List<String> listaArt = iconUsuario.listarNicknameArtistas();
			assertTrue(
			listaArt.stream().anyMatch(a ->  (a == "nicknameArtista"))
			
			);
	
			
		
	}
	@Test
	@Order(7)
	public void listarNicknameEspectadoresTest() {

			List<String> listaEsp = iconUsuario.listarNicknameEspectadores();
			assertTrue(
			listaEsp.stream().anyMatch(e ->  (e == "nicknameEspectador"))
			
			);
	
			
		
	}
	@Test
	@Order(8)
	public void listarNicknameUsuariosTest() {

			List<String> listaUser = iconUsuario.listarNicknameUsuarios();
			assertTrue(
			listaUser.stream().anyMatch(u ->  (u == "nicknameEspectador")) ||listaUser.stream().anyMatch(a ->  (a == "nicknameArtista"))
			
			);
	
			
		
	}
	@Test
	@Order(9)
	public void seguirUsuarioTest() throws UsuarioRepetidoExcepcion {


		dte = new DtEspectador("nicknameEspectador2", "nombreEspectador2", "apellidoEspectador2", "email@Espectador2", new Date(), "contraseniaEspectador2", null, null, null);
		iconUsuario.altaDtEspectador(dte);
		dta = new DtArtista("nicknameArtista2", "nombreArtista2", "apellidoArtista2", "email@Artista2", new Date(), "contraseniaArtista2", null, null, null, "descripcionArtista2", "biografiaArtista2", "linkArtista2");
		iconUsuario.altaDtArtista(dta);
		
		iconUsuario.seguirUsuario(dte.getNickname(), dta.getNickname());
		List<String> listaSeguidos = iconUsuario.listarNicknameUsuariosSeguidos(dta.getNickname());
		iconUsuario.dejarDeSeguirUsuario(dte.getNickname(), dta.getNickname());	
		List<String> listaNoSeguidos = iconUsuario.listarNicknameUsuariosNoSeguidos(dta.getNickname());
//		
	}
	@Test
	public void loginTest() throws UsuarioRepetidoExcepcion {


		dte = new DtEspectador("nicknameEspectador3", "nombreEspectador3", "apellidoEspectador3", "email@Espectador3", new Date(), "contraseniaEspectador3", null, null, null);
		iconUsuario.altaDtEspectador(dte);
		iconUsuario.getLoginUsuario(dte.getNickname());
		iconUsuario.getLoginUsuarioMail(dte.getEmail());
	}
	
	
//	@Test(expected = UsuarioRepetidoExcepcion.class)
//	@Order(9)
//	public void usuarioRepetidoTest() throws UsuarioRepetidoExcepcion {
//		dtu = new DtEspectador("nicknameEspectador2", "nombreEspectador2", "apellidoEspectador2", "email@Espectador", new Date(), "contraseniaEspectador2", null, null, null);
//		iconUsuario.altaUsuario(dtu);
//		iconUsuario.altaUsuario(dtu);
//
//			
//	}
	
}

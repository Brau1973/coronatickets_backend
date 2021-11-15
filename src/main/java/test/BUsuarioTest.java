package test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import datatypes.DtArtista;
import datatypes.DtEspectador;
import datatypes.DtUsuario;
import excepciones.UsuarioRepetidoExcepcion;
import interfaces.Fabrica;
import interfaces.IControladorUsuario;
import logica.Usuario;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BUsuarioTest {

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
	@Order(5)
	public void altaEspectadorTest() throws UsuarioRepetidoExcepcion{
			
			dte = new DtEspectador("nicknameEspectador", "nombreEspectador", "apellidoEspectador", "email@Espectador", new Date(), "contraseniaEspectador", null, null, null);
			iconUsuario.altaDtEspectador(dte);
			Usuario dtBd = iconUsuario.obtenerUsuario(dte.getNickname());
			assertEquals(dte.getNickname(),dtBd.getNickname());
		
	}
	@Test
	@Order(6)
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
	@Order(7)
	public void listarNicknameArtistasTest() {

			List<String> listaArt = iconUsuario.listarNicknameArtistas();
			assertTrue(
			listaArt.stream().anyMatch(a ->  (a == "nicknameArtista"))
			
			);
	}
	
	@Test
	@Order(8)
	public void listarNicknameEspectadoresTest() {

			List<String> listaEsp = iconUsuario.listarNicknameEspectadores();
			assertTrue(
			listaEsp.stream().anyMatch(e ->  (e == "nicknameEspectador"))
			
			);
	}
	
	@Test
	@Order(9)
	public void listarNicknameUsuariosTest() {

			List<String> listaUser = iconUsuario.listarNicknameUsuarios();
			assertTrue(
			listaUser.stream().anyMatch(u ->  (u == "nicknameEspectador")) ||listaUser.stream().anyMatch(a ->  (a == "nicknameArtista"))
			
			);
	}
	
	@Test
	@Order(10)	
	public void seguirUsuarioTest() throws UsuarioRepetidoExcepcion {
		dte = new DtEspectador("nicknameEspectador2", "nombreEspectador2", "apellidoEspectador2", "email@Espectador2", new Date(), "contraseniaEspectador2", null, null, null);
		iconUsuario.altaDtEspectador(dte);
		dta = new DtArtista("nicknameArtista2", "nombreArtista2", "apellidoArtista2", "email@Artista2", new Date(), "contraseniaArtista2", null, null, null, "descripcionArtista2", "biografiaArtista2", "linkArtista2");
		iconUsuario.altaDtArtista(dta);
		
		iconUsuario.seguirUsuario(dte.getNickname(), dta.getNickname());
		List<String> listaSeguidos = iconUsuario.listarNicknameUsuariosSeguidos(dta.getNickname());
		
		List<String> lstSeguidos = iconUsuario.listarNicknameUsuariosSeguidos(dte.getNickname());
		String nicknameSeguido = lstSeguidos.get(0);
		
		iconUsuario.dejarDeSeguirUsuario(dte.getNickname(), dta.getNickname());	
		List<String> listaNoSeguidos = iconUsuario.listarNicknameUsuariosSeguidos(dte.getNickname());
		
		assertTrue(nicknameSeguido.equals(dta.getNickname()) && listaNoSeguidos.isEmpty());
	}
	
	
	@Test
	@Order(11)
	public void loginTest() throws UsuarioRepetidoExcepcion {

		dte = new DtEspectador("nicknameEspectadorLogin", "nombreEspectadorLogin", "apellidoEspectadorLogin", "email@EspectadorLogin", new Date(), "contraseniaEspectadorLogin", null, null, null);
		iconUsuario.altaDtEspectador(dte);
		DtUsuario dtUsuario =  iconUsuario.getLoginUsuario(dte.getNickname());
		boolean loginOK = dtUsuario.getNickname().equals(dte.getNickname());
		boolean emailRepetido = iconUsuario.emailRepetido(dte.getEmail());
		assertTrue(emailRepetido && loginOK);
	}
	
	
//	@Test()
//	@Order(12)
//	public void usuarioRepetidoTest() throws UsuarioRepetidoExcepcion {
//		dtu = new DtEspectador("nicknameEspectador2", "nombreEspectador2", "apellidoEspectador2", "email@Espectador", new Date(), "contraseniaEspectador2", null, null, null);
//		iconUsuario.altaUsuario(dtu);
//		iconUsuario.altaUsuario(dtu);
//
//			
//	}
	
}

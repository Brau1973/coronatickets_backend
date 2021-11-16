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
import logica.Plataforma;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ERegistroTest {

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
	public void altaRegistro() {
		try {
			dtPla = new DtPlataforma("nombrePlataforma", "descripcionPlataforma", "urlPlataforma");
			iconPlataforma.altaPlataforma(dtPla);

			dtArt = new DtArtista("nicknameArtistaRegistro", "nombreArtistaRegistro", "apellidoArtistaRegistro", "email@ArtistaRegistro", new Date(), null, null, "contraseniaArtistaRegistro", null, "descripcionArtistaRegistro", "biografiaArtistaRegistro", "linkArtistaRegistro");
			iconUsuario.altaDtArtista(dtArt);

			dtEspectador = new DtEspectador("nicknameEspectadorRegistro", "nombreEspectadorRegistro", "apellidoEspectadorRegistro", "email@EspectadorRegistro", new Date(),null, null, "contraseniaEspectadorRegistro", null);
			iconUsuario.altaUsuario(dtEspectador);

			dtEsp = new DtEspectaculo(dtArt.getNickname(), dtPla.getNombre(), "nombreEspectaculoRegistro", "descripcionEspectaculoRegistro", 58, 50, 200, "urlEspectaculoRegistro", 150, new Date());
			iconEspectaculo.altaEspectaculo(dtEsp, dtPla.getNombre());

			dtFunc = new DtFuncion("nombreFuncionRegistro", new Date(), new Time(02, 05, 55), new Date(), new ArrayList<String>());
			iconFuncion.altaFuncion(dtFunc, dtEsp.getNombre(), null);

			dtReg = new DtRegistro(dtFunc.getNombre(), new Date(), 150);
			iconRegistro.altaRegistro(dtReg, dtEspectador.getNickname());

			assertTrue(true);
			//TODO
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(false);
		}
	}

}

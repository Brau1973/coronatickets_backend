package presentacion;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import interfaces.Fabrica;
import interfaces.IControladorEspectaculo;
import interfaces.IControladorFuncion;
import interfaces.IControladorPaquete;
import interfaces.IControladorPlataforma;
import interfaces.IControladorUsuario;
import publicadores.ControladorPlataformaPublish;
import publicadores.ControladorUsuarioPublish;
import publicadores.ControladorEspectaculoPublish;
import publicadores.ControladorFuncionPublish;
import publicadores.ControladorPaquetePublish;

@SuppressWarnings("serial")
public class FrmPrincipal extends JFrame implements ActionListener {
	private Container contenedor;
	private JMenuBar barraMenu;
	private JMenu menuInicio, menuUsuario, menuEspectaculo, menuAyuda, menuPlataforma, menuFuncion, menuPaquete;
	private JMenuItem menuItAltaUsuario, menuItModificarDatosUsuario, menuItConsultaUsuario, menuItAltaEspectaculo, menuItConsultaEspectaculo;
	private JMenuItem menuItConsultaPaqueteEspectaculo, menuItCreaPaqueteEspectaculo, menuItAltaPlataforma, menuItAltaFuncion, menuItConsultaFuncion, menuItRegistroFuncion;
	private JMenuItem menuItAgregarEspectaculoAPaquete;

	private AltaUsuario internalFrameAltaUsuario;
	private ConsultarUsuario internalFrameConsultaUsuario;
	private ModificarDatosUsuario internalFrameModificarDatosUsuario;
	private AltaEspectaculo internalFrameAltaEspectaculo;
	private ConsultaEspectaculo internalFrameConsultaEspectaculo;
	private ConsultaPaqueteEspectaculos internalFrameConsultaPaqueteEspectaculo;
	private AltaPlataforma internalFrameAltaPlataforma;
	private AltaFuncion internalFrameAltaFuncion;
	private ConsultaFuncion internalFrameConsultaFuncion;
	private RegistroFuncion internalFrameRegistroFuncion;
	private CreaPaqueteEspectaculo internalFrameCreaPaqueteEspectaculo;
	private AgregarEspectaculoAPaquete internalFrameAgregarEspectaculoAPaquete;
    
	private Fabrica fabrica = Fabrica.getInstancia();
	private IControladorPlataforma iconP;
	private IControladorUsuario iconU;
	private IControladorFuncion iconF;
	private IControladorEspectaculo iconE;
	private IControladorPaquete iconPE;
	
	// Constructor
	public FrmPrincipal() {
		ControladorPlataformaPublish cp = new ControladorPlataformaPublish();
		cp.publicar();
		iconP = fabrica.getIControladorPlataforma();
		
		ControladorFuncionPublish cf = new ControladorFuncionPublish();
		cf.publicar();
		iconF = fabrica.getIControladorFuncion();
		
		ControladorUsuarioPublish cu = new ControladorUsuarioPublish();
		cu.publicar();
		iconU = fabrica.getIControladorUsuario();
		
		ControladorEspectaculoPublish ce = new ControladorEspectaculoPublish();
		ce.publicar();
		iconE = fabrica.getIControladorEspectaculo();
		
		
		ControladorPaquetePublish cpa = new ControladorPaquetePublish();
		cpa.publicar();
		iconPE = fabrica.getIControladorPaquete();
		
		
		inicializar();
		setTitle("coronaTickets.uy");
		setSize(800, 750);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void inicializar() {
		contenedor = getContentPane();
		contenedor.setLayout(null);
		// JMenu
		menuInicio = new JMenu();
		menuUsuario = new JMenu();
		menuEspectaculo = new JMenu();
		menuPlataforma = new JMenu();
		menuPaquete = new JMenu("Paquete");
		menuFuncion = new JMenu();
		menuAyuda = new JMenu();
		menuInicio.setText("Inicio");
		menuUsuario.setText("Usuario");
		menuEspectaculo.setText("Espectaculo");
		menuPlataforma.setText("Plataforma");
		menuFuncion.setText("Funciones");
		menuAyuda.setText("Ayuda");
		barraMenu = new JMenuBar();
		barraMenu.add(menuInicio);
		barraMenu.add(menuUsuario);
		barraMenu.add(menuEspectaculo);
		barraMenu.add(menuPlataforma);
		barraMenu.add(menuFuncion);
		barraMenu.add(menuPaquete);
		barraMenu.add(menuAyuda);
		setJMenuBar(barraMenu);

		// MenuItem
		menuItAltaUsuario = new JMenuItem();
		menuItConsultaUsuario = new JMenuItem();
		menuItModificarDatosUsuario = new JMenuItem();
		menuItAltaEspectaculo = new JMenuItem();
		menuItConsultaEspectaculo = new JMenuItem();
		menuItAltaPlataforma = new JMenuItem();
		menuItAltaFuncion = new JMenuItem();
		menuItConsultaFuncion = new JMenuItem();
		menuItRegistroFuncion = new JMenuItem();
		menuItCreaPaqueteEspectaculo = new JMenuItem();
		menuItConsultaPaqueteEspectaculo = new JMenuItem();
		menuItAgregarEspectaculoAPaquete = new JMenuItem();

		// Menu Item Usuario
		menuItAltaUsuario.setText("Alta de Usuario");
		menuItConsultaUsuario.setText("Consulta de Usuario");
		menuItModificarDatosUsuario.setText("Modificar Datos de Usuario");
		menuUsuario.add(menuItAltaUsuario);
		menuUsuario.addSeparator();
		menuUsuario.add(menuItConsultaUsuario);
		menuUsuario.addSeparator();
		menuUsuario.add(menuItModificarDatosUsuario);
		menuItAltaUsuario.addActionListener(this);
		menuItConsultaUsuario.addActionListener(this);
		menuItModificarDatosUsuario.addActionListener(this);

		// Menu Item Espectaculo
		menuItAltaEspectaculo.setText("Alta de Espectaculo");
		menuItConsultaEspectaculo.setText("Consulta de Espectaculo");
		menuEspectaculo.add(menuItAltaEspectaculo);
		menuEspectaculo.addSeparator();
		menuEspectaculo.add(menuItConsultaEspectaculo);
		menuItAltaEspectaculo.addActionListener(this);
		menuItConsultaEspectaculo.addActionListener(this);

		// Menu Item Plataforma
		menuItAltaPlataforma.setText("Alta de Plataforma");
		menuPlataforma.add(menuItAltaPlataforma);
		menuItAltaPlataforma.addActionListener(this);

		// Menu Paquete
		menuItCreaPaqueteEspectaculo.setText("Crear Paquete de Espectaculo");
		menuItConsultaPaqueteEspectaculo.setText("Consultar Paquete de Espectaculo");
		menuPaquete.add(menuItCreaPaqueteEspectaculo);
		menuPaquete.addSeparator();
		menuItConsultaPaqueteEspectaculo = new JMenuItem("Consulta de Paquete de Espectaculos");

		menuItAgregarEspectaculoAPaquete.setText("Agregar Espectaculo a Paquete");
		menuPaquete.add(menuItAgregarEspectaculoAPaquete);
		menuPaquete.addSeparator();
		menuPaquete.add(menuItConsultaPaqueteEspectaculo);
		menuItCreaPaqueteEspectaculo.addActionListener(this);
		menuItConsultaPaqueteEspectaculo.addActionListener(this);
		menuItAgregarEspectaculoAPaquete.addActionListener(this);

		// Menu Item Funcion
		menuItAltaFuncion.setText("Alta de Funcion de Espectaculo");
		menuFuncion.add(menuItAltaFuncion);
		menuItAltaFuncion.addActionListener(this);
		menuFuncion.addSeparator();
		menuItConsultaFuncion.setText("Consulta de Funcion de Espectaculo");
		menuFuncion.add(menuItConsultaFuncion);
		menuItConsultaFuncion.addActionListener(this);
		menuFuncion.addSeparator();
		menuItRegistroFuncion.setText("Registro a Funcion de Espectaculo");
		menuFuncion.add(menuItRegistroFuncion);
		menuItRegistroFuncion.addActionListener(this);

		// Casos de uso
		inFrmAltaUsuario();
		inFrmConsultaUsuario();
		inFrmModificarDatosUsuario();
		inFrmAltaEspectaculo();
		inFrmConsultaEspectaculo();
		inFrmAltaPlataforma();
		inFrmAltaFuncion();
		inFrmConsultaFuncion();
		inFrmRegistroFuncion();
		inFrmConsultaPaqueteEspectaculos();
		inFrmCreaPaqueteEspectaculo();
		inFrmAgregarEspectaculoAPaquete();
	}

	// InternalFrame Alta Usuario
	private void inFrmAltaUsuario() {
		internalFrameAltaUsuario = new AltaUsuario(iconU);
		internalFrameAltaUsuario.setVisible(false);
		contenedor.add(internalFrameAltaUsuario);
	}

	// InternalFrame Consulta Usuario
	private void inFrmConsultaUsuario() {
		internalFrameConsultaUsuario = new ConsultarUsuario(iconU);
		internalFrameConsultaUsuario.setVisible(false);
		contenedor.add(internalFrameConsultaUsuario);
	}

	// InternalFrame Modificar Datos Usuario
	private void inFrmModificarDatosUsuario() {
		internalFrameModificarDatosUsuario = new ModificarDatosUsuario(iconU);
		internalFrameModificarDatosUsuario.setVisible(false);
		contenedor.add(internalFrameModificarDatosUsuario);
	}

	// InternalFrame Alta de Espectaculo // 79S
	private void inFrmAltaEspectaculo() {
		internalFrameAltaEspectaculo = new AltaEspectaculo(iconE);
		internalFrameAltaEspectaculo.setVisible(false);
		contenedor.add(internalFrameAltaEspectaculo);
	}

	// InternalFrame Consulta Espectaculo
	private void inFrmConsultaEspectaculo() {
		internalFrameConsultaEspectaculo = new ConsultaEspectaculo();
		internalFrameConsultaEspectaculo.setVisible(false);
		contenedor.add(internalFrameConsultaEspectaculo);
	}

	// InternalFrame Crear Paquete de espectaculo
	private void inFrmCreaPaqueteEspectaculo() {
		internalFrameCreaPaqueteEspectaculo = new CreaPaqueteEspectaculo();
		internalFrameCreaPaqueteEspectaculo.setVisible(false);
		contenedor.add(internalFrameCreaPaqueteEspectaculo);
	}

	// InternalFrame Consultar Paquete de espectaculo
	private void inFrmConsultaPaqueteEspectaculos() {
		internalFrameConsultaPaqueteEspectaculo = new ConsultaPaqueteEspectaculos();
		internalFrameConsultaPaqueteEspectaculo.setVisible(false);
		contenedor.add(internalFrameConsultaPaqueteEspectaculo);
	}

	// InternalFrame Alta Plataforma
	private void inFrmAltaPlataforma() {
		internalFrameAltaPlataforma = new AltaPlataforma(iconP);
		internalFrameAltaPlataforma.setVisible(false);
		contenedor.add(internalFrameAltaPlataforma);
	}

	// InternalFrame Alta Funcion
	private void inFrmAltaFuncion() {
		internalFrameAltaFuncion = new AltaFuncion(iconF);
		internalFrameAltaFuncion.setVisible(false);
		contenedor.add(internalFrameAltaFuncion);
	}

	// InternalFrame Consulta Funcion
	private void inFrmConsultaFuncion() {
		internalFrameConsultaFuncion = new ConsultaFuncion(iconF);
		internalFrameConsultaFuncion.setVisible(false);
		contenedor.add(internalFrameConsultaFuncion);
	}

	// InternalFrame Registro Funcion
	private void inFrmRegistroFuncion() {
		internalFrameRegistroFuncion = new RegistroFuncion();
		internalFrameRegistroFuncion.setVisible(false);
		contenedor.add(internalFrameRegistroFuncion);
	}

	// InternalFrame Agregar espectaculo a Paquete
	private void inFrmAgregarEspectaculoAPaquete() {
		internalFrameAgregarEspectaculoAPaquete = new AgregarEspectaculoAPaquete();
		internalFrameAgregarEspectaculoAPaquete.setVisible(false);
		contenedor.add(internalFrameAgregarEspectaculoAPaquete);
	}

	// Eventos
	public void actionPerformed(ActionEvent e) {
		internalFrameAltaUsuario.setVisible(false);
		internalFrameConsultaUsuario.setVisible(false);
		internalFrameModificarDatosUsuario.setVisible(false);
		internalFrameAltaEspectaculo.setVisible(false);
		internalFrameConsultaEspectaculo.setVisible(false);
		internalFrameAltaPlataforma.setVisible(false);
		internalFrameAltaFuncion.setVisible(false);
		internalFrameConsultaFuncion.setVisible(false);
		internalFrameRegistroFuncion.setVisible(false);
		internalFrameConsultaPaqueteEspectaculo.setVisible(false);
		internalFrameCreaPaqueteEspectaculo.setVisible(false);
		internalFrameAgregarEspectaculoAPaquete.setVisible(false);

		switch (e.getActionCommand()) {
		case "Alta de Usuario":
			internalFrameAltaUsuario.setVisible(true);
			break;
		case "Modificar Datos de Usuario":
			internalFrameModificarDatosUsuario.iniciarlizarComboBox();
			internalFrameModificarDatosUsuario.setVisible(true);
			break;
		case "Consulta de Usuario":
			internalFrameConsultaUsuario.iniciaComboBoxU();
			internalFrameConsultaUsuario.setVisible(true);
			break;
		case "Alta de Espectaculo":
			internalFrameAltaEspectaculo.iniciarlizarComboBox();
			internalFrameAltaEspectaculo.setVisible(true);
			break;
		case "Consulta de Espectaculo":
			internalFrameConsultaEspectaculo.iniciarlizarComboBox();
			internalFrameConsultaEspectaculo.limpiarFormulario();
			internalFrameConsultaEspectaculo.setVisible(true);
			break;
		case "Alta de Plataforma":
			internalFrameAltaPlataforma.setVisible(true);
			break;
		case "Alta de Funcion de Espectaculo":
			internalFrameAltaFuncion.limpiarListaArtistas();
			internalFrameAltaFuncion.iniciarlizarComboBox();
			internalFrameAltaFuncion.setVisible(true);
			break;
		case "Consulta de Funcion de Espectaculo":
			internalFrameConsultaFuncion.inicializarComboBox();
			internalFrameConsultaFuncion.limpiarFormulario();
			internalFrameConsultaFuncion.setVisible(true);
			break;
		case "Registro a Funcion de Espectaculo":
			internalFrameRegistroFuncion.iniciarlizarComboBox();
			internalFrameRegistroFuncion.setVisible(true);
			break;
		case "Crear Paquete de Espectaculo":
			internalFrameCreaPaqueteEspectaculo.setVisible(true);
			break;
		case "Consulta de Paquete de Espectaculos":
			internalFrameConsultaPaqueteEspectaculo.iniciarlizarComboBox();
			internalFrameConsultaPaqueteEspectaculo.setVisible(true);
			break;
		case "Agregar Espectaculo a Paquete":
			//System.out.println("menu agregar");
			/* iconU.seguirUsuario("Alexis Sanchez", "CR7"); iconU.seguirUsuario("CR7", "Alexis Sanchez"); */
			internalFrameAgregarEspectaculoAPaquete.iniciarlizarComboBox();
			internalFrameAgregarEspectaculoAPaquete.setVisible(true);
			break;
		default:
			break;
		}
	}
}

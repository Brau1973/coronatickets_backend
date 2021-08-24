package presentacion;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class FrmPrincipal extends JFrame implements ActionListener{ // Se cambia nombre de algunas variables, ej Registro por Alta. 79S
    private Container contenedor;
    private JMenuBar barraMenu;
    private JMenu menuInicio, menuUsuario, menuEspectaculo, menuAyuda, menuPlataforma, menuFuncion, menuPaquete;
    private JMenuItem menuItAltaUsuario, menuItModificarDatosUsuario, menuItConsultaUsuario, menuItAltaEspectaculo, menuItConsultaEspectaculo;
    private JMenuItem menuItConsultaPaqueteEspectaculo, menuItAltaPlataforma, menuItAltaFuncion, menuItConsultaFuncion, menuItRegistroFuncion;
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

    // Constructor
    public FrmPrincipal(){
	 inicializar();
	 setTitle("coronaTickets.uy");
	 setSize(800, 600);
	 setLocationRelativeTo(null);
	 setResizable(false);
	 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void inicializar(){
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
	 // Se realizan los cambios que hablamos en el menu. 79S
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

	 // Menu Item Usuario
	 menuItAltaUsuario.setText("Alta Usuario");
	 menuItConsultaUsuario.setText("Consultar Usuario");
	 menuItModificarDatosUsuario.setText("Modificar Datos Usuario");
	 menuUsuario.add(menuItAltaUsuario);
	 menuUsuario.addSeparator();
	 menuUsuario.add(menuItConsultaUsuario);
	 menuUsuario.addSeparator();
	 menuUsuario.add(menuItModificarDatosUsuario);
	 menuItAltaUsuario.addActionListener(this);
	 menuItConsultaUsuario.addActionListener(this);
	 menuItModificarDatosUsuario.addActionListener(this);

	 // Menu Item Espectaculo
	 menuItAltaEspectaculo.setText("Alta Espectaculo");
	 menuItConsultaEspectaculo.setText("Consultar Espectaculo");
	 menuEspectaculo.add(menuItAltaEspectaculo);
	 menuEspectaculo.addSeparator();
	 menuEspectaculo.add(menuItConsultaEspectaculo);
	 menuItAltaEspectaculo.addActionListener(this);
	 menuItConsultaEspectaculo.addActionListener(this);

	 // Menu Item Plataforma
	 menuItAltaPlataforma.setText("Alta Plataforma");
	 menuPlataforma.add(menuItAltaPlataforma);
	 menuItAltaPlataforma.addActionListener(this);

	 // Menu Paquete
	 menuItConsultaPaqueteEspectaculo = new JMenuItem("Consultar Paquete de Espectaculo");
	 menuPaquete.add(menuItConsultaPaqueteEspectaculo);
	 menuItConsultaPaqueteEspectaculo.addActionListener(this);

	 // Menu Item Funcion
	 menuItAltaFuncion.setText("Alta Funcion");
	 menuFuncion.add(menuItAltaFuncion);
	 menuItAltaFuncion.addActionListener(this);
	 menuItConsultaFuncion.setText("Consultar Funcion");
	 menuFuncion.add(menuItConsultaFuncion);
	 menuItConsultaFuncion.addActionListener(this);
	 menuItRegistroFuncion.setText("Registro Funcion"); // La funcion se registra en espectaculo, no seria mejor que este en el menuEspectaculo ??. 79S
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
    }

    // InternalFrame Alta Usuario
    private void inFrmAltaUsuario(){
	 internalFrameAltaUsuario = new AltaUsuario();
	 internalFrameAltaUsuario.setVisible(false);
	 contenedor.add(internalFrameAltaUsuario);
    }

    // InternalFrame Consulta Usuario
    private void inFrmConsultaUsuario(){
	 internalFrameConsultaUsuario = new ConsultarUsuario();
	 internalFrameConsultaUsuario.setVisible(false);
	 contenedor.add(internalFrameConsultaUsuario);
    }

    // InternalFrame Modificar Datos Usuario
    private void inFrmModificarDatosUsuario(){
	 internalFrameModificarDatosUsuario = new ModificarDatosUsuario();
	 internalFrameModificarDatosUsuario.setVisible(false);
	 contenedor.add(internalFrameModificarDatosUsuario);
    }

    // InternalFrame Alta Espectaculo
    private void inFrmAltaEspectaculo(){
	 internalFrameAltaEspectaculo = new AltaEspectaculo();
	 internalFrameAltaEspectaculo.setVisible(false);
	 contenedor.add(internalFrameAltaEspectaculo);
    }

    // InternalFrame Consulta Espectaculo
    private void inFrmConsultaEspectaculo(){
	 internalFrameConsultaEspectaculo = new ConsultaEspectaculo();
	 internalFrameConsultaEspectaculo.setVisible(false);
	 contenedor.add(internalFrameConsultaEspectaculo);
    }

    // InternalFrame Consultar Paquete de espectaculo
    private void inFrmConsultaPaqueteEspectaculos(){
	 internalFrameConsultaPaqueteEspectaculo = new ConsultaPaqueteEspectaculos();
	 internalFrameConsultaPaqueteEspectaculo.setVisible(false);
	 contenedor.add(internalFrameConsultaPaqueteEspectaculo);
    }

    // InternalFrame Alta Plataforma
    private void inFrmAltaPlataforma(){
	 internalFrameAltaPlataforma = new AltaPlataforma();
	 internalFrameAltaPlataforma.setVisible(false);
	 contenedor.add(internalFrameAltaPlataforma);
    }

    // InternalFrame Alta Funcion
    private void inFrmAltaFuncion(){
	 internalFrameAltaFuncion = new AltaFuncion();
	 internalFrameAltaFuncion.setVisible(false);
	 contenedor.add(internalFrameAltaFuncion);
    }

    // InternalFrame Consulta Funcion
    private void inFrmConsultaFuncion(){
	 internalFrameConsultaFuncion = new ConsultaFuncion();
	 internalFrameConsultaFuncion.setVisible(false);
	 contenedor.add(internalFrameConsultaFuncion);
    }

    // InternalFrame Registro Funcion
    private void inFrmRegistroFuncion(){
	 internalFrameRegistroFuncion = new RegistroFuncion();
	 internalFrameRegistroFuncion.setVisible(false);
	 contenedor.add(internalFrameRegistroFuncion);
    }

    // Eventos
    public void actionPerformed(ActionEvent e){
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

	 switch(e.getActionCommand()){
	 case "Alta Usuario":
	     internalFrameAltaUsuario.setVisible(true);
	     break;
	 case "Modificar Datos Usuario":
	     internalFrameModificarDatosUsuario.setVisible(true);
	     break;
	 case "Consultar Usuario":
	     internalFrameConsultaUsuario.setVisible(true);
	     break;
	 case "Alta Espectaculo":
	     internalFrameAltaEspectaculo.setVisible(true);
	     break;
	 case "Consultar Espectaculo":
	     internalFrameConsultaEspectaculo.setVisible(true);
	     break;
	 case "Alta Plataforma":
	     internalFrameAltaPlataforma.setVisible(true);
	     break;
	 case "Alta Funcion":
	     internalFrameAltaFuncion.setVisible(true);
	     break;
	 case "Consultar Funcion":
	     internalFrameConsultaFuncion.setVisible(true);
	     break;
	 case "Registro Funcion":
	     internalFrameRegistroFuncion.setVisible(true);
	     break;
	 case "Consultar Paquete de Espectaculo":
	     internalFrameConsultaPaqueteEspectaculo.setVisible(true);
	     break;
	 default:
	     break;
	 }
    }
}

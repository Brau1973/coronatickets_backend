package presentacion;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class FrmPrincipal extends JFrame implements ActionListener{ // Se cambia nombre de algunas variables, ej Registro por Alta. 79S
    private Container contenedor;
    private JMenuBar barraMenu;
    private JMenu menuInicio, menuUsuario, menuEspectaculo, menuAyuda, menuPlataforma, menuFuncion;
    private JMenuItem menuItAltaUsuario, menuItAltaEspectaculo, menuItConsultaUsuario, menuItConsultaEspectaculo, menuItAltaPlataforma, menuItAltaFuncion, menuItConsultaFuncion, menuItRegistroFuncion;
    private JInternalFrame internalFrameAltaPlataforma, internalFrameAltaFuncion, internalFrameConsultaFuncion, internalFrameRegistroFuncion;

    private AltaUsuario internalFrameAltaUsuario;
    private ConsultarUsuario internalFrameConsultaUsuario;
    private AltaEspectaculo internalFrameAltaEspectaculo;


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
	 barraMenu.add(menuAyuda);
	 setJMenuBar(barraMenu);

	 // MenuItem
	 menuItAltaUsuario = new JMenuItem();
	 menuItAltaEspectaculo = new JMenuItem();
	 menuItConsultaUsuario = new JMenuItem();
	 menuItConsultaEspectaculo = new JMenuItem();
	 menuItAltaPlataforma = new JMenuItem();
	 menuItAltaFuncion = new JMenuItem();
	 menuItConsultaFuncion = new JMenuItem();
	 menuItRegistroFuncion = new JMenuItem();

	 // Menu Item Usuario
	 menuItAltaUsuario.setText("Alta Usuario");
	 menuItConsultaUsuario.setText("Consultar Usuario");
	 menuUsuario.add(menuItAltaUsuario);
	 menuUsuario.addSeparator();
	 menuUsuario.add(menuItConsultaUsuario);
	 menuItAltaUsuario.addActionListener(this);
	 menuItConsultaUsuario.addActionListener(this);

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

	 // Menu Item Funcion
	 menuItAltaFuncion.setText("Alta Funcion");
	 menuFuncion.add(menuItAltaFuncion);
	 menuItAltaFuncion.addActionListener(this);
	 menuItConsultaFuncion.setText("Consulta Funcion");
	 menuFuncion.add(menuItConsultaFuncion);
	 menuItConsultaFuncion.addActionListener(this);
	 menuItRegistroFuncion.setText("Registro Funcion"); // La funcion se registra en espectaculo, no seria mejor que este en el menuEspectaculo ??. 79S
	 menuFuncion.add(menuItRegistroFuncion);
	 menuItRegistroFuncion.addActionListener(this);

	 // Casos de uso
	 inFrmAltaUsuario();
	 inFrmConsultaUsuario();
	 inFrmAltaEspectaculo();
	 // inFrmConsultaEspectaculo
	 inFrmAltaPlataforma();
	 inFrmAltaFuncion();
	 inFrmConsultaFuncion();
	 inFrmRegistroFuncion();
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

    // InternalFrame Alta Espectaculo
    private void inFrmAltaEspectaculo(){
	 internalFrameAltaEspectaculo = new AltaEspectaculo();
	 internalFrameAltaEspectaculo.setVisible(false);
	 contenedor.add(internalFrameAltaEspectaculo);
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
	 internalFrameAltaEspectaculo.setVisible(false);
	 internalFrameAltaPlataforma.setVisible(false);
	 internalFrameAltaFuncion.setVisible(false);
	 internalFrameConsultaFuncion.setVisible(false);
	 internalFrameRegistroFuncion.setVisible(false);

	 if(e.getSource() == menuItAltaUsuario){
	     internalFrameAltaUsuario.setVisible(true);
	 }
	 if(e.getSource() == menuItConsultaUsuario){
	     internalFrameConsultaUsuario.setVisible(true);
	 }

	 if(e.getSource() == menuItAltaEspectaculo){
	     internalFrameAltaEspectaculo.setVisible(true);
	 }
	 if(e.getSource() == menuItConsultaEspectaculo){
	     // internalFrameConsultaEspectaculo.setVisible(true);
	 }

	 if(e.getSource() == menuItAltaPlataforma){
	     internalFrameAltaPlataforma.setVisible(true);
	 }

	 if(e.getSource() == menuItAltaFuncion){
	     internalFrameAltaFuncion.setVisible(true);
	 }
	 if(e.getSource() == menuItConsultaFuncion){
	     internalFrameConsultaFuncion.setVisible(true);
	 }
	 if(e.getSource() == menuItRegistroFuncion){
	     internalFrameRegistroFuncion.setVisible(true);
	 }
    }
}

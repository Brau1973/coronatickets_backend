package presentacion;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

@SuppressWarnings("serial")
public class FrmPrincipal extends JFrame implements ActionListener{ // 19S
    private Container contenedor;
    private JMenuBar barraMenu;
    private JMenu menuInicio, menuRegristros, menuConsultas, menuAyuda, menuPlataforma, menuFuncion;
    private JMenuItem menuItAltaUsuario, menuItAltaEspectaculo, menuItConsultaUsuario, menuItConsultaEspectaculo, menuItAltaPlataforma, menuItAltaFuncion, menuItConsultaFuncion, menuItRegistroFuncion;
    private JInternalFrame inFrameEspectaculo, internalFrameAltaPlataforma, internalFrameAltaFuncion, internalFrameConsultaFuncion, internalFrameRegistroFuncion;

    private JPanel miPanel;
    private JLabel lblTitulo, lblNickname, lblNombre, lblApellido, lblEmail, lblfNacimiento;
    private JTextField txtNickname, txtNombre, txtApellido, txtEmail;
    private JSpinner spinDia, spinMes, spinAnio;
    private JButton btnAceptar, btnCancelar;
    private ConsultarUsuario internalFrameConsultaUsuario;// porque esta aparte??? aldrin
    private AltaUsuario internalFrameAltaUsuario;
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

	 // Menu
	 menuInicio = new JMenu();
	 menuRegristros = new JMenu();
	 menuConsultas = new JMenu();
	 menuPlataforma = new JMenu();
	 menuFuncion = new JMenu();
	 menuAyuda = new JMenu();

	 menuInicio.setText("Inicio");
	 menuRegristros.setText("Registros");
	 menuConsultas.setText("Consultas");
	 menuPlataforma.setText("Plataforma");
	 menuFuncion.setText("Funciones");
	 menuAyuda.setText("Ayuda");

	 barraMenu = new JMenuBar();
	 barraMenu.add(menuInicio);
	 barraMenu.add(menuRegristros);
	 barraMenu.add(menuConsultas);
	 barraMenu.add(menuPlataforma);
	 barraMenu.add(menuFuncion);
	 barraMenu.add(menuAyuda);
	 setJMenuBar(barraMenu);

	 // Menu Item
	 menuItAltaUsuario = new JMenuItem();
	 menuItAltaEspectaculo = new JMenuItem();
	 menuItConsultaUsuario = new JMenuItem();
	 menuItConsultaEspectaculo = new JMenuItem();
	 menuItAltaPlataforma = new JMenuItem();
	 menuItAltaFuncion = new JMenuItem();
	 menuItConsultaFuncion = new JMenuItem();
	 menuItRegistroFuncion = new JMenuItem();

	 // Menu Item Registrar
	 menuItAltaUsuario.setText("Registrar Usuario");
	 menuItAltaEspectaculo.setText("Registrar Espectaculo");
	 menuItAltaUsuario.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.CTRL_MASK));
	 menuItAltaEspectaculo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));

	 menuRegristros.add(menuItAltaUsuario);
	 menuRegristros.addSeparator();
	 menuRegristros.add(menuItAltaEspectaculo);

	 menuItAltaUsuario.addActionListener(this);
	 menuItAltaEspectaculo.addActionListener(this);

	 // Menu Item Consultar
	 menuItConsultaUsuario.setText("Consultar Usuario");
	 menuItConsultaEspectaculo.setText("Consultar Espectaculo");
	 menuItConsultaUsuario.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
	 menuItConsultaEspectaculo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
	 menuConsultas.add(menuItConsultaUsuario);
	 menuConsultas.addSeparator();
	 menuConsultas.add(menuItConsultaEspectaculo);
	 menuItConsultaUsuario.addActionListener(this);
	 menuItConsultaEspectaculo.addActionListener(this);

	 // Menu Plataforma
	 menuItAltaPlataforma.setText("Alta Plataforma");
	 menuPlataforma.add(menuItAltaPlataforma);
	 menuItAltaPlataforma.addActionListener(this);

	 // Menu Funcion
	 menuItAltaFuncion.setText("Alta Funcion");
	 menuFuncion.add(menuItAltaFuncion);
	 menuItAltaFuncion.addActionListener(this);

	 menuItConsultaFuncion.setText("Consulta Funcion");
	 menuFuncion.add(menuItConsultaFuncion);
	 menuItConsultaFuncion.addActionListener(this);

	 menuItRegistroFuncion.setText("Registro Funcion");
	 menuFuncion.add(menuItRegistroFuncion);
	 menuItRegistroFuncion.addActionListener(this);

	 // InternalFrame

	 inFrmAltaUsuario();
	 inFrmAltaEspectaculo();
	 inFrmConsultaUsuario();
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

    // InternalFrame Alta Espectaculo
    private void inFrmAltaEspectaculo(){
	 internalFrameAltaEspectaculo = new AltaEspectaculo();
	 internalFrameAltaEspectaculo.setVisible(false);
	 contenedor.add(internalFrameAltaEspectaculo);
    }

    private void inFrmConsultaUsuario(){
	 internalFrameConsultaUsuario = new ConsultarUsuario();
	 internalFrameConsultaUsuario.setVisible(false);
	 contenedor.add(internalFrameConsultaUsuario);
    }

    private void inFrmAltaPlataforma(){
	 internalFrameAltaPlataforma = new AltaPlataforma();
	 internalFrameAltaPlataforma.setVisible(false);
	 contenedor.add(internalFrameAltaPlataforma);

    }

    private void inFrmAltaFuncion(){
	 internalFrameAltaFuncion = new AltaFuncion();
	 internalFrameAltaFuncion.setVisible(false);
	 contenedor.add(internalFrameAltaFuncion);
    }

    private void inFrmConsultaFuncion(){
	 internalFrameConsultaFuncion = new ConsultaFuncion();
	 internalFrameConsultaFuncion.setVisible(false);
	 contenedor.add(internalFrameConsultaFuncion);
    }

    private void inFrmRegistroFuncion(){
	 internalFrameRegistroFuncion = new RegistroFuncion();
	 internalFrameRegistroFuncion.setVisible(false);
	 contenedor.add(internalFrameRegistroFuncion);
    }

    // Limpia Formulario
    private void limpiarPantalla(){
	 txtNickname.setText("");
	 txtNombre.setText("");
	 txtApellido.setText("");
	 txtEmail.setText("");
    }

    // Eventos
    public void actionPerformed(ActionEvent e){
	 // internalFrameEspectaculo.setVisible(false);
	 internalFrameConsultaUsuario.setVisible(false);
	 internalFrameAltaUsuario.setVisible(false);
	 internalFrameAltaPlataforma.setVisible(false);
	 internalFrameAltaFuncion.setVisible(false);

	 if(e.getSource() == menuItAltaUsuario){
	     internalFrameAltaUsuario.setVisible(true);
	 }
	 if(e.getSource() == menuItAltaEspectaculo){
	     // internalFrameEspectaculo.setVisible(true);
	 }

	 if(e.getSource() == menuItConsultaUsuario){
	     internalFrameConsultaUsuario.setVisible(true);
	 }

	 if(e.getSource() == btnAceptar){
	     limpiarPantalla();
	 }
	 // if(e.getSource() == btnCancelar){
	 // internalFrame.setVisible(false);
	 // internalFrameEspectaculo.setVisible(false);
	 // internalFrameConsultaUsuario.setVisible(false);
	 // }
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
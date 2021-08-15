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
public class FrmPrincipal extends JFrame implements ActionListener{
     private Container contenedor;
     private JMenuBar barraMenu;
     private JMenu menuInicio, menuRegristros, menuConsultas;
     private JMenuItem menuItAltaUsuario, menuItAltaEspectaculo, menuItConsultaUsuario, menuItConsultaEsp;
     String retorno = ""; // SGL
     // private JDesktopPane desktopPane;
     private JInternalFrame internalFrame, internalFrameEsp;
     private JPanel miPanel;
     private JLabel lblTitulo, lblNickname, lblNombre, lblApellido, lblEmail, lblfNacimiento;
     private JTextField txtNickname, txtNombre, txtApellido, txtEmail;
     private JButton btnAceptar, btnCancelar;
     private JSpinner spinDia, spinMes, spinAnio;
     private ConsultarUsuario inFrmConsultaUsuario;

     // Constructor
     public FrmPrincipal(){
	   inicializar();
	   setTitle("coronaTickets.uy");
	   setSize(530, 490);
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

	   menuInicio.setText("Inicio");
	   menuRegristros.setText("Registros");
	   menuConsultas.setText("Consultas");

	   barraMenu = new JMenuBar();
	   barraMenu.add(menuInicio);
	   barraMenu.add(menuRegristros);
	   barraMenu.add(menuConsultas);

	   // Menu Item
	   menuItAltaUsuario = new JMenuItem();
	   menuItAltaEspectaculo = new JMenuItem();
	   menuItConsultaUsuario = new JMenuItem();
	   menuItConsultaEsp = new JMenuItem();

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
	   menuItConsultaUsuario.setText("Consultar	 Usuario");
	   menuItConsultaEsp.setText("Consultar Espectaculo");
	   menuItConsultaUsuario.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
	   menuItConsultaEsp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
	   menuConsultas.add(menuItConsultaUsuario);
	   menuConsultas.addSeparator();
	   menuConsultas.add(menuItConsultaEsp);
	   menuItConsultaUsuario.addActionListener(this);
	   menuItConsultaEsp.addActionListener(this);

	   setJMenuBar(barraMenu);
	   inFrmRegistrarUsuario();
	   inFrmRegistrarEspectaculo();

	   // InternalFrame Consultar Usuario
	   inFrmConsultaUsuario = new ConsultarUsuario();
	   inFrmConsultaUsuario.setVisible(false);
	   contenedor.add(inFrmConsultaUsuario);
     }


     // InternalFrame Registrar Usuario
     private void inFrmRegistrarUsuario(){
	   miPanel = new JPanel();
	   miPanel.setLayout(null);

	   internalFrame = new JInternalFrame("Registrar Usuario");
	   internalFrame.add(miPanel);
	   internalFrame.setBounds(30, 30, 460, 500);
	   internalFrame.setResizable(false); // Permite redimencionar la ventana interna
	   internalFrame.setClosable(false);
	   internalFrame.setIconifiable(false);
	   internalFrame.setBorder(null);
	   ((javax.swing.plaf.basic.BasicInternalFrameUI) internalFrame.getUI()).setNorthPane(null);
	   contenedor.add(internalFrame);

	   lblTitulo = new JLabel();
	   lblNickname = new JLabel();
	   lblNombre = new JLabel();
	   lblApellido = new JLabel();
	   lblEmail = new JLabel();
	   lblfNacimiento = new JLabel();

	   lblTitulo.setText("Registrar Usuario");
	   lblNickname.setText("Nickname:");
	   lblNombre.setText("Nombre:");
	   lblApellido.setText("Apellido:");
	   lblEmail.setText("Email:");
	   lblfNacimiento.setText("Fecha nacimiento:");

	   lblTitulo.setFont(new java.awt.Font("Comic Sans MS", 1, 20));
	   lblNickname.setFont(new java.awt.Font("Verdana", 1, 12));
	   lblNombre.setFont(new java.awt.Font("Verdana", 1, 12));
	   lblApellido.setFont(new java.awt.Font("Verdana", 1, 12));
	   lblEmail.setFont(new java.awt.Font("Verdana", 1, 12));
	   lblfNacimiento.setFont(new java.awt.Font("Verdana", 1, 12));

	   lblTitulo.setBounds(10, 3, 280, 35);
	   lblNickname.setBounds(10, 70, 80, 25);
	   lblNombre.setBounds(10, 110, 80, 25);
	   lblApellido.setBounds(10, 150, 80, 25);
	   lblEmail.setBounds(10, 190, 80, 25);
	   lblfNacimiento.setBounds(10, 230, 150, 25);

	   miPanel.add(lblTitulo);
	   miPanel.add(lblNickname);
	   miPanel.add(lblNombre);
	   miPanel.add(lblApellido);
	   miPanel.add(lblEmail);
	   miPanel.add(lblfNacimiento);

	   txtNickname = new JTextField();
	   txtNombre = new JTextField();
	   txtApellido = new JTextField();
	   txtEmail = new JTextField();
	   spinDia = new JSpinner();
	   spinMes = new JSpinner();
	   spinAnio = new JSpinner();

	   txtNickname.setBounds(179, 68, 260, 25);
	   txtNombre.setBounds(179, 108, 260, 25);
	   txtApellido.setBounds(179, 148, 260, 25);
	   txtEmail.setBounds(179, 188, 260, 25);
	   spinDia.setBounds(179, 228, 45, 25);
	   spinMes.setBounds(239, 228, 45, 25);
	   spinAnio.setBounds(299, 228, 45, 25);

	   miPanel.add(txtNickname);
	   miPanel.add(txtNombre);
	   miPanel.add(txtApellido);
	   miPanel.add(txtEmail);
	   miPanel.add(spinDia);
	   miPanel.add(spinMes);
	   miPanel.add(spinAnio);

	   // Boton Aceptar
	   btnAceptar = new JButton();
	   btnAceptar.setText("Aceptar");
	   btnAceptar.setBounds(230, 330, 100, 23);
	   miPanel.add(btnAceptar);
	   btnAceptar.addActionListener(this);

	   // Boton Cancelar
	   btnCancelar = new JButton();
	   btnCancelar.setText("Cancelar");
	   btnCancelar.setBounds(337, 330, 100, 23);
	   miPanel.add(btnCancelar);
	   btnCancelar.addActionListener(this);
     }

     // InternalFrame Registrar Espectaculo
     private void inFrmRegistrarEspectaculo(){
	   JLabel lblArtista, lblPlataforma, lblNombre, lblDescripcion, lblDuracion;
	   miPanel = new JPanel();
	   miPanel.setLayout(null);

	   internalFrameEsp = new JInternalFrame("Registrar Espectaculo");
	   internalFrameEsp.add(miPanel);
	   internalFrameEsp.setBounds(30, 30, 460, 500);
	   internalFrameEsp.setResizable(false);
	   internalFrameEsp.setClosable(false);
	   internalFrameEsp.setIconifiable(false);
	   internalFrameEsp.setBorder(null);
	   ((javax.swing.plaf.basic.BasicInternalFrameUI) internalFrameEsp.getUI()).setNorthPane(null);
	   contenedor.add(internalFrameEsp);

	   lblTitulo = new JLabel();
	   lblArtista = new JLabel();
	   lblPlataforma = new JLabel();
	   lblNombre = new JLabel();
	   lblDescripcion = new JLabel();
	   lblDuracion = new JLabel();

	   lblTitulo.setText("Registrar Espectaculo");
	   lblArtista.setText("Artista:");
	   lblPlataforma.setText("Plataforma:");
	   lblNombre.setText("Nombre:");
	   lblDescripcion.setText("Descripcion:");
	   lblDuracion.setText("Duracion:");

	   lblTitulo.setFont(new java.awt.Font("Comic Sans MS", 1, 20));
	   lblArtista.setFont(new java.awt.Font("Verdana", 1, 12));
	   lblPlataforma.setFont(new java.awt.Font("Verdana", 1, 12));
	   lblNombre.setFont(new java.awt.Font("Verdana", 1, 12));
	   lblDescripcion.setFont(new java.awt.Font("Verdana", 1, 12));
	   lblDuracion.setFont(new java.awt.Font("Verdana", 1, 12));

	   lblTitulo.setBounds(10, 3, 350, 35);
	   lblArtista.setBounds(10, 70, 110, 25);
	   lblPlataforma.setBounds(10, 110, 110, 25);
	   lblNombre.setBounds(10, 150, 110, 25);
	   lblDescripcion.setBounds(10, 190, 110, 25);
	   lblDuracion.setBounds(10, 230, 150, 25);

	   miPanel.add(lblTitulo);
	   miPanel.add(lblArtista);
	   miPanel.add(lblPlataforma);
	   miPanel.add(lblNombre);
	   miPanel.add(lblDescripcion);
	   miPanel.add(lblDuracion);
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
	   if(e.getSource() == menuItAltaUsuario){
		 internalFrameEsp.setVisible(false);
		 inFrmConsultaUsuario.setVisible(false);
		 internalFrame.setVisible(true);
	   }
	   if(e.getSource() == menuItAltaEspectaculo){
		 internalFrame.setVisible(false);
		 inFrmConsultaUsuario.setVisible(false);
		 internalFrameEsp.setVisible(true);
	   }

	   if(e.getSource() == menuItConsultaUsuario){
		 internalFrame.setVisible(false);
		 internalFrameEsp.setVisible(false);
		 inFrmConsultaUsuario.setVisible(true);
	   }

	   if(e.getSource() == btnAceptar){
		 limpiarPantalla();
	   }
	   if(e.getSource() == btnCancelar){
		 internalFrame.setVisible(false);
		 internalFrameEsp.setVisible(false);
		 inFrmConsultaUsuario.setVisible(false);
	   }
     }
}


// if(e.getSource() == menuItAltaUsuario){
// if(internalFrameEsp.isVisible() == true){
// internalFrameEsp.setVisible(false);
// }
// internalFrame.setVisible(true);
// }
// retorno = "AltaUsuario";
// JOptionPane.showMessageDialog(null, retorno, "Informacion", JOptionPane.INFORMATION_MESSAGE);
// this.dispose();
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
     private JInternalFrame internalFrameAltaUsuario, internalFrameEspectaculo, internalFrameAltaPlataforma, internalFrameAltaFuncion, internalFrameConsultaFuncion, internalFrameRegistroFuncion;

     private JPanel miPanel;
     private JLabel lblTitulo, lblNickname, lblNombre, lblApellido, lblEmail, lblfNacimiento;
     private JTextField txtNickname, txtNombre, txtApellido, txtEmail;
     private JSpinner spinDia, spinMes, spinAnio;
     private JButton btnAceptar, btnCancelar;
     private ConsultarUsuario internalFrameConsultaUsuario;// porque esta aparte??? aldrin

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
	   inFrmRegistrarUsuario();
	   inFrmRegistrarEspectaculo();

	   inFrmConsultaUsuario();
	   inFrmAltaPlataforma();
	   inFrmAltaFuncion();
	   inFrmConsultaFuncion();
	   inFrmRegistroFuncion();
     }
     
     private void inFrmConsultaUsuario(){
	   internalFrameConsultaUsuario = new ConsultarUsuario();
	   internalFrameConsultaUsuario.setVisible(false);
	   contenedor.add(internalFrameConsultaUsuario);
     }
     
     private void inFrmAltaPlataforma() {
    	 internalFrameAltaPlataforma = new AltaPlataforma();
    	 internalFrameAltaPlataforma.setVisible(false);
	  	 contenedor.add(internalFrameAltaPlataforma);

     }
     private void inFrmAltaFuncion() {
    	 internalFrameAltaFuncion = new AltaFuncion();
    	 internalFrameAltaFuncion.setVisible(false);
	  	 contenedor.add(internalFrameAltaFuncion);

     }
     private void inFrmConsultaFuncion() {
    	 internalFrameConsultaFuncion = new ConsultaFuncion();
    	 internalFrameConsultaFuncion.setVisible(false);
	  	 contenedor.add(internalFrameConsultaFuncion);
    	 
     }
     private void inFrmRegistroFuncion() {
    	 internalFrameRegistroFuncion = new RegistroFuncion();
    	 internalFrameRegistroFuncion.setVisible(false);
	  	 contenedor.add(internalFrameRegistroFuncion);
     }
     // InternalFrame Registrar Usuario
     private void inFrmRegistrarUsuario(){
	   miPanel = new JPanel();
	   miPanel.setLayout(null);

	   internalFrameAltaUsuario = new JInternalFrame("Registrar Usuario");
	   internalFrameAltaUsuario.add(miPanel);
	   internalFrameAltaUsuario.setBounds(30, 15, 460, 500);
	   internalFrameAltaUsuario.setResizable(false);
	   internalFrameAltaUsuario.setClosable(false);
	   internalFrameAltaUsuario.setIconifiable(false);
	   internalFrameAltaUsuario.setBorder(null);
	   ((javax.swing.plaf.basic.BasicInternalFrameUI) internalFrameAltaUsuario.getUI()).setNorthPane(null);
	   contenedor.add(internalFrameAltaUsuario);

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
	   lblfNacimiento.setText("Fecha de nacimiento:");

	   lblTitulo.setFont(new java.awt.Font("Comic Sans MS", 1, 20));
	   lblNickname.setFont(new java.awt.Font("Verdana", 1, 12));
	   lblNombre.setFont(new java.awt.Font("Verdana", 1, 12));
	   lblApellido.setFont(new java.awt.Font("Verdana", 1, 12));
	   lblEmail.setFont(new java.awt.Font("Verdana", 1, 12));
	   lblfNacimiento.setFont(new java.awt.Font("Verdana", 1, 12));

	   lblTitulo.setBounds(10, 1, 280, 25);
	   lblNickname.setBounds(10, 50, 80, 25);
	   lblNombre.setBounds(10, 90, 80, 25);
	   lblApellido.setBounds(10, 130, 80, 25);
	   lblEmail.setBounds(10, 170, 80, 25);
	   lblfNacimiento.setBounds(10, 210, 150, 25);

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

	   txtNickname.setBounds(179, 48, 260, 25);
	   txtNombre.setBounds(179, 88, 260, 25);
	   txtApellido.setBounds(179, 128, 260, 25);
	   txtEmail.setBounds(179, 168, 260, 25);
	   spinDia.setBounds(179, 208, 45, 25);
	   spinMes.setBounds(239, 208, 45, 25);
	   spinAnio.setBounds(299, 208, 45, 25);

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
	   btnAceptar.setBounds(200, 270, 115, 25);
	   miPanel.add(btnAceptar);
	   btnAceptar.addActionListener(this);

	   // Boton Cancelar
	   btnCancelar = new JButton();
	   btnCancelar.setText("Cancelar");
	   btnCancelar.setBounds(322, 270, 115, 25);
	   miPanel.add(btnCancelar);
	   btnCancelar.addActionListener(this);
     }

     // InternalFrame Registrar Espectaculo
     private void inFrmRegistrarEspectaculo(){// mirar error. Aldrin
	   JLabel lblArtista, lblPlataforma, lblNombre, lblDescripcion, lblDuracion, lblCantEsp, lblCantMinEsp, lblCantMaxEsp, lblUrl, lblCosto, lblRegistro;
	   JTextField txtArtista, txtPlataforma, txtNombre, txtDescripcion, txtDuracion, txtUrl, txtCosto, ltxtRegistro;
	   JSpinner spinDia, spinMes, spinAnio, spinMin, spinMax;
	   miPanel = new JPanel();
	   miPanel.setLayout(null);

	   internalFrameEspectaculo = new JInternalFrame("Registrar Espectaculo");
	   internalFrameEspectaculo.add(miPanel);
	   internalFrameEspectaculo.setBounds(30, 15, 460, 500);
	   internalFrameEspectaculo.setResizable(false);
	   internalFrameEspectaculo.setClosable(false);
	   internalFrameEspectaculo.setIconifiable(false);
	   internalFrameEspectaculo.setBorder(null);
	   ((javax.swing.plaf.basic.BasicInternalFrameUI) internalFrameEspectaculo.getUI()).setNorthPane(null);
	   contenedor.add(internalFrameEspectaculo);

	   lblTitulo = new JLabel();
	   lblArtista = new JLabel();
	   lblPlataforma = new JLabel();
	   lblNombre = new JLabel();
	   lblDescripcion = new JLabel();
	   lblDuracion = new JLabel();
	   lblCantEsp = new JLabel();
	   lblCantMinEsp = new JLabel();
	   lblCantMaxEsp = new JLabel();
	   lblUrl = new JLabel();
	   lblCosto = new JLabel();
	   lblRegistro = new JLabel();

	   lblTitulo.setText("Registrar Espectaculo");
	   lblArtista.setText("Artista:");
	   lblPlataforma.setText("Plataforma:");
	   lblNombre.setText("Nombre:");
	   lblDescripcion.setText("Descripcion:");
	   lblDuracion.setText("Duracion:");
	   lblCantEsp.setText("Cant. espectadores:");
	   lblCantMinEsp.setText("Minimo");
	   lblCantMaxEsp.setText("Maximo");
	   lblUrl.setText("URL:");
	   lblCosto.setText("Costo:");
	   lblRegistro.setText("Fecha de alta:");

	   lblTitulo.setFont(new java.awt.Font("Comic Sans MS", 1, 20));
	   lblArtista.setFont(new java.awt.Font("Verdana", 1, 12));
	   lblPlataforma.setFont(new java.awt.Font("Verdana", 1, 12));
	   lblNombre.setFont(new java.awt.Font("Verdana", 1, 12));
	   lblDescripcion.setFont(new java.awt.Font("Verdana", 1, 12));
	   lblDuracion.setFont(new java.awt.Font("Verdana", 1, 12));
	   lblCantEsp.setFont(new java.awt.Font("Verdana", 1, 12));
	   lblCantMinEsp.setFont(new java.awt.Font("Verdana", 1, 12));
	   lblCantMaxEsp.setFont(new java.awt.Font("Verdana", 1, 12));
	   lblUrl.setFont(new java.awt.Font("Verdana", 1, 12));
	   lblCosto.setFont(new java.awt.Font("Verdana", 1, 12));
	   lblRegistro.setFont(new java.awt.Font("Verdana", 1, 12));

	   lblTitulo.setBounds(10, 1, 350, 25);
	   lblArtista.setBounds(10, 50, 110, 25);
	   lblPlataforma.setBounds(10, 90, 110, 25);
	   lblNombre.setBounds(10, 130, 110, 25);
	   lblDescripcion.setBounds(10, 170, 110, 25);
	   lblDuracion.setBounds(10, 210, 150, 25);
	   lblCantEsp.setBounds(10, 250, 180, 25);
	   lblCantMinEsp.setBounds(183, 250, 110, 25);
	   lblCantMaxEsp.setBounds(320, 250, 110, 25);
	   lblUrl.setBounds(10, 290, 150, 25);
	   lblCosto.setBounds(10, 330, 150, 25);
	   lblRegistro.setBounds(10, 370, 150, 25);

	   miPanel.add(lblTitulo);
	   miPanel.add(lblArtista);
	   miPanel.add(lblPlataforma);
	   miPanel.add(lblNombre);
	   miPanel.add(lblDescripcion);
	   miPanel.add(lblDuracion);
	   miPanel.add(lblCantEsp);
	   miPanel.add(lblCantMinEsp);
	   miPanel.add(lblCantMaxEsp);
	   miPanel.add(lblUrl);
	   miPanel.add(lblCosto);
	   miPanel.add(lblRegistro);

	   txtArtista = new JTextField();
	   txtPlataforma = new JTextField();
	   txtNombre = new JTextField();
	   txtDescripcion = new JTextField();
	   txtDuracion = new JTextField();
	   spinMin = new JSpinner();
	   spinMax = new JSpinner();
	   txtUrl = new JTextField();
	   txtCosto = new JTextField();
	   spinDia = new JSpinner();
	   spinMes = new JSpinner();
	   spinAnio = new JSpinner();

	   txtArtista.setBounds(183, 48, 260, 25);
	   txtPlataforma.setBounds(183, 88, 260, 25);
	   txtNombre.setBounds(183, 128, 260, 25);
	   txtDescripcion.setBounds(183, 168, 260, 25);
	   txtDuracion.setBounds(183, 208, 260, 25);
	   spinMin.setBounds(237, 246, 65, 25);
	   spinMax.setBounds(376, 246, 65, 25);
	   txtUrl.setBounds(183, 286, 260, 25);
	   txtCosto.setBounds(183, 326, 260, 25);
	   spinDia.setBounds(183, 366, 45, 25);
	   spinMes.setBounds(243, 366, 45, 25);
	   spinAnio.setBounds(303, 366, 45, 25);

	   miPanel.add(txtArtista);
	   miPanel.add(txtPlataforma);
	   miPanel.add(txtNombre);
	   miPanel.add(txtDescripcion);
	   miPanel.add(txtDuracion);
	   miPanel.add(spinMin);
	   miPanel.add(spinMax);
	   miPanel.add(txtUrl);
	   miPanel.add(txtCosto);
	   miPanel.add(spinDia);
	   miPanel.add(spinMes);
	   miPanel.add(spinAnio);

	   // Boton Aceptar
	   btnAceptar = new JButton();
	   btnAceptar.setText("Aceptar");
	   btnAceptar.setBounds(200, 418, 115, 25);
	   miPanel.add(btnAceptar);
	   btnAceptar.addActionListener(this);

	   // Boton Cancelar
	   btnCancelar = new JButton();
	   btnCancelar.setText("Cancelar");
	   btnCancelar.setBounds(322, 418, 115, 25);
	   miPanel.add(btnCancelar);
	   btnCancelar.addActionListener(this);
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
    	 internalFrameEspectaculo.setVisible(false);
    	 internalFrameConsultaUsuario.setVisible(false);
    	 internalFrameAltaUsuario.setVisible(false);
    	 internalFrameAltaPlataforma.setVisible(false);
    	 internalFrameAltaFuncion.setVisible(false);
    	 
	   if(e.getSource() == menuItAltaUsuario){
		 internalFrameAltaUsuario.setVisible(true);
	   }
	   if(e.getSource() == menuItAltaEspectaculo){
		 internalFrameEspectaculo.setVisible(true);
	   }

	   if(e.getSource() == menuItConsultaUsuario){
		 internalFrameConsultaUsuario.setVisible(true);
	   }
	  
	   if(e.getSource() == btnAceptar){
		 limpiarPantalla();
	   }
//	   if(e.getSource() == btnCancelar){
//		 internalFrame.setVisible(false);
//		 internalFrameEspectaculo.setVisible(false);
//		 internalFrameConsultaUsuario.setVisible(false);
//	   }
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
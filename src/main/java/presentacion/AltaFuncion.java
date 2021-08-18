package presentacion;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;

import com.toedter.calendar.JCalendar;

@SuppressWarnings("serial")
public class AltaFuncion extends JInternalFrame{
     private JButton btnAceptar, btnCancelar;
     private JPanel miPanel;
     private JLabel lblPlataforma, lblEspectaculos, lblNombre, lblFecha, lblHora, lblArtistasInv, lblFechaAlta, lblDots;
     private JTextField txtPlataforma, txtNombre;
     private JSpinner spinHora, spinMin;
     private JCalendar calendar;
     private JComboBox<String> comboArtistas, comboEspectaculos;
     // Constructor
     public AltaFuncion(){
	   miPanel = new JPanel();
	   miPanel.setLayout(null);

	   add(miPanel);
	   setBounds(30, 30, 800, 600);
	   setResizable(false);
	   setClosable(false);
	   setIconifiable(false);
	   setBorder(null);
	   // setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	   ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).setNorthPane(null);
//	   lblTitulo = new JLabel();
//	   lblTitulo.setText("Alta plataforma");
//	   lblTitulo.setFont(new java.awt.Font("Comic Sans MS", 1, 20));
//	   lblTitulo.setBounds(10, 1, 280, 25);
//	   miPanel.add(lblTitulo);

	   
	   lblPlataforma = new JLabel();
	   lblPlataforma.setText("Plataforma"); 
	   lblPlataforma.setBounds(10,0,200,20);
	   miPanel.add(lblPlataforma);
	   
	   txtPlataforma = new JTextField();
	   txtPlataforma.setBounds(220,0,200,20);
	   miPanel.add(txtPlataforma);
	   
	   lblEspectaculos = new JLabel();
	   lblEspectaculos.setText("Espectaculos"); 
	   lblEspectaculos.setBounds(10,30,200,20);
	   miPanel.add(lblEspectaculos);
	   
	   comboEspectaculos = new JComboBox<String>();
	   comboEspectaculos.setBounds(220, 30, 200, 20);
	   miPanel.add(comboEspectaculos);
	   
	   lblPlataforma = new JLabel();
	   lblPlataforma.setText("Datos De La Funcion"); 
	   lblPlataforma.setBounds(10,60,250,20);
	   miPanel.add(lblPlataforma);
	   
	   lblNombre = new JLabel();
	   lblNombre.setText("Nombre"); 
	   lblNombre.setBounds(10,90,200,20);
	   miPanel.add(lblNombre);
	   
	   txtNombre = new JTextField();
	   txtNombre.setBounds(220,90,200,20);
	   miPanel.add(txtNombre);
	   
	   lblFecha = new JLabel();
	   lblFecha.setText("Fecha de la Funcion"); 
	   lblFecha.setBounds(10,120,200,20);
	   miPanel.add(lblFecha);
	   
	   calendar = new JCalendar();
	   calendar.setBounds(220,120,200,20);
	   miPanel.add(calendar);
	   
	   lblHora = new JLabel();
	   lblHora.setText("Hora de Inicio"); 
	   lblHora.setBounds(10,150,100,20);
	   miPanel.add(lblHora);
	   
	   spinHora = new JSpinner();
	   spinHora.setBounds(220, 150, 45, 20);
	   miPanel.add(spinHora);
	   
	   lblDots = new JLabel();
	   lblDots.setText(":"); 
	   lblDots.setBounds(275,150,20,20);
	   miPanel.add(lblDots);
	   
	   spinMin = new JSpinner();
	   spinMin.setBounds(295, 150, 45, 20);
	   miPanel.add(spinMin);
	   
	   lblArtistasInv = new JLabel();
	   lblArtistasInv.setText("Artistas Invitados"); 
	   lblArtistasInv.setBounds(10,180,200,20);
	   miPanel.add(lblArtistasInv);
	   
	   comboArtistas = new JComboBox<String>();
	   comboArtistas.setBounds(220, 180, 200, 20);
	   miPanel.add(comboArtistas);
	   
	   lblFechaAlta = new JLabel();
	   lblFechaAlta.setText("Fecha de Alta"); 
	   lblFechaAlta.setBounds(10,210,200,20);
	   miPanel.add(lblFechaAlta);
	   
	   calendar = new JCalendar();
	   calendar.setBounds(220,210,200,20);
	   miPanel.add(calendar);
	   
	    
	   // Boton Aceptar
	   btnAceptar = new JButton();
	   btnAceptar.setText("Aceptar");
	   btnAceptar.setBounds(200, 270, 115, 25);
	   miPanel.add(btnAceptar);
	   /// btnAceptar.addActionListener(this);

	   // Boton Cancelar
	   btnCancelar = new JButton();
	   btnCancelar.setText("Cancelar");
	   btnCancelar.setBounds(322, 270, 115, 25);
	   miPanel.add(btnCancelar);
	   // btnCancelar.addActionListener(this);
     }
}
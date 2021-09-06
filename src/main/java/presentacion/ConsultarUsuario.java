package presentacion;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

import com.toedter.calendar.JDateChooser;

import interfaces.IControladorEspectaculo;
import interfaces.IControladorUsuario;
import logica.Espectaculo;
import logica.Usuario;
import manejadores.ManejadorEspectaculo;


@SuppressWarnings("serial")
public class ConsultarUsuario extends JInternalFrame implements ActionListener{
    private IControladorUsuario iconU;
    private IControladorEspectaculo iconE;
    private JPanel miPanel;
    private JScrollPane panel;
    private JLabel lblTitulo, lblNickname, lblNombre, lblApellido, lblEmail, lblfNacimiento, lblBuscar;
    private JTextField txtBuscar, txtNickname, txtNombre, txtApellido, txtEmail;
    private JDateChooser dateFechaNac;
    private JTable tabUsuario;
    private JComboBox<String> comboUsuarios;
    JTextArea jtextarea;
    private List<Usuario> listUsuarios;

    // Tabla muestra todos los datos basicos.
    // Constructor
    public ConsultarUsuario(IControladorUsuario iconU){
	 this.iconU = iconU;
	 miPanel = new JPanel();
	 miPanel.setLayout(null);
	 add(miPanel);
	 setBounds(15, 15, 460, 400);
	 setResizable(false);
	 setClosable(true);
	 setIconifiable(false);
	 setBorder(null);
	 ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).setNorthPane(null);

	 // JLabel
	 lblTitulo = new JLabel("Consulta de Usuario");
	 lblTitulo.setFont(new java.awt.Font("Comic Sans MS", 1, 18));
	 lblTitulo.setBounds(10, 1, 270, 25);
	 miPanel.add(lblTitulo);

	 lblBuscar = new JLabel("Usuario:");
	 lblBuscar.setFont(new java.awt.Font("Verdana", 1, 12));
	 lblBuscar.setBounds(10, 35, 150, 25);
	 miPanel.add(lblBuscar);

	 // JComboBox
	 comboUsuarios = new JComboBox<String>();
	 comboUsuarios.setBounds(120, 38, 255, 25);
	 miPanel.add(comboUsuarios);
	 comboUsuarios.addActionListener(this);

	 jtextarea = new JTextArea(20, 58);
	 Border border = BorderFactory.createLineBorder(Color.GRAY);
	 jtextarea.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10)));
	 jtextarea.setBounds(10, 70, 365, 200);
	 jtextarea.setFont(new java.awt.Font("Verdana", 1, 12));
	 jtextarea.setEditable(false);
	 miPanel.add(jtextarea);

	 // Tabla Funciones de espectulos
	 /*	 DefaultTableModel model = new DefaultTableModel(data, header);
	 tabUsuario = new JTable(model);
	 tabUsuario.setPreferredScrollableViewportSize(new Dimension(40, 290));
	 JScrollPane jsPane = new JScrollPane(tabUsuario);
	 jsPane.setBounds(10, 180, 365, 118);
	 jsPane.setVisible(false);
	 miPanel.add(jsPane, BorderLayout.SOUTH);*/

	 // Label
	 /* lblNickname = new JLabel(); 
	 lblNombre = new JLabel();
	 lblApellido = new JLabel();
	 lblEmail = new JLabel();
	 lblfNacimiento = new JLabel();
	 lblNickname.setText("Nickname:");
	 lblNombre.setText("Nombre:");
	 lblApellido.setText("Apellido:");
	 lblEmail.setText("Email:");
	 lblfNacimiento.setText("Fecha nacimiento:");
	 lblNickname.setFont(new java.awt.Font("Verdana", 1, 12));
	 lblNombre.setFont(new java.awt.Font("Verdana", 1, 12));
	 lblApellido.setFont(new java.awt.Font("Verdana", 1, 12));
	 lblEmail.setFont(new java.awt.Font("Verdana", 1, 12));
	 lblfNacimiento.setFont(new java.awt.Font("Verdana", 1, 12));
	 lblNickname.setBounds(10, 220, 80, 25);
	 lblNombre.setBounds(10, 250, 80, 25);
	 lblApellido.setBounds(10, 280, 80, 25);
	 lblEmail.setBounds(10, 310, 80, 25);
	 lblfNacimiento.setBounds(10, 340, 150, 25);*/

	 // JTextField
	 // txtNickname = new JTextField();
	 // txtNickname.setBounds(140, 218, 240, 25);
	 // miPanel.add(txtNickname);
	 /* txtNombre = new JTextField();
	 txtApellido = new JTextField();
	 txtEmail = new JTextField();
	 dateFechaNac = new JDateChooser(); // Fecha
	 
	 txtNombre.setBounds(140, 248, 240, 25);
	 txtApellido.setBounds(140, 278, 240, 25);
	 txtEmail.setBounds(140, 308, 240, 25);
	 dateFechaNac.setBounds(140, 338, 240, 25);*/

	 // Agrego JTextField al Panel
	 /*	
	 miPanel.add(txtNombre);
	 miPanel.add(txtApellido);
	 miPanel.add(txtEmail);
	 miPanel.add(dateFechaNac);*/

	 // Click en tabUsuario
	 /* tabUsuario.addMouseListener(new MouseAdapter(){
	     public void mouseClicked(MouseEvent evt){
	   int fila = tabUsuario.rowAtPoint(evt.getPoint());
	   txtNombre.setText(String.valueOf(tabUsuario.getValueAt(fila, 0)));
	   txtApellido.setText(String.valueOf(tabUsuario.getValueAt(fila, 1)));
	     }
	 });*/

    }

    // Inicializar ComboBox
    public void iniciarlizarComboBox(){
	 // Cargo combo de artistas
	 listUsuarios = iconU.listarUsuarios();
	 listUsuarios.forEach((u) -> {
	     comboUsuarios.addItem(u.getNickname());
	 });
    }

    public void actionPerformed(ActionEvent e){ // 79S
	 if(e.getSource() == comboUsuarios){
	     String strUsuario = this.comboUsuarios.getSelectedItem().toString();
	     Usuario u = this.iconU.obtenerUsuario(strUsuario);
	     SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
	     ManejadorEspectaculo mE = ManejadorEspectaculo.getInstancia();
	     List<Espectaculo> usuario = mE.obtenerEspectaculo();
	     String datos = "\n\nLista de espectaculos:";
	     for(Espectaculo i :usuario){
		  datos = datos + "\n" + i.toString();
	     }
	     jtextarea.setText("Nombre: " + u.getNombre() + "\nApellido: " + u.getApellido() + "\nEmail: " + u.getEmail() + "\nFecha: " + formatoFecha.format(u.getfNacimiento()) + datos);
	 }
    }
}


/*   txtNickname.setText(u.getNickname());
      txtNombre.setText(u.getNombre());
txtApellido.setText(u.getApellido());
txtEmail.setText(u.getEmail());
dateFechaNac.setDate(u.getfNacimiento());*/
// String s = JOptionPane.showInputDialog(null, "Digite un caracter: ");
// char ch = s.charAt(0);
// micoordinador.proceso3(ch);
/*		  retorno = "\nNickname:  " + data[1][0].toString() + "\n";
		  retorno += "Nombre:  " + data[1][1].toString() + "\n";
		  retorno += "Apellido:  " + data[1][2].toString() + "\n\n";
 * */

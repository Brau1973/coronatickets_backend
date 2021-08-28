package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

@SuppressWarnings("serial")
public class ModificarDatosUsuario extends JInternalFrame implements ActionListener{
    private JButton btnGuardar;
    private JPanel miPanel;
    private JTextField txtNickname, txtNombre, txtApellido, txtEmail;
    private JDateChooser dateFechaNac;
    private JComboBox<String> comboUsuarios;
    private String[] header = {"Nombre", "Apellido"};
    private String[][] data = {{"Sebastian", "Gonzalez"}, {"Aldrin", "Rebella"}, {"Leonardo", "Mesa"}, {"Lucas", "Sugo"}, {"Luisito", "Suarez"}, {"Colorado", "DeOmar"}, {"Colorado", "DeOmar"}, {"Gruffi ", "Gummi"}};

    // Constructor
    public ModificarDatosUsuario(){
	 miPanel = new JPanel();
	 miPanel.setLayout(null);
	 add(miPanel);
	 setBounds(15, 15, 460, 400);
	 setResizable(false);
	 setClosable(true);
	 setIconifiable(false);
	 setBorder(null);
	 ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).setNorthPane(null);

	 // JLabel Titulo
	 JLabel lblTitulo = new JLabel("Modificar Datos de Usuario");
	 lblTitulo.setFont(new java.awt.Font("Comic Sans MS", 1, 19));
	 lblTitulo.setBounds(10, 1, 270, 25);
	 miPanel.add(lblTitulo);

	 JLabel lblUsuario = new JLabel("Usuario:");
	 lblUsuario.setFont(new java.awt.Font("Verdana", 1, 12));
	 lblUsuario.setBounds(10, 48, 150, 25);
	 miPanel.add(lblUsuario);

	 comboUsuarios = new JComboBox<String>();
	 comboUsuarios.addItem("Seleccionar... ");
	 comboUsuarios.addItem("sebastiangl7");
	 comboUsuarios.addItem("leonut563");
	 comboUsuarios.addItem("oldrin526u");
	 comboUsuarios.setBounds(140, 48, 237, 25);
	 miPanel.add(comboUsuarios);

	 // Label
	 JLabel lblNickname = new JLabel("Nickname:");
	 lblNickname.setFont(new java.awt.Font("Verdana", 1, 12));
	 lblNickname.setBounds(10, 78, 80, 25);
	 miPanel.add(lblNickname);

	 JLabel lblNombre = new JLabel("Nombre:");
	 lblNombre.setFont(new java.awt.Font("Verdana", 1, 12));
	 lblNombre.setBounds(10, 108, 80, 25);
	 miPanel.add(lblNombre);

	 JLabel lblApellido = new JLabel("Apellido:");
	 lblApellido.setFont(new java.awt.Font("Verdana", 1, 12));
	 lblApellido.setBounds(10, 138, 80, 25);
	 miPanel.add(lblApellido);

	 JLabel lblEmail = new JLabel("Email:");
	 lblEmail.setFont(new java.awt.Font("Verdana", 1, 12));
	 lblEmail.setBounds(10, 168, 80, 25);
	 miPanel.add(lblEmail);

	 JLabel lblfNacimiento = new JLabel("Fecha nacimiento:");
	 lblfNacimiento.setFont(new java.awt.Font("Verdana", 1, 12));
	 lblfNacimiento.setBounds(10, 198, 150, 25);
	 miPanel.add(lblfNacimiento);

	 // JTextField
	 txtNickname = new JTextField();
	 txtNickname.setBounds(140, 78, 237, 25);
	 txtNickname.setEditable(false);
	 miPanel.add(txtNickname);

	 txtNombre = new JTextField();
	 txtNombre.setBounds(140, 108, 237, 25);
	 miPanel.add(txtNombre);

	 txtApellido = new JTextField();
	 txtApellido.setBounds(140, 138, 237, 25);
	 miPanel.add(txtApellido);

	 txtEmail = new JTextField();
	 txtEmail.setBounds(140, 168, 237, 25);
	 txtEmail.setEditable(false);
	 miPanel.add(txtEmail);

	 dateFechaNac = new JDateChooser();
	 dateFechaNac.setBounds(140, 198, 148, 25);
	 miPanel.add(dateFechaNac);

	 // Boton Guardar
	 btnGuardar = new JButton("Guardar");
	 btnGuardar.setBounds(291, 198, 85, 25);
	 miPanel.add(btnGuardar);
	 btnGuardar.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
	 if(e.getSource() == btnGuardar){
	     JOptionPane.showMessageDialog(null, "Datos modificados correctamente");
	 }
    }
}

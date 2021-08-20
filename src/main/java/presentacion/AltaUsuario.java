package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class AltaUsuario extends JInternalFrame implements ActionListener{
    public String tipoUsuario;
    private JPanel miPanel;
    JLabel lblTitulo, lblNickname, lblNombre, lblApellido, lblEmail, lblfNacimiento, lblDescripcion, lblBiografia, lblLink;
    JTextField txtNickname, txtNombre, txtApellido, txtEmail, txtDescripcion, txtBiografia, txtLink;
    private JSpinner spinDia, spinMes, spinAnio;
    JButton btnAceptar, btnCancelar;

    public AltaUsuario(){
	 miPanel = new JPanel();
	 miPanel.setLayout(null);
	 add(miPanel);
	 setBounds(20, 20, 460, 420);
	 setResizable(false);
	 setClosable(true);
	 setIconifiable(false);
	 setBorder(null);
	 ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).setNorthPane(null);

	 // Label
	 lblTitulo = new JLabel();
	 lblNickname = new JLabel();
	 lblNombre = new JLabel();
	 lblApellido = new JLabel();
	 lblEmail = new JLabel();
	 lblfNacimiento = new JLabel();
	 lblDescripcion = new JLabel();
	 lblBiografia = new JLabel();
	 lblLink = new JLabel();
	 lblTitulo.setText("Alta Usuario");
	 lblNickname.setText("Nickname:");
	 lblNombre.setText("Nombre:");
	 lblApellido.setText("Apellido:");
	 lblEmail.setText("Email:");
	 lblfNacimiento.setText("Fecha de nacimiento:");
	 lblDescripcion.setText("Descripcion:");
	 lblBiografia.setText("Biografia:");
	 lblLink.setText("Link:");
	 lblTitulo.setFont(new java.awt.Font("Comic Sans MS", 1, 20));
	 lblNickname.setFont(new java.awt.Font("Verdana", 1, 12));
	 lblNombre.setFont(new java.awt.Font("Verdana", 1, 12));
	 lblApellido.setFont(new java.awt.Font("Verdana", 1, 12));
	 lblEmail.setFont(new java.awt.Font("Verdana", 1, 12));
	 lblfNacimiento.setFont(new java.awt.Font("Verdana", 1, 12));
	 lblDescripcion.setFont(new java.awt.Font("Verdana", 1, 12));
	 lblBiografia.setFont(new java.awt.Font("Verdana", 1, 12));
	 lblLink.setFont(new java.awt.Font("Verdana", 1, 12));
	 lblTitulo.setBounds(10, 1, 280, 25);
	 lblNickname.setBounds(10, 50, 80, 25);
	 lblNombre.setBounds(10, 90, 80, 25);
	 lblApellido.setBounds(10, 130, 80, 25);
	 lblEmail.setBounds(10, 170, 80, 25);
	 lblfNacimiento.setBounds(10, 210, 150, 25);
	 lblDescripcion.setBounds(10, 250, 150, 25);
	 lblBiografia.setBounds(10, 290, 150, 25);
	 lblLink.setBounds(10, 330, 150, 25);
	 // Agrego label al Panel
	 miPanel.add(lblTitulo);
	 miPanel.add(lblNickname);
	 miPanel.add(lblNombre);
	 miPanel.add(lblApellido);
	 miPanel.add(lblEmail);
	 miPanel.add(lblfNacimiento);
	 miPanel.add(lblDescripcion);
	 miPanel.add(lblBiografia);
	 miPanel.add(lblLink);
	 // JTextField
	 txtNickname = new JTextField();
	 txtNombre = new JTextField();
	 txtApellido = new JTextField();
	 txtEmail = new JTextField();
	 spinDia = new JSpinner();
	 spinMes = new JSpinner();
	 spinAnio = new JSpinner();
	 txtDescripcion = new JTextField();
	 txtBiografia = new JTextField();
	 txtLink = new JTextField();
	 txtNickname.setBounds(179, 48, 260, 25);
	 txtNombre.setBounds(179, 88, 260, 25);
	 txtApellido.setBounds(179, 128, 260, 25);
	 txtEmail.setBounds(179, 168, 260, 25);
	 spinDia.setBounds(179, 208, 45, 25);
	 spinMes.setBounds(239, 208, 45, 25);
	 spinAnio.setBounds(299, 208, 45, 25);
	 txtDescripcion.setBounds(179, 248, 260, 25);
	 txtBiografia.setBounds(179, 288, 260, 25);
	 txtLink.setBounds(179, 328, 260, 25);
	 // Agrego JTextField al Panel
	 miPanel.add(txtNickname);
	 miPanel.add(txtNombre);
	 miPanel.add(txtApellido);
	 miPanel.add(txtEmail);
	 miPanel.add(spinDia);
	 miPanel.add(spinMes);
	 miPanel.add(spinAnio);
	 miPanel.add(txtDescripcion);
	 miPanel.add(txtBiografia);
	 miPanel.add(txtLink);

	 // Boton Aceptar
	 btnAceptar = new JButton();
	 btnAceptar.setText("Aceptar");
	 // btnAceptar.setBounds(200, 370, 115, 25);
	 miPanel.add(btnAceptar);
	 btnAceptar.addActionListener(this);

	 // Boton Cancelar
	 btnCancelar = new JButton();
	 btnCancelar.setText("Cancelar");
	 btnCancelar.setBounds(322, 370, 115, 25);
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

    public void actionPerformed(ActionEvent e){
	 if(e.getSource() == btnAceptar){
	     JOptionPane.showMessageDialog(null, tipoUsuario);
	     limpiarPantalla();
	 }
	 if(e.getSource() == btnCancelar){
	     System.out.println("Cancelar");
	     limpiarPantalla();
	 }
    }
}
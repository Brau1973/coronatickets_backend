package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

@SuppressWarnings("serial")
public class AltaUsuario extends JInternalFrame implements ActionListener{
    private JPanel miPanel;
    private JRadioButton rbtnEspectador, rbtnArtista;
    private JLabel lblTitulo, lblNickname, lblNombre, lblApellido, lblEmail, lblfNacimiento, lblDescripcion, lblBiografia, lblLink;
    private JTextField txtNickname, txtNombre, txtApellido, txtEmail, txtDescripcion, txtBiografia, txtLink;
    private JDateChooser dateFechaNac;
    private JButton btnAceptar, btnCancelar;

    public AltaUsuario(){
	 miPanel = new JPanel();
	 miPanel.setLayout(null);
	 getContentPane().add(miPanel);
	 setBounds(15, 15, 469, 434);
	 setResizable(false);
	 setClosable(true);
	 setIconifiable(false);
	 setBorder(null);
	 ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).setNorthPane(null);

	 // JRadioButton
	 rbtnEspectador = new JRadioButton("Espectador");
	 rbtnEspectador.setFont(new java.awt.Font("Verdana", 1, 13));
	 rbtnEspectador.setBounds(152, 10, 110, 25);
	 miPanel.add(rbtnEspectador);
	 rbtnEspectador.addActionListener(this);
	 rbtnArtista = new JRadioButton("Artista");
	 rbtnArtista.setFont(new java.awt.Font("Verdana", 1, 13));
	 rbtnArtista.setBounds(270, 10, 120, 25);
	 miPanel.add(rbtnArtista);
	 rbtnArtista.addActionListener(this);
	 rbtnArtista.setSelected(true); // x defecto
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
	 lblfNacimiento.setText("Fecha nacimiento:");
	 lblDescripcion.setText("Descripción:");
	 lblBiografia.setText("Biografia:");
	 lblLink.setText("Link:");
	 lblTitulo.setFont(new java.awt.Font("Comic Sans MS", 1, 19));
	 lblNickname.setFont(new java.awt.Font("Verdana", 1, 12));
	 lblNombre.setFont(new java.awt.Font("Verdana", 1, 12));
	 lblApellido.setFont(new java.awt.Font("Verdana", 1, 12));
	 lblEmail.setFont(new java.awt.Font("Verdana", 1, 12));
	 lblfNacimiento.setFont(new java.awt.Font("Verdana", 1, 12));
	 lblDescripcion.setFont(new java.awt.Font("Verdana", 1, 12));
	 lblBiografia.setFont(new java.awt.Font("Verdana", 1, 12));
	 lblLink.setFont(new java.awt.Font("Verdana", 1, 12));
	 lblTitulo.setBounds(10, 6, 280, 25);
	 lblNickname.setBounds(10, 50, 80, 25);
	 lblNombre.setBounds(10, 80, 80, 25);
	 lblApellido.setBounds(10, 110, 80, 25);
	 lblEmail.setBounds(10, 140, 80, 25);
	 lblfNacimiento.setBounds(10, 170, 150, 25);
	 lblDescripcion.setBounds(10, 200, 150, 25);
	 lblBiografia.setBounds(10, 230, 150, 25);
	 lblLink.setBounds(10, 260, 150, 25);

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
	 dateFechaNac =  new JDateChooser();
	 txtDescripcion = new JTextField();
	 txtBiografia = new JTextField();
	 txtLink = new JTextField();


	 // Agrego JTextField al Panel
	 miPanel.add(txtNickname);
	 miPanel.add(txtNombre);
	 miPanel.add(txtApellido);
	 miPanel.add(txtEmail);
	 miPanel.add(dateFechaNac);
	 miPanel.add(txtDescripcion);
	 miPanel.add(txtBiografia);
	 miPanel.add(txtLink);

	 // Boton Aceptar
	 btnAceptar = new JButton();
	 btnAceptar.setText("Aceptar");
	 btnAceptar.setBounds(155, 300, 127, 25);
	 miPanel.add(btnAceptar);
	 btnAceptar.addActionListener(this);

	 // Boton Cancelar
	 btnCancelar = new JButton();
	 btnCancelar.setText("Cancelar");
	 btnCancelar.setBounds(286, 300, 127, 25);
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
	     JOptionPane.showMessageDialog(null, "El usuario se ha creado con éxito");
	     limpiarPantalla();
	 }
	 if(e.getSource() == btnCancelar){
	     limpiarPantalla();
	 }

	 if(e.getSource() == rbtnEspectador){
	     if(rbtnEspectador.isSelected()){
		  btnAceptar.setBounds(155, 210, 127, 25);
		  btnCancelar.setBounds(286, 210, 127, 25);
		  lblDescripcion.setVisible(false);
		  lblBiografia.setVisible(false);
		  lblLink.setVisible(false);
		  txtDescripcion.setVisible(false);
		  txtBiografia.setVisible(false);
		  txtLink.setVisible(false);
		  rbtnArtista.setSelected(false);
	     }
	 }
	 if(e.getSource() == rbtnArtista){
	     if(rbtnArtista.isSelected()){
		  btnAceptar.setBounds(155, 300, 127, 25);
		  btnCancelar.setBounds(286, 300, 127, 25);
		  lblDescripcion.setVisible(true);
		  lblBiografia.setVisible(true);
		  lblLink.setVisible(true);
		  txtDescripcion.setVisible(true);
		  txtBiografia.setVisible(true);
		  txtLink.setVisible(true);
		  rbtnEspectador.setSelected(false);
	     }
	 }
    }
}
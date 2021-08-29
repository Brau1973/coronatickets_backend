package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import excepciones.PlataformaRepetidaExcepcion;
import excepciones.UsuarioRepetidoExcepcion;
import interfaces.IControladorUsuario;
import logica.Artista;
import logica.Espectador;
import logica.Usuario;




@SuppressWarnings("serial")
public class AltaUsuario extends JInternalFrame implements ActionListener{
    private IControladorUsuario iconU;
    private JPanel miPanel;
    private JRadioButton rbtnEspectador, rbtnArtista;
    private JLabel lblTitulo, lblNickname, lblNombre, lblApellido, lblEmail, lblfNacimiento, lblDescripcion, lblBiografia, lblLink;
    private JTextField txtNickname, txtNombre, txtApellido, txtEmail, txtDescripcion, txtBiografia, txtLink;
    private JDateChooser dateFechaNac;
    private JButton btnAceptar, btnCancelar;

    public AltaUsuario(IControladorUsuario iconU){
	this.iconU = iconU;
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
	 lblTitulo.setText("Alta Usuario");
	 lblTitulo.setFont(new java.awt.Font("Comic Sans MS", 1, 19));
	 lblTitulo.setBounds(10, 6, 280, 25);
	 miPanel.add(lblTitulo);

	 lblNickname = new JLabel();
	 lblNickname.setText("Nickname:");
	 lblNickname.setFont(new java.awt.Font("Verdana", 1, 12));
	 lblNickname.setBounds(10, 50, 80, 25);
	 miPanel.add(lblNickname);

	 txtNickname = new JTextField();
	 txtNickname.setBounds(155, 48, 260, 25);
	 miPanel.add(txtNickname);

	 lblNombre = new JLabel();
	 lblNombre.setText("Nombre:");
	 lblNombre.setFont(new java.awt.Font("Verdana", 1, 12));
	 lblNombre.setBounds(10, 80, 80, 25);
	 miPanel.add(lblNombre);

	 txtNombre = new JTextField();
	 txtNombre.setBounds(155, 78, 260, 25);
	 miPanel.add(txtNombre);

	 lblApellido = new JLabel();
	 lblApellido.setText("Apellido:");
	 lblApellido.setFont(new java.awt.Font("Verdana", 1, 12));
	 lblApellido.setBounds(10, 110, 80, 25);
	 miPanel.add(lblApellido);

	 txtApellido = new JTextField();
	 txtApellido.setBounds(155, 108, 260, 25);
	 miPanel.add(txtApellido);

	 lblEmail = new JLabel();
	 lblEmail.setText("Email:");
	 lblEmail.setFont(new java.awt.Font("Verdana", 1, 12));
	 lblEmail.setBounds(10, 140, 80, 25);
	 miPanel.add(lblEmail);

	 txtEmail = new JTextField();
	 txtEmail.setBounds(155, 138, 260, 25);
	 miPanel.add(txtEmail);

	 lblfNacimiento = new JLabel();
	 lblfNacimiento.setText("Fecha nacimiento:");
	 lblfNacimiento.setFont(new java.awt.Font("Verdana", 1, 12));
	 lblfNacimiento.setBounds(10, 170, 150, 25);
	 miPanel.add(lblfNacimiento);

	 dateFechaNac = new JDateChooser();
	 dateFechaNac.setBounds(155, 168, 260, 25);
	 miPanel.add(dateFechaNac);

	 lblDescripcion = new JLabel();
	 lblDescripcion.setText("Descripción:");
	 lblDescripcion.setFont(new java.awt.Font("Verdana", 1, 12));
	 lblDescripcion.setBounds(10, 200, 150, 25);
	 miPanel.add(lblDescripcion);

	 txtDescripcion = new JTextField();
	 txtDescripcion.setBounds(155, 198, 260, 25);
	 miPanel.add(txtDescripcion);

	 lblBiografia = new JLabel();
	 lblBiografia.setText("Biografia:");
	 lblBiografia.setFont(new java.awt.Font("Verdana", 1, 12));
	 lblBiografia.setBounds(10, 230, 150, 25);
	 miPanel.add(lblBiografia);

	 txtBiografia = new JTextField();
	 txtBiografia.setBounds(155, 228, 260, 25);
	 miPanel.add(txtBiografia);

	 lblLink = new JLabel();
	 lblLink.setText("Link:");
	 lblLink.setFont(new java.awt.Font("Verdana", 1, 12));
	 lblLink.setBounds(10, 260, 150, 25);
	 miPanel.add(lblLink);

	 txtLink = new JTextField();
	 txtLink.setBounds(155, 258, 260, 25);
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

	//	protected void actionListenerAceptar(ActionEvent e) {
		public void actionPerformed(ActionEvent e) {
			String strNickname=this.txtNickname.getText();
			String strNombre=this.txtNombre.getText();
			String strApellido=this.txtApellido.getText();
			String strEmail=this.txtEmail.getText();
			Date dateFechaNac=this.dateFechaNac.getDate();
			String strDescripcion=this.txtDescripcion.getText();
			String strBiografia=this.txtBiografia.getText();
			String strLink=this.txtLink.getText();
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
			 if(e.getSource() == btnAceptar) {
				 if(rbtnEspectador.isSelected()){
					 if(checkFormulario()){
						 try{
				   // 	falta mirar chequeo de fecha 
				    		Usuario u = new Espectador(strNickname,strNombre,strApellido,strEmail,dateFechaNac);
				    		this.iconU.altaUsuario(u);
				    		JOptionPane.showMessageDialog(this, "el Espectador se ha creado con Exito");
				    	
				    	}catch(UsuarioRepetidoExcepcion x){
					  JOptionPane.showMessageDialog(this, x.getMessage(), "Alta Usuario", JOptionPane.ERROR_MESSAGE);
				    	}
						 limpiarFormulario();
						 setVisible(false);
					 }
				 }	 
				 if (rbtnArtista.isSelected()){
				 if(checkFormulario2()){
				     try{
				    	 // 	falta mirar chequeo de fecha 
				    		Usuario a = new Artista(strNickname,strNombre,strApellido,strEmail,dateFechaNac,strDescripcion,strBiografia,strLink);
				    		this.iconU.altaUsuario(a);
				    		JOptionPane.showMessageDialog(this, "el Artista se ha creado con Exito");
				    	
				    	}catch(UsuarioRepetidoExcepcion x){
					  JOptionPane.showMessageDialog(this, x.getMessage(), "Alta Usuario", JOptionPane.ERROR_MESSAGE);
				     }
				     limpiarFormulario();
				     setVisible(false);
				 }
				 } 
		 }
			
		}

    
		private boolean checkFormulario(){
		String strNickname=this.txtNickname.getText();
		String strNombre=this.txtNombre.getText();
		String strApellido=this.txtApellido.getText();
		String strEmail=this.txtEmail.getText();
		//Date dateFechaNac=this.dateFechaNac.getDate();
	//	String strDescripcion=this.txtDescripcion.getText();
	//	String strBiografia=this.txtBiografia.getText();
	//	String strLink=this.txtLink.getText();
			 if(strNickname.isEmpty() || strNombre.isEmpty() || strApellido.isEmpty() || strEmail.isEmpty()){
			     JOptionPane.showMessageDialog(this, "No puede haber campos vacios", "Alta Usuario", JOptionPane.ERROR_MESSAGE);
			     return false;
			 }
			 return true;
		    }
	 
		private boolean checkFormulario2(){
			String strNickname=this.txtNickname.getText();
			String strNombre=this.txtNombre.getText();
			String strApellido=this.txtApellido.getText();
			String strEmail=this.txtEmail.getText();
			//Date dateFechaNac=this.dateFechaNac.getDate();
			String strDescripcion=this.txtDescripcion.getText();

				 if(strNickname.isEmpty() || strNombre.isEmpty() || strApellido.isEmpty() || strEmail.isEmpty() || strDescripcion.isEmpty()){
				     JOptionPane.showMessageDialog(this, "No puede haber campos vacios", "Alta Usuario", JOptionPane.ERROR_MESSAGE);
				     return false;
				 }
				 return true;
			    }
		
		
		private void limpiarFormulario(){
			txtNickname.setText("");
			txtNombre.setText("");
			txtApellido.setText("");
			txtEmail.setText("");
			dateFechaNac.setDate(null);
			txtDescripcion.setText("");
			txtBiografia.setText("");
			txtLink.setText("");
		    }
		


  }  	

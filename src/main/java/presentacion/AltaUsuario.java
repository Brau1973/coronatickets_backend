package presentacion;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.toedter.calendar.JDateChooser;

import datatypes.DtArtista;
import datatypes.DtEspectador;
import datatypes.DtUsuario;
import interfaces.IControladorUsuario;
import manejadores.ManejadorUsuario;

@SuppressWarnings("serial")
public class AltaUsuario extends JInternalFrame implements ActionListener{
	private IControladorUsuario iconU;
	private JPanel miPanel;
	private JRadioButton rbtnEspectador, rbtnArtista;
	private JLabel lblTitulo, lblNickname, lblNombre, lblApellido, lblEmail, lblfNacimiento, lblContrasenia, lblContrasenia2, lblDescripcion, lblBiografia, lblLink,jLabelImag,jLabelImage;
	private JTextField txtNickname, txtNombre, txtApellido, txtEmail, txtContrasenia, txtContrasenia2, txtDescripcion, txtBiografia, txtLink,txturl;
	private JDateChooser dateFechaNac;
	private JButton btnAceptar, btnCancelar, btnAbrir;

	private List<String> seguidos = new ArrayList<String>(); // Vacias porque recien se esta creando el usuario;
	private List<String> seguidores = new ArrayList<String>();

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

		lblContrasenia = new JLabel();
		lblContrasenia.setText("Contraseña:");
		lblContrasenia.setFont(new java.awt.Font("Verdana", 1, 12));
		lblContrasenia.setBounds(10, 200, 150, 25);
		miPanel.add(lblContrasenia);

		txtContrasenia = new JTextField();
		txtContrasenia.setBounds(155, 198, 260, 25);
		miPanel.add(txtContrasenia);
		
		lblContrasenia2 = new JLabel();
		lblContrasenia2.setText("Contraseña:");
		lblContrasenia2.setFont(new java.awt.Font("Verdana", 1, 12));
		lblContrasenia2.setBounds(10, 230, 150, 25);
		miPanel.add(lblContrasenia2);

		txtContrasenia2 = new JTextField();
		txtContrasenia2.setBounds(155, 228, 260, 25);
		miPanel.add(txtContrasenia2);

		lblDescripcion = new JLabel();
		lblDescripcion.setText("Descripcion:");
		lblDescripcion.setFont(new java.awt.Font("Verdana", 1, 12));
		lblDescripcion.setBounds(10, 260, 150, 25);
		miPanel.add(lblDescripcion);

		txtDescripcion = new JTextField();
		txtDescripcion.setBounds(155, 258, 260, 25);
		miPanel.add(txtDescripcion);

		lblBiografia = new JLabel();
		lblBiografia.setText("Biografia:");
		lblBiografia.setFont(new java.awt.Font("Verdana", 1, 12));
		lblBiografia.setBounds(10, 290, 150, 25);
		miPanel.add(lblBiografia);

		txtBiografia = new JTextField();
		txtBiografia.setBounds(155, 288, 260, 25);
		miPanel.add(txtBiografia);

		lblLink = new JLabel();
		lblLink.setText("Link:");
		lblLink.setFont(new java.awt.Font("Verdana", 1, 12));
		lblLink.setBounds(10, 320, 150, 25);
		miPanel.add(lblLink);

		txtLink = new JTextField();
		txtLink.setBounds(155, 318, 260, 25);
		miPanel.add(txtLink);

		jLabelImag = new JLabel("Seleccionar imagen"); // label imagen
		jLabelImag.setBounds(10, 400, 200, 20);
		miPanel.add(jLabelImag);

		jLabelImage = new JLabel(); // label imagen
		jLabelImage.setBounds(230, 400, 140, 140);
		miPanel.add(jLabelImage);

		txturl = new JTextField(); // url
		txturl.setBounds(202, 530, 200, 20);
		miPanel.add(txturl);
		txturl.setVisible(false);

		btnAbrir = new JButton();
		btnAbrir.setText("...");
		btnAbrir.setBounds(180, 400, 40, 20);

		miPanel.add(btnAbrir);
		btnAbrir.addActionListener(this);
		
		// Boton Aceptar
		btnAceptar = new JButton();
		btnAceptar.setText("Aceptar");
		btnAceptar.setBounds(155, 350, 127, 25);
		miPanel.add(btnAceptar);
		btnAceptar.addActionListener(this);

		// Boton Cancelar
		btnCancelar = new JButton();
		btnCancelar.setText("Cancelar");
		btnCancelar.setBounds(286, 350, 127, 25);
		miPanel.add(btnCancelar);
		btnCancelar.addActionListener(this);
	}

	// protected void actionListenerAceptar(ActionEvent e) {
	public void actionPerformed(ActionEvent e){
		String strNickname = this.txtNickname.getText();
		String strNombre = this.txtNombre.getText();
		String strApellido = this.txtApellido.getText();
		String strEmail = this.txtEmail.getText();
		Date dateFechaNac = this.dateFechaNac.getDate();
		String strContrasenia = this.txtContrasenia.getText();
		String strDescripcion = this.txtDescripcion.getText();
		String strBiografia = this.txtBiografia.getText();
		String strLink = this.txtLink.getText();
		if(e.getSource() == rbtnEspectador){
			if(rbtnEspectador.isSelected()){
				btnAceptar.setBounds(155, 258, 127, 25);
				btnCancelar.setBounds(286, 258, 127, 25);
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
				btnAceptar.setBounds(155, 350, 127, 25);
				btnCancelar.setBounds(286, 350, 127, 25);
				lblDescripcion.setVisible(true);
				lblBiografia.setVisible(true);
				lblLink.setVisible(true);
				txtDescripcion.setVisible(true);
				txtBiografia.setVisible(true);
				txtLink.setVisible(true);
				rbtnEspectador.setSelected(false);
			}
		}
		
		if(e.getSource() == btnAbrir){ 
			JFileChooser browseImageFile = new JFileChooser();
			FileNameExtensionFilter fnef = new FileNameExtensionFilter("IMAGES", "png", "jpg", "jpeg");
			browseImageFile.addChoosableFileFilter(fnef);
			int showOpenDialogue = browseImageFile.showOpenDialog(null);

			if(showOpenDialogue == JFileChooser.APPROVE_OPTION){
				File selectedImageFile = browseImageFile.getSelectedFile();
				String selectedImagePath = selectedImageFile.getAbsolutePath();
		
				// JOptionPane.showMessageDialog(null, selectedImagePath);
				ImageIcon ii = new ImageIcon(selectedImagePath);
				Image image = ii.getImage().getScaledInstance(jLabelImage.getWidth(), jLabelImage.getHeight(), Image.SCALE_SMOOTH);
				jLabelImage.setIcon(new ImageIcon(image));

				this.txturl.setText(selectedImagePath);
			}
		}
		
		if(e.getSource() == btnAceptar){
			String url = this.txturl.getText();
			byte[] selectedImage = null;
			if(url != null && !url.isEmpty()) {
				try{
					selectedImage = Files.readAllBytes(Paths.get(url));
				}catch(IOException e1){
					e1.printStackTrace();
				}
			}
			if(rbtnEspectador.isSelected()){
				if(checkFormulario() && modificarDatos()){
					try{
						// falta mirar chequeo de fecha
						DtUsuario dte = new DtEspectador(strNickname, strNombre, strApellido, strEmail, dateFechaNac, strContrasenia,selectedImage, seguidos, seguidores);

						this.iconU.altaUsuario(dte);
						JOptionPane.showMessageDialog(this, "el Espectador se ha creado con Exito");

					}catch(Exception x){
						JOptionPane.showMessageDialog(this, x.getMessage(), "Alta Usuario", JOptionPane.ERROR_MESSAGE);
					}
					limpiarFormulario();
					setVisible(false);
				}
			}
			if(rbtnArtista.isSelected()){
				if(checkFormulario2() && modificarDatos()){
					try{
						// falta mirar chequeo de fecha
						DtUsuario dta = new DtArtista(strNickname, strNombre, strApellido, strEmail, dateFechaNac, strContrasenia,selectedImage,seguidos, seguidores, strDescripcion, strBiografia, strLink);

						this.iconU.altaUsuario(dta);
						JOptionPane.showMessageDialog(this, "el Artista se ha creado con Exito");
					}catch(Exception x){
						JOptionPane.showMessageDialog(this, x.getMessage(), "Alta Usuario", JOptionPane.ERROR_MESSAGE);
					}
					limpiarFormulario();
					setVisible(false);
				}
			}
		}

		if(e.getSource() == btnCancelar){
			limpiarFormulario();
			setVisible(false);
		}

	}

	private boolean checkFormulario(){
		String strNickname = this.txtNickname.getText();
		String strNombre = this.txtNombre.getText();
		String strApellido = this.txtApellido.getText();
		String strEmail = this.txtEmail.getText();
		String strContrasenia = this.txtContrasenia.getText();
		String strContrasenia2 = this.txtContrasenia2.getText();
		if(strNickname.isEmpty() || strNombre.isEmpty() || strApellido.isEmpty() || strEmail.isEmpty() || strContrasenia.isEmpty()
				|| strContrasenia2.isEmpty()){
			JOptionPane.showMessageDialog(this, "No puede haber campos vacios", "Alta Usuario", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if(!strContrasenia.equals(strContrasenia2)) {
			JOptionPane.showMessageDialog(this, "Las Contraseñas deben ser iguales", "Alta Usuario", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}

	private boolean checkFormulario2(){
		String strNickname = this.txtNickname.getText();
		String strNombre = this.txtNombre.getText();
		String strApellido = this.txtApellido.getText();
		String strEmail = this.txtEmail.getText();
		String strContrasenia = this.txtContrasenia.getText();
		// Date dateFechaNac=this.dateFechaNac.getDate();
		String strDescripcion = this.txtDescripcion.getText();

		if(strNickname.isEmpty() || strNombre.isEmpty() || strApellido.isEmpty() || strEmail.isEmpty() || strContrasenia.isEmpty() || strDescripcion.isEmpty()){
			JOptionPane.showMessageDialog(this, "No puede haber campos vacios", "Alta Usuario", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}

	private boolean modificarDatos(){
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		if(mU.buscarUsuario(txtNickname.getText()) != null){
			int respuesta = JOptionPane.showConfirmDialog(null, "El nickname del Usuario ya existe\n¿Desea modificar los datos?\n", "Advertencia", JOptionPane.YES_NO_OPTION);
			if(respuesta != JOptionPane.YES_NO_OPTION){
				limpiarFormulario();
				setVisible(false);
			}
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
		txtContrasenia.setText("");
		txtDescripcion.setText("");
		txtBiografia.setText("");
		txtLink.setText("");
	}

}
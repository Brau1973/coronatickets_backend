package presentacion;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.toedter.calendar.JDateChooser;

import datatypes.DtEspectaculo;
import excepciones.EspectaculoRepetidoExcepcion;
import interfaces.Fabrica;
import interfaces.IControladorEspectaculo;
import interfaces.IControladorPlataforma;
import interfaces.IControladorUsuario;
import manejadores.ManejadorEspectaculo;

@SuppressWarnings("serial")
public class AltaEspectaculo extends JInternalFrame implements ActionListener {
	private IControladorEspectaculo iconE;
	private IControladorUsuario iconU;
	private IControladorPlataforma iconP;
	private JPanel miPanel;
	private JComboBox<String> comboPlataforma, comboArtista;
	private JTextField txtNombre, txtDescripcion, txtDuracion, txtUrl, txtCosto;
	private JSpinner spinMin, spinMax;
	private JDateChooser dateFechaNac;
	private JButton btnAceptar, btnCancelar,btnAbrir;
	private List<String> listPlataformas;
	private List<String> listArtistas;
	private File archivo;
	private byte[] imagen;
	private String imagenesSVPath = "C:\\Users\\Braulio\\Documents\\Brau2015\\Desarrollo\\Portfolio\\coronatickets_frontend\\coronaTicketsWeb\\WebContent\\imagenes\\";
	private String txturl;
	private JLabel jLabelImage, jLabelImag;
	
	public AltaEspectaculo(IControladorEspectaculo iconE) {
		this.iconE = iconE;
		iconU = Fabrica.getInstancia().getIControladorUsuario();
		iconP = Fabrica.getInstancia().getIControladorPlataforma();
		miPanel = new JPanel();
		miPanel.setLayout(null);
		add(miPanel);
		setBounds(30, 30, 800, 600);
		setResizable(false);
		setClosable(true);
		setIconifiable(false);
		setBorder(null);
		((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).setNorthPane(null);

		// JLabel
		JLabel lblTitulo = new JLabel("Alta Espectaculo");
		lblTitulo.setFont(new java.awt.Font("Comic Sans MS", 1, 19));
		lblTitulo.setBounds(10, 1, 350, 25);
		miPanel.add(lblTitulo);

		JLabel lblPlataforma = new JLabel("Plataforma:");
		lblPlataforma.setFont(new java.awt.Font("Verdana", 1, 12));
		lblPlataforma.setBounds(10, 50, 110, 25);
		miPanel.add(lblPlataforma);

		JLabel lblArtista = new JLabel("Artista:");
		lblArtista.setFont(new java.awt.Font("Verdana", 1, 12));
		lblArtista.setBounds(10, 80, 110, 25);
		miPanel.add(lblArtista);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new java.awt.Font("Verdana", 1, 12));
		lblNombre.setBounds(10, 110, 110, 25);
		miPanel.add(lblNombre);

		JLabel lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setFont(new java.awt.Font("Verdana", 1, 12));
		lblDescripcion.setBounds(10, 140, 110, 25);
		miPanel.add(lblDescripcion);

		JLabel lblDuracion = new JLabel("Duracion:");
		lblDuracion.setFont(new java.awt.Font("Verdana", 1, 12));
		lblDuracion.setBounds(10, 170, 150, 25);
		miPanel.add(lblDuracion);

		JLabel lblCantEsp = new JLabel("Espectadores:");
		lblCantEsp.setFont(new java.awt.Font("Verdana", 1, 12));
		lblCantEsp.setBounds(10, 200, 180, 25);
		miPanel.add(lblCantEsp);

		JLabel lblCantMinEsp = new JLabel("Minimo:");
		lblCantMinEsp.setFont(new java.awt.Font("Verdana", 1, 12));
		lblCantMinEsp.setBounds(155, 200, 110, 25);
		miPanel.add(lblCantMinEsp);

		JLabel lblCantMaxEsp = new JLabel("Maximo:");
		lblCantMaxEsp.setFont(new java.awt.Font("Verdana", 1, 12));
		lblCantMaxEsp.setBounds(292, 200, 110, 25);
		miPanel.add(lblCantMaxEsp);

		JLabel lblUrl = new JLabel("URL:");
		lblUrl.setFont(new java.awt.Font("Verdana", 1, 12));
		lblUrl.setBounds(10, 230, 150, 25);
		miPanel.add(lblUrl);

		JLabel lblCosto = new JLabel("Costo:");
		lblCosto.setFont(new java.awt.Font("Verdana", 1, 12));
		lblCosto.setBounds(10, 260, 150, 25);
		miPanel.add(lblCosto);

		JLabel lblRegistro = new JLabel("Fecha de alta:");
		lblRegistro.setFont(new java.awt.Font("Verdana", 1, 12));
		lblRegistro.setBounds(10, 290, 150, 25);
		miPanel.add(lblRegistro);

		// JComboBox
		comboPlataforma = new JComboBox<String>();
		comboPlataforma.setBounds(155, 48, 260, 25);
		miPanel.add(comboPlataforma);

		comboArtista = new JComboBox<String>();
		comboArtista.setBounds(155, 78, 260, 25);
		miPanel.add(comboArtista);

		// JTextField
		txtNombre = new JTextField();
		txtNombre.setBounds(155, 108, 260, 25);
		miPanel.add(txtNombre);

		txtDescripcion = new JTextField();
		txtDescripcion.setBounds(155, 138, 260, 25);
		miPanel.add(txtDescripcion);

		txtDuracion = new JTextField();
		txtDuracion.setBounds(155, 168, 260, 25);
		miPanel.add(txtDuracion);

		spinMin = new JSpinner();
		spinMin.setBounds(209, 196, 65, 25);
		miPanel.add(spinMin);

		spinMax = new JSpinner();
		spinMax.setBounds(348, 196, 65, 25);
		miPanel.add(spinMax);

		txtUrl = new JTextField();
		txtUrl.setBounds(155, 226, 260, 25);
		miPanel.add(txtUrl);

		txtCosto = new JTextField();
		txtCosto.setBounds(155, 256, 260, 25);
		miPanel.add(txtCosto);

		dateFechaNac = new JDateChooser();
		dateFechaNac.setBounds(155, 286, 260, 25);
		miPanel.add(dateFechaNac);

		jLabelImag = new JLabel("Seleccionar imagen"); // label imagen
		jLabelImag.setFont(new java.awt.Font("Verdana", 1, 12));
		jLabelImag.setBounds(10, 325, 200, 20);
		miPanel.add(jLabelImag);

		btnAbrir = new JButton();
		btnAbrir.setText("...");
		btnAbrir.setFont(new java.awt.Font("Verdana", 1, 12));
		btnAbrir.setBounds(155, 325, 40, 20);
		miPanel.add(btnAbrir);
		btnAbrir.addActionListener(this);
		
		jLabelImage = new JLabel(); // label imagen
		jLabelImage.setBounds(230, 325, 140, 140);
		miPanel.add(jLabelImage);

		// JButton
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(155, 500, 127, 25);
		miPanel.add(btnAceptar);
		btnAceptar.addActionListener(this);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(286, 500, 127, 25);
		miPanel.add(btnCancelar);
		btnCancelar.addActionListener(this);
	}

	// Inicializar ComboBox
	public void iniciarlizarComboBox() {
		comboPlataforma.removeAllItems();
		comboArtista.removeAllItems();

		listPlataformas = iconP.listarPlataformasStr();
		listPlataformas.forEach((p) -> {
			comboPlataforma.addItem(p);
		});

		listArtistas = iconU.listarNicknameArtistas();
		listArtistas.forEach((art) -> {
			comboArtista.addItem(art);
		});
	}

	public void actionPerformed(ActionEvent e){
	 if(e.getSource() == btnAceptar){
	     if(checkFormulario()){
		  String strplataforma = (String) this.comboPlataforma.getSelectedItem();
		  String strartista = (String) this.comboArtista.getSelectedItem();
		  String strnombre = this.txtNombre.getText();
		  String strdescripcion = this.txtDescripcion.getText();
		  int cantMin = (Integer) spinMin.getValue();
		  int cantMax = (Integer) spinMax.getValue();
		  String strurl = this.txtUrl.getText();
		  Date dateRegistro = this.dateFechaNac.getDate();
		  try{
		      DtEspectaculo dte = new DtEspectaculo(strartista, strplataforma, strnombre, strdescripcion, Integer.parseInt(this.txtDuracion.getText()), cantMin, cantMax, strurl, Integer.parseInt(this.txtCosto.getText()), dateRegistro,archivo.getName());
		      this.iconE.altaEspectaculo(dte, strplataforma);
		      String pathImagenAGuardar = imagenesSVPath + archivo.getName();
		      copiarArchivo(txturl, pathImagenAGuardar);
		      JOptionPane.showMessageDialog(null, "Espectaculo ingresado con Exito", "Agregar Espectaculo", JOptionPane.INFORMATION_MESSAGE);
		      limpiarFormulario();
		  }catch(EspectaculoRepetidoExcepcion ex){
		      System.out.println("Mensaje: " + ex.getFaultInfo());
		      JOptionPane.showMessageDialog(null, "Los datos ingresados no son correctos", "Error", JOptionPane.ERROR_MESSAGE);
		      limpiarFormulario();
		  }
		  setVisible(false);
	     }
	 }
	 
	 if (e.getSource() == btnAbrir) {
			JFileChooser browseImageFile = new JFileChooser();
			FileNameExtensionFilter fnef = new FileNameExtensionFilter("IMAGES", "png", "jpg", "jpeg");
			browseImageFile.addChoosableFileFilter(fnef);
			int showOpenDialogue = browseImageFile.showOpenDialog(null);

			if (showOpenDialogue == JFileChooser.APPROVE_OPTION) {
				archivo = browseImageFile.getSelectedFile();
				String selectedImagePath = archivo.getAbsolutePath();
				if (archivo.canRead()) {
					if (archivo.getName().endsWith("jpeg") || archivo.getName().endsWith("jpg")
							|| archivo.getName().endsWith("png") || archivo.getName().endsWith("gif")) {
						ImageIcon ii = new ImageIcon(selectedImagePath);
						Image image = ii.getImage().getScaledInstance(jLabelImage.getWidth(), jLabelImage.getHeight(),
								Image.SCALE_SMOOTH);
						jLabelImage.setIcon(new ImageIcon(image));
						this.txturl = selectedImagePath;;
					} else {
						JOptionPane.showMessageDialog(null, "Archivo no compatible");
					}
					this.txturl = selectedImagePath;
				}
			}
	 }
	 
	 if(e.getSource() == btnCancelar){
	     limpiarFormulario();
	     setVisible(false);
	 }
    }

	private boolean checkFormulario() {
		if (!txtNombre.getText().isEmpty() && !txtDescripcion.getText().isEmpty() && !txtDuracion.getText().isEmpty()
				&& !txtUrl.getText().isEmpty() && txtCosto.getText() != null && dateFechaNac.getDate() != null) {
			if (this.iconE.existeEspectaculo(txtNombre.getText())) {
				int respuesta = JOptionPane.showConfirmDialog(null,
						"El nombre del espectaculo ya existe\n¿Desea modificar los datos?\n", "Advertencia",
						JOptionPane.YES_NO_OPTION);
				if (respuesta != JOptionPane.YES_NO_OPTION) {
					limpiarFormulario();
					setVisible(false);
				}
				return false;
			}
		} else {
			JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios", "Error",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}

	private void limpiarFormulario() {
		txtNombre.setText("");
		txtDescripcion.setText("");
		txtDuracion.setText("");
		spinMin.setValue(0);
		spinMax.setValue(0);
		txtUrl.setText("");
		txtCosto.setText("");
		dateFechaNac.setDate(null);
		this.txturl = "";
		jLabelImage.setIcon(null);
	}

	public void copiarArchivo(String fromStr, String toStr) {
		Path from = Paths.get(fromStr);
		Path to = Paths.get(toStr);
		System.out.println("fromStr: " + fromStr);
		System.out.println("toStr: " + toStr);
		// Reemplazamos el fichero si ya existe
		CopyOption[] options = new CopyOption[] { StandardCopyOption.REPLACE_EXISTING,
				StandardCopyOption.COPY_ATTRIBUTES };
		try {
			System.out.println("Try");
			Files.copy(from, to, options);
		} catch (Exception e) {
			System.out.println("Catch");
		}
	}
}
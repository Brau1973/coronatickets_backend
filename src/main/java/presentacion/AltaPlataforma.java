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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import datatypes.DtPlataforma;
import excepciones.PlataformaRepetidaExcepcion;
import interfaces.IControladorPlataforma;

@SuppressWarnings("serial")
public class AltaPlataforma extends JInternalFrame implements ActionListener {
	private IControladorPlataforma iconP;
	private JButton btnGuardar, btnCancelar, btnAbrir;
	private JPanel miPanel;
	private JLabel lblTitulo, lblNombre, lblDescripcion, lblUrl, jLabelImage, jLabelImag;
	private JTextField txtNombre, txtDescripcion, txtUrl;
	private String imagenesSVPath = "C:\\Users\\Braulio\\Documents\\Brau2015\\Desarrollo\\Portfolio\\coronatickets_frontend\\coronaTicketsWeb\\WebContent\\imagenes\\Plataformas";
	private File archivo;
	private String imagePath;
	static final int X_LABEL = 10;
	static final int X_TEXT = 200;
	static final int Y_DIST = 30;
	static final int WIDTH_LABEL = 180;
	static final int WIDTH_TEXT = 200;
	static final int HEIGHT_FIELD = 25;

	// Constructor
	public AltaPlataforma(IControladorPlataforma iconP) {
		this.iconP = iconP;
		miPanel = new JPanel();
		miPanel.setLayout(null);
		add(miPanel);
		setBounds(30, 30, 800, 600);
		setResizable(false);
		setClosable(false);
		setIconifiable(false);
		setBorder(null);
		((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).setNorthPane(null);

		// Titulo
		lblTitulo = new JLabel("Alta Plataforma");
		lblTitulo.setFont(new java.awt.Font("Comic Sans MS", 1, 20));
		lblTitulo.setBounds(10, 0, 800, 25);
		miPanel.add(lblTitulo);

		// Nombre
		lblNombre = new JLabel("Nombre", SwingConstants.RIGHT);
		lblNombre.setBounds(X_LABEL, Y_DIST * 2, WIDTH_LABEL, HEIGHT_FIELD);
		miPanel.add(lblNombre);
		txtNombre = new JTextField();
		txtNombre.setBounds(X_TEXT, Y_DIST * 2, WIDTH_TEXT, HEIGHT_FIELD);
		miPanel.add(txtNombre);

		// Descripcion
		lblDescripcion = new JLabel("Descripcion", SwingConstants.RIGHT);
		lblDescripcion.setBounds(X_LABEL, Y_DIST * 3, WIDTH_LABEL, HEIGHT_FIELD);
		miPanel.add(lblDescripcion);
		txtDescripcion = new JTextField();
		txtDescripcion.setBounds(X_TEXT, Y_DIST * 3, WIDTH_TEXT, HEIGHT_FIELD);
		miPanel.add(txtDescripcion);

		// Url
		lblUrl = new JLabel("Url", SwingConstants.RIGHT);
		lblUrl.setBounds(X_LABEL, Y_DIST * 4, WIDTH_LABEL, HEIGHT_FIELD);
		miPanel.add(lblUrl);
		txtUrl = new JTextField();
		txtUrl.setBounds(X_TEXT, Y_DIST * 4, WIDTH_TEXT, HEIGHT_FIELD);
		miPanel.add(txtUrl);
		
		jLabelImag = new JLabel("Seleccionar imagen"); // label imagen
		jLabelImag.setBounds(X_LABEL, Y_DIST * 5, WIDTH_LABEL, HEIGHT_FIELD);
		miPanel.add(jLabelImag);

		jLabelImage = new JLabel(); // label imagen
		jLabelImage.setBounds(X_LABEL+200, Y_DIST * 7, WIDTH_LABEL-60, HEIGHT_FIELD+120);
		miPanel.add(jLabelImage);

		// Boton Abrir
		btnAbrir = new JButton();
		btnAbrir.setText("...");
		btnAbrir.setBounds(X_TEXT, Y_DIST * 5, WIDTH_TEXT, HEIGHT_FIELD);

		miPanel.add(btnAbrir);
		btnAbrir.addActionListener(this);
		
		// Boton Guardar
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(200, Y_DIST * 13, 115, 25);
		miPanel.add(btnGuardar);
		btnGuardar.addActionListener(this);

		// Boton cancelar
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(325, Y_DIST * 13, 115, 25);
		miPanel.add(btnCancelar);
		btnCancelar.addActionListener(this);

	}
	
	public void actionPerformed(ActionEvent e) {
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
						this.imagePath = selectedImagePath;
					} else {
						JOptionPane.showMessageDialog(null, "Archivo no compatible");
					}
					this.imagePath = selectedImagePath;
				}
			}
			
		}
		
		if (e.getSource() == btnGuardar){
			if (checkFormulario() && modificarDatos()) {
				String nombre = this.txtNombre.getText();
				String descripcion = this.txtDescripcion.getText();
				String url = this.txtUrl.getText();
				DtPlataforma dtP = new DtPlataforma(nombre, descripcion, url, archivo.getName());
				try {
					this.iconP.altaPlataforma(dtP);
					String pathImagenAGuardar = imagenesSVPath + archivo.getName();
					copiarArchivo(this.imagePath, pathImagenAGuardar);
					JOptionPane.showMessageDialog(this, "Plataforma ingresada con Exito");
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(this, ex.getMessage(), "Alta Plataforma", JOptionPane.ERROR_MESSAGE);
				}
				limpiarFormulario();
				setVisible(false);
			}
		}
	}

	protected void actionListenerCancelar(ActionEvent ca) {
		limpiarFormulario();
		setVisible(false);
	}

	@SuppressWarnings("unused")
	private boolean checkFormulario() {
		if (this.txtNombre.getText().isEmpty() || this.txtDescripcion.getText().isEmpty()
				|| this.txtUrl.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios", "Error",
					JOptionPane.ERROR_MESSAGE);
			return false;
		} else {
			return true;
		}
	}

	@SuppressWarnings("unused")
	private boolean modificarDatos() {
		// ManejadorPlataforma mP = ManejadorPlataforma.getInstancia();
		// if(mP.buscarPlataforma(txtNombre.getText()) != null){
		if (this.iconP.existePlataforma(txtNombre.getText())) {
			int respuesta = JOptionPane.showConfirmDialog(null,
					"El nombre de la plataforma ya existe\n¿Desea modificar los datos?\n", "Advertencia",
					JOptionPane.YES_NO_OPTION);
			if (respuesta != JOptionPane.YES_NO_OPTION) {
				limpiarFormulario();
				setVisible(false);
			}
			return false;
		}
		return true;
	}

	private void limpiarFormulario() {
		txtNombre.setText("");
		txtDescripcion.setText("");
		txtUrl.setText("");
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

package presentacion;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;

import datatypes.DtArtista;
import datatypes.DtEspectador;
import datatypes.DtUsuario;
import interfaces.Fabrica;
import interfaces.IControladorEspectaculo;
import interfaces.IControladorUsuario;

@SuppressWarnings("serial")
public class ConsultarUsuario extends JInternalFrame implements ActionListener {

	private JPanel miPanel;
//   private JScrollPane panel;
	private JLabel lblTitulo, lblBuscar,jLabelImage;
	// private JDateChooser dateFechaNac;
	// private JTable tabUsuario;
	private JComboBox<String> comboUsuarios;
	private JTextArea jtextarea;
	private List<String> listUsuariosStr;
	IControladorUsuario iconU = Fabrica.getInstancia().getIControladorUsuario();
	IControladorEspectaculo iconE = Fabrica.getInstancia().getIControladorEspectaculo();

	// Constructor
	public ConsultarUsuario(IControladorUsuario iconU) {
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
		lblTitulo.setBounds(10, 1, 380, 25);
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

		jtextarea = new JTextArea(25, 150);
		Border border = BorderFactory.createLineBorder(Color.GRAY);
		jtextarea
				.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		jtextarea.setBounds(10, 70, 330, 300);
		jtextarea.setFont(new java.awt.Font("Verdana", 1, 12));
		jtextarea.setOpaque(false);
		jtextarea.setAutoscrolls(maximizable);
		miPanel.add(jtextarea);
		
		jLabelImage = new JLabel();
		jLabelImage.setBounds(10, 400, 140, 140);
		miPanel.add(jLabelImage);

		// Tabla Funciones de espectulos
		/*
		 * DefaultTableModel model = new DefaultTableModel(data, header); tabUsuario =
		 * new JTable(model); tabUsuario.setPreferredScrollableViewportSize(new
		 * Dimension(40, 290)); JScrollPane jsPane = new JScrollPane(tabUsuario);
		 * jsPane.setBounds(10, 180, 365, 118); jsPane.setVisible(false);
		 * miPanel.add(jsPane, BorderLayout.SOUTH);
		 */
		// Click en tabUsuario
		/*
		 * tabUsuario.addMouseListener(new MouseAdapter(){ public void
		 * mouseClicked(MouseEvent evt){ int fila =
		 * tabUsuario.rowAtPoint(evt.getPoint());
		 * txtNombre.setText(String.valueOf(tabUsuario.getValueAt(fila, 0)));
		 * txtApellido.setText(String.valueOf(tabUsuario.getValueAt(fila, 1))); } });
		 */
		// iniciaComboBoxU();
	}

	// Inicializar ComboBox
	public void iniciaComboBoxU() {
		comboUsuarios.removeAllItems();
		listUsuariosStr = iconU.listarNicknameUsuarios();
		listUsuariosStr.forEach((u) -> {
			comboUsuarios.addItem(u);
		});
		/*
		 * ManejadorUsuario mU = ManejadorUsuario.getInstancia(); listUsuarios =
		 * mU.obtenerUsuario(); listUsuarios.forEach((u) -> {
		 * comboUsuarios.addItem(u.getNickname()); });
		 */
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == comboUsuarios) {
			//String strUsuario = "";
			//jLabelImage.setIcon(null);
			if(this.comboUsuarios.getSelectedItem() != null) {
				String strUsuario = this.comboUsuarios.getSelectedItem().toString();
				DtUsuario dtusu = iconU.obtenerInfoUsuario(strUsuario);
				String datos = "";
				String op = "";
				SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
				if (dtusu instanceof DtArtista) {
					System.out.println("ARTISTA");
					op = "--------Artistas--------\n\n";
					
					List<String> espArtista = iconE.obtenerEspectaculosArtista(strUsuario);
					datos = "\n\nLista de espectaculos:";
					for (String i : espArtista) {
						datos = datos + "\n" + i.toString();
					}
					
					jtextarea.setText(op + "Nombre: " + dtusu.getNombre() + "\nApellido: " + dtusu.getApellido() + "\nEmail: "
							+ dtusu.getEmail() + "\nFecha: " + formatoFecha.format(dtusu.getfNacimiento()) + "\nDescripcion: "
							+ ((DtArtista) dtusu).getDescripcion() + "\nBiografia: " +((DtArtista) dtusu).getBiografia() 
							+ "\nLink: " +((DtArtista) dtusu).getLink() +  
							datos);
				} else if (dtusu instanceof DtEspectador) {
					System.out.println("ESPECTADOR");
					op = "--------Espectador--------\n\n";
					jtextarea.setText(op + "Nombre: " + dtusu.getNombre() + "\nApellido: " + dtusu.getApellido() + "\nEmail: "
							+ dtusu.getEmail() + "\nFecha: " + formatoFecha.format(dtusu.getfNacimiento()) + datos);
				}
				// CARGA POSIBLE IMAGEN
				if(dtusu.getImagen()!= null) {
					System.out.println("TENGO IMAGEN");
					byte[] b = dtusu.getImagen();
					BufferedImage image = null;
					InputStream in = new ByteArrayInputStream(b);
					//System.out.println("IN: " + b);
					try{
						image = ImageIO.read(in);
					}catch(IOException e1){
						e1.printStackTrace();
					}
					ImageIcon imgi = new ImageIcon(image);
					Image imagei = imgi.getImage().getScaledInstance(jLabelImage.getWidth(), jLabelImage.getHeight(), Image.SCALE_SMOOTH);
					jLabelImage.setIcon(new ImageIcon(imagei));
				}
			}
		}
	}
}

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

	private IControladorUsuario iconU;
	private JPanel miPanel;
	private JLabel lblTitulo, lblBuscar,jLabelImage;
	private JComboBox<String> comboUsuarios;
	private JTextArea jtextarea;
	private List<String> listUsuariosStr;
	private String imagenesSVPath = "C:\\Users\\Braulio\\Documents\\Brau2015\\Desarrollo\\Portfolio\\coronatickets_frontend\\coronaTicketsWeb\\WebContent\\imagenes\\Usuarios\\";
	private String imagenesSVPathUser;
	//IControladorUsuario iconU = Fabrica.getInstancia().getIControladorUsuario();
	IControladorEspectaculo iconE = Fabrica.getInstancia().getIControladorEspectaculo();

	// Constructor
	public ConsultarUsuario(IControladorUsuario iconU) {
		this.iconU = iconU;
		miPanel = new JPanel();
		miPanel.setLayout(null);
		add(miPanel);
		setBounds(15, 15, 800, 600);
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
		
		/*
		jLabelIamgeTxt = new JLabel("IMAGEN AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA: ");
		jLabelIamgeTxt.setBounds(10, 65, 140, 4);
		miPanel.add(jLabelIamgeTxt);	
		*/
		
		jtextarea = new JTextArea(25, 150);
		Border border = BorderFactory.createLineBorder(Color.GRAY);
		jtextarea.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		jtextarea.setBounds(10, 70, 330, 300);
		jtextarea.setFont(new java.awt.Font("Verdana", 1, 12));
		jtextarea.setOpaque(false);
		jtextarea.setAutoscrolls(maximizable);
		miPanel.add(jtextarea);
		
		/*
		jLabelIamgeTxt = new JLabel("IMAGEN AAAAAAAAAAAAAAAAAAAAAAAAAA: ");
		jLabelIamgeTxt.setBounds(350, 150, 140, 140);
		miPanel.add(jLabelIamgeTxt);	
		*/
		
		jLabelImage = new JLabel();
		jLabelImage.setBounds(350, 150, 140, 140);
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
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == comboUsuarios) {
			if(this.comboUsuarios.getSelectedItem() != null) {
				String strUsuario = this.comboUsuarios.getSelectedItem().toString();
				DtUsuario dtusu = iconU.obtenerInfoUsuario(strUsuario);
				String datos = "";
				String op = "";
				jLabelImage.setIcon(null);
				
				SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
				if (dtusu instanceof DtArtista) {
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
					imagenesSVPathUser = this.imagenesSVPath+"Artistas\\";
				} else if (dtusu instanceof DtEspectador) {
					op = "--------Espectador--------\n\n";
					jtextarea.setText(op + "Nombre: " + dtusu.getNombre() + "\nApellido: " + dtusu.getApellido() + "\nEmail: "
							+ dtusu.getEmail() + "\nFecha: " + formatoFecha.format(dtusu.getfNacimiento()) + datos);
					imagenesSVPathUser = this.imagenesSVPath+"Espectadores\\";
				}
				// CARGA POSIBLE IMAGEN
				if(dtusu.getImageName() != null) {
					ImageIcon imgi = new ImageIcon(imagenesSVPathUser+dtusu.getImageName());
					Image imagei = imgi.getImage().getScaledInstance(jLabelImage.getWidth(), jLabelImage.getHeight(), Image.SCALE_SMOOTH);
					jLabelImage.setIcon(new ImageIcon(imagei));
				}
			}
		}
	}
}

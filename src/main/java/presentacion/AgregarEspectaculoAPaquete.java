package presentacion;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import logica.PaqueteEspectaculos;
import java.awt.Font;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class AgregarEspectaculoAPaquete extends JInternalFrame {
	private JPanel miPanel;
	static final int X_LABEL = 10;
	static final int X_TEXT = 200;
	static final int Y_DIST = 30;
	static final int WIDTH_LABEL = 180;
	static final int WIDTH_TEXT = 200;
	static final int HEIGHT_FIELD = 25;

	private String[] header = { "Nombre", "Descripcion", "etc," };
	private String[][] data = {};

	private PaqueteEspectaculos paqueteSelected;

	List<PaqueteEspectaculos> lstPaquetes = new ArrayList<PaqueteEspectaculos>();
	private JTable table;

	// Constructor
	public AgregarEspectaculoAPaquete() {

		// cargarDatosPrueba();

		miPanel = new JPanel();
		miPanel.setBounds(0, 0, 800, 100);
		getContentPane().add(miPanel);
		miPanel.setLayout(null);

		JLabel lblTitulo = new JLabel("Agregar Espectaculo a Paquete ");
		lblTitulo.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		lblTitulo.setBounds(10, 0, 800, 25);
		miPanel.add(lblTitulo);

		JLabel lblPaquete = new JLabel("Paquete", SwingConstants.RIGHT);
		lblPaquete.setBounds(10, 53, 180, 25);
		miPanel.add(lblPaquete);

		JComboBox<String> comboPaquetes = new JComboBox<String>();
		comboPaquetes.setBounds(202, 53, 200, 25);
		miPanel.add(comboPaquetes);

		JLabel lblPlataforma = new JLabel("Plataforma", SwingConstants.RIGHT);
		lblPlataforma.setBounds(10, 87, 180, 25);
		miPanel.add(lblPlataforma);

		JComboBox<String> comboPlataformas = new JComboBox<String>();
		comboPlataformas.setBounds(202, 87, 200, 25);
		miPanel.add(comboPlataformas);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 143, 494, 168);
		miPanel.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Nombre", "Descripcion" }));
		scrollPane.setViewportView(table);

		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.setBounds(152, 339, 89, 23);
		miPanel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.setBounds(329, 339, 89, 23);
		miPanel.add(btnNewButton_1);
		setBounds(30, 30, 800, 600);
		setResizable(false);
		setClosable(false);
		setIconifiable(false);
		setBorder(null);
		((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).setNorthPane(null);
		lstPaquetes.forEach((p) -> {
			comboPaquetes.addItem(p.getNombre());
		});

		// Tabla Espectaculos
		DefaultTableModel model = new DefaultTableModel(data, header);
	}

	private void limpiarTabla(DefaultTableModel dtm) {
		int cantRow = dtm.getRowCount();
		for (int i = 0; i < cantRow; i++) {
			dtm.removeRow(0);
		}
	}

}

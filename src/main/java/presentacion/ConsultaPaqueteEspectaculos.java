package presentacion;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import interfaces.Fabrica;
import interfaces.IControladorPaquete;
import logica.Espectaculo;
import logica.PaqueteEspectaculos;

@SuppressWarnings("serial")
public class ConsultaPaqueteEspectaculos extends JInternalFrame {
	private JPanel miPanel, panelEsp;
	private JLabel lblTitulo, lblPaquete, lblNombEspectaculo, lblDescripcion, lblCosto, lblDuracion;
	private JTable tablaEspectaculos;
	private JComboBox<String> comboPaquetes;
	private JTextField txtNombEspectaculo, txtDescripcion, txtCosto, txtDuracion;
	private Border borderPnlEspectaculos;
	static final int X_LABEL = 10;
	static final int X_TEXT = 200;
	static final int Y_DIST = 30;
	static final int WIDTH_LABEL = 180;
	static final int WIDTH_TEXT = 200;
	static final int HEIGHT_FIELD = 25;
	static final String SELECCIONE = "Seleccione";

	private String[] header = { "Nombre", "Artista", "Plataforma", "Descripción" };
	private String[][] data = {};

	private PaqueteEspectaculos paqueteSelected;
	List<PaqueteEspectaculos> lstPaquetes = new ArrayList<PaqueteEspectaculos>();

	IControladorPaquete iControladorPaquete = Fabrica.getInstancia().getIControladorPaquete();

	// Constructor
	public ConsultaPaqueteEspectaculos() {
		lstPaquetes = iControladorPaquete.obtenerPaquetes();

		miPanel = new JPanel();
		miPanel.setLayout(null);
		miPanel.setBounds(0, 0, 800, 100);
		add(miPanel);
		setBounds(30, 30, 800, 600);
		setResizable(false);
		setClosable(false);
		setIconifiable(false);
		setBorder(null);
		((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).setNorthPane(null);

		// Titulo
		lblTitulo = new JLabel("Consultar Paquete de Espectaculos");
		lblTitulo.setFont(new java.awt.Font("Comic Sans MS", 1, 20));
		lblTitulo.setBounds(10, 0, 800, 25);
		miPanel.add(lblTitulo);

		// Combo Paquete
		lblPaquete = new JLabel("Paquete", SwingConstants.RIGHT);
		lblPaquete.setBounds(X_LABEL, Y_DIST * 2, WIDTH_LABEL, HEIGHT_FIELD);
		miPanel.add(lblPaquete);
		comboPaquetes = new JComboBox<String>();
		comboPaquetes.addItem(SELECCIONE);
		comboPaquetes.setBounds(X_TEXT, Y_DIST * 2, WIDTH_TEXT, HEIGHT_FIELD);
		lstPaquetes.forEach((p) -> {
			comboPaquetes.addItem(p.getNombre());
		});
		comboPaquetes.addItemListener(this::listenerComboPaquetes);
		miPanel.add(comboPaquetes);

		// Tabla Espectaculos
		DefaultTableModel model = new DefaultTableModel(data, header);
		tablaEspectaculos = new JTable(model);
		tablaEspectaculos.setPreferredScrollableViewportSize(new Dimension(40, 190));
		JScrollPane sp = new JScrollPane(tablaEspectaculos);
		tablaEspectaculos.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int row = tablaEspectaculos.getSelectedRow();
				Espectaculo esp = paqueteSelected.getEspectaculos().get(row);
				cargarPanelEspectaculo(esp);
			}
		});
		sp.setBounds(20, Y_DIST * 4, 700, 150);
		miPanel.add(sp);

		// Panel detalles Espectaculo
		panelEsp = new JPanel();
		borderPnlEspectaculos = BorderFactory.createTitledBorder("Espectaculo");
		panelEsp.setBorder(borderPnlEspectaculos);
		panelEsp.setLayout(null);
		panelEsp.setBounds(X_LABEL, Y_DIST * 9, 500, 200);
		miPanel.add(panelEsp);
		panelEsp.setVisible(false);
		lblNombEspectaculo = new JLabel("Espectaculo", SwingConstants.RIGHT);
		lblNombEspectaculo.setBounds(X_LABEL, Y_DIST, WIDTH_LABEL, HEIGHT_FIELD);
		panelEsp.add(lblNombEspectaculo);
		txtNombEspectaculo = new JTextField();
		txtNombEspectaculo.setEnabled(false);
		txtNombEspectaculo.setBounds(X_TEXT, Y_DIST, WIDTH_TEXT, HEIGHT_FIELD);
		panelEsp.add(txtNombEspectaculo);
		
		lblDescripcion = new JLabel("Descripcion", SwingConstants.RIGHT);
		lblDescripcion.setBounds(X_LABEL, Y_DIST*2, WIDTH_LABEL, HEIGHT_FIELD);
		panelEsp.add(lblDescripcion);
		txtDescripcion = new JTextField();
		txtDescripcion.setEnabled(false);
		txtDescripcion.setBounds(X_TEXT, Y_DIST*2, WIDTH_TEXT, HEIGHT_FIELD);
		panelEsp.add(txtDescripcion);
		
		lblCosto = new JLabel("Costo", SwingConstants.RIGHT);
		lblCosto.setBounds(X_LABEL, Y_DIST*3, WIDTH_LABEL, HEIGHT_FIELD);
		panelEsp.add(lblCosto);
		txtCosto = new JTextField();
		txtCosto.setEnabled(false);
		txtCosto.setBounds(X_TEXT, Y_DIST*3, WIDTH_TEXT, HEIGHT_FIELD);
		panelEsp.add(txtCosto);
		
		lblDuracion = new JLabel("Duracion", SwingConstants.RIGHT);
		lblDuracion.setBounds(X_LABEL, Y_DIST*4, WIDTH_LABEL, HEIGHT_FIELD);
		panelEsp.add(lblDuracion);
		txtDuracion = new JTextField();
		txtDuracion.setEnabled(false);
		txtDuracion.setBounds(X_TEXT, Y_DIST*4, WIDTH_TEXT, HEIGHT_FIELD);
		panelEsp.add(txtDuracion);
	}

	private void listenerComboPaquetes(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			DefaultTableModel tm = (DefaultTableModel) tablaEspectaculos.getModel();
			if (!e.getItem().equals(SELECCIONE)) {
				limpiarTabla(tm);
				paqueteSelected = lstPaquetes.stream().filter(p -> (p.getNombre() == e.getItem())).findFirst().get();
				for (int i = 0; i < paqueteSelected.getEspectaculos().size(); i++) {
					Espectaculo esp = paqueteSelected.getEspectaculos().get(i);
					Object[] data = { esp.getNombre(), esp.getArtista(), esp.getPlataforma(), esp.getDescripcion() };
					tm.addRow(data);
				}
			}else {
				limpiarTabla(tm);
			}
		}
	}

	private void cargarPanelEspectaculo(Espectaculo espectaculo) {
		panelEsp.setVisible(true);
		txtNombEspectaculo.setText(espectaculo.getNombre());
		txtDescripcion.setText(espectaculo.getDescripcion());
		txtCosto.setText(String.valueOf(espectaculo.getCosto()));
		txtDuracion.setText(String.valueOf(espectaculo.getDuracion()));
	}

	private void limpiarTabla(DefaultTableModel dtm) {
		panelEsp.setVisible(false);
		int cantRow = dtm.getRowCount();
		for (int i = 0; i < cantRow; i++) {
			dtm.removeRow(0);
		}
	}

}
package presentacion;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.util.List;
import java.util.Optional;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import datatypes.DtEspectaculo;
import datatypes.DtPaqueteEspectaculo;
import datatypes.DtPlataforma;
import interfaces.Fabrica;
import interfaces.IControladorPaquete;
import interfaces.IControladorPlataforma;

@SuppressWarnings("serial")
public class AgregarEspectaculoAPaquete extends JInternalFrame {
	private JPanel miPanel;
	private JButton btnGuardar, btnCancelar;
	static final int X_LABEL = 10;
	static final int X_TEXT = 200;
	static final int Y_DIST = 30;
	static final int WIDTH_LABEL = 180;
	static final int WIDTH_TEXT = 200;
	static final int HEIGHT_FIELD = 25;
	static final String SELECCIONE = "Seleccione";
	private JComboBox<String> comboPlataformas, comboPaquetes, comboEspectaculo;
/*	private String[] header = { "Nombre", "Descripcion", "etc," };
	private String[][] data = {};
	private JTable table;*/
	private IControladorPlataforma iconP;
	private IControladorPaquete iconPaquete;
	private List<DtPlataforma> listPlataformas;
	private List<DtPaqueteEspectaculo> listPaquetes;
	private DtPaqueteEspectaculo paqueteSelected;
	private DtPlataforma plataformaSelected;
	private String espectaculoSelected = "";

	// Constructor
	public AgregarEspectaculoAPaquete() {
		iconP = Fabrica.getInstancia().getIControladorPlataforma();
		iconPaquete = Fabrica.getInstancia().getIControladorPaquete();
		setBounds(30, 30, 800, 600);
		setResizable(false);
		setClosable(false);
		setIconifiable(false);
		setBorder(null);
		((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).setNorthPane(null);
		miPanel = new JPanel();
		miPanel.setBounds(0, 0, 800, 100);
		getContentPane().add(miPanel);
		miPanel.setLayout(null);

		JLabel lblTitulo = new JLabel("Agregar Espectaculo a Paquete ");
		lblTitulo.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		lblTitulo.setBounds(10, 0, 800, 25);
		miPanel.add(lblTitulo);

		JLabel lblPaquete = new JLabel("Paquete", SwingConstants.RIGHT);
		lblPaquete.setBounds(X_LABEL, Y_DIST, WIDTH_LABEL, HEIGHT_FIELD);
		miPanel.add(lblPaquete);

		comboPaquetes = new JComboBox<String>();
		comboPaquetes.setBounds(X_TEXT, Y_DIST, WIDTH_TEXT, HEIGHT_FIELD);
		comboPaquetes.addItemListener(this::listenerComboPaquetes);
		miPanel.add(comboPaquetes);

		JLabel lblPlataforma = new JLabel("Plataforma", SwingConstants.RIGHT);
		lblPlataforma.setBounds(X_LABEL, Y_DIST * 2, WIDTH_LABEL, HEIGHT_FIELD);
		miPanel.add(lblPlataforma);

		comboPlataformas = new JComboBox<String>();
		comboPlataformas.setBounds(X_TEXT, Y_DIST * 2, WIDTH_TEXT, HEIGHT_FIELD);
		comboPlataformas.addItemListener(this::listenerComboPlataforma);
		miPanel.add(comboPlataformas);

		JLabel lblEspectaculo = new JLabel("Espectaculo", SwingConstants.RIGHT);
		lblEspectaculo.setBounds(X_LABEL, Y_DIST * 3, WIDTH_LABEL, HEIGHT_FIELD);
		miPanel.add(lblEspectaculo);

		comboEspectaculo = new JComboBox<String>();
		comboEspectaculo.setBounds(X_TEXT, Y_DIST * 3, WIDTH_TEXT, HEIGHT_FIELD);
		comboEspectaculo.addItemListener(this::listenerComboEspectaculo);
		miPanel.add(comboEspectaculo);
		// Boton Guardar
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionListenerGuardar(e);
			}

		});
		btnGuardar.setBounds(200, Y_DIST * 6, 115, 25);
		miPanel.add(btnGuardar);

		// Boton cancelar
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionListenerCancelar(e);
			}

		});
		btnCancelar.setBounds(325, Y_DIST * 6, 115, 25);
		miPanel.add(btnCancelar);
	}

	private void listenerComboPlataforma(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			if (!e.getItem().equals(SELECCIONE)) {
				plataformaSelected = listPlataformas.stream().filter(p -> (p.getNombre() == e.getItem())).findFirst().get();
				if (paqueteSelected != null) {
					cargarComboEspectaculo(plataformaSelected, paqueteSelected);
				}
			} else if (e.getItem().equals(SELECCIONE)) {
				comboEspectaculo.removeAllItems();
				espectaculoSelected = "";
				plataformaSelected = null;
			}
		}
	}

	private void listenerComboPaquetes(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			if (!e.getItem().equals(SELECCIONE)) {
				paqueteSelected = listPaquetes.stream().filter(p -> (p.getNombre() == e.getItem())).findFirst().get();
				if (plataformaSelected != null) {
					cargarComboEspectaculo(plataformaSelected, paqueteSelected);
				}
			} else if (e.getItem().equals(SELECCIONE)) {
				comboEspectaculo.removeAllItems();
				espectaculoSelected = "";
				paqueteSelected = null;
			}
		}
	}

	private void listenerComboEspectaculo(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			if (!e.getItem().equals(SELECCIONE)) {
				espectaculoSelected = e.getItem().toString();
			} else if (e.getItem().equals(SELECCIONE)) {
				espectaculoSelected = "";
			}
		}
	}

	private void cargarComboEspectaculo(DtPlataforma plataforma, DtPaqueteEspectaculo paquete) {
		comboEspectaculo.removeAllItems();
		comboEspectaculo.addItem(SELECCIONE);
		comboEspectaculo.setSelectedItem(SELECCIONE);
		for (DtEspectaculo espectaculo : plataforma.getEspectaculo()) {
			Optional<DtEspectaculo> op = paquete.getEspectaculos().stream().filter(e -> (e.getNombre() == espectaculo.getNombre())).findFirst();
			if (!op.isPresent()) {
				comboEspectaculo.addItem(espectaculo.getNombre());
			}
		}
	}

	public void iniciarlizarComboBox() {
		comboPlataformas.removeAllItems();
		comboPaquetes.removeAllItems();
		comboEspectaculo.removeAllItems();
		comboPaquetes.addItem(SELECCIONE);
		comboPaquetes.setSelectedItem(SELECCIONE);
		comboPlataformas.addItem(SELECCIONE);
		comboPlataformas.setSelectedItem(SELECCIONE);
		iconP.listarPlataformas();
		listPlataformas.forEach((p) -> {
			comboPlataformas.addItem(p.getNombre());
		});
		listPaquetes = iconPaquete.obtenerPaquetes();
		listPaquetes.forEach((p) -> {
			comboPaquetes.addItem(p.getNombre());
		});
	}

	private void actionListenerGuardar(ActionEvent al) {
		if (paqueteSelected != null && plataformaSelected != null && !espectaculoSelected.isEmpty()) {
			iconPaquete.agregarEspectaculo(paqueteSelected.getNombre(), espectaculoSelected);
			JOptionPane.showMessageDialog(this, "Se agrego el espectaculo al paquete con Exito");
			iniciarlizarComboBox();
		} else {
			JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void actionListenerCancelar(ActionEvent al) {
		setVisible(false);
	}

}

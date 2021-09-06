package presentacion;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.IconifyAction;
import javax.swing.table.DefaultTableModel;

import interfaces.Fabrica;
import interfaces.IControladorEspectaculo;
import interfaces.IControladorFuncion;
import interfaces.IControladorPlataforma;
import logica.Espectaculo;
import logica.Funcion;
import logica.Plataforma;
import manejadores.ManejadorFuncion;
import javax.swing.JTextArea;

@SuppressWarnings("serial")

public class ConsultaFuncion extends JInternalFrame {
	private IControladorFuncion iconF;
	private IControladorPlataforma iconP;
	private IControladorEspectaculo iconE;
	private JButton btnAceptar, btnCancelar;
	private JPanel miPanel;
	private JLabel lblTitulo, lblPlataforma, lblEspectaculos, lblFunciones, lblNombre, lblFecha, lblHora,
			lblArtistasInv, lblFechaAlta;
	private JTextArea txtDatosFuncion;
	private JScrollPane scrollDatosFuncion;
	private JComboBox<String> comboEspectaculos, comboPlataforma, comboFunciones;
	// private JTable tabFuncion;
	private JScrollPane scrollPane;
	private JList listFunciones;
	private String[] header = { "Plataforma", "Espectaculo" };
	private String[][] data = { { "1", "las aventuras de seba" }, { "2", "seba por el tiempo" }, { "3", "sebalandia" },
			{ "4", "la cocina de seba" } };
	private List<Plataforma> listPlataformas;
	private List<Espectaculo> listEspectaculos;
	private List<Funcion> listFuncion;

	// Constructor
	public ConsultaFuncion(IControladorFuncion iconF) {
		this.iconF = iconF;
		iconP = Fabrica.getInstancia().getIControladorPlataforma();
		iconE = Fabrica.getInstancia().getIControladorEspectaculo();
		miPanel = new JPanel();
		miPanel.setLayout(null);
		getContentPane().add(miPanel);
		setBounds(30, 30, 800, 600);
		setResizable(false);
		setClosable(false);
		setIconifiable(false);
		setBorder(null);
		((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).setNorthPane(null);

		lblTitulo = new JLabel();
		lblTitulo.setText("Consulta de Funcion de Espectaculo");
		lblTitulo.setBounds(10, 0, 400, 20);
		lblTitulo.setFont(new java.awt.Font("Comic Sans MS", 1, 17));
		miPanel.add(lblTitulo);

		lblPlataforma = new JLabel();
		lblPlataforma.setText("Plataforma");
		lblPlataforma.setBounds(10, 30, 200, 20);
		miPanel.add(lblPlataforma);

		comboPlataforma = new JComboBox<String>();
		// comboPlataforma.addItem("Seleccione Plataforma");
		comboPlataforma.setBounds(220, 30, 200, 20);
		miPanel.add(comboPlataforma);
		comboPlataforma.addItemListener(this::listenerComboPlataforma);

		lblEspectaculos = new JLabel();
		lblEspectaculos.setText("Espectaculos");
		lblEspectaculos.setBounds(10, 60, 200, 20);
		miPanel.add(lblEspectaculos);

		comboEspectaculos = new JComboBox<String>();
		// comboEspectaculos.addItem("Seleccione Espectaculo");
		comboEspectaculos.setBounds(220, 60, 200, 20);
		miPanel.add(comboEspectaculos);
		comboEspectaculos.addItemListener(this::listenerComboEspectaculo);

		lblFunciones = new JLabel();
		lblFunciones.setText("Funciones");
		lblFunciones.setBounds(10, 90, 200, 20);
		miPanel.add(lblFunciones);

		comboFunciones = new JComboBox<String>();
		// comboFunciones.addItem("Seleccione Funcion");
		comboFunciones.setBounds(220, 90, 200, 20);
		miPanel.add(comboFunciones);
		comboFunciones.addItemListener(this::listenerComboFunciones);

		lblPlataforma = new JLabel();
		lblPlataforma.setText("Datos De La Funcion");
		lblPlataforma.setBounds(10, 120, 250, 20);
		miPanel.add(lblPlataforma);

		txtDatosFuncion = new JTextArea();
		txtDatosFuncion.setTabSize(8);
		txtDatosFuncion.setBounds(220, 130, 300, 100);
		txtDatosFuncion.setFont(new java.awt.Font("Verdana", 1, 12));
		miPanel.add(txtDatosFuncion);

		/*
		 * scrollDatosFuncion = new JScrollPane(txtDatosFuncion);
		 * scrollDatosFuncion.setBounds(220, 130, 330, 150);
		 * miPanel.add(scrollDatosFuncion);
		 */
		/*
		 * listFunciones = new JList();
		 * listFunciones.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION
		 * ); // modelo = new DefaultListModel(); scrollPane = new JScrollPane();
		 * scrollPane.setBounds(300, 250, 120, 60);
		 * scrollPane.setViewportView(listFunciones); miPanel.add(scrollPane);
		 */

		/*
		 * DefaultTableModel model = new DefaultTableModel(data, header); tabFuncion =
		 * new JTable(model); tabFuncion.setPreferredScrollableViewportSize(new
		 * Dimension(40, 290)); JScrollPane jsPane = new JScrollPane(tabFuncion);
		 * jsPane.setBounds(10, 150, 365, 118); jsPane.setVisible(true);
		 * miPanel.add(jsPane, BorderLayout.SOUTH);
		 * 
		 * // Boton Aceptar btnAceptar = new JButton(); btnAceptar.setText("Aceptar");
		 * btnAceptar.setBounds(200, 270, 115, 25); miPanel.add(btnAceptar); ///
		 * btnAceptar.addActionListener(this);
		 * 
		 * // Boton Cancelar btnCancelar = new JButton();
		 * btnCancelar.setText("Cancelar"); btnCancelar.setBounds(322, 270, 115, 25);
		 * miPanel.add(btnCancelar); // btnCancelar.addActionListener(this);
		 */
	}

	public void inicializarComboBox() {
		comboPlataforma.removeAllItems();
		comboEspectaculos.removeAllItems();
		comboFunciones.removeAllItems();
		listPlataformas = iconP.listarPlataformas();
		listPlataformas.forEach((p) -> {
			comboPlataforma.addItem(p.getNombre());
		});
		// modelo.clear();
	}

	/*
	 * public void inicializarComboBoxes(){ // DefaultComboBoxModel<String>
	 * modelFuncionEspectaculo = new
	 * DefaultComboBoxModel<String>(icon.listarPlataformas()); //
	 * comboPlataforma.setModel(modelFuncionEspectaculo); }
	 */

	private void listenerComboPlataforma(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			if (e.getSource() == comboPlataforma) {
				System.out.println("CLICK EN COMBO PLATAFORMA");
				String strPlataforma = this.comboPlataforma.getSelectedItem().toString();
				/*Plataforma plataforma = listPlataformas.stream().filter(p -> (p.getNombre() == strPlataforma))
						.findFirst().get();
				this.listEspectaculos = plataforma.getEspectaculo();*/
				if (listEspectaculos.isEmpty()) {
					System.out.println("LISTA DE ESPECTACULOS VACIA");
					comboEspectaculos.removeAllItems();
				} else {
					comboEspectaculos.removeAllItems();
					listEspectaculos.forEach((esp) -> {
						comboEspectaculos.addItem(esp.getNombre());
					});
				}
			}
		}
	}

	private void listenerComboEspectaculo(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			if (e.getSource() == comboEspectaculos) {
				System.out.println("CLICK EN COMBO ESPECTACULO");
				String strEspectaculo = this.comboEspectaculos.getSelectedItem().toString();
				Espectaculo espectaculo = listEspectaculos.stream().filter(es -> (es.getNombre() == strEspectaculo))
						.findFirst().get();
				List<Funcion> listFunciones = espectaculo.getFunciones();
				if (listFunciones.isEmpty()) {
					System.out.println("LISTA DE FUNCIONES VACIA");
					comboFunciones.removeAllItems();
				} else {
					comboFunciones.removeAllItems();
					listFunciones.forEach((f) -> {
						comboFunciones.addItem(f.getNombre());
					});
				}
			}
		}

	}

	private void listenerComboFunciones(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			if (e.getSource() == comboFunciones) {
				System.out.println("CLICK EN COMBO FUNCION");
				// System.out.println("CLICK EN COMBO PLATAFORMA");
				String strFuncion = this.comboFunciones.getSelectedItem().toString();
				Funcion f = this.iconF.obtenerFuncion(strFuncion);
				SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
				SimpleDateFormat formatoHora = new SimpleDateFormat("hh:mm");
				txtDatosFuncion.setText("Nombre: " + f.getNombre() + "\nFecha: " + formatoFecha.format(f.getFecha())
						+ "\nFecha Alta: " + formatoFecha.format(f.getRegistro()) + "\nHora Inicio: "
						+ formatoHora.format(f.getHoraInicio()) + "\nEspectaculo: " + f.getEspectaculo());
			}
		}
	}
}
package presentacion;

import java.awt.Image;
import java.awt.event.ItemEvent;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

import datatypes.DtEspectaculo;
import datatypes.DtFuncion;
import datatypes.DtPaqueteEspectaculos;
import datatypes.DtPlataforma;
import interfaces.Fabrica;
import interfaces.IControladorFuncion;
import interfaces.IControladorPlataforma;

@SuppressWarnings("serial")
public class ConsultaEspectaculo extends JInternalFrame {
	private IControladorPlataforma iconP;
//	private IControladorEspectaculo iconE;
	//private IControladorPaquete iconPaquete;
	private IControladorFuncion iconF;
	private JPanel miPanel;
	private JLabel lblTitulo, lblPlataforma, lblEspectaculos, lblPaquetes;
	private JComboBox<String> comboPlataforma, comboEspectaculos, comboPaquetes, comboFunciones;
	private List<DtPlataforma> listPlataformas;
//	private List<DtEspectaculo> listEspectaculos;
//	private List<Espectaculo> listEspectaculos2;
	private List<DtFuncion> listFunciones;
	private List<DtPaqueteEspectaculos> listPaqEspe;
	//private List<DtPaqueteEspectaculo> listPaquetes;
	private JLabel lblCantidadMaxima;
	private JLabel lblURL, lblCosto, lblRegistro,jLabelImage;
	private JTextField textNombreEspectaculo;
	private JTextField textArtistaOrganizador, textDescripcion, textDuracion, textCantidadMinima, textCantidadMaxima, textURL, textRegistro, textCosto;
	private JLabel lblFunciones;
	static final String SELECCIONE = "Seleccione";
	private DtPaqueteEspectaculos paqueteSelected;
	private DtFuncion funcionSelect;
	private PnlDatosPaquete pnlDatosPaquete;
	private PnlDatosFuncion pnlDatosFuncion;
	private DtPlataforma plataformaSelected;
	//private String espectaculoSelected = "";
	private String imagenesSVPath = "C:\\Users\\Braulio\\Documents\\Brau2015\\Desarrollo\\Portfolio\\coronatickets_frontend\\coronaTicketsWeb\\WebContent\\imagenes\\Espectaculos\\";

	// Constructor
	public ConsultaEspectaculo() {
		iconP = Fabrica.getInstancia().getIControladorPlataforma();
	//	iconPaquete = Fabrica.getInstancia().getIControladorPaquete();
		//iconE = Fabrica.getInstancia().getIControladorEspectaculo();
		iconF = Fabrica.getInstancia().getIControladorFuncion();
		miPanel = new JPanel();
		miPanel.setLayout(null);
		getContentPane().add(miPanel);
		setBounds(20, 10, 800, 700);
		setResizable(false);
		setClosable(true);
		setIconifiable(false);
		setBorder(null);
		((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).setNorthPane(null);
		lblTitulo = new JLabel();
		lblTitulo.setText("Consulta de Espectaculo");
		lblTitulo.setFont(new java.awt.Font("Comic Sans MS", 1, 17));
		lblTitulo.setBounds(10, 0, 300, 20);
		miPanel.add(lblTitulo);

		lblPlataforma = new JLabel();
		lblPlataforma.setText("Plataforma:");
		lblPlataforma.setBounds(10, 30, 137, 20);
		miPanel.add(lblPlataforma);

		comboPlataforma = new JComboBox<String>();
		comboPlataforma.setBounds(147, 31, 200, 20);
		miPanel.add(comboPlataforma);
		comboPlataforma.addItemListener(this::listenerComboPlataforma);

		lblEspectaculos = new JLabel("Espectaculo:");
		lblEspectaculos.setBounds(10, 62, 97, 20);
		miPanel.add(lblEspectaculos);

		comboEspectaculos = new JComboBox<String>();
		comboEspectaculos.setBounds(147, 61, 200, 22);
		miPanel.add(comboEspectaculos);
		comboEspectaculos.addItemListener(this::listenerComboEspectaculo);

		lblFunciones = new JLabel("Funciones:");
		lblFunciones.setBounds(10, 94, 85, 14);
		miPanel.add(lblFunciones);

		comboFunciones = new JComboBox<String>();
		comboFunciones.setBounds(147, 91, 200, 22);
		miPanel.add(comboFunciones);
		comboFunciones.addItemListener(this::listenerComboFuncion);

		lblPaquetes = new JLabel("Paquetes:");
		lblPaquetes.setBounds(10, 126, 85, 14);
		miPanel.add(lblPaquetes);

		comboPaquetes = new JComboBox<String>();
		comboPaquetes.setBounds(147, 121, 200, 22);
		miPanel.add(comboPaquetes);
		comboPaquetes.addItemListener(this::listenerComboPaquetes);

		JLabel lblNombreEspectaculo = new JLabel("Nombre:");
		lblNombreEspectaculo.setBounds(370, 30, 137, 14);
		miPanel.add(lblNombreEspectaculo);

		textNombreEspectaculo = new JTextField();
		textNombreEspectaculo.setEditable(false);
		textNombreEspectaculo.setBounds(490, 30, 200, 20);
		miPanel.add(textNombreEspectaculo);

		JLabel lblArtistaOrganizador = new JLabel("Organiza:");
		lblArtistaOrganizador.setBounds(370, 62, 137, 14);
		miPanel.add(lblArtistaOrganizador);

		textArtistaOrganizador = new JTextField();
		textArtistaOrganizador.setEditable(false);
		textArtistaOrganizador.setBounds(490, 62, 200, 20);
		miPanel.add(textArtistaOrganizador);

		JLabel lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setBounds(370, 94, 137, 14);
		miPanel.add(lblDescripcion);

		textDescripcion = new JTextField();
		textDescripcion.setEditable(false);
		textDescripcion.setBounds(490, 94, 200, 20);
		miPanel.add(textDescripcion);

		JLabel lblDuracion = new JLabel("Duracion:");
		lblDuracion.setBounds(370, 126, 137, 14);
		miPanel.add(lblDuracion);

		textDuracion = new JTextField();
		textDuracion.setEditable(false);
		textDuracion.setBackground(UIManager.getColor("Button.disabledForeground"));
		textDuracion.setBounds(490, 126, 40, 20);
		miPanel.add(textDuracion);

		JLabel lblCantidadMinima = new JLabel("Cant. Minima:");
		lblCantidadMinima.setBounds(545, 126, 105, 14);
		miPanel.add(lblCantidadMinima);

		textCantidadMaxima = new JTextField();
		textCantidadMaxima.setEditable(false);
		textCantidadMaxima.setBackground(UIManager.getColor("Button.disabledForeground"));
		textCantidadMaxima.setBounds(650, 126, 40, 20);
		miPanel.add(textCantidadMaxima);

		lblCantidadMaxima = new JLabel("Cant. Maxima:");
		lblCantidadMaxima.setBounds(370, 158, 105, 14);
		miPanel.add(lblCantidadMaxima);

		textCantidadMinima = new JTextField();
		textCantidadMinima.setEditable(false);
		textCantidadMinima.setBackground(UIManager.getColor("Button.disabledForeground"));
		textCantidadMinima.setBounds(490, 158, 40, 20);
		miPanel.add(textCantidadMinima);

		lblCosto = new JLabel("Costo:");
		lblCosto.setBounds(545, 158, 105, 14);
		miPanel.add(lblCosto);

		textCosto = new JTextField();
		textCosto.setEditable(false);
		textCosto.setBackground(UIManager.getColor("Button.disabledForeground"));
		textCosto.setBounds(650, 158, 40, 20);
		miPanel.add(textCosto);

		lblRegistro = new JLabel("Registro:");
		lblRegistro.setBounds(370, 190, 55, 14);
		// miPanel.add(lblRegistro);
		textRegistro = new JTextField();
		textRegistro.setEditable(false);
		textRegistro.setBackground(UIManager.getColor("Button.disabledForeground"));
		textRegistro.setBounds(490, 190, 200, 20);
		// miPanel.add(textRegistro);

		lblURL = new JLabel("URL:");
		lblURL.setBounds(370, 190, 53, 14);
		miPanel.add(lblURL);

		textURL = new JTextField();
		textURL.setEditable(false);
		textURL.setBackground(UIManager.getColor("Button.disabledForeground"));
		textURL.setBounds(490, 190, 200, 20);
		miPanel.add(textURL);
		
		jLabelImage = new JLabel();
		jLabelImage.setBounds(370, 230, 140, 140);
		miPanel.add(jLabelImage);

		pnlDatosPaquete = new PnlDatosPaquete();
		pnlDatosPaquete.setBounds(0, 510, 700, 500);
		pnlDatosPaquete.setVisible(false);
		miPanel.add(pnlDatosPaquete);

		pnlDatosFuncion = new PnlDatosFuncion();
		pnlDatosFuncion.setBounds(0, 410, 700, 500);
		pnlDatosFuncion.setVisible(false);
		miPanel.add(pnlDatosFuncion);
	}

	private void listenerComboPlataforma(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			if (!e.getItem().equals(SELECCIONE)) {
				plataformaSelected = listPlataformas.stream().filter(p -> (p.getNombre() == e.getItem())).findFirst().get();
				cargarComboEspectaculo(plataformaSelected);
			} else if (e.getItem().equals(SELECCIONE)) {
				comboEspectaculos.removeAllItems();
			//	espectaculoSelected = "";
				plataformaSelected = null;
			}
		}
	}

	private void cargarComboEspectaculo(DtPlataforma plataforma) {
		comboEspectaculos.removeAllItems();
		comboEspectaculos.addItem(SELECCIONE);
		comboEspectaculos.setSelectedItem(SELECCIONE);
		for (DtEspectaculo espectaculo : plataforma.getEspectaculo()) {
			comboEspectaculos.addItem(espectaculo.getNombre());
		}
	}

	private void listenerComboEspectaculo(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			if (!e.getItem().equals(SELECCIONE)) {
				String strEspectaculo = this.comboEspectaculos.getSelectedItem().toString();
				DtEspectaculo espectaculo = plataformaSelected.getEspectaculo().stream().filter(p -> (p.getNombre() == e.getItem())).findFirst().get();
				listPaqEspe = espectaculo.getPaquetes();
				SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
				String datosFecha = formatoFecha.format(espectaculo.getRegistro());
				this.textNombreEspectaculo.setText(espectaculo.getNombre());
				this.textArtistaOrganizador.setText(espectaculo.getArtista());
				this.textDescripcion.setText(espectaculo.getDescripcion());
				this.textDuracion.setText(String.valueOf(espectaculo.getDuracion()));
				this.textCantidadMinima.setText(String.valueOf(espectaculo.getCantMin()));
				this.textCantidadMaxima.setText(String.valueOf(espectaculo.getCantMax()));
				this.textURL.setText(espectaculo.getUrl());
				this.textCosto.setText(String.valueOf(espectaculo.getCosto()));
				this.textRegistro.setText(String.valueOf(datosFecha));
				if(!espectaculo.getimageName().isEmpty()) {
					ImageIcon imgi = new ImageIcon(this.imagenesSVPath+espectaculo.getimageName());
					Image imagei = imgi.getImage().getScaledInstance(jLabelImage.getWidth(), jLabelImage.getHeight(), Image.SCALE_SMOOTH);
					jLabelImage.setIcon(new ImageIcon(imagei));
				}
				listFunciones = iconF.listarFunciones(strEspectaculo);
				if (listFunciones.isEmpty()) {
					JOptionPane.showMessageDialog(this, "El espectaculo no tiene funciones asociadas", "Warning", JOptionPane.WARNING_MESSAGE);
					comboFunciones.removeAllItems();
				} else {
					comboFunciones.removeAllItems();
					comboFunciones.addItem(SELECCIONE);
					listFunciones.forEach((f) -> {
						comboFunciones.addItem(f.getNombre());
					});
				}

				if (espectaculo.getPaquetes().isEmpty()) {
					JOptionPane.showMessageDialog(this, "El espectaculo no tiene paquetes asociados", "Warning", JOptionPane.WARNING_MESSAGE);
					comboPaquetes.removeAllItems();
				} else {
					comboPaquetes.removeAllItems();
					comboPaquetes.addItem(SELECCIONE);
					espectaculo.getPaquetes().forEach((f) -> {
						comboPaquetes.addItem(f.getNombre());
					});
				}
			}
		}
	}

	private void listenerComboFuncion(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			if (!e.getItem().equals(SELECCIONE)) {
				funcionSelect = listFunciones.stream().filter(f -> (f.getNombre() == e.getItem())).findFirst().get();
				pnlDatosFuncion.cargarPanel(funcionSelect);
				pnlDatosPaquete.setVisible(false);
				pnlDatosFuncion.setVisible(true);
			} else {
				pnlDatosFuncion.setVisible(false);
			}
		}
	}

	private void listenerComboPaquetes(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			if (!e.getItem().equals(SELECCIONE)) {
				paqueteSelected = listPaqEspe.stream().filter(p -> (p.getNombre() == e.getItem())).findFirst().get();
				pnlDatosPaquete.cargarPanel(paqueteSelected, false);
				pnlDatosFuncion.setVisible(false);
				pnlDatosPaquete.setVisible(true);
			} else {
				pnlDatosPaquete.setVisible(false);
			}
		}
	}

	// Inicializar ComboBox
	public void iniciarlizarComboBox() {
		comboPlataforma.removeAllItems();
		// comboPaquetes.removeAllItems();
		comboPlataforma.addItem(SELECCIONE);
		comboPlataforma.setSelectedItem(SELECCIONE);
		listPlataformas = iconP.listarPlataformas();
		listPlataformas.forEach((p) -> {
			comboPlataforma.addItem(p.getNombre());
		});
	}
	
	public void limpiarFormulario() {
		textNombreEspectaculo.setText("");
		textArtistaOrganizador.setText("");
		textDescripcion.setText("");
		textDuracion.setText("");
		textCantidadMinima.setText("");
		textCantidadMaxima.setText("");
		textURL.setText("");
		textRegistro.setText("");
		textCosto.setText("");
		jLabelImage.setIcon(null);
	}

}

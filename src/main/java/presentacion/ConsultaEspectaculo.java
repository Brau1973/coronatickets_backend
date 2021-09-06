package presentacion;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.util.Date;
import java.util.List;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import datatypes.DtEspectaculo;
import interfaces.Fabrica;
import interfaces.IControladorEspectaculo;
import interfaces.IControladorPaquete;
import interfaces.IControladorPlataforma;
import logica.Artista;
import logica.Espectaculo;
import logica.Funcion;
import logica.PaqueteEspectaculos;
import logica.Plataforma;
import javax.swing.UIManager;

@SuppressWarnings("serial")
public class ConsultaEspectaculo extends JInternalFrame{

	private IControladorPlataforma iconP;
	private IControladorEspectaculo iconE;

	private JButton btnConsulta;
	private JPanel miPanel;
	private JLabel lblTitulo, lblPlataforma, lblEspectaculos, lblPaquetes;
	private JComboBox<String> comboPlataforma, comboEspectaculos, comboPaquetes,comboFunciones;
	private List<Plataforma> listPlataformas;
	private List<Espectaculo> listEspectaculos;
	private List<DtEspectaculo> listDtEspectaculos;
	private JLabel lblCantidadMaxima;
	private JLabel lblURL;
	private JLabel lblCosto;
	private JTextField textNombreEspectaculo;
	private JTextField textArtistaOrganizador;
	private JTextField textDescripcion;
	private JTextField textDuracion;
	private JTextField textCantidadMinima;
	private JTextField textCantidadMaxima;
	private JTextField textURL;
	private JTextField textCosto;
	private JLabel lblFunciones;

	// Constructor
	public ConsultaEspectaculo() {

		iconP = Fabrica.getInstancia().getIControladorPlataforma();
		iconE = Fabrica.getInstancia().getIControladorEspectaculo();
		
		miPanel = new JPanel();
		miPanel.setLayout(null);
		getContentPane().add(miPanel);
		setBounds(20, 20, 460, 400);
		setResizable(false);
		setClosable(true);
		setIconifiable(false);
		setBorder(null);
		((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).setNorthPane(null);
		lblTitulo = new JLabel();
		lblTitulo.setText("Consulta de Espectaculo");
		lblTitulo.setFont(new java.awt.Font("Comic Sans MS", 1, 20));
		lblTitulo.setBounds(10, 0, 300, 20);
		miPanel.add(lblTitulo);

		lblPlataforma = new JLabel();
		lblPlataforma.setText("Plataforma");
		lblPlataforma.setBounds(10, 30, 137, 20);
		miPanel.add(lblPlataforma);

		comboPlataforma = new JComboBox<String>();
		comboPlataforma.setBounds(147, 31, 200, 20);
		comboPlataforma.addItemListener(this::listenerComboPlataforma);
		miPanel.add(comboPlataforma);
		// comboPlataforma.addActionListener(this);

		lblEspectaculos = new JLabel();
		lblEspectaculos.setText("Espectaculos");
		lblEspectaculos.setBounds(10, 62, 97, 20);
		miPanel.add(lblEspectaculos);

		comboEspectaculos = new JComboBox<String>();
		comboEspectaculos.setBounds(147, 61, 200, 22);
		miPanel.add(comboEspectaculos);
		comboEspectaculos.addItemListener(this::listenerComboEspectaculo);

		JLabel lblNombreEspectaculo = new JLabel("Nombre Espectaculo");
		lblNombreEspectaculo.setBounds(10, 97, 137, 14);
		miPanel.add(lblNombreEspectaculo);

		textNombreEspectaculo = new JTextField();
		textNombreEspectaculo.setEditable(false);
		textNombreEspectaculo.setBounds(147, 94, 200, 20);
		miPanel.add(textNombreEspectaculo);

		JLabel lblArtistaOrganizador = new JLabel("Artista Organizador");
		lblArtistaOrganizador.setBounds(10, 128, 137, 14);
		miPanel.add(lblArtistaOrganizador);

		textArtistaOrganizador = new JTextField();
		textArtistaOrganizador.setEditable(false);
		textArtistaOrganizador.setBounds(147, 125, 200, 20);
		miPanel.add(textArtistaOrganizador);

		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setBounds(10, 156, 137, 14);
		miPanel.add(lblDescripcion);

		textDescripcion = new JTextField();
		textDescripcion.setEditable(false);
		textDescripcion.setBounds(147, 153, 200, 20);
		miPanel.add(textDescripcion);

		JLabel lblDuracion = new JLabel("Duracion");
		lblDuracion.setBounds(10, 184, 53, 14);
		miPanel.add(lblDuracion);

		textDuracion = new JTextField();
		textDuracion.setEditable(false);
		textDuracion.setBackground(UIManager.getColor("Button.disabledForeground"));
		textDuracion.setBounds(76, 181, 40, 20);
		miPanel.add(textDuracion);

		JLabel lblCantidadMinima = new JLabel("Cant. Minima");
		lblCantidadMinima.setBounds(130, 184, 105, 14);
		miPanel.add(lblCantidadMinima);

		textCantidadMaxima = new JTextField();
		textCantidadMaxima.setEditable(false);
		textCantidadMaxima.setBackground(UIManager.getColor("Button.disabledForeground"));
		textCantidadMaxima.setBounds(395, 181, 40, 20);
		miPanel.add(textCantidadMaxima);

		lblCantidadMaxima = new JLabel("Cant. Maxima");
		lblCantidadMaxima.setBounds(290, 184, 105, 14);
		miPanel.add(lblCantidadMaxima);

		textCantidadMinima = new JTextField();
		textCantidadMinima.setEditable(false);
		textCantidadMinima.setBackground(UIManager.getColor("Button.disabledForeground"));
		textCantidadMinima.setBounds(240, 181, 40, 20);
		miPanel.add(textCantidadMinima);

		lblURL = new JLabel("URL");
		lblURL.setBounds(10, 212, 53, 14);
		miPanel.add(lblURL);

		textURL = new JTextField();
		textURL.setEditable(false);
		textURL.setBackground(UIManager.getColor("Button.disabledForeground"));
		textURL.setBounds(76, 209, 200, 20);
		miPanel.add(textURL);

		lblCosto = new JLabel("Costo");
		lblCosto.setBounds(290, 212, 40, 14);
		miPanel.add(lblCosto);

		textCosto = new JTextField();
		textCosto.setEditable(false);
		textCosto.setBackground(UIManager.getColor("Button.disabledForeground"));
		textCosto.setBounds(332, 209, 53, 20);
		miPanel.add(textCosto);
		
		comboPaquetes = new JComboBox<String>();
		comboPaquetes.setBounds(77, 251, 199, 22);
		miPanel.add(comboPaquetes);
		
		lblPaquetes = new JLabel("Paquetes");
		lblPaquetes.setBounds(10, 255, 46, 14);
		miPanel.add(lblPaquetes);
		
		lblFunciones = new JLabel("Funciones");
		lblFunciones.setBounds(10, 291, 46, 14);
		miPanel.add(lblFunciones);
		
		comboFunciones = new JComboBox();
		comboFunciones.setBounds(76, 287, 200, 22);
		miPanel.add(comboFunciones);

		// artistaOrganizador, descripcion, duracion, cantMinEsp, cantMaxEsp, url,
		// costo, registro
	}

	private void listenerComboPlataforma(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			System.out.println("CLICK EN COMBO PLATAFORMA");
			String strPlataforma = this.comboPlataforma.getSelectedItem().toString();
			Plataforma plataforma = listPlataformas.stream().filter(p -> (p.getNombre() == strPlataforma)).findFirst()
					.get();
//			this.listDtEspectaculos = iconP.listarEspectaculos(strPlataforma);
//			if (listDtEspectaculos.isEmpty()) {
//				System.out.println("LISTA ESPECTACULOS VACIA");
//				comboEspectaculos.removeAllItems();
//			} else {
//				comboEspectaculos.removeAllItems();
//				
//				listDtEspectaculos.forEach((esp) -> {
//					comboEspectaculos.addItem(esp.getNombre());
//				});
//			}
			
			
			
			
			this.listEspectaculos = plataforma.getEspectaculo();
			if (listEspectaculos.isEmpty()) {
				System.out.println("LISTA ESPECTACULOS VACIA");
				comboEspectaculos.removeAllItems();
			} else {
				comboEspectaculos.removeAllItems();
				
				listEspectaculos.forEach((esp) -> {
					comboEspectaculos.addItem(esp.getNombre());
				});
			}
			
			
		}
	}

	private void listenerComboEspectaculo(ItemEvent e){
	 if(e.getStateChange() == ItemEvent.SELECTED){
		String strEspectaculo = this.comboEspectaculos.getSelectedItem().toString();
		Espectaculo espectaculo = listEspectaculos.stream().filter(espec -> (espec.getNombre() == strEspectaculo))
				.findFirst().get();

		this.textNombreEspectaculo.setText(espectaculo.getNombre());
		
		//this.textArtistaOrganizador.setText(espectaculo.getArtista().getNickname());
		
		this.textDescripcion.setText(espectaculo.getDescripcion());
		
		this.textDuracion.setText(String.valueOf(espectaculo.getDuracion()));
		
		this.textCantidadMinima.setText(String.valueOf(espectaculo.getCantMinEsp()));
		
		this.textCantidadMaxima.setText(String.valueOf(espectaculo.getCantMaxEsp()));
		
		this.textURL.setText(espectaculo.getUrl());
		
		this.textCosto.setText(String.valueOf(espectaculo.getCosto()));
		
		this.textCosto.setText(String.valueOf(espectaculo.getRegistro()));
		
		comboPaquetes.removeAllItems();
		List<PaqueteEspectaculos> listPaquetes = espectaculo.getPaquete();
		listPaquetes.forEach((p) -> {
			comboPaquetes.addItem(p.getNombre());
		});
		comboPaquetes.setSelectedItem("Seleccione plataforma");
		
		
		comboFunciones.removeAllItems();
		List<Funcion> listFunciones = espectaculo.getFunciones();
		listFunciones.forEach((p) -> {
			comboFunciones.addItem(p.getNombre());
		});
		comboFunciones.setSelectedItem("Seleccione plataforma");
		
	 	}
	 }

	// Inicializar ComboBox
	public void iniciarlizarComboBox() {
		comboPlataforma.removeAllItems();
		listPlataformas = iconP.listarPlataformas();
		listPlataformas.forEach((p) -> {
			comboPlataforma.addItem(p.getNombre());
		});
		comboPlataforma.setSelectedItem("Seleccione plataforma");
		
		// modelo.clear();
	}
}

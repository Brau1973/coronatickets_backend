package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
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
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import com.toedter.calendar.JDateChooser;

import excepciones.FuncionRepetidaExcepcion;
import excepciones.FuncionYaRegistradaEnEspectaculoExcepcion;
//import excepciones.FuncionYaRegistradaEnEspectaculoExcepcion;
import interfaces.Fabrica;
import interfaces.IControladorEspectaculo;
import interfaces.IControladorFuncion;
import interfaces.IControladorPlataforma;
import interfaces.IControladorUsuario;
import datatypes.DtArtista;
import datatypes.DtEspectaculo;
import datatypes.DtFuncion;

@SuppressWarnings("serial")
public class AltaFuncion extends JInternalFrame implements ActionListener {
	private IControladorFuncion iconF;
	private IControladorPlataforma iconP;
	private IControladorUsuario iconU;
	private IControladorEspectaculo iconE;
	private JButton btnAceptar, btnCancelar, btnCopiar;
	private JPanel miPanel;
	private JLabel lblPlataforma, lblEspectaculos, lblNombre, lblFecha, lblHora, lblArtistasInv, lblFechaAlta, lblDots,
			lblTitulo;
	private JTextField txtNombre;
	private JSpinner spinHora, spinMin;
	private JDateChooser fechaFuncion, fechaAlta;
	private JComboBox<String> comboArtista, comboEspectaculos, comboPlataforma;
	private JList<String> listaArtistasSeleccionados;
	private DefaultListModel<String> modelo;
	private JScrollPane scrollPane;
	private List<String> listPlataformas;
	private List<DtEspectaculo> listEspectaculos;
	private List<DtArtista> listArtistas;
	private List<String> listArtistasSeleccionados;

	// Constructor
	public AltaFuncion(IControladorFuncion iconF) {
		iconU = Fabrica.getInstancia().getIControladorUsuario();
		iconP = Fabrica.getInstancia().getIControladorPlataforma();
		iconE = Fabrica.getInstancia().getIControladorEspectaculo();
		this.iconF = iconF;

		miPanel = new JPanel();
		miPanel.setLayout(null);
		add(miPanel);
		setBounds(30, 30, 800, 600);
		setResizable(false);
		setClosable(false);
		setIconifiable(false);
		setBorder(null);
		((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).setNorthPane(null);

		lblTitulo = new JLabel();
		lblTitulo.setText("Alta de Funcion de Espectaculo");
		lblTitulo.setBounds(10, 0, 300, 20);
		lblTitulo.setFont(new java.awt.Font("Comic Sans MS", 1, 17));
		miPanel.add(lblTitulo);

		lblPlataforma = new JLabel("Plataforma");
		lblPlataforma.setBounds(10, 30, 200, 20);
		miPanel.add(lblPlataforma);

		comboPlataforma = new JComboBox<String>();
		comboPlataforma.setBounds(220, 30, 200, 25);
		miPanel.add(comboPlataforma);
		comboPlataforma.addActionListener(this);

		lblEspectaculos = new JLabel("Espectaculos");
		lblEspectaculos.setBounds(10, 60, 200, 20);
		miPanel.add(lblEspectaculos);

		comboEspectaculos = new JComboBox<String>();
		comboEspectaculos.setBounds(220, 60, 200, 25);
		miPanel.add(comboEspectaculos);

		lblPlataforma = new JLabel("Datos De La Funcion");
		lblPlataforma.setBounds(10, 90, 250, 25);
		miPanel.add(lblPlataforma);

		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 120, 200, 20);
		miPanel.add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setBounds(220, 120, 200, 20);
		miPanel.add(txtNombre);

		lblFecha = new JLabel("Fecha de la Funcion");
		lblFecha.setBounds(10, 150, 200, 20);
		miPanel.add(lblFecha);

		fechaFuncion = new JDateChooser();
		fechaFuncion.setBounds(220, 150, 200, 20);
		miPanel.add(fechaFuncion);

		lblHora = new JLabel("Hora de Inicio");
		lblHora.setBounds(10, 180, 100, 20);
		miPanel.add(lblHora);

		spinHora = new JSpinner();
		spinHora.setBounds(220, 180, 45, 20);
		miPanel.add(spinHora);

		lblDots = new JLabel();
		lblDots.setText(":");
		lblDots.setBounds(275, 180, 20, 20);
		miPanel.add(lblDots);

		spinMin = new JSpinner();
		spinMin.setBounds(295, 180, 45, 20);
		miPanel.add(spinMin);

		lblArtistasInv = new JLabel("Artistas invitados");
		lblArtistasInv.setBounds(10, 210, 150, 20);
		miPanel.add(lblArtistasInv);

		btnCopiar = new JButton(">>>");
		btnCopiar.setBounds(220, 250, 70, 30);
		btnCopiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				agregarNombre();
			}
		});
		miPanel.add(btnCopiar);

		listaArtistasSeleccionados = new JList<String>();
		listaArtistasSeleccionados.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		modelo = new DefaultListModel<String>();
		scrollPane = new JScrollPane();
		scrollPane.setBounds(300, 250, 120, 60);
		scrollPane.setViewportView(listaArtistasSeleccionados);
		miPanel.add(scrollPane);

		comboArtista = new JComboBox<String>();
		comboArtista.setBounds(220, 210, 200, 25);
		miPanel.add(comboArtista);

		lblFechaAlta = new JLabel("Fecha de Alta");
		lblFechaAlta.setBounds(10, 330, 200, 20);
		miPanel.add(lblFechaAlta);

		fechaAlta = new JDateChooser();
		fechaAlta.setBounds(220, 330, 200, 20);
		miPanel.add(fechaAlta);

		// Boton Aceptar
		btnAceptar = new JButton();
		btnAceptar.setText("Aceptar");
		btnAceptar.setBounds(200, 400, 115, 25);
		miPanel.add(btnAceptar);
		btnAceptar.addActionListener(this);

		// Boton Cancelar
		btnCancelar = new JButton();
		btnCancelar.setText("Cancelar");
		btnCancelar.setBounds(322, 400, 115, 25);
		miPanel.add(btnCancelar);
		btnCancelar.addActionListener(this);
	}

	private void agregarNombre() {
		String nombre = this.comboArtista.getSelectedItem().toString();
		modelo.addElement(nombre);
		listaArtistasSeleccionados.setModel(modelo);
		comboArtista.removeItem(this.comboArtista.getSelectedItem());
		
		listArtistasSeleccionados.add(nombre);
	}

	// Inicializar ComboBox
	public void iniciarlizarComboBox() {
		comboPlataforma.removeAllItems();
		comboArtista.removeAllItems();

		listPlataformas = iconP.listarPlataformasDt();
		listPlataformas.forEach((p) -> {
			comboPlataforma.addItem(p);
		});

		listArtistas = iconU.listarArtistasDt();
		listArtistas.forEach((DtArt) -> {
			comboArtista.addItem(DtArt.getNickname());
		});

		modelo.clear();
	}

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == comboPlataforma) {
			if (this.comboPlataforma.getSelectedItem() != null) {
				String strPlataforma = this.comboPlataforma.getSelectedItem().toString();
				listEspectaculos = iconE.listarEspectaculos(strPlataforma);
				if (listEspectaculos.isEmpty()) {
					comboEspectaculos.removeAllItems();
				} else {
					comboEspectaculos.removeAllItems();
					listEspectaculos.forEach((Dtesp) -> {
						comboEspectaculos.addItem(Dtesp.getNombre());
					});
				}
			}
		}

		if (e.getSource() == btnAceptar) {
			if (checkFormulario()) {
				String nombreFuncion = this.txtNombre.getText();
				Date FechaFuncion = this.fechaFuncion.getDate();
				int hora = Integer.parseInt(this.spinHora.getValue().toString());
				int minutos = Integer.parseInt(this.spinMin.getValue().toString());
				Time horaInicio = new Time(hora, minutos, 0);
				Date fechaRegistro = this.fechaAlta.getDate();
				String strespectaculo = (String) this.comboEspectaculos.getSelectedItem();
				DtFuncion dtFuncion = new DtFuncion(nombreFuncion, FechaFuncion, horaInicio, fechaRegistro,
						strespectaculo, listArtistasSeleccionados);
				try {
					this.iconF.altaFuncion(dtFuncion);
					JOptionPane.showMessageDialog(this, "la funcion se ha creado con Exito");
				} catch (FuncionYaRegistradaEnEspectaculoExcepcion msg) {
					JOptionPane.showMessageDialog(this, msg.getMessage(), "Alta Plataforma", JOptionPane.ERROR_MESSAGE);
				}
				limpiarFormulario();
				setVisible(false);
			}
		}

		if (e.getSource() == btnCancelar) {
			limpiarFormulario();
			setVisible(false);
		}
	}

	private boolean checkFormulario() {
		if (!txtNombre.getText().isEmpty() && fechaFuncion.getDate() != null && fechaAlta.getDate() != null) {
		} else {
			JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios", "Error",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}

	private void limpiarFormulario() {
		this.txtNombre.setText("");
		this.fechaFuncion.setDate(null);
		this.spinHora.setValue(0);
		this.spinMin.setValue(0);
		this.fechaAlta.setDate(null);
	}

	public void limpiarListaArtistas() {
		listArtistasSeleccionados = new ArrayList<String>();
		listArtistasSeleccionados.clear();
	}

}

package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.toedter.calendar.JDateChooser;

import datatypes.DtEspectaculo;
import datatypes.DtEspectador;
import datatypes.DtFuncion;
import datatypes.DtPlataforma;
import datatypes.DtRegistro;
import interfaces.Fabrica;
import interfaces.IControladorFuncion;
import interfaces.IControladorPlataforma;
import interfaces.IControladorRegistro;
import interfaces.IControladorUsuario;
import logica.Plataforma;

@SuppressWarnings("serial")
public class RegistroFuncion extends JInternalFrame {
	private IControladorPlataforma iconP;
	private IControladorUsuario iconU;
	private IControladorFuncion iconF;
	private IControladorRegistro iconR;
	private JButton btnAceptar, btnCancelar;
	private JPanel miPanel;
	private JLabel lblPlataforma, lblEspectaculos, lblFunciones, lblNombre, lblFecha, lblHora, lblArtistasInv,
			lblEspectadores, lblRegistro, lblFuncionesDelEspectador;
	private JComboBox<String> comboEspectaculos, comboPlataforma, comboFunciones, comboEspectadores, comboRegistro,
			comboFuncionesDelEspectador;
	static final String SELECCIONE = "Seleccione";
	private DtPlataforma plataformaSelected;
	private DtEspectaculo espectaculoSelected;
	private DtFuncion funcionSelected;
	private PnlDatosFuncion pnlDatosFuncion;
	private JDateChooser fechaRegistro;
	private List<String> listFuncionesRegistradasEspectador;

	private List<DtPlataforma> listPlataformas;
	private List<String> listEspectadores;

	// Constructor
	public RegistroFuncion() {
		iconP = Fabrica.getInstancia().getIControladorPlataforma();
		iconU = Fabrica.getInstancia().getIControladorUsuario();
		iconF = Fabrica.getInstancia().getIControladorFuncion();
		iconR = Fabrica.getInstancia().getIControladorRegistro();
		miPanel = new JPanel();
		miPanel.setLayout(null);
		add(miPanel);
		setBounds(30, 30, 800, 600);
		setResizable(false);
		setClosable(false);
		setIconifiable(false);
		setBorder(null);
		((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).setNorthPane(null);
		// lblTitulo = new JLabel();
		// lblTitulo.setText("Alta plataforma");
		// lblTitulo.setFont(new java.awt.Font("Comic Sans MS", 1, 20));
		// lblTitulo.setBounds(10, 1, 280, 25);
		// miPanel.add(lblTitulo);

		lblPlataforma = new JLabel();
		lblPlataforma.setText("Plataforma");
		lblPlataforma.setBounds(10, 0, 200, 20);
		miPanel.add(lblPlataforma);

		comboPlataforma = new JComboBox<String>();
		comboPlataforma.setBounds(220, 0, 200, 20);
		comboPlataforma.addItemListener(this::listenerComboPlataforma);
		miPanel.add(comboPlataforma);

		lblEspectaculos = new JLabel();
		lblEspectaculos.setText("Espectaculos");
		lblEspectaculos.setBounds(10, 30, 200, 20);
		miPanel.add(lblEspectaculos);

		comboEspectaculos = new JComboBox<String>();
		comboEspectaculos.setBounds(220, 30, 200, 20);
		comboEspectaculos.addItemListener(this::listenerComboEspectaculo);
		miPanel.add(comboEspectaculos);

		lblFunciones = new JLabel();
		lblFunciones.setText("Funciones");
		lblFunciones.setBounds(10, 60, 200, 20);
		miPanel.add(lblFunciones);

		comboFunciones = new JComboBox<String>();
		comboFunciones.setBounds(220, 60, 200, 20);
		comboFunciones.addItemListener(this::listenerComboFunciones);
		miPanel.add(comboFunciones);

		pnlDatosFuncion = new PnlDatosFuncion();
		pnlDatosFuncion.setBounds(10, 80, 700, 220);
		pnlDatosFuncion.setVisible(false);
		miPanel.add(pnlDatosFuncion);

		lblEspectadores = new JLabel();
		lblEspectadores.setText("Espectadores");
		lblEspectadores.setBounds(10, 340, 200, 20);
		miPanel.add(lblEspectadores);

		comboEspectadores = new JComboBox<String>();
		comboEspectadores.setBounds(220, 340, 200, 20);
		comboEspectadores.addItemListener(this::listenerComboEspectadores);
		miPanel.add(comboEspectadores);

		lblFuncionesDelEspectador = new JLabel();
		lblFuncionesDelEspectador.setText("Registros del Espectador");
		lblFuncionesDelEspectador.setBounds(10, 370, 200, 20);
		miPanel.add(lblFuncionesDelEspectador);

		comboFuncionesDelEspectador = new JComboBox<String>();
		comboFuncionesDelEspectador.setBounds(220, 370, 200, 20);
		miPanel.add(comboFuncionesDelEspectador);

		lblFecha = new JLabel();
		lblFecha.setText("Fecha");
		lblFecha.setBounds(10, 400, 200, 20);
		miPanel.add(lblFecha);

		fechaRegistro = new JDateChooser();
		fechaRegistro.setBounds(220, 400, 200, 20);
		miPanel.add(fechaRegistro);

		lblRegistro = new JLabel();
		lblRegistro.setText("Tipo de Registro");
		lblRegistro.setBounds(10, 430, 200, 20);
		miPanel.add(lblRegistro);

		comboRegistro = new JComboBox<String>();
		comboRegistro.setBounds(220, 430, 200, 20);
		miPanel.add(comboRegistro);

		// Boton Aceptar
		btnAceptar = new JButton();
		btnAceptar.setText("Aceptar");
		btnAceptar.setBounds(200, 460, 115, 25);
		miPanel.add(btnAceptar);
	    btnAceptar.addActionListener(new ActionListener(){
		     public void actionPerformed(ActionEvent e){
				  actionListenerAceptar(e);
			     }
	    });

		// Boton Cancelar
		btnCancelar = new JButton();
		btnCancelar.setText("Cancelar");
		btnCancelar.setBounds(322, 460, 115, 25);
		miPanel.add(btnCancelar);
		// btnCancelar.addActionListener(this);

	}

	public void iniciarlizarComboBox() {
		comboPlataforma.removeAllItems();
		listPlataformas = iconP.listarPlataformas();
		listPlataformas.forEach((p) -> {
			comboPlataforma.addItem(p.getNombre());
		});

		comboEspectadores.removeAllItems();
		listEspectadores = iconU.listarNicknameEspectadores();
		listEspectadores.forEach((e) -> {
			comboEspectadores.addItem(e);
		});
	}
	
	private void actionListenerAceptar(ActionEvent e) {
		String funcion = comboFunciones.getSelectedItem().toString();
		String espectador = comboEspectadores.getSelectedItem().toString();
		float costo = 200;
		Date fechaRegistro = this.fechaRegistro.getDate();
		DtRegistro dtRegistro = new DtRegistro(funcion,fechaRegistro,costo);
		
		iconR.altaRegistro(dtRegistro,espectador);
		
	}

	private void listenerComboPlataforma(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			if (!e.getItem().equals(SELECCIONE)) {
				plataformaSelected = listPlataformas.stream().filter(p -> (p.getNombre() == e.getItem())).findFirst()
						.get();
				cargarComboEspectaculo(plataformaSelected);
			} else if (e.getItem().equals(SELECCIONE)) {
				comboEspectaculos.removeAllItems();
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
				espectaculoSelected = plataformaSelected.getEspectaculo().stream()
						.filter(p -> (p.getNombre() == e.getItem())).findFirst().get();
				cargarComboFuncion(espectaculoSelected);
			} else if (e.getItem().equals(SELECCIONE)) {
				comboFunciones.removeAllItems();
			}
		}
	}

	private void cargarComboFuncion(DtEspectaculo espectaculo) {
		comboFunciones.removeAllItems();
		comboFunciones.addItem(SELECCIONE);
		comboFunciones.setSelectedItem(SELECCIONE);
		for (DtFuncion funcion : espectaculo.getFunciones()) {
			Date fecha = new Date();
			System.out.println(fecha);
			if (funcion.getFecha().after(fecha) || funcion.getFecha().equals(fecha)) { // CARGA SOLAMENTE LAS FUNCIONES
																						// VIGENTES
				comboFunciones.addItem(funcion.getNombre());
			}
		}
	}

	private void listenerComboFunciones(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			if (!e.getItem().equals(SELECCIONE)) {
				pnlDatosFuncion.setVisible(true);
				funcionSelected = espectaculoSelected.getFunciones().stream()
						.filter(p -> (p.getNombre() == e.getItem())).findFirst().get();
				pnlDatosFuncion.cargarPanel(funcionSelected);
				// iconF.getCantidadEspectadoresRegistrados(funcionSelected.getNombre());
			} else if (e.getItem().equals(SELECCIONE)) {
				pnlDatosFuncion.setVisible(false);
			}

		}
	}

	private void listenerComboEspectadores(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			if (!e.getItem().equals(SELECCIONE)) {
				String espectadorSelected = comboEspectadores.getSelectedItem().toString();
				listFuncionesRegistradasEspectador = iconF
						.getFuncionesVigentesRegistradasPorEspectador(espectadorSelected);
				if (listFuncionesRegistradasEspectador.isEmpty()) {
					comboFuncionesDelEspectador.removeAllItems();
				} else {
					comboFuncionesDelEspectador.removeAllItems();
					listFuncionesRegistradasEspectador.forEach((Fun) -> {
						comboFuncionesDelEspectador.addItem(Fun);
					});
				}
			} else if (e.getItem().equals(SELECCIONE)) {
				comboFuncionesDelEspectador.removeAllItems();
				;
			}

		}
	}
}

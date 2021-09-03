package presentacion;

import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import interfaces.Fabrica;
import interfaces.IControladorPaquete;
import logica.PaqueteEspectaculos;

@SuppressWarnings("serial")
public class ConsultaPaqueteEspectaculos extends JInternalFrame {
	private JPanel miPanel;
	private JLabel lblTitulo, lblPaquete;
	private JComboBox<String> comboPaquetes;
	static final int X_LABEL = 10;
	static final int X_TEXT = 200;
	static final int Y_DIST = 30;
	static final int WIDTH_LABEL = 180;
	static final int WIDTH_TEXT = 200;
	static final int HEIGHT_FIELD = 25;
	static final String SELECCIONE = "Seleccione";

	private PnlDatosPaquete pnlDatosPaquete;

	private PaqueteEspectaculos paqueteSelected;
	List<PaqueteEspectaculos> lstPaquetes = new ArrayList<PaqueteEspectaculos>();

	IControladorPaquete iControladorPaquete = Fabrica.getInstancia().getIControladorPaquete();

	// Constructor
	public ConsultaPaqueteEspectaculos() {

		miPanel = new JPanel();
		miPanel.setLayout(null);
		miPanel.setBounds(0, 0, 800, 600);
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

		comboPaquetes.addItemListener(this::listenerComboPaquetes);
		miPanel.add(comboPaquetes);

		pnlDatosPaquete = new PnlDatosPaquete();
		pnlDatosPaquete.setBounds(20, Y_DIST * 3, 700, 500);
		pnlDatosPaquete.setVisible(false);
		miPanel.add(pnlDatosPaquete);
	}

	// Inicializar ComboBox
	public void iniciarlizarComboBox() {
		comboPaquetes.removeAllItems();
		pnlDatosPaquete.setVisible(false);
		lstPaquetes = iControladorPaquete.obtenerPaquetes();
		lstPaquetes.forEach((p) -> {
			comboPaquetes.addItem(p.getNombre());
		});
	}

	private void listenerComboPaquetes(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			if (!e.getItem().equals(SELECCIONE)) {
				paqueteSelected = lstPaquetes.stream().filter(p -> (p.getNombre() == e.getItem())).findFirst().get();
				pnlDatosPaquete.cargarPanel(paqueteSelected);
				pnlDatosPaquete.setVisible(true);
			} else {
				pnlDatosPaquete.setVisible(false);
//				TODO aca va el limpiar panelPaquete
			}
		}
	}

}
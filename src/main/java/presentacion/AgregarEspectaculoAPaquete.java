package presentacion;

import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import datatypes.DtEspectaculo;
import datatypes.DtPaqueteEspectaculo;
import datatypes.DtPlataforma;
import interfaces.Fabrica;
import interfaces.IControladorPaquete;
import interfaces.IControladorPlataforma;
import logica.PaqueteEspectaculos;

@SuppressWarnings("serial")
public class AgregarEspectaculoAPaquete extends JInternalFrame {
	private JPanel miPanel;
	static final int X_LABEL = 10;
	static final int X_TEXT = 200;
	static final int Y_DIST = 30;
	static final int WIDTH_LABEL = 180;
	static final int WIDTH_TEXT = 200;
	static final int HEIGHT_FIELD = 25;
    static final String SELECCIONE = "Seleccione";
	JComboBox<String> comboPlataformas, comboPaquetes, comboEspectaculo;
	private String[] header = { "Nombre", "Descripcion", "etc," };
	private String[][] data = {};
	private JTable table;
	private IControladorPlataforma iconP;
	private IControladorPaquete iconPaquete;
	List<DtPlataforma> listPlataformas;
	List<DtPaqueteEspectaculo> listPaquetes;
	DtPaqueteEspectaculo paqueteSelected;
	DtPlataforma plataformaSelected;
	// Constructor
	public AgregarEspectaculoAPaquete() {
		iconP = Fabrica.getInstancia().getIControladorPlataforma();
		iconPaquete = Fabrica.getInstancia().getIControladorPaquete();
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
		lblPaquete.setBounds(X_LABEL, Y_DIST, WIDTH_LABEL, HEIGHT_FIELD);
		miPanel.add(lblPaquete);

		comboPaquetes = new JComboBox<String>();
		comboPaquetes.setBounds(X_TEXT, Y_DIST, WIDTH_TEXT, HEIGHT_FIELD);
		comboPaquetes.addItemListener(this::listenerComboPaquetes);
		miPanel.add(comboPaquetes);

		JLabel lblPlataforma = new JLabel("Plataforma", SwingConstants.RIGHT);
		lblPlataforma.setBounds(X_LABEL, Y_DIST*2, WIDTH_LABEL, HEIGHT_FIELD);
		miPanel.add(lblPlataforma);

		comboPlataformas = new JComboBox<String>();
		comboPlataformas.setBounds(X_TEXT, Y_DIST*2, WIDTH_LABEL, HEIGHT_FIELD);
		comboPlataformas.addItemListener(this::listenerComboPlataforma);
		miPanel.add(comboPlataformas);

		JLabel lblEspectaculo = new JLabel("Espectaculo", SwingConstants.RIGHT);
		lblEspectaculo.setBounds(X_LABEL, Y_DIST*3, WIDTH_LABEL, HEIGHT_FIELD);
		miPanel.add(lblEspectaculo);

		comboEspectaculo = new JComboBox<String>();
		comboEspectaculo.setBounds(X_TEXT, Y_DIST*3, WIDTH_LABEL, HEIGHT_FIELD);
		miPanel.add(comboEspectaculo);
		
//		JScrollPane scrollPane = new JScrollPane();
//		scrollPane.setBounds(33, 143, 494, 168);
//		miPanel.add(scrollPane);
//
//		table = new JTable();
//		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Nombre", "Descripcion" }));
//		scrollPane.setViewportView(table);

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
		// Tabla Espectaculos
		DefaultTableModel model = new DefaultTableModel(data, header);
	}

	private void listenerComboPlataforma(ItemEvent e) {
		if(e.getStateChange() == ItemEvent.SELECTED){
		     if(!e.getItem().equals(SELECCIONE)){
		    	 if(paqueteSelected != null) {
		    		 plataformaSelected = listPlataformas.stream().filter(p -> (p.getNombre() == e.getItem())).findFirst().get();
		    		 cargarComboEspectaculo(plataformaSelected,paqueteSelected);
		    	 }
		     }else if(e.getItem().equals(SELECCIONE)){
		    	 comboEspectaculo.removeAllItems();
		    	 plataformaSelected = null;
		     }
		}
	}


	private void listenerComboPaquetes(ItemEvent e) {
		if(e.getStateChange() == ItemEvent.SELECTED){
		     if(!e.getItem().equals(SELECCIONE)){
		    	 if(plataformaSelected != null) {
		    		 paqueteSelected = listPaquetes.stream().filter(p -> (p.getNombre() == e.getItem())).findFirst().get();
		    		 cargarComboEspectaculo(plataformaSelected,paqueteSelected);
		    	 }
		     }else if(e.getItem().equals(SELECCIONE)){
		    	 comboEspectaculo.removeAllItems();
		    	 paqueteSelected = null;
		     }
		}
	}
	
	private void cargarComboEspectaculo(DtPlataforma plataforma, DtPaqueteEspectaculo paquete) {
		comboEspectaculo.removeAllItems();
		for(DtEspectaculo espectaculo : plataforma.getEspectaculo()) {
			Optional<DtEspectaculo> op = paquete.getEspectaculos().stream().filter(e -> (e.getNombre() == espectaculo.getNombre())).findFirst();
			if(!op.isPresent()) {
				comboEspectaculo.addItem(op.get().getNombre());
			}
		}
		
	}
	
	private void limpiarTabla(DefaultTableModel dtm) {
		int cantRow = dtm.getRowCount();
		for (int i = 0; i < cantRow; i++) {
			dtm.removeRow(0);
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
		listPlataformas = iconP.listarPlataformas();
		listPlataformas.forEach((p) -> {
			comboPlataformas.addItem(p.getNombre());
		});
		listPaquetes = iconPaquete.obtenerPaquetes();
		listPaquetes.forEach((p) -> {
			comboPaquetes.addItem(p.getNombre());
		});
	}

}

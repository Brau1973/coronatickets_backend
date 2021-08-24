package presentacion;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

<<<<<<< HEAD
//import jdk.nashorn.internal.scripts.JS;
=======
import jdk.nashorn.internal.scripts.JS;
import logica.DtEsp;
import logica.DtFecha;
import logica.Espectaculo;
import logica.PaqEspectaculos;
>>>>>>> 77fddc67c383b480870e46c9bdca8f33122a7294

@SuppressWarnings("serial")
public class ConsultaPaqueteEspectaculos extends JInternalFrame{
    private JPanel miPanel,panelEspectaculo;
    private JLabel lblTitulo, lblPaquete, lblEspectaculo;
    private JTable tablaEspectaculos;
    private JComboBox<String> comboPaquetes;
    private JTextField txtEspectaculo;
    static final int X_LABEL = 10;
    static final int X_TEXT = 200;
    static final int Y_DIST = 30;
    static final int WIDTH_LABEL = 180;
    static final int WIDTH_TEXT = 200;
    static final int HEIGHT_FIELD = 25;

    private String[] header = {"Nombre", "Descripcion", "etc,"};
    private String[][] data = {};
    
    private PaqEspectaculos paqueteSelected;
    //TODO borrar lista que es solo para prueba
    List<PaqEspectaculos> lstPaquetes = new ArrayList<PaqEspectaculos>();
    
    
    // Constructor
	public ConsultaPaqueteEspectaculos() {
		//TODO borrar que es solo para pruebas hasta tener la BD
		cargarDatosPrueba();
		
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
		lblPaquete.setBounds(X_LABEL, Y_DIST*2, WIDTH_LABEL, HEIGHT_FIELD);
		miPanel.add(lblPaquete);
		comboPaquetes = new JComboBox<String>();
		comboPaquetes.addItem("Seleccione Paquete");
		comboPaquetes.setBounds(X_TEXT, Y_DIST*2, WIDTH_TEXT, HEIGHT_FIELD);
		lstPaquetes.forEach((p)->{
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
		sp.setBounds(20, Y_DIST*4, 700, 150);
		miPanel.add(sp);

		lblEspectaculo = new JLabel("Espectaculo", SwingConstants.RIGHT);
		lblEspectaculo.setBounds(X_LABEL, Y_DIST*10, WIDTH_LABEL, HEIGHT_FIELD);
		miPanel.add(lblEspectaculo);
		txtEspectaculo= new JTextField();
		txtEspectaculo.setEnabled(false);
		txtEspectaculo.setBounds(X_TEXT, Y_DIST*10, WIDTH_TEXT, HEIGHT_FIELD);
		miPanel.add(txtEspectaculo);
	}
	
	private void listenerComboPaquetes(ItemEvent e) {
		if(e.getStateChange() == ItemEvent.SELECTED) {
			DefaultTableModel tm = (DefaultTableModel) tablaEspectaculos.getModel();
			limpiarTabla(tm);
			paqueteSelected = lstPaquetes.stream().filter(p -> (p.getNombre() == e.getItem())).findFirst().get();
			for (int i = 0; i < paqueteSelected.getEspectaculos().size(); i++) {
				Espectaculo esp = paqueteSelected.getEspectaculos().get(i);
				Object[] data = {esp.getNombre(),
						esp.getDescripcion(),
						esp.getPlataforma()};
				tm.addRow(data);
			}
		}
	}
	
	private void cargarPanelEspectaculo(Espectaculo espectaculo) {
		txtEspectaculo.setText(espectaculo.getNombre());
	}
	private void limpiarTabla(DefaultTableModel dtm) {
		int cantRow = dtm.getRowCount();
		for(int i = 0; i < cantRow; i++) {
			dtm.removeRow(0);
		}
	}
	
	private void cargarDatosPrueba() {
		PaqEspectaculos pq = new PaqEspectaculos("Paquete 1", "primer Paq", new DtFecha(1, 1, 1), new DtFecha(2, 1, 1), 10);
		Espectaculo e = new Espectaculo("El Seba", "Twitch", "StandUp - Seba", "Tremendo StandUp de El Seba", 60, 1, 10, "laUrl", 5, null);
		pq.addEspectaculo(e);
		lstPaquetes.add(pq);
		pq = new PaqEspectaculos("Paquete 2", "segundo Paq", new DtFecha(1, 1, 1), new DtFecha(2, 1, 1), 15);
		pq.addEspectaculo(e);
		e = new Espectaculo("El aviador", "Telefonica", "Servidores y Aviones", "Terminaremos hablando de Telefonica", 60, 1, 10, "laUrl", 5, null);
		pq.addEspectaculo(e);
		
		lstPaquetes.add(pq);
		pq = new PaqEspectaculos("Paquete 3", "tercer Paq", new DtFecha(1, 1, 1), new DtFecha(2, 1, 1), 20);
		lstPaquetes.add(pq);
	}
}

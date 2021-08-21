package presentacion;

import java.awt.BorderLayout;
import java.awt.Dimension;

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
import javax.swing.table.DefaultTableModel;

import jdk.nashorn.internal.scripts.JS;

@SuppressWarnings("serial")
public class ConsultaPaqueteEspectaculos extends JInternalFrame{
    private JButton btnGuardar, btnCancelar;
    private JPanel miPanel,panelTable;
    private JLabel lblTitulo, lblPaquete, lblDescripcion, lblUrl;
    private JTextField txtNombre, txtDescripcion, txtUrl;
    private JTable tablaEspectaculos;
    private JComboBox<String> comboPaquetes;
    static final int X_LABEL = 10;
    static final int X_TEXT = 200;
    static final int Y_DIST = 30;
    static final int WIDTH_LABEL = 180;
    static final int WIDTH_TEXT = 200;
    static final int HEIGHT_FIELD = 25;

    private String[] header = {"Nombre", "Descripcion", "etc,"};
    private String[][] data = {{"ver", "que", "Mostrar"}};
    
    
    // Constructor
	public ConsultaPaqueteEspectaculos() {
		miPanel = new JPanel();
		miPanel.setLayout(null);
		miPanel.setBounds(0, 0, 700, 100);
		add(miPanel);
		setBounds(30, 30, 700, 600);
		setResizable(false);
		setClosable(false);
		setIconifiable(false);
		setBorder(null);
		((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).setNorthPane(null);
		
		panelTable = new JPanel();
		panelTable.setLayout(null);
		panelTable.setBounds(0, 0, 700, 500);
		add(panelTable);

		
		// Titulo
		lblTitulo = new JLabel("Consultar Paquete de Espectaculos");
		lblTitulo.setFont(new java.awt.Font("Comic Sans MS", 1, 20));
		lblTitulo.setBounds(10, 0, 800, 25);
		miPanel.add(lblTitulo);

		// Paquete
		lblPaquete = new JLabel("Paquete", SwingConstants.RIGHT);
		lblPaquete.setBounds(X_LABEL, Y_DIST*2, WIDTH_LABEL, HEIGHT_FIELD);
		miPanel.add(lblPaquete);
		comboPaquetes = new JComboBox<String>();
		comboPaquetes.addItem("Seleccione Paquete");
		comboPaquetes.setBounds(X_TEXT, Y_DIST*2, WIDTH_TEXT, HEIGHT_FIELD);
		miPanel.add(comboPaquetes);
		 
		// Tabla Espectaculos
		tablaEspectaculos = new JTable(data,header);
		tablaEspectaculos.setPreferredScrollableViewportSize(new Dimension(40, 290));
		JScrollPane sp = new JScrollPane(tablaEspectaculos);
		sp.setBounds(20, Y_DIST*4, 600, 200);
		panelTable.add(sp);

	}
}

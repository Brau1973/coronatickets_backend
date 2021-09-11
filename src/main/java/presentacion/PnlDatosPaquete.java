package presentacion;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import interfaces.Fabrica;
import interfaces.IControladorPaquete;
import logica.Espectaculo;
import logica.PaqueteEspectaculos;

@SuppressWarnings("serial")
public class PnlDatosPaquete extends JInternalFrame{
    private JPanel miPanel, panelEsp, panelPaquete;
    private JLabel lblEspectaculos, lblNombEspectaculo, lblNombPaquete, lblDescPaquete, lblDescripcion, lblCosto, lblDuracion;
    private JTable tablaEspectaculos;
    private JLabel txtNombEspectaculo, txtDescripcion, txtNombPaquete, txtDescripcionPaquete, txtCosto, txtDuracion;
    private Border borderPnlEspectaculos, borderPnlPaquete;
    static final int X_LABEL = 15;
    static final int X_TEXT = 200;
    static final int Y_DIST = 30;
    static final int WIDTH_LABEL = 180;
    static final int WIDTH_TEXT = 200;
    static final int HEIGHT_FIELD = 25;
    static final String SELECCIONE = "Seleccione";

    private String[] header = {"Nombre", "Artista", "Descripcion"};
    private String[][] data = {};

    private PaqueteEspectaculos paqueteSelected;
    List<PaqueteEspectaculos> lstPaquetes = new ArrayList<PaqueteEspectaculos>();
    IControladorPaquete iControladorPaquete = Fabrica.getInstancia().getIControladorPaquete();

    // Constructor
    public PnlDatosPaquete(){
	 miPanel = new JPanel();
	 miPanel.setLayout(null);
	 miPanel.setBounds(0, 0, 800, 700);
	 add(miPanel);
	 setBounds(3, 3, 700, 700);
	 setResizable(false);
	 setClosable(false);
	 setIconifiable(false);
	 setBorder(null);
	 ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).setNorthPane(null);

	 panelPaquete = new JPanel();
	 borderPnlPaquete = BorderFactory.createTitledBorder("Paquete");
	 panelPaquete.setBorder(borderPnlPaquete);
	 panelPaquete.setLayout(null);
	 panelPaquete.setBounds(X_LABEL, Y_DIST, 680, 235);
	 miPanel.add(panelPaquete);
	 panelPaquete.setVisible(true);
	 lblNombPaquete = new JLabel("Nombre", SwingConstants.RIGHT);
	 lblNombPaquete.setBounds(X_LABEL, Y_DIST, WIDTH_LABEL, HEIGHT_FIELD);
	 panelPaquete.add(lblNombPaquete);
	 txtNombPaquete = new JLabel();
	 txtNombPaquete.setEnabled(false);
	 txtNombPaquete.setBounds(X_TEXT, Y_DIST, WIDTH_TEXT, HEIGHT_FIELD);
	 panelPaquete.add(txtNombPaquete);

	 lblDescPaquete = new JLabel("Descripcion", SwingConstants.RIGHT);
	 lblDescPaquete.setBounds(X_LABEL, Y_DIST * 2, WIDTH_LABEL, HEIGHT_FIELD);
	 panelPaquete.add(lblDescPaquete);
	 txtDescripcionPaquete = new JLabel();
	 txtDescripcionPaquete.setEnabled(false);
	 txtDescripcionPaquete.setBounds(X_TEXT, Y_DIST * 2, WIDTH_TEXT, HEIGHT_FIELD);
	 panelPaquete.add(txtDescripcionPaquete);

	 lblEspectaculos = new JLabel("Espectaculos", SwingConstants.RIGHT);
	 lblEspectaculos.setBounds(X_LABEL, Y_DIST * 3, WIDTH_LABEL, HEIGHT_FIELD);
	 panelPaquete.add(lblEspectaculos);

	 // Tabla Espectaculos
	 DefaultTableModel model = new DefaultTableModel(data, header);
	 tablaEspectaculos = new JTable(model);
	 tablaEspectaculos.setPreferredScrollableViewportSize(new Dimension(40, 190));
	 JScrollPane sp = new JScrollPane(tablaEspectaculos);
	 tablaEspectaculos.addMouseListener(new MouseAdapter(){
	     public void mouseClicked(MouseEvent e){
		  int row = tablaEspectaculos.getSelectedRow();
		  Espectaculo esp = paqueteSelected.getEspectaculos().get(row);
		  cargarPanelEspectaculo(esp);
	     }
	 });
	 sp.setBounds(20, Y_DIST * 4, 640, 100);
	 panelPaquete.add(sp);

	 // Panel detalles Espectaculo
	 panelEsp = new JPanel();
	 borderPnlEspectaculos = BorderFactory.createTitledBorder("Espectaculo");
	 panelEsp.setBorder(borderPnlEspectaculos);
	 panelEsp.setLayout(null);
	 panelEsp.setBounds(X_LABEL, Y_DIST * 9, 680, 180);
	 miPanel.add(panelEsp);
	 panelEsp.setVisible(false);
	 lblNombEspectaculo = new JLabel("Nombre", SwingConstants.RIGHT);
	 lblNombEspectaculo.setBounds(X_LABEL, Y_DIST, WIDTH_LABEL, HEIGHT_FIELD);
	 panelEsp.add(lblNombEspectaculo);
	 txtNombEspectaculo = new JLabel();
	 txtNombEspectaculo.setEnabled(false);
	 txtNombEspectaculo.setBounds(X_TEXT, Y_DIST, WIDTH_TEXT, HEIGHT_FIELD);
	 panelEsp.add(txtNombEspectaculo);

	 lblDescripcion = new JLabel("Descripcion", SwingConstants.RIGHT);
	 lblDescripcion.setBounds(X_LABEL, Y_DIST * 2, WIDTH_LABEL, HEIGHT_FIELD);
	 panelEsp.add(lblDescripcion);
	 txtDescripcion = new JLabel();
	 txtDescripcion.setEnabled(false);
	 txtDescripcion.setBounds(X_TEXT, Y_DIST * 2, WIDTH_TEXT, HEIGHT_FIELD);
	 panelEsp.add(txtDescripcion);

	 lblCosto = new JLabel("Costo", SwingConstants.RIGHT);
	 lblCosto.setBounds(X_LABEL, Y_DIST * 3, WIDTH_LABEL, HEIGHT_FIELD);
	 panelEsp.add(lblCosto);
	 txtCosto = new JLabel();
	 txtCosto.setEnabled(false);
	 txtCosto.setBounds(X_TEXT, Y_DIST * 3, WIDTH_TEXT, HEIGHT_FIELD);
	 panelEsp.add(txtCosto);

	 lblDuracion = new JLabel("Duracion", SwingConstants.RIGHT);
	 lblDuracion.setBounds(X_LABEL, Y_DIST * 4, WIDTH_LABEL, HEIGHT_FIELD);
	 panelEsp.add(lblDuracion);
	 txtDuracion = new JLabel();
	 txtDuracion.setEnabled(false);
	 txtDuracion.setBounds(X_TEXT, Y_DIST * 4, WIDTH_TEXT, HEIGHT_FIELD);
	 panelEsp.add(txtDuracion);
    }

    // Inicializar panel
    public void cargarPanel(PaqueteEspectaculos p){
	 DefaultTableModel tm = (DefaultTableModel) tablaEspectaculos.getModel();
	 paqueteSelected = p;
	 txtNombPaquete.setText(paqueteSelected.getNombre());
	 txtDescripcionPaquete.setText(paqueteSelected.getDescripcion());
	 limpiarTabla(tm);
	 for(int i = 0; i < p.getEspectaculos().size(); i++){
	     Espectaculo esp = p.getEspectaculos().get(i);
	     Object[] data = {esp.getNombre(), esp.getArtista(), esp.getDescripcion()};
	     tm.addRow(data);
	 }
    }

    private void cargarPanelEspectaculo(Espectaculo espectaculo){
	 panelEsp.setVisible(true);
	 txtNombEspectaculo.setText(espectaculo.getNombre());
	 txtDescripcion.setText(espectaculo.getDescripcion());
	 txtCosto.setText("$" + String.valueOf(espectaculo.getCosto()));
	 txtDuracion.setText(String.valueOf(espectaculo.getDuracion()));
    }

    private void limpiarTabla(DefaultTableModel dtm){
	 panelEsp.setVisible(false);
	 int cantRow = dtm.getRowCount();
	 for(int i = 0; i < cantRow; i++){
	     dtm.removeRow(0);
	 }
    }

}
package presentacion;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import datatypes.DtEspectaculo;
import datatypes.DtPaqueteEspectaculo;
import interfaces.Fabrica;
import interfaces.IControladorPaquete;

@SuppressWarnings("serial")
public class PnlDatosPaquete extends JInternalFrame{
    private JPanel miPanel, panelEsp, panelPaquete;
    private JLabel lblEspectaculos, lblRegistro, lblNombPaquete, lblDescPaquete, lblURL, lblCosto, lblCantidadMaxima;
    private JTextField textNombreEspectaculo, textCantidadMaxima, textArtistaOrganizador, textDescripcion, textDuracion, textCosto, textURL, textRegistro, textCantidadMinima;
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

    private Boolean eventoTablaActivo = true;
    private String[] header = {"Nombre", "Artista", "Plataforma", "Descripción"};
    private String[][] data = {};

    private DtPaqueteEspectaculo paqueteSelected;
    List<DtPaqueteEspectaculo> lstPaquetes = new ArrayList<DtPaqueteEspectaculo>();
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
		  if(eventoTablaActivo){
		      int row = tablaEspectaculos.getSelectedRow();
		      DtEspectaculo esp = paqueteSelected.getEspectaculos().get(row);
		      cargarPanelEspectaculo(esp);
		  }
	     }
	 });
	 sp.setBounds(20, Y_DIST * 4, 640, 100);
	 panelPaquete.add(sp);

	 // Panel detalles Espectaculo
	 panelEsp = new JPanel();
	 borderPnlEspectaculos = BorderFactory.createTitledBorder("Espectaculo");
	 panelEsp.setBorder(borderPnlEspectaculos);
	 panelEsp.setLayout(null);
	 panelEsp.setBounds(X_LABEL, Y_DIST * 9, 680, 220);
	 miPanel.add(panelEsp);
	 panelEsp.setVisible(false);
	 // lblNombEspectaculo = new JLabel("Nombre", SwingConstants.RIGHT);
	 // lblNombEspectaculo.setBounds(X_LABEL, Y_DIST, WIDTH_LABEL, HEIGHT_FIELD);
	 // panelEsp.add(lblNombEspectaculo);
	 // txtNombEspectaculo = new JLabel();
	 // txtNombEspectaculo.setEnabled(false);
	 // txtNombEspectaculo.setBounds(X_TEXT, Y_DIST, WIDTH_TEXT, HEIGHT_FIELD);
	 // panelEsp.add(txtNombEspectaculo);
	 //
	 // lblDescripcion = new JLabel("Descripcion", SwingConstants.RIGHT);
	 // lblDescripcion.setBounds(X_LABEL, Y_DIST * 2, WIDTH_LABEL, HEIGHT_FIELD);
	 // panelEsp.add(lblDescripcion);
	 // txtDescripcion = new JLabel();
	 // txtDescripcion.setEnabled(false);
	 // txtDescripcion.setBounds(X_TEXT, Y_DIST * 2, WIDTH_TEXT, HEIGHT_FIELD);
	 // panelEsp.add(txtDescripcion);
	 //
	 // lblCosto = new JLabel("Costo", SwingConstants.RIGHT);
	 // lblCosto.setBounds(X_LABEL, Y_DIST * 3, WIDTH_LABEL, HEIGHT_FIELD);
	 // panelEsp.add(lblCosto);
	 // txtCosto = new JLabel();
	 // txtCosto.setEnabled(false);
	 // txtCosto.setBounds(X_TEXT, Y_DIST * 3, WIDTH_TEXT, HEIGHT_FIELD);
	 // panelEsp.add(txtCosto);
	 //
	 // lblDuracion = new JLabel("Duracion", SwingConstants.RIGHT);
	 // lblDuracion.setBounds(X_LABEL, Y_DIST * 4, WIDTH_LABEL, HEIGHT_FIELD);
	 // panelEsp.add(lblDuracion);
	 // txtDuracion = new JLabel();
	 // txtDuracion.setEnabled(false);
	 // txtDuracion.setBounds(X_TEXT, Y_DIST * 4, WIDTH_TEXT, HEIGHT_FIELD);
	 // panelEsp.add(txtDuracion);

	 JLabel lblNombreEspectaculo = new JLabel("Nombre:");
	 lblNombreEspectaculo.setBounds(X_LABEL, 30, 137, 14);
	 panelEsp.add(lblNombreEspectaculo);

	 textNombreEspectaculo = new JTextField();
	 textNombreEspectaculo.setEditable(false);
	 textNombreEspectaculo.setBounds(X_TEXT, 30, 200, 20);
	 panelEsp.add(textNombreEspectaculo);

	 JLabel lblArtistaOrganizador = new JLabel("Organiza:");
	 lblArtistaOrganizador.setBounds(X_LABEL, 62, 137, 14);
	 panelEsp.add(lblArtistaOrganizador);

	 textArtistaOrganizador = new JTextField();
	 textArtistaOrganizador.setEditable(false);
	 textArtistaOrganizador.setBounds(X_TEXT, 62, 200, 20);
	 panelEsp.add(textArtistaOrganizador);

	 JLabel lblDescripcion = new JLabel("Descripcion:");
	 lblDescripcion.setBounds(X_LABEL, 94, 137, 14);
	 panelEsp.add(lblDescripcion);

	 textDescripcion = new JTextField();
	 textDescripcion.setEditable(false);
	 textDescripcion.setBounds(X_TEXT, 94, 200, 20);
	 panelEsp.add(textDescripcion);

	 JLabel lblDuracion = new JLabel("Duracion:");
	 lblDuracion.setBounds(X_LABEL, 126, 137, 14);
	 panelEsp.add(lblDuracion);

	 textDuracion = new JTextField();
	 textDuracion.setEditable(false);
	 textDuracion.setBackground(UIManager.getColor("Button.disabledForeground"));
	 textDuracion.setBounds(X_TEXT, 126, 40, 20);
	 panelEsp.add(textDuracion);

	 JLabel lblCantidadMinima = new JLabel("Cant. Minima:");
	 lblCantidadMinima.setBounds(255, 126, 105, 14);
	 panelEsp.add(lblCantidadMinima);

	 textCantidadMaxima = new JTextField();
	 textCantidadMaxima.setEditable(false);
	 textCantidadMaxima.setBackground(UIManager.getColor("Button.disabledForeground"));
	 textCantidadMaxima.setBounds(360, 126, 40, 20);
	 panelEsp.add(textCantidadMaxima);

	 lblCantidadMaxima = new JLabel("Cant. Maxima:");
	 lblCantidadMaxima.setBounds(X_LABEL, 158, 105, 14);
	 panelEsp.add(lblCantidadMaxima);

	 textCantidadMinima = new JTextField();
	 textCantidadMinima.setEditable(false);
	 textCantidadMinima.setBackground(UIManager.getColor("Button.disabledForeground"));
	 textCantidadMinima.setBounds(X_TEXT, 158, 40, 20);
	 panelEsp.add(textCantidadMinima);

	 lblCosto = new JLabel("Costo:");
	 lblCosto.setBounds(255, 158, 105, 20);
	 panelEsp.add(lblCosto);

	 textCosto = new JTextField();
	 textCosto.setEditable(false);
	 textCosto.setBackground(UIManager.getColor("Button.disabledForeground"));
	 textCosto.setBounds(360, 158, 40, 20);
	 panelEsp.add(textCosto);

	 lblRegistro = new JLabel("Registro:");
	 lblRegistro.setBounds(X_LABEL, 190, 55, 14);
	 // miPanel.add(lblRegistro);
	 textRegistro = new JTextField();
	 textRegistro.setEditable(false);
	 textRegistro.setBackground(UIManager.getColor("Button.disabledForeground"));
	 textRegistro.setBounds(X_TEXT, 190, 200, 20);
	 // miPanel.add(textRegistro);

	 lblURL = new JLabel("URL:");
	 lblURL.setBounds(X_LABEL, 190, 53, 14);
	 panelEsp.add(lblURL);

	 textURL = new JTextField();
	 textURL.setEditable(false);
	 textURL.setBackground(UIManager.getColor("Button.disabledForeground"));
	 textURL.setBounds(X_TEXT, 190, 200, 20);
	 panelEsp.add(textURL);
    }

    // Inicializar panel
    public void cargarPanel(DtPaqueteEspectaculo p, Boolean eventoTablaActivo){
	 this.eventoTablaActivo = eventoTablaActivo;
	 DefaultTableModel tm = (DefaultTableModel) tablaEspectaculos.getModel();
	 paqueteSelected = p;
	 txtNombPaquete.setText(paqueteSelected.getNombre());
	 txtDescripcionPaquete.setText(paqueteSelected.getDescripcion());
	 limpiarTabla(tm);
	 for(int i = 0; i < p.getEspectaculos().size(); i++){
	     DtEspectaculo esp = p.getEspectaculos().get(i);
	     Object[] data = {esp.getNombre(), esp.getArtista(), "", esp.getDescripcion()};
	     tm.addRow(data);
	 }
    }

    private void cargarPanelEspectaculo(DtEspectaculo espectaculo){
	 panelEsp.setVisible(true);
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

    }

    private void limpiarTabla(DefaultTableModel dtm){
	 panelEsp.setVisible(false);
	 int cantRow = dtm.getRowCount();
	 for(int i = 0; i < cantRow; i++){
	     dtm.removeRow(0);
	 }
    }

}
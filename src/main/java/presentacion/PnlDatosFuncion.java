package presentacion;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import interfaces.Fabrica;
import interfaces.IControladorPaquete;
import logica.Funcion;
import logica.PaqueteEspectaculos;

@SuppressWarnings("serial")
public class PnlDatosFuncion extends JInternalFrame{
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

    private String[] header = {"Nombre", "Artista", "Plataforma", "Descripción"};
    private String[][] data = {};

    private PaqueteEspectaculos paqueteSelected;
    List<PaqueteEspectaculos> lstPaquetes = new ArrayList<PaqueteEspectaculos>();
    IControladorPaquete iControladorPaquete = Fabrica.getInstancia().getIControladorPaquete();

    // Constructor
    public PnlDatosFuncion(){
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
	 borderPnlPaquete = BorderFactory.createTitledBorder("Funcion");
	 panelPaquete.setBorder(borderPnlPaquete);
	 panelPaquete.setLayout(null);
	 panelPaquete.setBounds(X_LABEL, Y_DIST, 680, 235);
	 miPanel.add(panelPaquete);
	 panelPaquete.setVisible(true);
	 lblNombPaquete = new JLabel("Nombre:", SwingConstants.RIGHT);
	 lblNombPaquete.setBounds(X_LABEL, Y_DIST, WIDTH_LABEL, HEIGHT_FIELD);
	 panelPaquete.add(lblNombPaquete);
	 txtNombPaquete = new JLabel();
	 txtNombPaquete.setEnabled(false);
	 txtNombPaquete.setBounds(X_TEXT, Y_DIST, WIDTH_TEXT, HEIGHT_FIELD);
	 panelPaquete.add(txtNombPaquete);

	 lblDescPaquete = new JLabel("Fecha:", SwingConstants.RIGHT);
	 lblDescPaquete.setBounds(X_LABEL, Y_DIST * 2, WIDTH_LABEL, HEIGHT_FIELD);
	 panelPaquete.add(lblDescPaquete);
	 txtDescripcion = new JLabel();
	 txtDescripcion.setEnabled(false);
	 txtDescripcion.setBounds(X_TEXT, Y_DIST * 2, WIDTH_TEXT, HEIGHT_FIELD);
	 panelPaquete.add(txtDescripcion);

	 lblEspectaculos = new JLabel("Hora:", SwingConstants.RIGHT);
	 lblEspectaculos.setBounds(X_LABEL, Y_DIST * 3, WIDTH_LABEL, HEIGHT_FIELD);
	 panelPaquete.add(lblEspectaculos);
	 txtDescripcionPaquete = new JLabel();
	 txtDescripcionPaquete.setEnabled(false);
	 txtDescripcionPaquete.setBounds(X_TEXT, Y_DIST, WIDTH_TEXT, HEIGHT_FIELD);
	 panelPaquete.add(txtDescripcionPaquete);

	 lblDescripcion = new JLabel("Registro:", SwingConstants.RIGHT);
	 lblDescripcion.setBounds(X_LABEL, Y_DIST * 4, WIDTH_LABEL, HEIGHT_FIELD);
	 panelPaquete.add(lblDescripcion);
	 txtNombEspectaculo = new JLabel();
	 txtNombEspectaculo.setEnabled(false);
	 txtNombEspectaculo.setBounds(X_TEXT, Y_DIST * 5, WIDTH_TEXT, HEIGHT_FIELD);
	 panelPaquete.add(txtNombEspectaculo);

    }

    // Inicializar panel
    public void cargarPanel(Funcion funcion){
	 SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
	 String datosFecha = formatoFecha.format(funcion.getFecha());
	 String datosReg = formatoFecha.format(funcion.getRegistro());
	 /* DefaultTableModel tm = (DefaultTableModel) tablaEspectaculos.getModel();
	 paqueteSelected = p;*/
	 Time horaInicio = funcion.getHoraInicio();
	 txtNombPaquete.setText(funcion.getNombre());
	 txtDescripcion.setText(String.valueOf(datosFecha));
	 txtDescripcionPaquete.setText(horaInicio.toString());
	 txtNombEspectaculo.setText(String.valueOf(datosReg));
    }


}
package presentacion;

import java.sql.Time;
import java.text.SimpleDateFormat;

import javax.swing.BorderFactory;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import datatypes.DtFuncion;

@SuppressWarnings("serial")
public class PnlDatosFuncion extends JInternalFrame{
    private JPanel miPanel, panelFuncion;
    private JLabel lblRegistro, lblHoraInicio, lblFecha, lblNombFuncion;
    private JLabel txtRegistro, txtHoraInicio, txtFecha, txtNombFuncion;

    private Border borderPnlFuncion;
    static final int X_LABEL = 15;
    static final int X_TEXT = 200;
    static final int Y_DIST = 30;
    static final int WIDTH_LABEL = 180;
    static final int WIDTH_TEXT = 200;
    static final int HEIGHT_FIELD = 25;


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

	 panelFuncion = new JPanel();
	 borderPnlFuncion = BorderFactory.createTitledBorder("Funcion");
	 panelFuncion.setBorder(borderPnlFuncion);
	 panelFuncion.setLayout(null);
	 panelFuncion.setBounds(X_LABEL, Y_DIST, 680, 235);
	 miPanel.add(panelFuncion);
	 panelFuncion.setVisible(true);

	 lblNombFuncion = new JLabel("Nombre:", SwingConstants.RIGHT);
	 lblNombFuncion.setBounds(X_LABEL, Y_DIST, WIDTH_LABEL, HEIGHT_FIELD);
	 panelFuncion.add(lblNombFuncion);
	 txtNombFuncion = new JLabel();
	 txtNombFuncion.setEnabled(false);
	 txtNombFuncion.setBounds(X_TEXT, Y_DIST, WIDTH_TEXT, HEIGHT_FIELD);
	 panelFuncion.add(txtNombFuncion);

	 lblFecha = new JLabel("Fecha:", SwingConstants.RIGHT);
	 lblFecha.setBounds(X_LABEL, Y_DIST * 2, WIDTH_LABEL, HEIGHT_FIELD);
	 panelFuncion.add(lblFecha);
	 txtFecha = new JLabel();
	 txtFecha.setEnabled(false);
	 txtFecha.setBounds(X_TEXT, Y_DIST * 2, WIDTH_TEXT, HEIGHT_FIELD);
	 panelFuncion.add(txtFecha);

	 lblHoraInicio = new JLabel("Hora:", SwingConstants.RIGHT);
	 lblHoraInicio.setBounds(X_LABEL, Y_DIST * 3, WIDTH_LABEL, HEIGHT_FIELD);
	 panelFuncion.add(lblHoraInicio);
	 txtHoraInicio = new JLabel();
	 txtHoraInicio.setEnabled(false);
	 txtHoraInicio.setBounds(X_TEXT, Y_DIST * 3, WIDTH_TEXT, HEIGHT_FIELD);
	 panelFuncion.add(txtHoraInicio);

	 lblRegistro = new JLabel("Registro:", SwingConstants.RIGHT);
	 lblRegistro.setBounds(X_LABEL, Y_DIST * 4, WIDTH_LABEL, HEIGHT_FIELD);
	 panelFuncion.add(lblRegistro);
	 txtRegistro = new JLabel();
	 txtRegistro.setEnabled(false);
	 txtRegistro.setBounds(X_TEXT, Y_DIST * 4, WIDTH_TEXT, HEIGHT_FIELD);
	 panelFuncion.add(txtRegistro);

    }

    // Inicializar panel
    public void cargarPanel(DtFuncion funcion){
	 SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
	 String datosFecha = formatoFecha.format(funcion.getFecha());
	 String datosReg = formatoFecha.format(funcion.getRegistro());
	 Time horaInicio = funcion.getHoraInicio();
	 txtNombFuncion.setText(funcion.getNombre());
	 txtFecha.setText(String.valueOf(datosFecha));
	 txtHoraInicio.setText(horaInicio.toString());
	 txtRegistro.setText(String.valueOf(datosReg));
    }

    // Inicializar panel
    // public void cargarPanel(DtPaqueteEspectaculo p, Boolean eventoTablaActivo){

    // SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
    // String datosFecha = formatoFecha.format(p.getFecha());
    // String datosReg = formatoFecha.format(p.getRegistro());
    // Time horaInicio = p.getHoraInicio();
    // txtNombFuncion.setText(p.getNombre());
    // txtFecha.setText(String.valueOf(datosFecha));
    // txtHoraInicio.setText(horaInicio.toString());
    // txtRegistro.setText(String.valueOf(datosReg));

    /* paqueteSelected = p;
    txtNombPaquete.setText(paqueteSelected.getNombre());
    txtDescripcionPaquete.setText(paqueteSelected.getDescripcion());
    */
    /* for(int i = 0; i < p.getEspectaculos().size(); i++){
        DtEspectaculo esp = p.getEspectaculos().get(i);
        Object[] data = {esp.getNombre(), esp.getArtista(), "", esp.getDescripcion()};
        tm.addRow(data);
    }*/
    // }
}
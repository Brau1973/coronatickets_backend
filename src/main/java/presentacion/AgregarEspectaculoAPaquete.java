package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingConstants;

import logica.DtFecha;
import logica.Espectaculo;
import logica.PaqEspectaculos;

import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.JTextField;

public class AgregarEspectaculoAPaquete extends JInternalFrame {
	private JTextField textField;
	
    static final int X_LABEL = 10;
    static final int X_TEXT = 200;
    static final int Y_DIST = 30;
    static final int WIDTH_LABEL = 180;
    static final int WIDTH_TEXT = 200;
    static final int HEIGHT_FIELD = 25;

	
    //TODO borrar lista que es solo para prueba
    List<PaqEspectaculos> lstPaquetes = new ArrayList<PaqEspectaculos>();
	
	/**
	 * Launch the application.
	 */
    
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgregarEspectaculoAPaquete frame = new AgregarEspectaculoAPaquete();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AgregarEspectaculoAPaquete() {
		setBounds(30, 30, 800, 600); // MANOPLA
		getContentPane().setLayout(null);
		
		JPanel miPanel = new JPanel();
		miPanel.setLayout(null);
		miPanel.setBounds(0, 0, 800, 573);
		getContentPane().add(miPanel);
		
		JLabel lblAgregarEspectaculoA = new JLabel("Agregar Espectaculo a Paquete");
		lblAgregarEspectaculoA.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		lblAgregarEspectaculoA.setBounds(10, 0, 800, 25);
		miPanel.add(lblAgregarEspectaculoA);
		
		JLabel lblPaquete = new JLabel("Paquete", SwingConstants.RIGHT);
		lblPaquete.setBounds(10, 60, 180, 25);
		miPanel.add(lblPaquete);
		
		JComboBox<String> comboPaquetes = new JComboBox<String>();
		comboPaquetes.setBounds(200, 60, 200, 25);
		miPanel.add(comboPaquetes);
		
		JScrollPane sp = new JScrollPane((Component) null);
		sp.setBounds(20, 120, 700, 150);
		miPanel.add(sp);
		
		JLabel lblEspectaculo = new JLabel("Espectaculo", SwingConstants.RIGHT);
		lblEspectaculo.setBounds(10, 300, 180, 25);
		miPanel.add(lblEspectaculo);
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setBounds(200, 300, 200, 25);
		miPanel.add(textField);
		((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).setNorthPane(null);

		
		cargarDatosPrueba();
		
		// Combo Paquete
		//lblPaquete = new JLabel("Paquete", SwingConstants.RIGHT);
		//lblPaquete.setBounds(X_LABEL, Y_DIST*2, WIDTH_LABEL, HEIGHT_FIELD);
//		miPanel.add(lblPaquete);
//		comboPaquetes = new JComboBox<String>();
//		comboPaquetes.addItem("Seleccione Paquete");
//		comboPaquetes.setBounds(X_TEXT, Y_DIST*2, WIDTH_TEXT, HEIGHT_FIELD);
//		lstPaquetes.forEach((p)->{
//			comboPaquetes.addItem(p.getNombre());
//		});
//		//comboPaquetes.addItemListener(this::listenerComboPaquetes);
//		miPanel.add(comboPaquetes);
		
	}
	
	// NO AUTO GENERADO
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

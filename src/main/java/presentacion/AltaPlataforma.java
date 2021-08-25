package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import excepciones.PlataformaRepetidaExcepcion;
import interfaces.IControlador;

@SuppressWarnings("serial")
public class AltaPlataforma extends JInternalFrame{
	private IControlador icon;
    private JButton btnGuardar, btnCancelar;
    private JPanel miPanel;
    private JLabel lblTitulo, lblNombre, lblDescripcion, lblUrl;
    private JTextField txtNombre, txtDescripcion, txtUrl;
    static final int X_LABEL = 10;
    static final int X_TEXT = 200;
    static final int Y_DIST = 30;
    static final int WIDTH_LABEL = 180;
    static final int WIDTH_TEXT = 200;
    static final int HEIGHT_FIELD = 25;

    // Constructor
	public AltaPlataforma(IControlador icon) {
		this.icon = icon;
		miPanel = new JPanel();
		miPanel.setLayout(null);
		add(miPanel);
		setBounds(30, 30, 800, 600);
		setResizable(false);
		setClosable(false);
		setIconifiable(false);
		setBorder(null);
		((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).setNorthPane(null);

		
		// Titulo
		lblTitulo = new JLabel("Alta Plataforma");
		lblTitulo.setFont(new java.awt.Font("Comic Sans MS", 1, 20));
		lblTitulo.setBounds(10, 0, 800, 25);
		miPanel.add(lblTitulo);

		// Nombre
		lblNombre = new JLabel("Nombre", SwingConstants.RIGHT);
		lblNombre.setBounds(X_LABEL, Y_DIST*2, WIDTH_LABEL, HEIGHT_FIELD);
		miPanel.add(lblNombre);
		txtNombre = new JTextField();
		txtNombre.setBounds(X_TEXT, Y_DIST*2, WIDTH_TEXT, HEIGHT_FIELD);
		miPanel.add(txtNombre);

		// Descripcion
		lblDescripcion = new JLabel("Descripcion", SwingConstants.RIGHT);
		lblDescripcion.setBounds(X_LABEL, Y_DIST*3, WIDTH_LABEL, HEIGHT_FIELD);
		miPanel.add(lblDescripcion);
		txtDescripcion = new JTextField();
		txtDescripcion.setBounds(X_TEXT, Y_DIST*3, WIDTH_TEXT, HEIGHT_FIELD);
		miPanel.add(txtDescripcion);

		// Url
		lblUrl = new JLabel("Url", SwingConstants.RIGHT);
		lblUrl.setBounds(X_LABEL, Y_DIST*4, WIDTH_LABEL, HEIGHT_FIELD);
		miPanel.add(lblUrl);
		txtUrl = new JTextField();
		txtUrl.setBounds(X_TEXT, Y_DIST*4, WIDTH_TEXT, HEIGHT_FIELD);
		miPanel.add(txtUrl);

		// Boton Guardar
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				actionListenerGuardar(e);		
		}
			
		});
		btnGuardar.setBounds(200, Y_DIST*6, 115, 25);
		miPanel.add(btnGuardar);
		
		// Boton cancelar
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(325, Y_DIST*6, 115, 25);
		miPanel.add(btnCancelar);
	}
	
	protected void actionListenerGuardar(ActionEvent al) {
		String nombre = this.txtNombre.getText();
		String descripcion = this.txtDescripcion.getText();
		String url = this.txtUrl.getText();
		if (checkFormulario()) {
            try {
            	this.icon.altaPlataforma(nombre,descripcion,url);
            	JOptionPane.showMessageDialog(this, "la plataforma se ha creado con éxito");
            } catch (PlataformaRepetidaExcepcion e) {
                JOptionPane.showMessageDialog(this, e.getMessage(), "Alta Plataforma", JOptionPane.ERROR_MESSAGE);
            }
            limpiarFormulario();
            setVisible(false);
		}
        }
		private boolean checkFormulario() {
	        String nombre = this.txtNombre.getText();
	        String descripcion = this.txtDescripcion.getText();
	        String url = this.txtUrl.getText();
	        if (nombre.isEmpty() || descripcion.isEmpty()|| url.isEmpty()) {
	            JOptionPane.showMessageDialog(this, "No puede haber campos vacíos", "Alta Plataforma",
	                    JOptionPane.ERROR_MESSAGE);
	            return false;
	        }
	        return true;
	    }
		
		
		
		 private void limpiarFormulario() {
		        txtNombre.setText("");
		        txtDescripcion.setText("");
		        txtUrl.setText("");
		 }
	
	
}

package presentacion;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import com.toedter.calendar.JDateChooser;

import interfaces.Fabrica;
import interfaces.IControladorPaquete;
import logica.PaqueteEspectaculos;

@SuppressWarnings({ "serial"})
public class CreaPaqueteEspectaculo extends JInternalFrame {
	private JTextField txtNombre;
	private JTextField txtDescuento;
	private JTextArea txtDescripcion;
	private JLabel lblTitulo, lblNombre, lblDescripcion, lblFechaInicio, lblFechaFin, lblDescuento, lblFechaAlta;
	private JButton btnCancelar, btnAceptar; 
	private JScrollPane scrollDescripcion;
	private JDateChooser dateFechaInicio, dateFechaFin, dateFechaAlta;
	
	IControladorPaquete iControladorPaquete = Fabrica.getInstancia().getIControladorPaquete();
	
	public CreaPaqueteEspectaculo() {
		setBorder(null);
		setClosable(true);
		setBounds(10, 10, 800, 600);
		getContentPane().setLayout(null);
		((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).setNorthPane(null);
		
		lblTitulo = new JLabel("Crear Paquete de Espectaculo");
		lblTitulo.setFont(new Font("Comic Sans MS", Font.BOLD, 19));
		lblTitulo.setBounds(10, 11, 600, 27);
		getContentPane().add(lblTitulo);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Verdana", Font.BOLD, 12));
		lblNombre.setBounds(10, 69, 64, 14);
		getContentPane().add(lblNombre);
		
		lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setFont(new Font("Verdana", Font.BOLD, 12));
		lblDescripcion.setBounds(10, 112, 91, 14);
		getContentPane().add(lblDescripcion);
		
		lblFechaInicio = new JLabel("Fecha Inicio:");
		lblFechaInicio.setFont(new Font("Verdana", Font.BOLD, 12));
		lblFechaInicio.setBounds(10, 216, 91, 14);
		getContentPane().add(lblFechaInicio);
		
		lblFechaFin = new JLabel("Fecha Fin:");
		lblFechaFin.setFont(new Font("Verdana", Font.BOLD, 12));
		lblFechaFin.setBounds(10, 263, 79, 14);
		getContentPane().add(lblFechaFin);
		
		lblDescuento = new JLabel("Descuento:");
		lblDescuento.setFont(new Font("Verdana", Font.BOLD, 12));
		lblDescuento.setBounds(10, 307, 90, 14);
		getContentPane().add(lblDescuento);
		
		lblFechaAlta = new JLabel("Fecha Alta:");
		lblFechaAlta.setFont(new Font("Verdana", Font.BOLD, 12));
		lblFechaAlta.setBounds(10, 350, 79, 14);
		getContentPane().add(lblFechaAlta);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(148, 65, 260, 25);
		getContentPane().add(txtNombre);
		
		txtDescuento = new JTextField();
		txtDescuento.setBounds(148, 303, 260, 25);
		getContentPane().add(txtDescuento);
		
		btnCancelar = new JButton();
		btnCancelar.addActionListener((e) -> cancelar(e));
		btnCancelar.setText("Cancelar");
		btnCancelar.setBounds(279, 394, 127, 25);
		getContentPane().add(btnCancelar);
		
		
		
		btnAceptar = new JButton();
		btnAceptar.addActionListener((e) -> guardar(e));
		btnAceptar.setText("Aceptar");
		btnAceptar.setBounds(148, 394, 127, 25);
		getContentPane().add(btnAceptar);
		
		txtDescripcion = new JTextArea();
		txtDescripcion.setTabSize(8);
		txtDescripcion.setBounds(148, 96, 260, 100);
		getContentPane().add(txtDescripcion);
		
		scrollDescripcion = new JScrollPane(txtDescripcion);
		scrollDescripcion.setBounds(148, 96, 260, 100);
		getContentPane().add(scrollDescripcion);
		
		dateFechaInicio = new JDateChooser();
		dateFechaInicio.setBounds(148, 210, 260, 20);
		getContentPane().add(dateFechaInicio);
		
		dateFechaFin = new JDateChooser();
		dateFechaFin.setBounds(148, 257, 260, 20);
		getContentPane().add(dateFechaFin);
		
		dateFechaAlta = new JDateChooser();
		dateFechaAlta.setBounds(148, 350, 260, 20);
		getContentPane().add(dateFechaAlta);
		
	}
	
	// Limpia Formulario
    private void limpiarPantalla(){
    	txtNombre.setText("");
		txtDescripcion.setText("");
		dateFechaInicio.setCalendar(null);
		dateFechaFin.setCalendar(null);
		dateFechaAlta.setCalendar(null);
		txtDescuento.setText("");
    }
    
    private Boolean validateForm() {
    	if(!txtNombre.getText().isEmpty() &&
    			!txtDescripcion.getText().isEmpty() &&
    			dateFechaInicio.getDate() != null &&
    			dateFechaFin.getDate() != null &&
    			dateFechaAlta.getDate() != null &&
    			!txtDescuento.getText().isEmpty()) {
    		if(iControladorPaquete.existePaquete(txtNombre.getText())) {
    			JOptionPane.showMessageDialog(null, "Ya existe un paquete con ese nombre", "Error" , JOptionPane.ERROR_MESSAGE);
    			return false;
    		}
    	}else {
    		JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios", "Error" , JOptionPane.ERROR_MESSAGE);
    		return false;
    	}
    	return true;
    }
    
    private void guardar(ActionEvent a) {
		if(validateForm()) {
			 Integer.parseInt(this.txtDescuento.getText());
				PaqueteEspectaculos pe = new PaqueteEspectaculos(this.txtNombre.getText(), 
																this.txtDescripcion.getText(),
																this.dateFechaInicio.getDate(),
																this.dateFechaFin.getDate(),
																this.dateFechaAlta.getDate(),
																Integer.parseInt(this.txtDescuento.getText()));
				iControladorPaquete.altaPaquete(pe);
				JOptionPane.showMessageDialog(null, "Paquete creado correctamente", "Alta Paquete" , JOptionPane.INFORMATION_MESSAGE);
				limpiarPantalla();
		}
	}

    private void cancelar(ActionEvent a) {
    	limpiarPantalla();
    }
}

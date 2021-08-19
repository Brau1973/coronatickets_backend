package presentacion;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class AltaPlataforma extends JInternalFrame{
    private JButton btnAceptar, btnCancelar;
    private JPanel miPanel;
    private JLabel lblNombre, lblDescripcion, lblUrl;
    private JTextField txtNombre;

    // Constructor
    public AltaPlataforma(){
	 miPanel = new JPanel();
	 miPanel.setLayout(null);
	 add(miPanel);
	 setBounds(30, 30, 460, 500);
	 setResizable(false);
	 setClosable(false);
	 setIconifiable(false);
	 setBorder(null);
	 ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).setNorthPane(null);
	 // lblTitulo = new JLabel();
	 // lblTitulo.setText("Alta plataforma");
	 // lblTitulo.setFont(new java.awt.Font("Comic Sans MS", 1, 20));
	 // lblTitulo.setBounds(10, 1, 280, 25);
	 // miPanel.add(lblTitulo);

	 lblNombre = new JLabel();
	 lblNombre.setText("Nombre");
	 lblNombre.setBounds(10, 0, 100, 25);
	 miPanel.add(lblNombre);

	 txtNombre = new JTextField();
	 txtNombre.setBounds(120, 0, 200, 25);
	 miPanel.add(txtNombre);

	 // Boton Aceptar
	 btnAceptar = new JButton();
	 btnAceptar.setText("Aceptar");
	 btnAceptar.setBounds(200, 270, 115, 25);
	 miPanel.add(btnAceptar);
	 /// btnAceptar.addActionListener(this);

	 // Boton Cancelar
	 btnCancelar = new JButton();
	 btnCancelar.setText("Cancelar");
	 btnCancelar.setBounds(322, 270, 115, 25);
	 miPanel.add(btnCancelar);
	 // btnCancelar.addActionListener(this);
    }
}

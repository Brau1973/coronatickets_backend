package presentacion;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ConsultarUsuario extends JInternalFrame{
     private JButton btnAceptar, btnCancelar;
     private JPanel miPanel;
     private JLabel lblTitulo;

     // Constructor
     public ConsultarUsuario(){
	   miPanel = new JPanel();
	   miPanel.setLayout(null);

	   add(miPanel);
	   setBounds(30, 30, 460, 500);
	   setResizable(false);
	   setClosable(false);
	   setIconifiable(false);
	   setBorder(null);
	   // setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	   ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).setNorthPane(null);
	   lblTitulo = new JLabel();
	   lblTitulo.setText("Registrar Usuario");
	   lblTitulo.setFont(new java.awt.Font("Comic Sans MS", 1, 20));
	   lblTitulo.setBounds(10, 1, 280, 25);
	   miPanel.add(lblTitulo);

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

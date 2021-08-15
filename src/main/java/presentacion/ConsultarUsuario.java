package presentacion;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ConsultarUsuario extends JInternalFrame{
     private JButton btnAceptar, btnCancelar;
     private JPanel miPanel;

     public ConsultarUsuario(){
	   miPanel = new JPanel();
	   miPanel.setLayout(null);
	   add(miPanel);
	   setBounds(30, 30, 400, 280);
	   setResizable(false);
	   setIconifiable(false);
	   setMaximizable(false);
	   setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	   // setClosable(false);
	   // setBorder(null);
	   // ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).setNorthPane(null);

	   // Boton Aceptar
	   btnAceptar = new JButton();
	   btnAceptar.setText("Aceptar");
	   btnAceptar.setBounds(30, 220, 100, 23);
	   miPanel.add(btnAceptar);
	   /// btnAceptar.addActionListener(this);

	   // Boton Cancelar
	   btnCancelar = new JButton();
	   btnCancelar.setText("Cancelar");
	   btnCancelar.setBounds(150, 220, 100, 23);
	   miPanel.add(btnCancelar);
	   // btnCancelar.addActionListener(this);
     }
}

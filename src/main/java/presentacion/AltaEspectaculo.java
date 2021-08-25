package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import interfaces.IControlador;

@SuppressWarnings("serial")
public class AltaEspectaculo extends JInternalFrame implements ActionListener{
    private IControlador icon;
    private JLabel lblTitulo, lblArtista, lblPlataforma, lblNombre, lblDescripcion, lblDuracion, lblCantEsp, lblCantMinEsp, lblCantMaxEsp, lblUrl, lblCosto, lblRegistro;
    private JTextField txtArtista, txtPlataforma, txtNombre, txtDescripcion, txtDuracion, txtUrl, txtCosto;
    private JSpinner spinMin, spinMax;
    private JPanel miPanel;
    private JDateChooser dateFechaNac;
    private JButton btnAceptar, btnCancelar;

    public AltaEspectaculo(IControlador icon){
	 this.icon = icon;
	 miPanel = new JPanel();
	 miPanel.setLayout(null);
	 add(miPanel);
	 setBounds(20, 20, 475, 485);
	 setResizable(false);
	 setClosable(true);
	 setIconifiable(false);
	 setBorder(null);
	 ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).setNorthPane(null);

	 lblTitulo = new JLabel();
	 lblArtista = new JLabel();
	 lblPlataforma = new JLabel();
	 lblNombre = new JLabel();
	 lblDescripcion = new JLabel();
	 lblDuracion = new JLabel();
	 lblCantEsp = new JLabel();
	 lblCantMinEsp = new JLabel();
	 lblCantMaxEsp = new JLabel();
	 lblUrl = new JLabel();
	 lblCosto = new JLabel();
	 lblRegistro = new JLabel();
	 lblTitulo.setText("Alta Espectaculo");
	 lblArtista.setText("Artista:");
	 lblPlataforma.setText("Plataforma:");
	 lblNombre.setText("Nombre:");
	 lblDescripcion.setText("Descripcion:");
	 lblDuracion.setText("Duracion:");
	 lblCantEsp.setText("Espectadores:");
	 lblCantMinEsp.setText("Minimo");
	 lblCantMaxEsp.setText("Maximo");
	 lblUrl.setText("URL:");
	 lblCosto.setText("Costo:");
	 lblRegistro.setText("Fecha de alta:");
	 lblTitulo.setFont(new java.awt.Font("Comic Sans MS", 1, 19));
	 lblArtista.setFont(new java.awt.Font("Verdana", 1, 12));
	 lblPlataforma.setFont(new java.awt.Font("Verdana", 1, 12));
	 lblNombre.setFont(new java.awt.Font("Verdana", 1, 12));
	 lblDescripcion.setFont(new java.awt.Font("Verdana", 1, 12));
	 lblDuracion.setFont(new java.awt.Font("Verdana", 1, 12));
	 lblCantEsp.setFont(new java.awt.Font("Verdana", 1, 12));
	 lblCantMinEsp.setFont(new java.awt.Font("Verdana", 1, 12));
	 lblCantMaxEsp.setFont(new java.awt.Font("Verdana", 1, 12));
	 lblUrl.setFont(new java.awt.Font("Verdana", 1, 12));
	 lblCosto.setFont(new java.awt.Font("Verdana", 1, 12));
	 lblRegistro.setFont(new java.awt.Font("Verdana", 1, 12));
	 lblTitulo.setBounds(10, 1, 350, 25);
	 lblArtista.setBounds(10, 50, 110, 25);
	 lblPlataforma.setBounds(10, 80, 110, 25);
	 lblNombre.setBounds(10, 110, 110, 25);
	 lblDescripcion.setBounds(10, 140, 110, 25);
	 lblDuracion.setBounds(10, 170, 150, 25);
	 lblCantEsp.setBounds(10, 200, 180, 25);
	 lblCantMinEsp.setBounds(155, 200, 110, 25);
	 lblCantMaxEsp.setBounds(292, 200, 110, 25);
	 lblUrl.setBounds(10, 230, 150, 25);
	 lblCosto.setBounds(10, 260, 150, 25);
	 lblRegistro.setBounds(10, 290, 150, 25);
	 miPanel.add(lblTitulo);
	 miPanel.add(lblArtista);
	 miPanel.add(lblPlataforma);
	 miPanel.add(lblNombre);
	 miPanel.add(lblDescripcion);
	 miPanel.add(lblDuracion);
	 miPanel.add(lblCantEsp);
	 miPanel.add(lblCantMinEsp);
	 miPanel.add(lblCantMaxEsp);
	 miPanel.add(lblUrl);
	 miPanel.add(lblCosto);
	 miPanel.add(lblRegistro);
	 txtArtista = new JTextField();
	 txtPlataforma = new JTextField();
	 txtNombre = new JTextField();
	 txtDescripcion = new JTextField();
	 txtDuracion = new JTextField();
	 spinMin = new JSpinner();
	 spinMax = new JSpinner();
	 txtUrl = new JTextField();
	 txtCosto = new JTextField();
	 dateFechaNac = new JDateChooser();
	 txtArtista.setBounds(155, 48, 260, 25);
	 txtPlataforma.setBounds(155, 78, 260, 25);
	 txtNombre.setBounds(155, 108, 260, 25);
	 txtDescripcion.setBounds(155, 138, 260, 25);
	 txtDuracion.setBounds(155, 168, 260, 25);
	 spinMin.setBounds(209, 196, 65, 25);
	 spinMax.setBounds(348, 196, 65, 25);
	 txtUrl.setBounds(155, 226, 260, 25);
	 txtCosto.setBounds(155, 256, 260, 25);
	 dateFechaNac.setBounds(155, 286, 260, 25);
	 miPanel.add(txtArtista);
	 miPanel.add(txtPlataforma);
	 miPanel.add(txtNombre);
	 miPanel.add(txtDescripcion);
	 miPanel.add(txtDuracion);
	 miPanel.add(spinMin);
	 miPanel.add(spinMax);
	 miPanel.add(txtUrl);
	 miPanel.add(txtCosto);
	 miPanel.add(dateFechaNac);

	 // Boton Aceptar
	 btnAceptar = new JButton();
	 btnAceptar.setText("Aceptar");
	 btnAceptar.setBounds(155, 325, 127, 25);
	 miPanel.add(btnAceptar);
	 btnAceptar.addActionListener(this);

	 // Boton Cancelar
	 btnCancelar = new JButton();
	 btnCancelar.setText("Cancelar");
	 btnCancelar.setBounds(286, 325, 127, 25);
	 miPanel.add(btnCancelar);
	 btnCancelar.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
	 String strartista = this.txtArtista.getText();
	 String strplataforma = this.txtPlataforma.getText();
	 String strnombre = this.txtNombre.getText();
	 String strdescripcion = this.txtDescripcion.getText();
	 String strduracion = this.txtDuracion.getText();
	 int duracion = Integer.parseInt(strduracion);
	 if(e.getSource() == btnAceptar){
	     if(checkFormulario()){
		  try{
		      this.icon.altaEspectaculo(strartista, strplataforma, strnombre, strdescripcion, duracion, 3, 4, "a", 2);
		      JOptionPane.showMessageDialog(this, "El Espectaculo  se ha creado con exito", "Agregar Espectaculo", JOptionPane.INFORMATION_MESSAGE);
		  }catch(Exception ex){
		      JOptionPane.showMessageDialog(this, ex.getMessage(), "Agregar Espectaculo", JOptionPane.ERROR_MESSAGE);
		  }
		  setVisible(false);
	     }

	 }
	 if(e.getSource() == btnCancelar){
	     System.out.println("Cancelar");
	 }
    }

    private boolean checkFormulario(){
	 String strid = this.txtNombre.getText();
	 if(strid.isEmpty()){
	     JOptionPane.showMessageDialog(this, "No puede haber campos vacios", "Agregar Espectaculo", JOptionPane.ERROR_MESSAGE);
	     return false;
	 }
	 return true;
    }
}

package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import datatypes.DtEspectaculo;
import interfaces.IControlador;

@SuppressWarnings("serial")
public class AltaEspectaculo extends JInternalFrame implements ActionListener{ // 79S
    private IControlador icon;
    private JPanel miPanel;
    private JTextField txtArtista, txtPlataforma, txtNombre, txtDescripcion, txtDuracion, txtUrl, txtCosto;
    private JSpinner spinMin, spinMax;
    private JDateChooser dateFechaNac;
    private JButton btnAceptar, btnCancelar;

    public AltaEspectaculo(IControlador icon){
	 this.icon = icon;
	 miPanel = new JPanel();
	 miPanel.setLayout(null);
	 add(miPanel);
	 setBounds(15, 15, 475, 485);
	 setResizable(false);
	 setClosable(true);
	 setIconifiable(false);
	 setBorder(null);
	 ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).setNorthPane(null);

	 // JLabel
	 JLabel lblTitulo = new JLabel("Alta Espectaculo");
	 lblTitulo.setFont(new java.awt.Font("Comic Sans MS", 1, 19));
	 lblTitulo.setBounds(10, 1, 350, 25);
	 miPanel.add(lblTitulo);

	 JLabel lblArtista = new JLabel("Artista:");
	 lblArtista.setFont(new java.awt.Font("Verdana", 1, 12));
	 lblArtista.setBounds(10, 50, 110, 25);
	 miPanel.add(lblArtista);

	 JLabel lblPlataforma = new JLabel("Plataforma:");
	 lblPlataforma.setFont(new java.awt.Font("Verdana", 1, 12));
	 lblPlataforma.setBounds(10, 80, 110, 25);
	 miPanel.add(lblPlataforma);

	 JLabel lblNombre = new JLabel("Nombre:");
	 lblNombre.setFont(new java.awt.Font("Verdana", 1, 12));
	 lblNombre.setBounds(10, 110, 110, 25);
	 miPanel.add(lblNombre);

	 JLabel lblDescripcion = new JLabel("Descripción:");
	 lblDescripcion.setFont(new java.awt.Font("Verdana", 1, 12));
	 lblDescripcion.setBounds(10, 140, 110, 25);
	 miPanel.add(lblDescripcion);

	 JLabel lblDuracion = new JLabel("Duración:");
	 lblDuracion.setFont(new java.awt.Font("Verdana", 1, 12));
	 lblDuracion.setBounds(10, 170, 150, 25);
	 miPanel.add(lblDuracion);

	 JLabel lblCantEsp = new JLabel("Espectadores:");
	 lblCantEsp.setFont(new java.awt.Font("Verdana", 1, 12));
	 lblCantEsp.setBounds(10, 200, 180, 25);
	 miPanel.add(lblCantEsp);

	 JLabel lblCantMinEsp = new JLabel("Minimo:");
	 lblCantMinEsp.setFont(new java.awt.Font("Verdana", 1, 12));
	 lblCantMinEsp.setBounds(155, 200, 110, 25);
	 miPanel.add(lblCantMinEsp);

	 JLabel lblCantMaxEsp = new JLabel("Maximo:");
	 lblCantMaxEsp.setFont(new java.awt.Font("Verdana", 1, 12));
	 lblCantMaxEsp.setBounds(292, 200, 110, 25);
	 miPanel.add(lblCantMaxEsp);

	 JLabel lblUrl = new JLabel("URL:");
	 lblUrl.setFont(new java.awt.Font("Verdana", 1, 12));
	 lblUrl.setBounds(10, 230, 150, 25);
	 miPanel.add(lblUrl);

	 JLabel lblCosto = new JLabel("Costo:");
	 lblCosto.setFont(new java.awt.Font("Verdana", 1, 12));
	 lblCosto.setBounds(10, 260, 150, 25);
	 miPanel.add(lblCosto);

	 JLabel lblRegistro = new JLabel("Fecha de alta:");
	 lblRegistro.setFont(new java.awt.Font("Verdana", 1, 12));
	 lblRegistro.setBounds(10, 290, 150, 25);
	 miPanel.add(lblRegistro);

	 // JTextField
	 txtArtista = new JTextField();
	 txtArtista.setBounds(155, 48, 260, 25);
	 miPanel.add(txtArtista);

	 txtPlataforma = new JTextField();
	 txtPlataforma.setBounds(155, 78, 260, 25);
	 miPanel.add(txtPlataforma);

	 txtNombre = new JTextField();
	 txtNombre.setBounds(155, 108, 260, 25);
	 miPanel.add(txtNombre);

	 txtDescripcion = new JTextField();
	 txtDescripcion.setBounds(155, 138, 260, 25);
	 miPanel.add(txtDescripcion);

	 txtDuracion = new JTextField();
	 txtDuracion.setBounds(155, 168, 260, 25);
	 miPanel.add(txtDuracion);

	 spinMin = new JSpinner();
	 spinMin.setBounds(209, 196, 65, 25);
	 miPanel.add(spinMin);

	 spinMax = new JSpinner();
	 spinMax.setBounds(348, 196, 65, 25);
	 miPanel.add(spinMax);

	 txtUrl = new JTextField();
	 txtUrl.setBounds(155, 226, 260, 25);
	 miPanel.add(txtUrl);

	 txtCosto = new JTextField();
	 txtCosto.setBounds(155, 256, 260, 25);
	 miPanel.add(txtCosto);

	 dateFechaNac = new JDateChooser();
	 dateFechaNac.setBounds(155, 286, 260, 25);
	 miPanel.add(dateFechaNac);

	 // JButton
	 btnAceptar = new JButton("Aceptar");
	 btnAceptar.setBounds(155, 325, 127, 25);
	 miPanel.add(btnAceptar);
	 btnAceptar.addActionListener(this);

	 btnCancelar = new JButton("Cancelar");
	 btnCancelar.setBounds(286, 325, 127, 25);
	 miPanel.add(btnCancelar);
	 btnCancelar.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
	 String strartista = this.txtArtista.getText();
	 String strplataforma = this.txtPlataforma.getText();
	 String strnombre = this.txtNombre.getText();
	 String strdescripcion = this.txtDescripcion.getText();
	 int duracion = Integer.parseInt(this.txtDuracion.getText());
	 int cantMin = (Integer) spinMin.getValue();
	 int cantMax = (Integer) spinMax.getValue();
	 String strurl = this.txtUrl.getText();
	 int costo = Integer.parseInt(this.txtCosto.getText());
	 Date dateRegistro = this.dateFechaNac.getDate();
	 if(e.getSource() == btnAceptar){
	     if(checkFormulario()){
		  try{
		      DtEspectaculo dte = new DtEspectaculo(strartista, strplataforma, strnombre, strdescripcion, duracion, cantMin, cantMax, strurl, costo, dateRegistro);
		      this.icon.altaEspectaculo(dte);
		      JOptionPane.showMessageDialog(this, "El Espectaculo se ha creado con exito", "Agregar Espectaculo", JOptionPane.INFORMATION_MESSAGE);
		      limpiarFormulario();
		  }catch(Exception ex){
		      JOptionPane.showMessageDialog(this, ex.getMessage(), "Agregar Espectaculo", JOptionPane.ERROR_MESSAGE);
		  }
		  setVisible(false);
	     }
	 }

	 if(e.getSource() == btnCancelar){
	     limpiarFormulario();
	     setVisible(false);
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

    private void limpiarFormulario(){
	 txtArtista.setText("");
	 txtPlataforma.setText("");
	 txtNombre.setText("");
	 txtDescripcion.setText("");
	 txtDuracion.setText("");
	 spinMin.setValue(0);
	 spinMax.setValue(0);
	 txtUrl.setText("");
	 txtCosto.setText("");
	 dateFechaNac.setDate(null);
    }

}

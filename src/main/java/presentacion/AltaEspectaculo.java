package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import datatypes.DtEspectaculo;
import interfaces.IControladorEspectaculo;
import manejadores.ManejadorEspectaculo;

@SuppressWarnings("serial")
public class AltaEspectaculo extends JInternalFrame implements ActionListener{ // 79S
    private IControladorEspectaculo iconE;
    private JPanel miPanel;
    private JTextField txtArtista, txtNombre, txtDescripcion, txtDuracion, txtUrl, txtCosto;
    private JSpinner spinMin, spinMax;
    private JDateChooser dateFechaNac;
    private JButton btnAceptar, btnCancelar;
    private JComboBox<String> comboPlataforma;

    public AltaEspectaculo(IControladorEspectaculo iconE){
	 this.iconE = iconE;
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

	 JLabel lblPlataforma = new JLabel("Plataforma:");
	 lblPlataforma.setFont(new java.awt.Font("Verdana", 1, 12));
	 lblPlataforma.setBounds(10, 50, 110, 25);
	 miPanel.add(lblPlataforma);

	 JLabel lblArtista = new JLabel("Artista:");
	 lblArtista.setFont(new java.awt.Font("Verdana", 1, 12));
	 lblArtista.setBounds(10, 80, 110, 25);
	 miPanel.add(lblArtista);

	 JLabel lblNombre = new JLabel("Nombre:");
	 lblNombre.setFont(new java.awt.Font("Verdana", 1, 12));
	 lblNombre.setBounds(10, 110, 110, 25);
	 miPanel.add(lblNombre);

	 JLabel lblDescripcion = new JLabel("Descripcion:");
	 lblDescripcion.setFont(new java.awt.Font("Verdana", 1, 12));
	 lblDescripcion.setBounds(10, 140, 110, 25);
	 miPanel.add(lblDescripcion);

	 JLabel lblDuracion = new JLabel("Duracion:");
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
	 comboPlataforma = new JComboBox<String>();
	 comboPlataforma.setBounds(155, 48, 260, 25);
	 miPanel.add(comboPlataforma);

	 txtArtista = new JTextField();
	 txtArtista.setBounds(155, 78, 260, 25);
	 miPanel.add(txtArtista);

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

    public void iniciarlizarComboBox(){
	 DefaultComboBoxModel<String> modelPlataformas = new DefaultComboBoxModel<String>(iconE.listarPlataformas());
	 comboPlataforma.setModel(modelPlataformas);
    }

    public void actionPerformed(ActionEvent e){
	 String strartista = this.txtArtista.getText();
	 String strplataforma = (String) this.comboPlataforma.getSelectedItem();
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
		      this.iconE.altaEspectaculo(dte);
		      JOptionPane.showMessageDialog(null, "El espectaculo se ha creado con exito", "Agregar Espectaculo", JOptionPane.INFORMATION_MESSAGE);
		      limpiarFormulario();
		  }catch(Exception ex){
		      JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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
	 if(!txtNombre.getText().isEmpty() && !txtArtista.getText().isEmpty() && !txtDescripcion.getText().isEmpty() && !txtDuracion.getText().isEmpty() && !txtUrl.getText().isEmpty() && dateFechaNac.getDate() != null && !txtCosto.getText().isEmpty()){
	     ManejadorEspectaculo mE = ManejadorEspectaculo.getInstancia();
	     if(mE.buscarEspectaculo(txtNombre.getText()) != null){
		  int respuesta = JOptionPane.showConfirmDialog(null, "El nombre ingresado ya existe \n¿Desea modificar los datos?", "Advertencia", JOptionPane.YES_NO_OPTION);
		  if(respuesta != JOptionPane.YES_NO_OPTION){
		      limpiarFormulario();
		      setVisible(false);
		  }
		  return false;
	     }
	 }else{
	     JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
	     return false;
	 }
	 return true;
    }

    private void limpiarFormulario(){
	 txtArtista.setText("");
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
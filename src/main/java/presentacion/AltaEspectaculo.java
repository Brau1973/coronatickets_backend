package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class AltaEspectaculo extends JInternalFrame implements ActionListener{
    private JLabel lblTitulo, lblArtista, lblPlataforma, lblNombre, lblDescripcion, lblDuracion, lblCantEsp, lblCantMinEsp, lblCantMaxEsp, lblUrl, lblCosto, lblRegistro;
    private JTextField txtArtista, txtPlataforma, txtNombre, txtDescripcion, txtDuracion, txtUrl, txtCosto;
    private JSpinner spinDia, spinMes, spinAnio, spinMin, spinMax;
    private JPanel miPanel;
    private JButton btnAceptar, btnCancelar;

    public AltaEspectaculo(){
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
	 lblTitulo.setText("Registrar Espectaculo");
	 lblArtista.setText("Artista:");
	 lblPlataforma.setText("Plataforma:");
	 lblNombre.setText("Nombre:");
	 lblDescripcion.setText("Descripcion:");
	 lblDuracion.setText("Duracion:");
	 lblCantEsp.setText("Cant. espectadores:");
	 lblCantMinEsp.setText("Minimo");
	 lblCantMaxEsp.setText("Maximo");
	 lblUrl.setText("URL:");
	 lblCosto.setText("Costo:");
	 lblRegistro.setText("Fecha de alta:");
	 lblTitulo.setFont(new java.awt.Font("Comic Sans MS", 1, 20));
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
	 lblPlataforma.setBounds(10, 90, 110, 25);
	 lblNombre.setBounds(10, 130, 110, 25);
	 lblDescripcion.setBounds(10, 170, 110, 25);
	 lblDuracion.setBounds(10, 210, 150, 25);
	 lblCantEsp.setBounds(10, 250, 180, 25);
	 lblCantMinEsp.setBounds(183, 250, 110, 25);
	 lblCantMaxEsp.setBounds(320, 250, 110, 25);
	 lblUrl.setBounds(10, 290, 150, 25);
	 lblCosto.setBounds(10, 330, 150, 25);
	 lblRegistro.setBounds(10, 370, 150, 25);
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
	 spinDia = new JSpinner();
	 spinMes = new JSpinner();
	 spinAnio = new JSpinner();
	 txtArtista.setBounds(183, 48, 260, 25);
	 txtPlataforma.setBounds(183, 88, 260, 25);
	 txtNombre.setBounds(183, 128, 260, 25);
	 txtDescripcion.setBounds(183, 168, 260, 25);
	 txtDuracion.setBounds(183, 208, 260, 25);
	 spinMin.setBounds(237, 246, 65, 25);
	 spinMax.setBounds(376, 246, 65, 25);
	 txtUrl.setBounds(183, 286, 260, 25);
	 txtCosto.setBounds(183, 326, 260, 25);
	 spinDia.setBounds(183, 366, 45, 25);
	 spinMes.setBounds(243, 366, 45, 25);
	 spinAnio.setBounds(303, 366, 45, 25);
	 miPanel.add(txtArtista);
	 miPanel.add(txtPlataforma);
	 miPanel.add(txtNombre);
	 miPanel.add(txtDescripcion);
	 miPanel.add(txtDuracion);
	 miPanel.add(spinMin);
	 miPanel.add(spinMax);
	 miPanel.add(txtUrl);
	 miPanel.add(txtCosto);
	 miPanel.add(spinDia);
	 miPanel.add(spinMes);
	 miPanel.add(spinAnio);

	 // Boton Aceptar
	 btnAceptar = new JButton();
	 btnAceptar.setText("Aceptar");
	 btnAceptar.setBounds(200, 418, 115, 25);
	 miPanel.add(btnAceptar);
	 btnAceptar.addActionListener(this);

	 // Boton Cancelar
	 btnCancelar = new JButton();
	 btnCancelar.setText("Cancelar");
	 btnCancelar.setBounds(322, 418, 115, 25);
	 miPanel.add(btnCancelar);
	 btnCancelar.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
	 if(e.getSource() == btnAceptar){

	 }
	 if(e.getSource() == btnCancelar){
	     System.out.println("Cancelar");
	 }
    }

}

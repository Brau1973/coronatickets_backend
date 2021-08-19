package presentacion;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ConsultaFuncion extends JInternalFrame{
    private JButton btnAceptar, btnCancelar;
    private JPanel miPanel;
    private JLabel lblPlataforma, lblEspectaculos, lblFunciones, lblNombre, lblFecha, lblHora, lblArtistasInv, lblFechaAlta;
    private JComboBox<String> comboEspectaculos, comboPlataforma, comboFunciones;

    // Constructor
    public ConsultaFuncion(){
	 miPanel = new JPanel();
	 miPanel.setLayout(null);
	 add(miPanel);
	 setBounds(30, 30, 800, 600);
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

	 lblPlataforma = new JLabel();
	 lblPlataforma.setText("Plataforma");
	 lblPlataforma.setBounds(10, 0, 200, 20);
	 miPanel.add(lblPlataforma);

	 comboPlataforma = new JComboBox<String>();
	 comboPlataforma.setBounds(220, 0, 200, 20);
	 miPanel.add(comboPlataforma);

	 lblEspectaculos = new JLabel();
	 lblEspectaculos.setText("Espectaculos");
	 lblEspectaculos.setBounds(10, 30, 200, 20);
	 miPanel.add(lblEspectaculos);

	 comboEspectaculos = new JComboBox<String>();
	 comboEspectaculos.setBounds(220, 30, 200, 20);
	 miPanel.add(comboEspectaculos);

	 lblFunciones = new JLabel();
	 lblFunciones.setText("Funciones");
	 lblFunciones.setBounds(10, 60, 200, 20);
	 miPanel.add(lblFunciones);

	 comboFunciones = new JComboBox<String>();
	 comboFunciones.setBounds(220, 60, 200, 20);
	 miPanel.add(comboFunciones);

	 lblPlataforma = new JLabel();
	 lblPlataforma.setText("Datos De La Funcion");
	 lblPlataforma.setBounds(10, 90, 250, 20);
	 miPanel.add(lblPlataforma);

	 lblNombre = new JLabel();
	 lblNombre.setText("Nombre");
	 lblNombre.setBounds(10, 120, 200, 20);
	 miPanel.add(lblNombre);

	 lblFecha = new JLabel();
	 lblFecha.setText("Fecha de la Funcion");
	 lblFecha.setBounds(10, 150, 200, 20);
	 miPanel.add(lblFecha);

	 lblHora = new JLabel();
	 lblHora.setText("Hora de Inicio");
	 lblHora.setBounds(10, 180, 100, 20);
	 miPanel.add(lblHora);

	 lblArtistasInv = new JLabel();
	 lblArtistasInv.setText("Artistas Invitados");
	 lblArtistasInv.setBounds(10, 210, 200, 20);
	 miPanel.add(lblArtistasInv);

	 lblFechaAlta = new JLabel();
	 lblFechaAlta.setText("Fecha de Alta");
	 lblFechaAlta.setBounds(10, 240, 200, 20);
	 miPanel.add(lblFechaAlta);

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

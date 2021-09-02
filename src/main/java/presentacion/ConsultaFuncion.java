package presentacion;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import interfaces.IControladorFuncion;
import logica.Espectaculo;
import logica.Plataforma;
import manejadores.ManejadorFuncion;

@SuppressWarnings("serial")
public class ConsultaFuncion extends JInternalFrame implements ActionListener{
    private IControladorFuncion iconF;
    private JButton btnAceptar, btnCancelar;
    private JPanel miPanel;
    private JLabel lblTitulo, lblPlataforma, lblEspectaculos, lblFunciones, lblNombre, lblFecha, lblHora, lblArtistasInv, lblFechaAlta;
    private JComboBox<String> comboEspectaculos, comboPlataforma, comboFunciones;
    private JTable tabFuncion;
    private String[] header = {"Plataforma", "Espectaculo"};
    private String[][] data = {{"1", "las aventuras de seba"}, {"2", "seba por el tiempo"}, {"3", "sebalandia"}, {"4", "la cocina de seba"}};
    private List<Plataforma> listPlataformas;

    // Constructor
    public ConsultaFuncion(IControladorFuncion iconF){
	 this.iconF = iconF;
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

	 lblTitulo = new JLabel();
	 lblTitulo.setText("Consulta de Funcion de Espectaculo");
	 lblTitulo.setBounds(10, 0, 400, 20);
	 lblTitulo.setFont(new java.awt.Font("Comic Sans MS", 1, 17));
	 miPanel.add(lblTitulo);

	 lblPlataforma = new JLabel();
	 lblPlataforma.setText("Plataforma");
	 lblPlataforma.setBounds(10, 30, 200, 20);
	 miPanel.add(lblPlataforma);

	 comboPlataforma = new JComboBox<String>();
	 comboPlataforma.addItem("Seleccione Plataforma");
	 comboPlataforma.setBounds(220, 30, 200, 20);
	 miPanel.add(comboPlataforma);
	 comboPlataforma.addActionListener(this);

	 lblEspectaculos = new JLabel();
	 lblEspectaculos.setText("Espectaculos");
	 lblEspectaculos.setBounds(10, 60, 200, 20);
	 miPanel.add(lblEspectaculos);


	 comboEspectaculos = new JComboBox<String>();
	 comboEspectaculos.addItem("Seleccione Espectaculo");
	 comboEspectaculos.setBounds(220, 60, 200, 20);
	 miPanel.add(comboEspectaculos);


	 lblFunciones = new JLabel();
	 lblFunciones.setText("Funciones");
	 lblFunciones.setBounds(10, 90, 200, 20);
	 miPanel.add(lblFunciones);

	 comboFunciones = new JComboBox<String>();
	 comboFunciones.addItem("Seleccione Funcion");
	 comboFunciones.setBounds(220, 90, 200, 20);
	 miPanel.add(comboFunciones);

	 lblPlataforma = new JLabel();
	 lblPlataforma.setText("Datos De La Funcion");
	 lblPlataforma.setBounds(10, 120, 250, 20);
	 miPanel.add(lblPlataforma);

	 DefaultTableModel model = new DefaultTableModel(data, header);
	 tabFuncion = new JTable(model);
	 tabFuncion.setPreferredScrollableViewportSize(new Dimension(40, 290));
	 JScrollPane jsPane = new JScrollPane(tabFuncion);
	 jsPane.setBounds(10, 150, 365, 118);
	 jsPane.setVisible(true);
	 miPanel.add(jsPane, BorderLayout.SOUTH);

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

    @Override
    public void actionPerformed(ActionEvent e){
	 if(e.getSource() == comboPlataforma){
	     String strPlataforma = this.comboPlataforma.getSelectedItem().toString();
	     ManejadorFuncion mF = ManejadorFuncion.getInstancia();
	     // ArrayList<String> datos = mF.obtenerEspectaculo(plataforma);
	     Plataforma plataforma = listPlataformas.stream().filter(p -> (p.getNombre() == strPlataforma)).findFirst().get();
	     List<Espectaculo> listEspectaculos = plataforma.getEspectaculo();

	     if(listEspectaculos.isEmpty()){
		  JOptionPane.showMessageDialog(this, "Esta plataforma no tiene espectaculos asociados.", "Agregar Espectaculo", JOptionPane.WARNING_MESSAGE);
		  comboEspectaculos.getModel().setSelectedItem("Seleccione Espectaculo");
	     }else
		  listEspectaculos.forEach((esp) -> {
		      comboEspectaculos.addItem(esp.getNombre());
		  });
	     // comboEspectaculos.getModel().setSelectedItem(mF.obtenerEspectaculo(plataforma));
	 }

	 // Cargar combo Funcion respecto al espectaculo
	 /*if(e.getSource() == comboEspectaculos) {
	 	 String espectaculo = this.comboEspectaculos.getSelectedItem().toString();
	 	 ManejadorFuncion mF = ManejadorFuncion.getInstancia();
	      comboFuncion.getModel().setSelectedItem(mF.obtenerFuncion(espectaculo));
	     }*/
    }

}

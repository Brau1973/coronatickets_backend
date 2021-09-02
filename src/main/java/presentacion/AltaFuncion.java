package presentacion;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import org.hibernate.internal.build.AllowSysOut;

import com.toedter.calendar.JDateChooser;

import excepciones.FuncionRepetidaExcepcion;
import interfaces.Fabrica;
import interfaces.IControladorEspectaculo;
import interfaces.IControladorFuncion;
import interfaces.IControladorPlataforma;
import interfaces.IControladorUsuario;
import logica.Artista;
import logica.Espectaculo;
import logica.Funcion;
import logica.Plataforma;

@SuppressWarnings("serial")
public class AltaFuncion extends JInternalFrame implements ActionListener{
    private IControladorFuncion iconF;
    private IControladorPlataforma iconP;
    private IControladorUsuario iconU;
    private IControladorEspectaculo iconE;
    private JButton btnAceptar, btnCancelar, btnCopiar;
    private JPanel miPanel;
    private JLabel lblPlataforma, lblEspectaculos, lblNombre, lblFecha, lblHora, lblArtistasInv, lblFechaAlta, lblDots, lblTitulo;
    private JTextField txtNombre;
    private JSpinner spinHora, spinMin;
    private JDateChooser fechaFuncion, fechaAlta;
    private JComboBox<String> comboArtista, comboEspectaculos, comboPlataforma;
    private JList listaArtistas, listaArtistasSeleccionados;
    private String nombresArtistas[] = {"1", "2", "3", "4", "1", "2", "3", "4", "1", "2", "3", "4"};
    private DefaultListModel modelo;
    private JScrollPane scrollPane;
    @SuppressWarnings("rawtypes")
    private JList listNombres;
    private List<Plataforma> listPlataformas;
    private List<Espectaculo> listEspectaculos;
    private List<Artista> listArtistas;
    private List<Artista> listArtistasSeleccionados;
    private List<Artista> listArtistasR;

    // Constructor
    public AltaFuncion(IControladorFuncion iconF){
	 iconU = Fabrica.getInstancia().getIControladorUsuario();
	 iconP = Fabrica.getInstancia().getIControladorPlataforma();
	 iconE = Fabrica.getInstancia().getIControladorEspectaculo();
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

	 lblTitulo = new JLabel();
	 lblTitulo.setText("Alta de Funcion de Espectaculo");
	 lblTitulo.setBounds(10, 0, 300, 20);
	 lblTitulo.setFont(new java.awt.Font("Comic Sans MS", 1, 17));
	 miPanel.add(lblTitulo);

	 lblPlataforma = new JLabel("Plataforma");
	 lblPlataforma.setBounds(10, 30, 200, 20);
	 miPanel.add(lblPlataforma);

	 comboPlataforma = new JComboBox<String>();
	 comboPlataforma.setBounds(220, 30, 200, 25);
	 miPanel.add(comboPlataforma);
	 comboPlataforma.addActionListener(this);

	 lblEspectaculos = new JLabel("Espectaculos");
	 lblEspectaculos.setBounds(10, 60, 200, 20);
	 miPanel.add(lblEspectaculos);

	 comboEspectaculos = new JComboBox<String>();
	 comboEspectaculos.setBounds(220, 60, 200, 25);
	 miPanel.add(comboEspectaculos);

	 lblPlataforma = new JLabel("Datos De La Funcion");
	 lblPlataforma.setBounds(10, 90, 250, 25);
	 miPanel.add(lblPlataforma);

	 lblNombre = new JLabel("Nombre");
	 lblNombre.setBounds(10, 120, 200, 20);
	 miPanel.add(lblNombre);

	 txtNombre = new JTextField();
	 txtNombre.setBounds(220, 120, 200, 20);
	 miPanel.add(txtNombre);

	 lblFecha = new JLabel("Fecha de la Funcion");
	 lblFecha.setBounds(10, 150, 200, 20);
	 miPanel.add(lblFecha);

	 fechaFuncion = new JDateChooser();
	 fechaFuncion.setBounds(220, 150, 200, 20);
	 miPanel.add(fechaFuncion);

	 lblHora = new JLabel("Hora de Inicio");
	 lblHora.setBounds(10, 180, 100, 20);
	 miPanel.add(lblHora);

	 spinHora = new JSpinner();
	 spinHora.setBounds(220, 180, 45, 20);
	 miPanel.add(spinHora);

	 lblDots = new JLabel();
	 lblDots.setText(":");
	 lblDots.setBounds(275, 180, 20, 20);
	 miPanel.add(lblDots);

	 spinMin = new JSpinner();
	 spinMin.setBounds(295, 180, 45, 20);
	 miPanel.add(spinMin);

	 lblArtistasInv = new JLabel("Artistas invitados");
	 lblArtistasInv.setBounds(10, 210, 150, 20);
	 miPanel.add(lblArtistasInv);

	 btnCopiar = new JButton(">>>");
	 btnCopiar.setBounds(220, 250, 70, 30);
	 btnCopiar.addActionListener(new ActionListener(){
	     public void actionPerformed(ActionEvent evento){
		  agregarNombre();
	     }
	 });
	 miPanel.add(btnCopiar);

	 listNombres = new JList();
	 listNombres.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
	 modelo = new DefaultListModel();
	 scrollPane = new JScrollPane();
	 scrollPane.setBounds(300, 250, 120, 60);
	 scrollPane.setViewportView(listNombres);
	 miPanel.add(scrollPane);

	 comboArtista = new JComboBox<String>();
	 comboArtista.setBounds(220, 210, 200, 25);
	 miPanel.add(comboArtista);

	 lblFechaAlta = new JLabel("Fecha de Alta");
	 lblFechaAlta.setBounds(10, 330, 200, 20);
	 miPanel.add(lblFechaAlta);

	 fechaAlta = new JDateChooser();
	 fechaAlta.setBounds(220, 330, 200, 20);
	 miPanel.add(fechaAlta);

	 // Boton Aceptar
	 btnAceptar = new JButton();
	 btnAceptar.setText("Aceptar");
	 btnAceptar.setBounds(200, 400, 115, 25);
	 miPanel.add(btnAceptar);
	 btnAceptar.addActionListener(this);

	 // Boton Cancelar
	 btnCancelar = new JButton();
	 btnCancelar.setText("Cancelar");
	 btnCancelar.setBounds(322, 400, 115, 25);
	 miPanel.add(btnCancelar);
	 btnCancelar.addActionListener(this);
    }

    @SuppressWarnings("unchecked")
    private void agregarNombre(){
	 String nombre = this.comboArtista.getSelectedItem().toString();
	 modelo.addElement(nombre);
	 listNombres.setModel(modelo);
	 comboArtista.removeItem(this.comboArtista.getSelectedItem());
	 // listArtistasR = iconU.listarArtistas(); ///ver

	 listArtistasR = new ArrayList<Artista>();
	 listArtistasR.add(iconU.obtenerArtista(nombre));
    }

    // Inicializar ComboBox
    public void iniciarlizarComboBox(){
	 comboPlataforma.removeAllItems();
	 comboArtista.removeAllItems();

	 listPlataformas = iconP.listarPlataformas();
	 listPlataformas.forEach((p) -> {
	     comboPlataforma.addItem(p.getNombre());
	 });

	 listArtistas = iconU.listarArtistas();
	 listArtistas.forEach((a) -> {
	     comboArtista.addItem(a.getNickname());
	 });

	 modelo.clear();
    }

    @SuppressWarnings("deprecation")
    @Override
    public void actionPerformed(ActionEvent e){
	 if(e.getSource() == comboPlataforma){
	     String strPlataforma = this.comboPlataforma.getSelectedItem().toString();
	     Plataforma plataforma = listPlataformas.stream().filter(p -> (p.getNombre() == strPlataforma)).findFirst().get();
	     listEspectaculos = plataforma.getEspectaculo();
	     if(listEspectaculos.isEmpty()){
		  comboEspectaculos.removeAllItems();
	     }else{
		  comboEspectaculos.removeAllItems();
		  listEspectaculos.forEach((esp) -> {
		      comboEspectaculos.addItem(esp.getNombre());
		  });
	     }
	 }

	 if(e.getSource() == btnAceptar){
	     if(checkFormulario()){
		  String nombreFuncion = this.txtNombre.getText();
		  Date FechaFuncion = this.fechaFuncion.getDate();
		  int hora = Integer.parseInt(this.spinHora.getValue().toString());
		  int minutos = Integer.parseInt(this.spinMin.getValue().toString());
		  Time horaInicio = new Time(hora, minutos, 0);
		  Date fechaRegistro = this.fechaAlta.getDate();
		  String strespectaculo = (String) this.comboEspectaculos.getSelectedItem();
		  Espectaculo esp = listEspectaculos.stream().filter(p -> (p.getNombre() == strespectaculo)).findFirst().get();
		  Funcion fe = new Funcion(nombreFuncion, FechaFuncion, horaInicio, fechaRegistro, esp, listArtistasR);
		  try{
		      this.iconF.altaFuncion(fe);
		      JOptionPane.showMessageDialog(this, "la funcion se ha creado con Exito");
		  }catch(FuncionRepetidaExcepcion msg){
		      // JOptionPane.showMessageDialog(this, msg.getMessage(), "Alta Plataforma", JOptionPane.ERROR_MESSAGE);
		  }
		  // limpiarFormulario();
		  setVisible(false);
	     }
	 }

	 if(e.getSource() == btnCancelar){
	     // limpiarFormulario();
	     setVisible(false);
	 }
    }


    private boolean checkFormulario(){
	 /*	 if(!txtNombre.getText().isEmpty() && fechaFuncion.getDate() != null && fechaAlta.getDate() != null){
	 }else{
	     JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
	     return false;
	 }*/
	 return true;
    }

    private void limpiarFormulario(){
	 this.txtNombre.setText("");
	 this.fechaFuncion.setDate(null);
	 this.spinHora.setValue(0);
	 this.spinMin.setValue(0);
	 this.fechaAlta.setDate(null);
    }

}
// if(e.getSource() == comboPlataforma){
// acac String strPlataforma = this.comboPlataforma.getSelectedItem().toString();
// Plataforma plataforma = listPlataformas.stream().filter(p -> (p.getNombre() == strPlataforma)).findFirst().get();
//
// List<Espectaculo> listEspectaculos = plataforma.getEspectaculo();
// if(listEspectaculos.isEmpty()){
// comboPlataforma.getModel().setSelectedItem("Seleccione Plataforma");
// comboEspectaculos.getModel().setSelectedItem("Seleccione Espectaculo");
// JOptionPane.showMessageDialog(this, "Esta plataforma no tiene espectaculos asociados.", "Agregar Espectaculo", JOptionPane.WARNING_MESSAGE);
// }else
// comboEspectaculos.removeAllItems();
//
// listEspectaculos.forEach((esp) -> {
// comboEspectaculos.addItem(esp.getNombre());
// });

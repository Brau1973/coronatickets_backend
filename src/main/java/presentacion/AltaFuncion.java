package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
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

import com.toedter.calendar.JDateChooser;

import excepciones.FuncionRepetidaExcepcion;
import interfaces.Fabrica;
import interfaces.IControladorFuncion;
import interfaces.IControladorPlataforma;
import interfaces.IControladorUsuario;
import logica.Artista;
import logica.Espectaculo;
import logica.Plataforma;

@SuppressWarnings("serial")
public class AltaFuncion extends JInternalFrame implements ActionListener{

    private IControladorFuncion iconFun;
    private IControladorPlataforma iconP;
    private IControladorUsuario iconU;
    private JButton btnAceptar, btnCancelar, btnCopiar;
    private JPanel miPanel;
    private JLabel lblPlataforma, lblEspectaculos, lblNombre, lblFecha, lblHora, lblArtistasInv, lblFechaAlta, lblDots, lblTitulo;
    private JTextField txtNombre;
    private JSpinner spinHora, spinMin;
    private JDateChooser fechaFuncion, fechaAlta;
    private JComboBox<String> comboArtista, comboEspectaculos, comboPlataforma;
    private JList listaArtistas, listaArtistasSeleccionados;
    private JScrollPane scrollPaneListaArtistas, scrollPaneListaArtistasSeleccionados;
    private String nombresArtistas[] = {"1", "2", "3", "4", "1", "2", "3", "4", "1", "2", "3", "4"};
    private List<Plataforma> listPlataformas;
    private DefaultListModel modelo; // Declaramos el Modelo.
    private JScrollPane scrollPane;
    @SuppressWarnings("rawtypes")
    private JList listNombres; // Declaramos La Lista.
    private List<Artista> listArtistas;
    // Constructor

    public AltaFuncion(IControladorFuncion iconFun){
	 iconU = Fabrica.getInstancia().getIControladorUsuario();
	 this.iconFun = iconFun;
	 iconP = Fabrica.getInstancia().getIControladorPlataforma();

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

	 lblPlataforma = new JLabel();
	 lblPlataforma.setText("Datos De La Funcion");
	 lblPlataforma.setBounds(10, 90, 250, 20);
	 miPanel.add(lblPlataforma);

	 lblNombre = new JLabel();
	 lblNombre.setText("Nombre");
	 lblNombre.setBounds(10, 120, 200, 20);
	 miPanel.add(lblNombre);

	 txtNombre = new JTextField();
	 txtNombre.setBounds(220, 120, 200, 20);
	 miPanel.add(txtNombre);

	 lblFecha = new JLabel();
	 lblFecha.setText("Fecha de la Funcion");
	 lblFecha.setBounds(10, 150, 200, 20);
	 miPanel.add(lblFecha);

	 fechaFuncion = new JDateChooser();
	 fechaFuncion.setBounds(220, 150, 200, 20);
	 miPanel.add(fechaFuncion);

	 lblHora = new JLabel();
	 lblHora.setText("Hora de Inicio");
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

	 lblArtistasInv = new JLabel();
	 lblArtistasInv.setText("Artistas invitados");
	 lblArtistasInv.setBounds(10, 210, 150, 20);
	 miPanel.add(lblArtistasInv);

	 listaArtistas = new JList<String>(nombresArtistas);
	 listaArtistas.setBounds(220, 210, 100, 100);
	 listaArtistas.setVisibleRowCount(5);
	 listaArtistas.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
	 // miPanel.add(listaArtistas);

	 btnCopiar = new JButton(">>>");
	 btnCopiar.setBounds(220, 250, 70, 30);
	 btnCopiar.addActionListener(

		  new ActionListener(){
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

	 // listaArtistasSeleccionados = new JList();
	 // listaArtistasSeleccionados = new JList();
	 // listaArtistasSeleccionados.setBounds(410, 210, 100, 100);
	 // listaArtistasSeleccionados.setVisibleRowCount(5);
	 // listaArtistasSeleccionados.setFixedCellWidth( 100 );
	 // listaArtistasSeleccionados.setFixedCellHeight( 25 );
	 // listaArtistasSeleccionados.getTe
	 // listaArtistasSeleccionados.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
	 // miPanel.add(scrollPaneListaArtistas);
	 // JScrollPane algo = new JScrollPane(listaArtistasSeleccionados);
	 // algo.setBounds(410, 210, 100, 100);
	 // miPanel.add(algo);
	 comboArtista = new JComboBox<String>();
	 comboArtista.setBounds(220, 210, 200, 25);
	 miPanel.add(comboArtista);

	 lblFechaAlta = new JLabel();
	 lblFechaAlta.setText("Fecha de Alta");
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

	 // comboPlataforma.setSelectedItem("Seleccione Plataforma");
    }

    private void agregarNombre(){
	 String nombre = this.comboArtista.getSelectedItem().toString();
	 modelo.addElement(nombre);
	 listNombres.setModel(modelo);
	 txtNombre.setText("");
    }
    // Inicializar ComboBox

    // PLATAFORMAS
    public void iniciarlizarComboBox(){
	 // Cargo combo de plataformas
	 listPlataformas = iconP.listarPlataformas(); // PONER EN CONTROLADOR PLATAFORMA
	 listPlataformas.forEach((p) -> {
	     comboPlataforma.addItem(p.getNombre());
	 });

	 listArtistas = iconU.listarArtistas();
	 listArtistas.forEach((a) -> {
	     comboArtista.addItem(a.getNickname());
	 });
	 // Cargo combo de artistas
	 // listArtistas = iconU.listarArtistas();
	 // listArtistas.forEach((a) -> {
	 // comboArtista.addItem(a.getNickname());
	 // });

	 // ESPECTACULOS DE LA PLATAFORMA SELECCIONADA
	 // DefaultComboBoxModel<String> modelEspectaculos = new DefaultComboBoxModel<String>(iconFun.listarArtistas());
	 // comboEspectaculos.setModel(modelEspectaculos);
    }

    private boolean checkFormulario(){
	 if(!txtNombre.getText().isEmpty() && fechaFuncion.getDate() != null && fechaAlta.getDate() != null){
	 }else{
	     JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
	     return false;
	 }
	 return true;
    }

    private void limpiarFormulario(){
	 this.txtNombre.setText("");
	 this.fechaFuncion.setDate(null);
	 this.spinHora.setValue(0);
	 this.spinMin.setValue(0);
	 // //Artistas invitados
	 this.fechaAlta.setDate(null);
    }

    @Override
    public void actionPerformed(ActionEvent e){
	 // TODO Auto-generated method stub
	 if(e.getSource() == comboPlataforma){
	     // controla que no sea null
	     // int hora = Integer.parseInt (this.spinHora.getValue().toString());
	     // int minutos = Integer.parseInt (this.spinMin.getValue().toString());
	     // Time horaInicio = new Time(hora,minutos,0);
	     // System.out.println(horaInicio.toString());
	     String strPlataforma = this.comboPlataforma.getSelectedItem().toString();
	     Plataforma plataforma = listPlataformas.stream().filter(p -> (p.getNombre() == strPlataforma)).findFirst().get();
	     List<Espectaculo> listEspectaculos = plataforma.getEspectaculo();
	     if(listEspectaculos.isEmpty()){
		  comboPlataforma.getModel().setSelectedItem("Seleccione Plataforma");
		  comboEspectaculos.getModel().setSelectedItem("Seleccione Espectaculo");
		  JOptionPane.showMessageDialog(this, "Esta plataforma no tiene espectaculos asociados.", "Agregar Espectaculo", JOptionPane.WARNING_MESSAGE);
	     }else
		  listEspectaculos.forEach((esp) -> {
		      comboEspectaculos.addItem(esp.getNombre());
		  });
	 }

	 // BOTON ACEPTAR
	 if(e.getSource() == btnAceptar){
	     if(checkFormulario()){
		  String espectaculo = (String) this.comboEspectaculos.getSelectedItem();
		  Espectaculo esp = new Espectaculo();
		  String nombreEspectaculo = this.txtNombre.getText();
		  Date fechaFuncion = this.fechaFuncion.getDate();
		  int hora = Integer.parseInt(this.spinHora.getValue().toString());
		  int minutos = Integer.parseInt(this.spinHora.getValue().toString());
		  Time horaInicio = new Time(hora, minutos, 0);
		  System.out.println(horaInicio.toString());

		  List<String> ola = (List<String>) listaArtistasSeleccionados;

		  Date fechaAlta = this.fechaAlta.getDate();
		  try{
		      this.iconFun.altaFuncion(nombreEspectaculo, esp, fechaFuncion, null, null, fechaAlta);
		      JOptionPane.showMessageDialog(this, "la plataforma se ha creado con Exito");
		  }catch(FuncionRepetidaExcepcion msg){
		      JOptionPane.showMessageDialog(this, msg.getMessage(), "Alta Plataforma", JOptionPane.ERROR_MESSAGE);
		  }
		  limpiarFormulario();
		  setVisible(false);
	     }
	 }

	 if(e.getSource() == btnCancelar){
	     limpiarFormulario();
	     setVisible(false);
	 }
    }
}

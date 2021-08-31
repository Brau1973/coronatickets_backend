package presentacion;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.util.Date;
import java.util.List;

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
    private IControladorFuncion iconF;
    private IControladorPlataforma iconP;
    private IControladorUsuario iconU;

    private JButton btnAceptar, btnCancelar, btnCopiar;
    private JPanel miPanel;
    private JLabel lblPlataforma, lblEspectaculos, lblNombre, lblFecha, lblHora, lblArtistasInv, lblFechaAlta, lblDots, lblTitulo;
    private JTextField txtNombre;
    private JSpinner spinHora, spinMin;
    private JDateChooser fechaFuncion, fechaAlta;
    private JComboBox<String> comboEspectaculos, comboPlataforma;
    private JList<String> listaArtistas, listaArtistasSeleccionados;
    private JScrollPane scrollPaneListaArtistas, scrollPaneListaArtistasSeleccionados;
    private List<Plataforma> listPlataformas;
    private List<Artista> listArtistasInvitados;
    private int z;

    private String arrayArtistasStr[];
    String arrayArtistasSeleccionadosStr[];
    private List<Artista> listArtistas;

    // Constructor
    public AltaFuncion(IControladorFuncion iconF){
	 this.iconF = iconF;
	 iconP = Fabrica.getInstancia().getIControladorPlataforma();
	 iconU = Fabrica.getInstancia().getIControladorUsuario();

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
	 comboPlataforma.setBounds(220, 30, 200, 20);
	 miPanel.add(comboPlataforma);
	 comboPlataforma.addActionListener(this);

	 lblEspectaculos = new JLabel();
	 lblEspectaculos.setText("Espectaculos");
	 lblEspectaculos.setBounds(10, 60, 200, 20);
	 miPanel.add(lblEspectaculos);

	 comboEspectaculos = new JComboBox<String>();
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

	 // LISTA DE ARTISTAS + SCROLL PANE

	 // listaArtistas = new JList<String>(this.arrayArtistasStr); // RECIBE ARRAY DE STRING [];
	 listaArtistas = new JList<String>(); // RECIBE ARRAY DE STRING [];
	 listaArtistas.setBounds(220, 210, 100, 100);
	 listaArtistas.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

	 scrollPaneListaArtistas = new JScrollPane(listaArtistas);
	 scrollPaneListaArtistas.setBounds(220, 210, 100, 100);
	 scrollPaneListaArtistas.setVisible(true);
	 miPanel.add(scrollPaneListaArtistas, BorderLayout.SOUTH);

	 btnCopiar = new JButton(">>>");
	 btnCopiar.setBounds(330, 210, 70, 25);
	 btnCopiar.addActionListener(this);
	 miPanel.add(btnCopiar);

	 // LISTA DE ARTISTAS SELECCIONADOS + SCROLL PANE
	 listaArtistasSeleccionados = new JList<String>();
	 listaArtistasSeleccionados.setBounds(220, 210, 100, 100);

	 scrollPaneListaArtistasSeleccionados = new JScrollPane(listaArtistasSeleccionados);
	 scrollPaneListaArtistasSeleccionados.setBounds(220, 210, 100, 100);
	 scrollPaneListaArtistasSeleccionados.setVisible(false);
	 miPanel.add(scrollPaneListaArtistasSeleccionados, BorderLayout.SOUTH);

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
    }

    // Inicializar ComboBox

    // PLATAFORMAS
    public void iniciarlizarComboBox(){
	 // Cargo combo de plataformas
	 listPlataformas = iconP.listarPlataformas();
	 listPlataformas.forEach((p) -> {
	     comboPlataforma.addItem(p.getNombre());
	 });
	 comboPlataforma.getModel().setSelectedItem("Seleccione Plataforma");
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
	 if(e.getSource() == comboPlataforma){
	     String strPlataforma = this.comboPlataforma.getSelectedItem().toString();
	     if(strPlataforma != "Seleccione Plataforma"){
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
	     }else{
		  comboEspectaculos.removeAllItems();
		  comboEspectaculos.getModel().setSelectedItem("Seleccione Espectaculo");
	     }
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

		  Date fechaAlta = this.fechaAlta.getDate();

		  try{
		      this.iconF.altaFuncion(nombreEspectaculo, esp, fechaFuncion, null, null, fechaAlta);
		      ;
		      JOptionPane.showMessageDialog(this, "la plataforma se ha creado con Exito");
		  }catch(FuncionRepetidaExcepcion msg){
		      JOptionPane.showMessageDialog(this, msg.getMessage(), "Alta Plataforma", JOptionPane.ERROR_MESSAGE);
		  }
		  limpiarFormulario();
		  setVisible(false);
	     }
	 }

	 if(e.getSource() == btnCopiar){
	     List<String> artistasSeleccionadosStr = listaArtistas.getSelectedValuesList();
	     this.arrayArtistasSeleccionadosStr = new String[artistasSeleccionadosStr.size()];

	     for(int i = 0; i < artistasSeleccionadosStr.size(); i++){
		  // System.out.println(artistasSeleccionadosStr.get(i));
		  arrayArtistasSeleccionadosStr[i] = artistasSeleccionadosStr.get(i);
		  this.listArtistasInvitados.add(this.iconU.ObtenerArtista(artistasSeleccionadosStr.get(i)));
		  // System.out.println(arrayArtistasSeleccionadosStr[i]);
	     }
	     System.out.println(arrayArtistasSeleccionadosStr[0]);
	     listaArtistasSeleccionados.setListData(arrayArtistasSeleccionadosStr); // PARA QUE SE VISUALIZE EN EL JLIST 2
	 }

	 if(e.getSource() == btnCancelar){
	     limpiarFormulario();
	     setVisible(false);
	 }
    }

    public void CargarListaArtistas(){
	 // List<String> artistasStr = iconU.listarArtistasStr();
	 // this.arrayArtistasStr = new String[artistasStr.size()];
	 // for (int i = 0; i < artistasStr.size(); i++) {
	 // System.out.println(artistasStr.get(i));
	 // this.arrayArtistasStr[i] = artistasStr.get(i);
	 // }
	 this.listArtistas = iconU.listarArtistas();
	 System.out.println("TRAIGO ARTISTAS DESDE BD");
	 arrayArtistasStr = new String[listArtistas.size()];

	 this.z = 0;
	 this.listArtistas.forEach((a) -> {
	     this.arrayArtistasStr[z] = a.getNickname();
	     z = z + 1;
	 });

	 for(int j = 0; j < listArtistas.size(); j++){
	     System.out.println("CARGO DESDE LA BD");
	     System.out.println(this.arrayArtistasStr[j]);
	 }

	 this.listaArtistas.setListData(this.arrayArtistasStr);
    }

}

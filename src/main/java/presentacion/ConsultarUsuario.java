package presentacion;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.Border;

import com.toedter.calendar.JDateChooser;

import interfaces.Fabrica;
import interfaces.IControladorUsuario;
import logica.Espectaculo;
import logica.Usuario;
import manejadores.ManejadorEspectaculo;
import manejadores.ManejadorFuncion;

@SuppressWarnings("serial")
public class ConsultarUsuario extends JInternalFrame implements ActionListener{

    private JPanel miPanel;
    private JScrollPane panel;
    private JLabel lblTitulo, lblBuscar;
    private JDateChooser dateFechaNac;
    private JTable tabUsuario;
    private JComboBox<String> comboUsuarios;
    private JTextArea jtextarea;
    private List<Usuario> listUsuarios;
    IControladorUsuario iconU = Fabrica.getInstancia().getIControladorUsuario();

    // Constructor
    public ConsultarUsuario(IControladorUsuario iconU){
	 this.iconU = iconU;
	 miPanel = new JPanel();
	 miPanel.setLayout(null);
	 add(miPanel);
	 setBounds(15, 15, 460, 400);
	 setResizable(false);
	 setClosable(true);
	 setIconifiable(false);
	 setBorder(null);
	 ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).setNorthPane(null);

	 // JLabel
	 lblTitulo = new JLabel("Consulta de Usuario");
	 lblTitulo.setFont(new java.awt.Font("Comic Sans MS", 1, 18));
	 lblTitulo.setBounds(10, 1, 380, 25);
	 miPanel.add(lblTitulo);

	 lblBuscar = new JLabel("Usuario:");
	 lblBuscar.setFont(new java.awt.Font("Verdana", 1, 12));
	 lblBuscar.setBounds(10, 35, 150, 25);
	 miPanel.add(lblBuscar);

	 // JComboBox
	 comboUsuarios = new JComboBox<String>();
	 comboUsuarios.setBounds(120, 38, 255, 25);
	 miPanel.add(comboUsuarios);
	 comboUsuarios.addActionListener(this);

	 jtextarea = new JTextArea(25, 150);
	 Border border = BorderFactory.createLineBorder(Color.GRAY);
	 jtextarea.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10)));
	 jtextarea.setBounds(10, 70, 330, 300);
	 jtextarea.setFont(new java.awt.Font("Verdana", 1, 12));
	 jtextarea.setAutoscrolls(maximizable);
	 miPanel.add(jtextarea);

	 // Tabla Funciones de espectulos
	 /*	 DefaultTableModel model = new DefaultTableModel(data, header);
	 tabUsuario = new JTable(model);
	 tabUsuario.setPreferredScrollableViewportSize(new Dimension(40, 290));
	 JScrollPane jsPane = new JScrollPane(tabUsuario);
	 jsPane.setBounds(10, 180, 365, 118);
	 jsPane.setVisible(false);
	 miPanel.add(jsPane, BorderLayout.SOUTH);*/
	 // Click en tabUsuario
	 /* tabUsuario.addMouseListener(new MouseAdapter(){
	     public void mouseClicked(MouseEvent evt){
	   int fila = tabUsuario.rowAtPoint(evt.getPoint());
	   txtNombre.setText(String.valueOf(tabUsuario.getValueAt(fila, 0)));
	   txtApellido.setText(String.valueOf(tabUsuario.getValueAt(fila, 1)));
	     }
	 });*/
	 //iniciaComboBoxU();
    }

    /*// Inicializar ComboBox
    private void iniciaComboBoxU(){
	 listUsuarios = iconU.listarUsuarios();
	 listUsuarios.forEach((u) -> {
	     comboUsuarios.addItem(u.getNickname());
	 });
    }*/

    public void actionPerformed(ActionEvent e){
	 if(e.getSource() == comboUsuarios){
	     String strUsuario = (String) this.comboUsuarios.getSelectedItem();
	     Usuario u = iconU.obtenerUsuario(strUsuario);
	     SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
	     ManejadorEspectaculo mE = ManejadorEspectaculo.getInstancia();
	     List<Espectaculo> usuario = mE.obtenerEspectaculo();
	     ManejadorFuncion mF = ManejadorFuncion.getInstancia();

	     String datos = "";
	     String op = "";
	     /*   if(u instanceof Artista){
	       op = "***********Artista\n\n";
	       ArrayList<String> espArtista = mE.obtenerEspectaculodeArtista(strUsuario);
	       datos = "\n\nLista de espectaculos:";
	       for(String i :espArtista){
	           datos = datos + "\n" + i.toString();
	       }
	     
	       ArrayList<String> usuario = mE.obtenerEspectaculo();
	       String datos = "\n\nLista de espectaculos:";
	       for(Espectaculo i :usuario){
	           datos = datos + "\n" + i.toString();
	       }
	     
	       if(u instanceof Espectador){
	           op = "***********Espectador\n\n";
	           ArrayList<String> ff = mE.obtenerEspectaculo();// mF.obtenerFunciones();
	           datos = "\n\nLista de funciones:";
	           for(String f :ff){
	     	   datos = datos + "\n" + f.toString();
	           }
	       }*/
	     // jtextarea.setText(op + "Nombre: " + u.getNombre() + "\nApellido: " + u.getApellido() + "\nEmail: " + u.getEmail() + "\nFecha: " + formatoFecha.format(u.getfNacimiento()) + datos);
	     // }

	 }

    }
}


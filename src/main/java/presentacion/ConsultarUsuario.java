package presentacion;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import com.toedter.calendar.JDateChooser;

@SuppressWarnings("serial")
public class ConsultarUsuario extends JInternalFrame{
    private JButton btnConsulta;
    private JPanel miPanel;
    private JLabel lblTitulo, lblNickname, lblNombre, lblApellido, lblEmail, lblfNacimiento;
    private JTextField txtBuscar, txtNickname, txtNombre, txtApellido, txtEmail;
    private JDateChooser dateFechaNac;
    private JTable tabUsuario;
    private String[] header = {"Nombre", "Apellido"};
    private String[][] data = {{"Sebastian", "Gonzalez"}, {"Aldrin", "Rebella"}, {"Leonardo", "Mesa"}, {"Lucas", "Sugo"}, {"Luisito", "Suarez"}, {"Colorado", "DeOmar"}, {"Colorado", "DeOmar"}, {"Gruffi ", "Gummi"}};

    // Constructor
    public ConsultarUsuario(){
	 miPanel = new JPanel();
	 miPanel.setLayout(null);
	 add(miPanel);
	 setBounds(15, 15, 460, 400);
	 setResizable(false);
	 setClosable(true);
	 setIconifiable(false);
	 setBorder(null);
	 ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).setNorthPane(null);
	 // JLabel Titulo
	 lblTitulo = new JLabel();
	 lblTitulo.setText("Lista de Usuarios");
	 lblTitulo.setFont(new java.awt.Font("Comic Sans MS", 1, 19));
	 lblTitulo.setBounds(10, 1, 270, 25);
	 miPanel.add(lblTitulo);

	 // JTextField Buscar
	 txtBuscar = new JTextField();
	 txtBuscar.setBounds(10, 38, 286, 25);
	 miPanel.add(txtBuscar);
	 // Boton Buscar
	 btnConsulta = new JButton();
	 btnConsulta.setText("Buscar");
	 btnConsulta.setBounds(300, 38, 75, 24);
	 miPanel.add(btnConsulta);

	 // Tabla Usuarios
	 DefaultTableModel model = new DefaultTableModel(data, header);
	 tabUsuario = new JTable(model);
	 tabUsuario.setPreferredScrollableViewportSize(new Dimension(40, 290));
	 JScrollPane jsPane = new JScrollPane(tabUsuario);
	 jsPane.setBounds(10, 78, 365, 118);
	 jsPane.setVisible(true);
	 miPanel.add(jsPane, BorderLayout.SOUTH);

	 // Filtrar
	 btnConsulta.addActionListener(new ActionListener(){
	     public void actionPerformed(ActionEvent e){
		  TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(((DefaultTableModel) tabUsuario.getModel()));
		  sorter.setRowFilter(RowFilter.regexFilter("(?i)" + txtBuscar.getText()));
		  tabUsuario.setRowSorter(sorter);
	     }
	 });

	 // Label
	 lblNickname = new JLabel();
	 lblNombre = new JLabel();
	 lblApellido = new JLabel();
	 lblEmail = new JLabel();
	 lblfNacimiento = new JLabel();
	 lblNickname.setText("Nickname:");
	 lblNombre.setText("Nombre:");
	 lblApellido.setText("Apellido:");
	 lblEmail.setText("Email:");
	 lblfNacimiento.setText("Fecha nacimiento:");
	 lblNickname.setFont(new java.awt.Font("Verdana", 1, 12));
	 lblNombre.setFont(new java.awt.Font("Verdana", 1, 12));
	 lblApellido.setFont(new java.awt.Font("Verdana", 1, 12));
	 lblEmail.setFont(new java.awt.Font("Verdana", 1, 12));
	 lblfNacimiento.setFont(new java.awt.Font("Verdana", 1, 12));
	 lblNickname.setBounds(10, 220, 80, 25);
	 lblNombre.setBounds(10, 250, 80, 25);
	 lblApellido.setBounds(10, 280, 80, 25);
	 lblEmail.setBounds(10, 310, 80, 25);
	 lblfNacimiento.setBounds(10, 340, 150, 25);

	 // Agrego label al Panel
	 miPanel.add(lblNickname);
	 miPanel.add(lblNombre);
	 miPanel.add(lblApellido);
	 miPanel.add(lblEmail);
	 miPanel.add(lblfNacimiento);

	 // JTextField
	 txtNickname = new JTextField();
	 txtNombre = new JTextField();
	 txtApellido = new JTextField();
	 txtEmail = new JTextField();
	 dateFechaNac = new JDateChooser(); // Fecha
	 txtNickname.setBounds(140, 218, 240, 25);
	 txtNombre.setBounds(140, 248, 240, 25);
	 txtApellido.setBounds(140, 278, 240, 25);
	 txtEmail.setBounds(140, 308, 240, 25);
	 dateFechaNac.setBounds(140, 338, 240, 25);

	 // Agrego JTextField al Panel
	 miPanel.add(txtNickname);
	 miPanel.add(txtNombre);
	 miPanel.add(txtApellido);
	 miPanel.add(txtEmail);
	 miPanel.add(dateFechaNac);

	 // Click en tabUsuario
	 tabUsuario.addMouseListener(new MouseAdapter(){
	     public void mouseClicked(MouseEvent evt){
		  int fila = tabUsuario.rowAtPoint(evt.getPoint());
		  txtNombre.setText(String.valueOf(tabUsuario.getValueAt(fila, 0)));
		  txtApellido.setText(String.valueOf(tabUsuario.getValueAt(fila, 1)));
	     }
	 });

    }
}
// String s = JOptionPane.showInputDialog(null, "Digite un caracter: ");
// char ch = s.charAt(0);
// micoordinador.proceso3(ch);
/*		  retorno = "\nNickname:  " + data[1][0].toString() + "\n";
		  retorno += "Nombre:  " + data[1][1].toString() + "\n";
		  retorno += "Apellido:  " + data[1][2].toString() + "\n\n";
 * */

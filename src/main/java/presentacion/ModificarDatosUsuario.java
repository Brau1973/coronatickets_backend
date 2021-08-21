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
import javax.swing.JOptionPane;
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
public class ModificarDatosUsuario extends JInternalFrame implements ActionListener{
    private JButton btnConsulta, btnGuardar;
    private JPanel miPanel;
    private JLabel lblTitulo, lblNombre, lblApellido, lblfNacimiento;
    private JTextField txtBuscar, txtNombre, txtApellido;
    private JDateChooser dateFechaNac;
    private JTable tabUsuario;
    private String[] header = {"Nombre", "Apellido"};
    private String[][] data = {{"Sebastian", "Gonzalez"}, {"Aldrin", "Rebella"}, {"Leonardo", "Mesa"}, {"Lucas", "Sugo"}, {"Luisito", "Suarez"}, {"Colorado", "DeOmar"}, {"Colorado", "DeOmar"}, {"Gruffi ", "Gummi"}};

    // Constructor
    public ModificarDatosUsuario(){
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
	 lblTitulo.setText("Modificar Datos de Usuario");
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
	 lblNombre = new JLabel();
	 lblApellido = new JLabel();
	 lblfNacimiento = new JLabel();
	 lblNombre.setText("Nombre:");
	 lblApellido.setText("Apellido:");
	 lblfNacimiento.setText("Fecha nacimiento:");
	 lblNombre.setFont(new java.awt.Font("Verdana", 1, 12));
	 lblApellido.setFont(new java.awt.Font("Verdana", 1, 12));
	 lblfNacimiento.setFont(new java.awt.Font("Verdana", 1, 12));
	 lblNombre.setBounds(10, 220, 80, 25);
	 lblApellido.setBounds(10, 250, 80, 25);
	 lblfNacimiento.setBounds(10, 280, 150, 25);

	 // Agrego label al Panel
	 miPanel.add(lblNombre);
	 miPanel.add(lblApellido);
	 miPanel.add(lblfNacimiento);

	 // JTextField
	 txtNombre = new JTextField();
	 txtApellido = new JTextField();
	 dateFechaNac = new JDateChooser();
	 txtNombre.setBounds(140, 218, 237, 25);
	 txtApellido.setBounds(140, 248, 237, 25);
	 dateFechaNac.setBounds(140, 278, 148, 25);

	 // Agrego JTextField al Panel
	 miPanel.add(txtNombre);
	 miPanel.add(txtApellido);
	 miPanel.add(dateFechaNac);

	 // Click en tabUsuario
	 tabUsuario.addMouseListener(new MouseAdapter(){
	     public void mouseClicked(MouseEvent evt){
		  int fila = tabUsuario.rowAtPoint(evt.getPoint());
		  txtNombre.setText(String.valueOf(tabUsuario.getValueAt(fila, 0)));
		  txtApellido.setText(String.valueOf(tabUsuario.getValueAt(fila, 1)));
	     }
	 });
	 // Boton Guardar
	 btnGuardar = new JButton();
	 btnGuardar.setText("Guardar");
	 btnGuardar.setBounds(291, 278, 85, 24);
	 miPanel.add(btnGuardar);
	 btnGuardar.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
	 if(e.getSource() == btnGuardar){
	     JOptionPane.showMessageDialog(null, "Datos modificados correctamente");
	 }
    }
}

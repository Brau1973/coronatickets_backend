package presentacion;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

@SuppressWarnings("serial")
public class ConsultarUsuario extends JInternalFrame{
    private JButton btnConsulta;
    private JPanel miPanel;
    private JTextField txtBuscar;
    private JLabel lblTitulo;
    private JTable tabUsuario;
    private String[] header = {"Nombre", "Apellido"};
    private String[][] data = {{"Sebastian", "Gonzalez"}, {"Aldrin", "Rebella"}, {"Leonardo", "Mesa"}, {"Lucas", "Sugo"}};

    // Constructor
    public ConsultarUsuario(){
	 miPanel = new JPanel();
	 miPanel.setLayout(null);
	 add(miPanel);
	 setBounds(20, 20, 460, 400);
	 setResizable(false);
	 setClosable(true);
	 setIconifiable(false);
	 setBorder(null);
	 ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).setNorthPane(null);

	 lblTitulo = new JLabel();
	 lblTitulo.setText("Lista de Usuarios");
	 lblTitulo.setFont(new java.awt.Font("Comic Sans MS", 1, 20));
	 lblTitulo.setBounds(10, 1, 280, 25);
	 miPanel.add(lblTitulo);

	 DefaultTableModel model = new DefaultTableModel(data, header);
	 tabUsuario = new JTable(model);
	 tabUsuario.setPreferredScrollableViewportSize(new Dimension(40, 290));
	 JScrollPane jsPane = new JScrollPane(tabUsuario);
	 jsPane.setBorder(new EmptyBorder(0, 10, 0, 20));
	 jsPane.setVisible(true);
	 add(jsPane, BorderLayout.SOUTH);
	 // tabUsuario.setLayout(null);

	 txtBuscar = new JTextField();
	 txtBuscar.setBounds(10, 45, 270, 25);
	 miPanel.add(txtBuscar);

	 // Boton Buscar
	 btnConsulta = new JButton();
	 btnConsulta.setText("Buscar");
	 btnConsulta.setBounds(295, 45, 95, 25);
	 btnConsulta.addActionListener(new ActionListener(){
	     public void actionPerformed(ActionEvent e){
		  TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(((DefaultTableModel) tabUsuario.getModel()));
		  sorter.setRowFilter(RowFilter.regexFilter(txtBuscar.getText()));
		  tabUsuario.setRowSorter(sorter);
	     }
	 });
	 miPanel.add(btnConsulta);
    }
}


/*  // JOptionPane.showMessageDialog(null, retorno, "Información", JOptionPane.PLAIN_MESSAGE);
Object color = JOptionPane.showInputDialog(null, "Seleccione Un Color", "COLORES", JOptionPane.QUESTION_MESSAGE, null, new Object[] {"Seleccione", "Amarillo", "Azul", "Rojo"}, "Seleccione");
JOptionPane.showMessageDialog(null, "Color Seleccionado " + color);*/
// String s = JOptionPane.showInputDialog(null, "Digite un caracter: ");
// char ch = s.charAt(0);
// micoordinador.proceso3(ch);
/*		  retorno = "\nNickname:  " + data[1][0].toString() + "\n";
		  retorno += "Nombre:  " + data[1][1].toString() + "\n";
		  retorno += "Apellido:  " + data[1][2].toString() + "\n\n";
 * */

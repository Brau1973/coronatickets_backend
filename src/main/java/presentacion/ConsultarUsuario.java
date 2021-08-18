package presentacion;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class ConsultarUsuario extends JInternalFrame{
    private JButton btnConsulta;
    private JPanel miPanel;
    private JTextField txtBuscar;
    // private JLabel lblTitulo;
    private String[] header = {"Nickname", "Nombre", "Apellido"};
    private String[][] data = {{"sebagl", "Sebastian", "Gonzalez"}, {"aldrinkpo", "Aldrin", "Rebella"}, {"leito", "Leonardo", "Mesa"}, {"lucs12", "Lucas", "Sugo"}};
    private String retorno;

    // Constructor
    public ConsultarUsuario(){
	 miPanel = new JPanel();
	 miPanel.setLayout(null);
	 add(miPanel);
	 setBounds(2, 2, 460, 400);
	 setResizable(false);
	 setClosable(true);
	 setIconifiable(false);

	 // lblTitulo = new JLabel();
	 /* lblTitulo.setText("Consulta Usuario");
	 lblTitulo.setFont(new java.awt.Font("Comic Sans MS", 1, 20));
	 lblTitulo.setBounds(10, 1, 280, 25);
	 miPanel.add(lblTitulo);*/

	 DefaultTableModel model = new DefaultTableModel(data, header);
	 JTable tabUsuario = new JTable(model);
	 tabUsuario.setPreferredScrollableViewportSize(new Dimension(40, 290));

	 JScrollPane jsPane = new JScrollPane(tabUsuario);
	 jsPane.setBorder(new EmptyBorder(0, 10, 0, 20));
	 jsPane.setVisible(true);
	 add(jsPane, BorderLayout.SOUTH);

	 txtBuscar = new JTextField();
	 txtBuscar.setBounds(25, 20, 260, 25);
	 miPanel.add(txtBuscar);

	 // Boton Buscar
	 btnConsulta = new JButton();
	 btnConsulta.setText("Ver datos");
	 btnConsulta.setBounds(300, 20, 90, 25);
	 btnConsulta.addActionListener(new ActionListener(){
	     public void actionPerformed(ActionEvent e){
		  retorno = "Nickname:  " + data[1][0].toString() + "\n";
		  retorno += "Nombre:  " + data[1][1].toString() + "\n";
		  retorno += "Apellido:  " + data[1][2].toString() + "\n";
		  JOptionPane.showMessageDialog(null, retorno, "Informacion", JOptionPane.PLAIN_MESSAGE);
	     }
	 });
	 miPanel.add(btnConsulta);
    }


}

// String s = JOptionPane.showInputDialog(null, "Digite un caracter: ");
// char ch = s.charAt(0);
// micoordinador.proceso3(ch);

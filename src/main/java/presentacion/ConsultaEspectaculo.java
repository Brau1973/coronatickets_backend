package presentacion;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class ConsultaEspectaculo extends JInternalFrame{
    private JButton btnConsulta;
    private JPanel miPanel;
    private JLabel lblTitulo, lblPlataforma;
    private String[] header = {"Nombre", "Descripcion", "Duracion"};
    private String[][] data = {{"sebagl", "Sebastian", "Gonzalez"}, {"aldrinkpo", "Aldrin", "Rebella"}, {"leito", "Leonardo", "Mesa"}, {"lucs12", "Lucas", "Sugo"}};
    private JComboBox<String> comboPlataforma;

    // Constructor
    public ConsultaEspectaculo(){
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
	 lblTitulo.setText("Consulta de Espectaculo");
	 lblTitulo.setFont(new java.awt.Font("Comic Sans MS", 1, 20));
	 lblTitulo.setBounds(10, 1, 280, 25);
	 miPanel.add(lblTitulo);

	 lblPlataforma = new JLabel();
	 lblPlataforma.setText("Seleccionar Plataforma:");
	 lblPlataforma.setBounds(10, 40, 200, 20);
	 miPanel.add(lblPlataforma);

	 comboPlataforma = new JComboBox<String>();
	 comboPlataforma.setBounds(200, 40, 250, 20);
	 comboPlataforma.addItem("Sebastian");
	 comboPlataforma.addItem("Sebastian Gonzalez");
	 comboPlataforma.addItem("Plataforma 3");
	 miPanel.add(comboPlataforma);

	 DefaultTableModel model = new DefaultTableModel(data, header);
	 JTable tabUsuario = new JTable(model);
	 tabUsuario.setPreferredScrollableViewportSize(new Dimension(40, 290));
	 JScrollPane jsPane = new JScrollPane(tabUsuario);
	 jsPane.setBorder(new EmptyBorder(0, 90, 0, 20));
	 jsPane.setVisible(true);
	 // add(jsPane, BorderLayout.SOUTH);
	 
	 
	 
	 // Boton Buscar
	 btnConsulta = new JButton();
	 // btnConsulta.setText("Buscar...");
	 btnConsulta.setBounds(295, 65, 95, 25);
	 btnConsulta.addActionListener(new ActionListener(){
	     public void actionPerformed(ActionEvent e){
		  /*  retorno = "Nickname:  " + data[1][0].toString() + "\n";
		  retorno += "Nombre:  " + data[1][1].toString() + "\n";
		  retorno += "Apellido:  " + data[1][2].toString() + "\n";
		  JOptionPane.showMessageDialog(null, retorno, "Informacion", JOptionPane.PLAIN_MESSAGE);*/
	     }
	 });
	 // miPanel.add(btnConsulta);
    }
}

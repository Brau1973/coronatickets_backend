package presentacion;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class FrmPrincipal extends JFrame implements ActionListener{ // 79S
    private Container contenedor;
    private JMenuBar barraMenu;
    private JMenu menuInicio, menuRegristros, menuConsultas, menuAyuda;
    private JMenuItem menuItAltaUsuario, menuItAltaEspectaculo, menuItConsultaUsuario, menuItConsultaEspectaculo;

    private AltaUsuario internalFrameAltaUsuario;
    private AltaEspectaculo internalFrameAltaEspectaculo;
    private ConsultarUsuario internalFrameConsultaUsuario;

    // Constructor
    public FrmPrincipal(){
	 inicializar();
	 setTitle("coronaTickets.uy");
	 // setSize(530, 547);
	 setSize(550, 550);

	 setLocationRelativeTo(null);
	 setResizable(false);
	 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void inicializar(){
	 contenedor = getContentPane();
	 contenedor.setLayout(null);

	 // Menu
	 menuInicio = new JMenu();
	 menuRegristros = new JMenu();
	 menuConsultas = new JMenu();
	 menuAyuda = new JMenu();
	 menuInicio.setText("Inicio");
	 menuRegristros.setText("Registros");
	 menuConsultas.setText("Consultas");
	 menuAyuda.setText("Ayuda");
	 barraMenu = new JMenuBar();
	 barraMenu.add(menuInicio);
	 barraMenu.add(menuRegristros);
	 barraMenu.add(menuConsultas);
	 barraMenu.add(menuAyuda);
	 setJMenuBar(barraMenu);

	 // Menu Item
	 menuItAltaUsuario = new JMenuItem();
	 menuItAltaEspectaculo = new JMenuItem();
	 menuItConsultaUsuario = new JMenuItem();
	 menuItConsultaEspectaculo = new JMenuItem();

	 // Menu Item Registrar
	 menuItAltaUsuario.setText("Registrar Usuario");
	 menuItAltaEspectaculo.setText("Registrar Espectaculo");
	 menuRegristros.add(menuItAltaUsuario);
	 menuRegristros.addSeparator();
	 menuRegristros.add(menuItAltaEspectaculo);
	 menuItAltaUsuario.addActionListener(this);
	 menuItAltaEspectaculo.addActionListener(this);

	 // Menu Item Consultar
	 menuItConsultaUsuario.setText("Consultar Usuario");
	 menuItConsultaEspectaculo.setText("Consultar Espectaculo");
	 menuConsultas.add(menuItConsultaUsuario);
	 menuConsultas.addSeparator();
	 menuConsultas.add(menuItConsultaEspectaculo);
	 menuItConsultaUsuario.addActionListener(this);
	 menuItConsultaEspectaculo.addActionListener(this);

	 // InternalFrame
	 inFrmAltaUsuario();
	 inFrmAltaEspectaculo();
	 inFrmConsultaUsuario();
    }

    // InternalFrame Alta Usuario
    private void inFrmAltaUsuario(){
	 internalFrameAltaUsuario = new AltaUsuario();
	 internalFrameAltaUsuario.setVisible(false);
	 contenedor.add(internalFrameAltaUsuario);
    }

    // InternalFrame Alta Espectaculo
    private void inFrmAltaEspectaculo(){
	 internalFrameAltaEspectaculo = new AltaEspectaculo();
	 internalFrameAltaEspectaculo.setVisible(false);
	 contenedor.add(internalFrameAltaEspectaculo);
    }

    // InternalFrame Consulta Usuario
    private void inFrmConsultaUsuario(){
	 internalFrameConsultaUsuario = new ConsultarUsuario();
	 internalFrameConsultaUsuario.setVisible(false);
	 contenedor.add(internalFrameConsultaUsuario);
    }

    // Eventos
    public void actionPerformed(ActionEvent e){
	 internalFrameAltaEspectaculo.setVisible(false);
	 internalFrameConsultaUsuario.setVisible(false);
	 internalFrameAltaUsuario.setVisible(false);
	 if(e.getSource() == menuItAltaUsuario){
	     internalFrameAltaUsuario.setVisible(true);
	 }
	 if(e.getSource() == menuItAltaEspectaculo){
	     internalFrameAltaEspectaculo.setVisible(true);
	 }
	 if(e.getSource() == menuItConsultaUsuario){
	     internalFrameConsultaUsuario.setVisible(true);
	 }

    }
}
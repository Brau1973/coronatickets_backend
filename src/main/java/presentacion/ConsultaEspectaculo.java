package presentacion;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.util.Date;
import java.util.List;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import interfaces.Fabrica;
import interfaces.IControladorPlataforma;
import logica.Artista;
import logica.Espectaculo;
import logica.Plataforma;

@SuppressWarnings("serial")
public class ConsultaEspectaculo extends JInternalFrame{

	private IControladorPlataforma iconP;

	private JButton btnConsulta;
	private JPanel miPanel;
	private JLabel lblTitulo, lblPlataforma, lblEspectaculos;
	private JComboBox<String> comboPlataforma, comboEspectaculos;
	private List<Plataforma> listPlataformas;
	private List<Espectaculo> listEspectaculos;
	private JLabel lblCantidadMaxima;
	private JLabel lblURL;
	private JLabel lblCosto;
	private JTextField textNombreEspectaculo;
	private JTextField textArtistaOrganizador;
	private JTextField textDescripcion;
	private JTextField textDuracion;
	private JTextField textCantidadMinima;
	private JTextField textCantidadMaxima;
	private JTextField textURL;
	private JTextField textCosto;

	// Constructor
	public ConsultaEspectaculo() {

		iconP = Fabrica.getInstancia().getIControladorPlataforma();

		miPanel = new JPanel();
		miPanel.setLayout(null);
		getContentPane().add(miPanel);
		setBounds(20, 20, 460, 400);
		setResizable(false);
		setClosable(true);
		setIconifiable(false);
		setBorder(null);
		((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).setNorthPane(null);
		lblTitulo = new JLabel();
		lblTitulo.setText("Consulta de Espectaculo");
		lblTitulo.setFont(new java.awt.Font("Comic Sans MS", 1, 20));
		lblTitulo.setBounds(10, 0, 300, 20);
		miPanel.add(lblTitulo);

		lblPlataforma = new JLabel();
		lblPlataforma.setText("Plataforma");
		lblPlataforma.setBounds(10, 30, 137, 20);
		miPanel.add(lblPlataforma);

		comboPlataforma = new JComboBox<String>();
		comboPlataforma.setBounds(147, 31, 200, 20);
		comboPlataforma.addItemListener(this::listenerComboPlataforma);
		miPanel.add(comboPlataforma);
		// comboPlataforma.addActionListener(this);

		lblEspectaculos = new JLabel();
		lblEspectaculos.setText("Espectaculos");
		lblEspectaculos.setBounds(10, 62, 97, 20);
		miPanel.add(lblEspectaculos);

		comboEspectaculos = new JComboBox<String>();
		comboEspectaculos.setBounds(147, 61, 200, 22);
		miPanel.add(comboEspectaculos);
		comboEspectaculos.addItemListener(this::listenerComboEspectaculo);

		JLabel lblNombreEspectaculo = new JLabel("Nombre Espectaculo");
		lblNombreEspectaculo.setBounds(10, 97, 137, 14);
		miPanel.add(lblNombreEspectaculo);

		textNombreEspectaculo = new JTextField();
		textNombreEspectaculo.setEnabled(false);
		textNombreEspectaculo.setBounds(147, 94, 200, 20);
		miPanel.add(textNombreEspectaculo);

		JLabel lblArtistaOrganizador = new JLabel("Artista Organizador");
		lblArtistaOrganizador.setBounds(10, 128, 137, 14);
		miPanel.add(lblArtistaOrganizador);

		textArtistaOrganizador = new JTextField();
		textArtistaOrganizador.setEnabled(false);
		textArtistaOrganizador.setBounds(147, 125, 200, 20);
		miPanel.add(textArtistaOrganizador);

		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setBounds(10, 156, 137, 14);
		miPanel.add(lblDescripcion);

		textDescripcion = new JTextField();
		textDescripcion.setEnabled(false);
		textDescripcion.setBounds(147, 153, 200, 20);
		miPanel.add(textDescripcion);

		JLabel lblDuracion = new JLabel("Duracion");
		lblDuracion.setBounds(10, 184, 53, 14);
		miPanel.add(lblDuracion);

		textDuracion = new JTextField();
		textDuracion.setEnabled(false);
		textDuracion.setBounds(76, 181, 40, 20);
		miPanel.add(textDuracion);

		JLabel lblCantidadMinima = new JLabel("Cant. Minima");
		lblCantidadMinima.setBounds(130, 184, 105, 14);
		miPanel.add(lblCantidadMinima);

		textCantidadMaxima = new JTextField();
		textCantidadMaxima.setEnabled(false);
		textCantidadMaxima.setBounds(395, 181, 40, 20);
		miPanel.add(textCantidadMaxima);

		lblCantidadMaxima = new JLabel("Cant. Maxima");
		lblCantidadMaxima.setBounds(290, 184, 105, 14);
		miPanel.add(lblCantidadMaxima);

		textCantidadMinima = new JTextField();
		textCantidadMinima.setEnabled(false);
		textCantidadMinima.setBounds(240, 181, 40, 20);
		miPanel.add(textCantidadMinima);

		lblURL = new JLabel("URL");
		lblURL.setBounds(10, 212, 53, 14);
		miPanel.add(lblURL);

		textURL = new JTextField();
		textURL.setEnabled(false);
		textURL.setBounds(76, 209, 200, 20);
		miPanel.add(textURL);

		lblCosto = new JLabel("Costo");
		lblCosto.setBounds(290, 212, 40, 14);
		miPanel.add(lblCosto);

		textCosto = new JTextField();
		textCosto.setEnabled(false);
		textCosto.setBounds(332, 209, 53, 20);
		miPanel.add(textCosto);

		// artistaOrganizador, descripcion, duracion, cantMinEsp, cantMaxEsp, url,
		// costo, registro

//		// Boton Buscar
//		btnConsulta = new JButton();
//		// btnConsulta.setText("Buscar...");
//		btnConsulta.setBounds(295, 65, 95, 25);
//		btnConsulta.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				/*
//				 * retorno = "Nickname:  " + data[1][0].toString() + "\n"; retorno +=
//				 * "Nombre:  " + data[1][1].toString() + "\n"; retorno += "Apellido:  " +
//				 * data[1][2].toString() + "\n"; JOptionPane.showMessageDialog(null, retorno,
//				 * "Informacion", JOptionPane.PLAIN_MESSAGE);
//				 */
//			}
//		});
//		// miPanel.add(btnConsulta);
	}

	private void listenerComboPlataforma(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			System.out.println("CLICK EN COMBO PLATAFORMA");
			String strPlataforma = this.comboPlataforma.getSelectedItem().toString();
			Plataforma plataforma = listPlataformas.stream().filter(p -> (p.getNombre() == strPlataforma)).findFirst()
					.get();
			this.listEspectaculos = plataforma.getEspectaculo();
			if (listEspectaculos.isEmpty()) {
				System.out.println("LISTA ESPECTACULOS VACIA");
				comboEspectaculos.removeAllItems();
			} else {
				comboEspectaculos.removeAllItems();
				listEspectaculos.forEach((esp) -> {
					comboEspectaculos.addItem(esp.getNombre());
				});
			}
		}
	}

	private void listenerComboEspectaculo(ItemEvent e){
	 if(e.getStateChange() == ItemEvent.SELECTED){
		String strEspectaculo = this.comboEspectaculos.getSelectedItem().toString();
		Espectaculo espectaculo = listEspectaculos.stream().filter(espec -> (espec.getNombre() == strEspectaculo))
				.findFirst().get();

		this.textNombreEspectaculo.setText(espectaculo.getNombre());
		
		this.textArtistaOrganizador.setText(espectaculo.getArtista().getNickname());
		
		this.textDescripcion.setText(espectaculo.getDescripcion());
		
		this.textDuracion.setText(String.valueOf(espectaculo.getDuracion()));
		
		this.textCantidadMinima.setText(String.valueOf(espectaculo.getCantMinEsp()));
		
		this.textCantidadMaxima.setText(String.valueOf(espectaculo.getCantMaxEsp()));
		
		this.textURL.setText(espectaculo.getUrl());
		
		this.textCosto.setText(String.valueOf(espectaculo.getCosto()));
		
		this.textCosto.setText(String.valueOf(espectaculo.getRegistro()));
	 	}
	 }

	// Inicializar ComboBox
	public void iniciarlizarComboBox() {
		comboPlataforma.removeAllItems();
		listPlataformas = iconP.listarPlataformas();
		listPlataformas.forEach((p) -> {
			comboPlataforma.addItem(p.getNombre());
		});
		// modelo.clear();
	}

//	@Override
//	public void actionPerformed(ActionEvent e) {
//		// TODO Auto-generated method stub
//		if (e.getSource() == comboEspectaculos) {
//
//		}
//
//	}
}

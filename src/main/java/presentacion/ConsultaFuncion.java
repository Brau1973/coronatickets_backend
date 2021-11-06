package presentacion;

import java.awt.Image;
import java.awt.event.ItemEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import datatypes.DtEspectaculo;
import datatypes.DtFuncion;
import interfaces.Fabrica;
import interfaces.IControladorEspectaculo;
import interfaces.IControladorFuncion;
import interfaces.IControladorPlataforma;
import logica.Funcion;
import manejadores.ManejadorFuncion;

@SuppressWarnings("serial")
public class ConsultaFuncion extends JInternalFrame{
	private IControladorFuncion iconF;
	private IControladorPlataforma iconP;
	private IControladorEspectaculo iconE;
	private JPanel miPanel;
	private JLabel lblTitulo, lblPlataforma, lblEspectaculos, lblFunciones, jLabelImage;
	private JTextArea txtDatosFuncion;
	private JComboBox<String> comboEspectaculos, comboPlataforma, comboFunciones;

	private List<String> listPlataformas;
	private List<DtEspectaculo> listEspectaculos;
	private List<DtFuncion> listFunciones;
	private String artistasInvitadosAFuncion;

	static final String SELECCIONE_PLAT = "Seleccione Plataforma";
	static final String SELECCIONE_ESP = "Seleccione Espectaculo";
	static final String SELECCIONE_FUNC = "Seleccione Funcion";

	// Constructor
	public ConsultaFuncion(IControladorFuncion iconF){
		this.iconF = iconF;
		iconP = Fabrica.getInstancia().getIControladorPlataforma();
		iconE = Fabrica.getInstancia().getIControladorEspectaculo();
		miPanel = new JPanel();
		miPanel.setLayout(null);
		getContentPane().add(miPanel);
		setBounds(30, 30, 800, 600);
		setResizable(false);
		setClosable(false);
		setIconifiable(false);
		setBorder(null);
		((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).setNorthPane(null);

		lblTitulo = new JLabel();
		lblTitulo.setText("Consulta de Funcion de Espectaculo");
		lblTitulo.setBounds(10, 0, 400, 20);
		lblTitulo.setFont(new java.awt.Font("Comic Sans MS", 1, 17));
		miPanel.add(lblTitulo);

		lblPlataforma = new JLabel();
		lblPlataforma.setText("Plataforma");
		lblPlataforma.setBounds(10, 30, 200, 20);
		miPanel.add(lblPlataforma);

		comboPlataforma = new JComboBox<String>();
		comboPlataforma.setBounds(220, 30, 200, 20);
		comboPlataforma.addItemListener(this::listenerComboPlataforma);
		miPanel.add(comboPlataforma);

		lblEspectaculos = new JLabel();
		lblEspectaculos.setText("Espectaculos");
		lblEspectaculos.setBounds(10, 60, 200, 20);
		miPanel.add(lblEspectaculos);

		comboEspectaculos = new JComboBox<String>();
		comboEspectaculos.setBounds(220, 60, 200, 20);
		comboEspectaculos.addItemListener(this::listenerComboEspectaculo);
		miPanel.add(comboEspectaculos);

		lblFunciones = new JLabel();
		lblFunciones.setText("Funciones");
		lblFunciones.setBounds(10, 90, 200, 20);
		miPanel.add(lblFunciones);

		comboFunciones = new JComboBox<String>();
		comboFunciones.setBounds(220, 90, 200, 20);
		comboFunciones.addItemListener(this::listenerComboFunciones);
		miPanel.add(comboFunciones);

		lblPlataforma = new JLabel();
		lblPlataforma.setText("Datos De La Funcion");
		lblPlataforma.setBounds(10, 120, 250, 20);
		miPanel.add(lblPlataforma);

		txtDatosFuncion = new JTextArea();
		txtDatosFuncion.setTabSize(8);
		txtDatosFuncion.setBounds(220, 150, 300, 180);
		txtDatosFuncion.setFont(new java.awt.Font("Verdana", 1, 12));
		txtDatosFuncion.setOpaque(false);
		miPanel.add(txtDatosFuncion);

		jLabelImage = new JLabel();
		jLabelImage.setBounds(10, 155, 140, 140);
		miPanel.add(jLabelImage);
	}

	public void inicializarComboBox(){
		comboPlataforma.removeAllItems();
		comboEspectaculos.removeAllItems();
		comboFunciones.removeAllItems();

		comboPlataforma.addItem(SELECCIONE_PLAT);
		comboEspectaculos.addItem(SELECCIONE_ESP);
		comboFunciones.addItem(SELECCIONE_FUNC);

		iconP.listarPlataformasStr();
		listPlataformas.forEach((p) -> {
			comboPlataforma.addItem(p);
		});
	}

	private void listenerComboPlataforma(ItemEvent e){
		if(e.getStateChange() == ItemEvent.SELECTED){
			if(!e.getItem().equals(SELECCIONE_PLAT)){
				if(e.getSource() == comboPlataforma){
					String strPlataforma = this.comboPlataforma.getSelectedItem().toString();
					listEspectaculos = iconE.listarEspectaculos(strPlataforma);
					if(listEspectaculos.isEmpty()){
						JOptionPane.showMessageDialog(this, "La plataforma no tiene espectaculos asociados", "Error", JOptionPane.ERROR_MESSAGE);
						comboEspectaculos.removeAllItems();
						comboFunciones.removeAllItems();
						txtDatosFuncion.setText(null);
					}else{
						comboEspectaculos.removeAllItems();
						comboFunciones.removeAllItems();
						txtDatosFuncion.setText(null);

						comboEspectaculos.addItem(SELECCIONE_ESP);
						comboFunciones.addItem(SELECCIONE_FUNC);
						listEspectaculos.forEach((esp) -> {
							comboEspectaculos.addItem(esp.getNombre());
						});
					}
				}
			}
		}
	}

	private void listenerComboEspectaculo(ItemEvent e){
		if(e.getStateChange() == ItemEvent.SELECTED){
			if(!e.getItem().equals(SELECCIONE_ESP)){
				if(e.getSource() == comboEspectaculos){
					String strEspectaculo = this.comboEspectaculos.getSelectedItem().toString();
					listFunciones = iconF.listarFunciones(strEspectaculo);
					if(listFunciones.isEmpty()){
						JOptionPane.showMessageDialog(this, "El espectaculo no tiene funciones asociadas", "Error", JOptionPane.ERROR_MESSAGE);
						comboFunciones.removeAllItems();
						txtDatosFuncion.setText(null);
					}else{
						comboFunciones.removeAllItems();
						txtDatosFuncion.setText(null);

						comboFunciones.addItem(SELECCIONE_FUNC);
						listFunciones.forEach((f) -> {
							comboFunciones.addItem(f.getNombre());
						});
					}
				}
			}
		}
	}

	private void listenerComboFunciones(ItemEvent e){
		if(e.getStateChange() == ItemEvent.SELECTED){
			if(!e.getItem().equals(SELECCIONE_FUNC)){
				if(e.getSource() == comboFunciones){
					String strFuncion = this.comboFunciones.getSelectedItem().toString();
					int i = 0;
					String nombreFuncion;
					Funcion func = new Funcion();
					SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
					SimpleDateFormat formatoHora = new SimpleDateFormat("hh:mm");
					artistasInvitadosAFuncion = "";
					boolean encontre = false;
					while((i < this.listFunciones.size()) && (!encontre)){
						nombreFuncion = listFunciones.get(i).getNombre();
						if(nombreFuncion == strFuncion){
							encontre = true;
							DtFuncion dtFunc = listFunciones.get(i);
							listFunciones.get(i).getArtistas().forEach((a) -> {
								artistasInvitadosAFuncion += a + "\n";
							});
							txtDatosFuncion.setText("Nombre: " + dtFunc.getNombre() + "\nFecha: " + formatoFecha.format(dtFunc.getFecha()) + "\nFecha Alta: " + formatoFecha.format(dtFunc.getRegistro()) + "\nHora Inicio: " + formatoHora.format(dtFunc.getHoraInicio()) + "\n--------Artistas-------- \n" + artistasInvitadosAFuncion);
						}
						i++;
					}
					ManejadorFuncion mF = ManejadorFuncion.getInstancia();
					func = mF.buscarFuncion(strFuncion);

					byte[] b = func.getImagen();
					BufferedImage image = null;
					InputStream in = new ByteArrayInputStream(b);
				//System.out.println("IN: " + b);
					try{
						image = ImageIO.read(in);
					}catch(IOException e1){
						e1.printStackTrace();
					}
					ImageIcon imgi = new ImageIcon(image);
					Image imagei = imgi.getImage().getScaledInstance(jLabelImage.getWidth(), jLabelImage.getHeight(), Image.SCALE_SMOOTH);
					jLabelImage.setIcon(new ImageIcon(imagei));
					
				//	System.out.println("IN: " + );
				}
			}
		}
	}

	public void limpiarFormulario(){
		txtDatosFuncion.setText("");
	}

}
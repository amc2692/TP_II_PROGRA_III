package visual;



import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;

public class VentanaRegistros {

	public JFrame frame;
	public JTextField fieldVertice;
	public JTextField fieldLatitud;
	public JTextField fieldLongitud;
	public JTextField fieldOrigen;
	public JTextField fieldDestino;
	public JTextField fieldPeso;
	public JButton buttonSalir;
	public JButton buttonGuardarVertice;
	public JButton buttonGuardarArista;
	public JRadioButton buttonRadio;
	public JComboBox<String> boxUbicaciones;

	public VentanaRegistros() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 434, 348);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		buttonSalir = new JButton("SALIR");
		buttonSalir.setBounds(176, 276, 70, 22);
		frame.getContentPane().add(buttonSalir);
		
		fieldVertice = new JTextField();
		fieldVertice.setBounds(10, 35, 86, 20);
		frame.getContentPane().add(fieldVertice);
		fieldVertice.setColumns(10);
		
		fieldLatitud = new JTextField();
		fieldLatitud.setBounds(10, 76, 86, 20);
		frame.getContentPane().add(fieldLatitud);
		fieldLatitud.setColumns(10);
		
		fieldLongitud = new JTextField();
		fieldLongitud.setBounds(10, 114, 86, 20);
		frame.getContentPane().add(fieldLongitud);
		fieldLongitud.setColumns(10);
		
		buttonGuardarVertice = new JButton("GUARDAR");
		buttonGuardarVertice.setBounds(7, 153, 89, 23);
		frame.getContentPane().add(buttonGuardarVertice);
		
		fieldOrigen = new JTextField();
		fieldOrigen.setBounds(308, 35, 86, 20);
		frame.getContentPane().add(fieldOrigen);
		fieldOrigen.setColumns(10);
		
		fieldDestino = new JTextField();
		fieldDestino.setBounds(308, 76, 86, 20);
		frame.getContentPane().add(fieldDestino);
		fieldDestino.setColumns(10);
		
		buttonGuardarArista = new JButton("GUARDAR");
		buttonGuardarArista.setBounds(308, 153, 89, 23);
		frame.getContentPane().add(buttonGuardarArista);
		
		buttonRadio = new JRadioButton("");
		buttonRadio.setBounds(213, 76, 21, 23);
		frame.getContentPane().add(buttonRadio);
		
		boxUbicaciones = new JComboBox<String>();
		boxUbicaciones.setBounds(108, 75, 99, 22);
		frame.getContentPane().add(boxUbicaciones);
		
		JLabel lblNewLabel = new JLabel("Vertice");
		lblNewLabel.setBounds(10, 15, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Latitud");
		lblNewLabel_1.setBounds(10, 61, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Longitud");
		lblNewLabel_2.setBounds(10, 99, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Ubicacion");
		lblNewLabel_3.setBounds(106, 61, 101, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Vertice Origen");
		lblNewLabel_4.setBounds(308, 21, 86, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Vertice Destino");
		lblNewLabel_5.setBounds(308, 61, 86, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		fieldPeso = new JTextField();
		fieldPeso.setBounds(308, 114, 46, 20);
		frame.getContentPane().add(fieldPeso);
		fieldPeso.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Peso");
		lblNewLabel_6.setBounds(308, 99, 86, 14);
		frame.getContentPane().add(lblNewLabel_6);
		
		frame.setVisible(true);
	}
}

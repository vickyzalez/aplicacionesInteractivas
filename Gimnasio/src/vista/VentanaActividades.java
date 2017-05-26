package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class VentanaActividades extends JDialog {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaActividades frame = new VentanaActividades();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public VentanaActividades() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("ABM Actividades");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(70, 39, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(70, 70, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(70, 122, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(187, 122, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JTextPane txtpnNombre = new JTextPane();
		txtpnNombre.setText("Nombre");
		txtpnNombre.setBounds(10, 39, 50, 20);
		contentPane.add(txtpnNombre);
		
		JTextPane txtpnDa = new JTextPane();
		txtpnDa.setText("D\u00EDa");
		txtpnDa.setBounds(10, 70, 50, 20);
		contentPane.add(txtpnDa);
		
		JTextPane txtpnHasta = new JTextPane();
		txtpnHasta.setText("hasta");
		txtpnHasta.setBounds(157, 122, 35, 20);
		contentPane.add(txtpnHasta);
		
		JTextPane txtpnDesde = new JTextPane();
		txtpnDesde.setText("Desde");
		txtpnDesde.setBounds(31, 122, 40, 20);
		contentPane.add(txtpnDesde);
		
		JTextPane txtpnHorario = new JTextPane();
		txtpnHorario.setText("Horario");
		txtpnHorario.setBounds(10, 101, 58, 20);
		contentPane.add(txtpnHorario);
	}
}

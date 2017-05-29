package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class VentanaAbonos extends JDialog {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaAbonos frame = new VentanaAbonos();
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
	public VentanaAbonos() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("ABM Abono");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(76, 44, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(76, 75, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(76, 106, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JTextPane txtpnNombre = new JTextPane();
		txtpnNombre.setText("Nombre");
		txtpnNombre.setBounds(10, 44, 56, 20);
		contentPane.add(txtpnNombre);
		
		JTextPane txtpnPrecio = new JTextPane();
		txtpnPrecio.setText("Precio");
		txtpnPrecio.setBounds(10, 75, 56, 20);
		contentPane.add(txtpnPrecio);
		
		JTextPane txtpnVigencia = new JTextPane();
		txtpnVigencia.setText("Vigencia");
		txtpnVigencia.setBounds(10, 106, 56, 20);
		contentPane.add(txtpnVigencia);
	}

}

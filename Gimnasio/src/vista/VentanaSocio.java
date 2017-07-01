package vista;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import controladores.ControladorSocios;
import modelo.Socio;

public class VentanaSocio extends JDialog {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaSocio frame = new VentanaSocio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaSocio() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("ABM Socio");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		ControladorSocios cs = ControladorSocios.getInstancia();

		textField = new JTextField();
		textField.setBounds(73, 42, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(73, 73, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(73, 104, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(73, 135, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setBounds(73, 166, 86, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);

		textField_5 = new JTextField();
		textField_5.setBounds(73, 197, 86, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		JTextPane txtpnDni = new JTextPane();
		txtpnDni.setText("DNI");
		txtpnDni.setBounds(10, 42, 53, 20);
		contentPane.add(txtpnDni);

		JTextPane txtpnNombre = new JTextPane();
		txtpnNombre.setText("Nombre");
		txtpnNombre.setBounds(10, 73, 53, 20);
		contentPane.add(txtpnNombre);

		JTextPane txtpnApellido = new JTextPane();
		txtpnApellido.setText("Apellido");
		txtpnApellido.setBounds(10, 104, 53, 20);
		contentPane.add(txtpnApellido);

		JTextPane txtpnDomicilio = new JTextPane();
		txtpnDomicilio.setText("Domicilio");
		txtpnDomicilio.setBounds(10, 135, 53, 20);
		contentPane.add(txtpnDomicilio);

		JTextPane txtpnTelefono = new JTextPane();
		txtpnTelefono.setText("Telefono");
		txtpnTelefono.setBounds(10, 166, 53, 20);
		contentPane.add(txtpnTelefono);

		JTextPane txtpnMail = new JTextPane();
		txtpnMail.setText("Mail");
		txtpnMail.setBounds(10, 197, 53, 20);
		contentPane.add(txtpnMail);

		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(56, 228, 89, 23);
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int vl_dni = 0;
				int vl_telefono = 0;
				int vl_ok = 0;

				//              Validacion sobre campos ingresados
				while (vl_ok == 0){
					try {
						vl_dni = Integer.parseInt(textField.getText());
						vl_ok = 1;
					} catch (NumberFormatException e1) {
						JOptionPane.showMessageDialog(null, "Ingrese solo numeros en el dni");
						vl_ok = 0;
					}

					try {
						vl_telefono = Integer.parseInt(textField_4.getText());
						vl_ok = 1;
					} catch (NumberFormatException e2) {
						JOptionPane.showMessageDialog(null, "Ingrese solo numeros en el telefono");
						vl_ok = 0;
					}
				}

				cs.altaSocio(vl_dni, textField_1.getText(),  textField_2.getText(), 
						textField_3.getText(), vl_telefono, textField_5.getText());
				dispose();
			}
		});
		contentPane.add(btnAgregar);

		JButton btnNewButton = new JButton("Modificar");
		btnNewButton.setBounds(144, 228, 89, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int vl_dni = 0;
				int vl_telefono = 0;
				int vl_ok = 0;

				//              Validacion sobre campos ingresados
				while (vl_ok == 0){
					try {
						vl_dni = Integer.parseInt(textField.getText());
						vl_ok = 1;
					} catch (NumberFormatException e1) {  
						JOptionPane.showMessageDialog(null, "Ingrese solo numeros en el dni");
						vl_ok = 0; 
					}

					try {
						vl_telefono = Integer.parseInt(textField_4.getText());
						vl_ok = 1;
					} catch (NumberFormatException e2) {
						JOptionPane.showMessageDialog(null, "Ingrese solo numeros en el telefono");
						vl_ok = 0;
					}
				}

				cs.modificarSocio(vl_dni, textField_1.getText(),  textField_2.getText(), 
						textField_3.getText(), vl_telefono, textField_5.getText());
				dispose();
			}
		});
		contentPane.add(btnNewButton);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(320, 228, 89, 23);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		contentPane.add(btnCancelar);

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(232, 228, 89, 23);
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int vl_dni = 0;
				int vl_telefono = 0;
				int vl_ok = 0;

				//              Validacion sobre campos ingresados
				while (vl_ok == 0){
					try {
						vl_dni = Integer.parseInt(textField.getText());
						vl_ok = 1;
					} catch (NumberFormatException e1) {
						JOptionPane.showMessageDialog(null, "Ingrese solo numeros en el dni");
						vl_ok = 0;
					}
				}

				cs.bajaSocio(vl_dni);
				dispose();
			}
		});
		contentPane.add(btnEliminar);


		JList lista = new JList();
		DefaultListModel modelo = new DefaultListModel();
		String valor= null;
		Vector<Socio> vectorSocios = cs.getSocios();
		if (vectorSocios.size() > 0){

			for(int i=0; i < vectorSocios.size(); i++ ){
				valor = vectorSocios.get(i).getApellido();
				modelo.addElement(valor);
			}
		}

		lista.setModel(modelo);
		lista.setBounds(180, 41, 244, 176);
		contentPane.add(lista);

	}
}

package vista;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import controladores.FachadaMolinete;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class Fachada extends javax.swing.JFrame implements ActionListener{
	private JDesktopPane contenedor;
	private JTextField TEXTODNI;
	private JButton INGRESAR;
	private JLabel ingreso;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Fachada inst = new Fachada();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public Fachada() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			this.setTitle("Ingresar Gimnasio");
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				contenedor = new JDesktopPane();
				getContentPane().add(contenedor, BorderLayout.CENTER);
				{
					ingreso = new JLabel();
					contenedor.add(ingreso);
					ingreso.setText("Ingrese el DNI: ");
					ingreso.setBounds(49, 59, 113, 16);
				}
				{
					TEXTODNI = new JTextField();
					contenedor.add(TEXTODNI);
					TEXTODNI.setBounds(194, 56, 105, 23);
				}
				{
					INGRESAR = new JButton();
					contenedor.add(INGRESAR);
					INGRESAR.setText("Ingresar");
					INGRESAR.setBounds(194, 141, 105, 23);
					INGRESAR.addActionListener(this);
				}
			}
			pack();
			this.setSize(476, 300);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == INGRESAR){
			FachadaMolinete fm = new FachadaMolinete();
			boolean ok = fm.validarIngreso(Integer.parseInt(this.TEXTODNI.getText()));
			if (ok == true){
				JOptionPane.showMessageDialog(null, "Validacion Correcta");
			}else{
				JOptionPane.showMessageDialog(null, "No puede Ingresar al Gimnasio");
			}
		}
		
	}

}

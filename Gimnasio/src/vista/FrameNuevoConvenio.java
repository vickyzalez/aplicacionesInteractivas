package vista;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import controladores.ControladorAdministrativo;


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
public class FrameNuevoConvenio extends javax.swing.JFrame implements ActionListener {
	private JDesktopPane contenedor;
	private JButton guardar;
	private JTextField TEXTNOMBRE;
	private JLabel nombre;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				FrameNuevoConvenio inst = new FrameNuevoConvenio();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public FrameNuevoConvenio() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				contenedor = new JDesktopPane();
				getContentPane().add(contenedor, BorderLayout.CENTER);
				contenedor.setPreferredSize(new java.awt.Dimension(310, 172));
				{
					nombre = new JLabel();
					contenedor.add(nombre);
					nombre.setText("NOMBRE: ");
					nombre.setBounds(38, 36, 73, 16);
				}
				{
					TEXTNOMBRE = new JTextField();
					contenedor.add(TEXTNOMBRE);
					TEXTNOMBRE.setBounds(123, 33, 107, 23);
				}
				{
					guardar = new JButton();
					contenedor.add(guardar);
					guardar.setText("GUARDAR");
					guardar.setBounds(38, 111, 93, 23);
					guardar.addActionListener(this);
				}
			}
			pack();
			this.setSize(326, 214);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == guardar){
		   ControladorAdministrativo a = ControladorAdministrativo.getInstancia();
		   a.altaEmpresa(this.TEXTNOMBRE.getText());
			
			this.setVisible(false);
		}
		
	}

}

package vista;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

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
public class NuevoABONO extends javax.swing.JFrame implements ActionListener {
	private JDesktopPane CONTENEDOR;
	private JLabel PRECIO;
	private JButton salir;
	private JButton GUARDAR;
	private JTextField TEXETVIGENCIA;
	private JTextField TEXTPRECIO;
	private JTextField TEXTNOMBRE;
	private JLabel VIGENCIA;
	private JLabel NOMBRE;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				NuevoABONO inst = new NuevoABONO();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public NuevoABONO() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			this.setTitle("Agregar Nuevo Abono");
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				CONTENEDOR = new JDesktopPane();
				getContentPane().add(CONTENEDOR, BorderLayout.CENTER);
				{
					NOMBRE = new JLabel();
					CONTENEDOR.add(NOMBRE);
					NOMBRE.setText("NOMBRE :");
					NOMBRE.setBounds(33, 46, 100, 15);
				}
				{
					PRECIO = new JLabel();
					CONTENEDOR.add(PRECIO);
					PRECIO.setText("PRECIO : ");
					PRECIO.setBounds(33, 85, 66, 27);
				}
				{
					VIGENCIA = new JLabel();
					CONTENEDOR.add(VIGENCIA);
					VIGENCIA.setText("VIGENCIA: ");
					VIGENCIA.setBounds(33, 135, 66, 16);
				}
				{
					TEXTNOMBRE = new JTextField();
					CONTENEDOR.add(TEXTNOMBRE);
					TEXTNOMBRE.setBounds(118, 42, 86, 23);
				}
				{
					TEXTPRECIO = new JTextField();
					CONTENEDOR.add(TEXTPRECIO);
					TEXTPRECIO.setBounds(117, 87, 87, 23);
				}
				{
					TEXETVIGENCIA = new JTextField();
					CONTENEDOR.add(TEXETVIGENCIA);
					TEXETVIGENCIA.setBounds(117, 132, 87, 23);
				}
				{
					GUARDAR = new JButton();
					CONTENEDOR.add(GUARDAR);
					GUARDAR.setText("GUARDAR");
					GUARDAR.setBounds(117, 190, 101, 23);
					GUARDAR.addActionListener(this);
				}
				{
					salir = new JButton();
					CONTENEDOR.add(salir);
					salir.setText("SALIR ");
					salir.setBounds(259, 228, 74, 23);
					salir.addActionListener(this);
				}
			}
			pack();
			this.setSize(369, 300);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==GUARDAR){
			ControladorAdministrativo a = ControladorAdministrativo.getInstancia();
			a.altaAbono(this.TEXTNOMBRE.getText(),Float.parseFloat(this.TEXTPRECIO.getText()),Date.valueOf(this.TEXETVIGENCIA.getText()));
		}
		if(e.getSource()==salir){
			this.setVisible(false);
			
		}
	}

}

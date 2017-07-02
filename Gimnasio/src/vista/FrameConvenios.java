package vista;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;


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
public class FrameConvenios extends javax.swing.JFrame implements ActionListener {
	private JDesktopPane contenedor;
	private JButton salir;
	private JButton NUEVO;
	private JButton eliminar;
	private JComboBox empresas;
	private JLabel nombre;
	private JLabel titulo;
	private static FrameConvenios inst=null;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				FrameConvenios inst = new FrameConvenios();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public static FrameConvenios getFrameConvenios(){
		if(inst ==null){
			inst = new  FrameConvenios();
		}
		return inst;
	}
	
	private FrameConvenios() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				contenedor = new JDesktopPane();
				getContentPane().add(contenedor, BorderLayout.CENTER);
				{
					titulo = new JLabel();
					contenedor.add(titulo);
					titulo.setText("Empresas Convenio");
					titulo.setBounds(171, 26, 168, 16);
				}
				{
					nombre = new JLabel();
					contenedor.add(nombre);
					nombre.setText("NOMBRE: ");
					nombre.setBounds(53, 88, 113, 19);
				}
				{
					ComboBoxModel empresasModel = 
							new DefaultComboBoxModel(
									new String[] { "Item One", "Item Two" });
					empresas = new JComboBox();
					contenedor.add(empresas);
					empresas.setModel(empresasModel);
					empresas.setBounds(129, 88, 122, 23);
				}
				{
					eliminar = new JButton();
					contenedor.add(eliminar);
					eliminar.setText("ELIMINAR");
					eliminar.setBounds(294, 88, 147, 23);
					eliminar.addActionListener(this);
				}
				{
					NUEVO = new JButton();
					contenedor.add(NUEVO);
					NUEVO.setText("NUEVA EMPRESA");
					NUEVO.setBounds(294, 142, 147, 23);
					NUEVO.addActionListener(this);
				}
				{
					salir = new JButton();
					contenedor.add(salir);
					salir.setText("SALIR");
					salir.setBounds(360, 219, 76, 23);
					salir.addActionListener(this);
				}
			}
			pack();
			this.setSize(490, 297);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == eliminar){
			
		}
		if(e.getSource()==NUEVO){
			FrameNuevoConvenio f = new FrameNuevoConvenio();
			f.setVisible(true);
		}
		if(e.getSource() == salir){
			
			FrameAdministracion a = FrameAdministracion.getAdministracion();
			a.setVisible(true);
			this.setVisible(false);
		}
	}

}

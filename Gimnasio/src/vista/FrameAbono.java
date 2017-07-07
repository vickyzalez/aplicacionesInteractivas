package vista;
import java.awt.BorderLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;

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
public class FrameAbono extends javax.swing.JFrame implements ActionListener {
	private JDesktopPane contenedor;
	private JButton salir;
	private JButton NUEVO;
	private JButton eliminar;
	private JComboBox abonos;
	private JLabel nombre;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				FrameAbono inst = new FrameAbono();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public FrameAbono() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			this.setTitle("Gestion Abonos");
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				contenedor = new JDesktopPane();
				getContentPane().add(contenedor, BorderLayout.CENTER);
				{
					nombre = new JLabel();
					contenedor.add(nombre);
					nombre.setBounds(33, 38, 98, 16);
					nombre.setText("ABONOS: ");
				}
				{
					
					abonos = new JComboBox();
					
					ControladorAdministrativo adm = ControladorAdministrativo.getInstancia();
					List<String> IdABONOS = adm.abonosview();
					
					for(Iterator<String> i = IdABONOS.iterator();i.hasNext();){
						abonos.addItem(i.next());
					}
					
					contenedor.add(abonos);
					
					abonos.setBounds(103, 35, 132, 23);
				}
				{
					eliminar = new JButton();
					contenedor.add(eliminar);
					eliminar.setText("ELIMINAR ");
					eliminar.setBounds(287, 35, 122, 23);
					eliminar.addActionListener(this);
				}
				{
					NUEVO = new JButton();
					contenedor.add(NUEVO);
					NUEVO.setText("NUEVO ABONO");
					NUEVO.setBounds(287, 88, 122, 23);
					NUEVO.addActionListener(this);
				}
				{
					salir = new JButton();
					contenedor.add(salir);
					salir.setText("SALIR");
					salir.setBounds(324, 183, 81, 23);
					salir.addActionListener(this);
				}
			}
			pack();
			this.setSize(555, 274);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==salir){
			FrameAdministracion a = FrameAdministracion.getAdministracion();
			a.setVisible(true);
			this.setVisible(false);
		}
		if(e.getSource()== eliminar){
			ControladorAdministrativo adm = ControladorAdministrativo.getInstancia();
			adm.bajaAbono(Integer.parseInt(String.valueOf(this.abonos.getSelectedItem())));
			
			
		}
		if(e.getSource()==NUEVO){
			NuevoABONO a = new NuevoABONO();
			a.setVisible(true);
		}
		
	}

}

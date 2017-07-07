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

import controladores.ControladorDeportes;


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
public class BajaClase extends javax.swing.JFrame implements ActionListener{
	private JDesktopPane contenedor;
	private JButton salir;
	private JButton quitar;
	private JComboBox clasess;
	private JLabel IDCLASE;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				BajaClase inst = new BajaClase();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public BajaClase() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			this.setTitle("Quitar Clase");
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				contenedor = new JDesktopPane();
				getContentPane().add(contenedor, BorderLayout.CENTER);
				{
					IDCLASE = new JLabel();
					contenedor.add(IDCLASE);
					IDCLASE.setText("ID Clase: ");
					IDCLASE.setBounds(49, 61, 70, 16);
				}
				{
					clasess = new JComboBox();
				//	ControladorDeportes dep = ControladorDeportes.getInstancia();
				//	List<String> idclas = dep.IdClases();
				//	for(Iterator<String> i=idclas.iterator();i.hasNext();){
				//		clasess.addItem(i.next());
				//	}
					
					contenedor.add(clasess);
					clasess.setBounds(150, 54, 100, 23);
				}
				{
					quitar = new JButton();
					contenedor.add(quitar);
					quitar.setText("Borrar Clase");
					quitar.setBounds(150, 122, 116, 23);
					quitar.addActionListener(this);
				}
				{
					salir = new JButton();
					contenedor.add(salir);
					salir.setText("Salir");
					salir.setBounds(300, 122, 95, 23);
					salir.addActionListener(this);
				}
			}
			pack();
			this.setSize(466, 211);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == this.quitar){
			ControladorDeportes dep = ControladorDeportes.getInstancia();
			dep.bajaClase(Integer.parseInt(String.valueOf(this.clasess.getSelectedItem())));
		}
		if(e.getSource() == salir){
			this.setVisible(false);
		}
	}

}

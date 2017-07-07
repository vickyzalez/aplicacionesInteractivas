package vista;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;
import javax.swing.JButton;

import javax.swing.JDesktopPane;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;

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
public class VerRecibo extends javax.swing.JFrame implements ActionListener{
	private JDesktopPane contenedor;
	private JLabel descripcion;
	private JButton salir;
	private JEditorPane loadRecibos;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				VerRecibo inst = new VerRecibo();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public VerRecibo() {
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
					descripcion = new JLabel();
					contenedor.add(descripcion);
					descripcion.setText("Se generaron los siguientes recibos: ");
					descripcion.setBounds(45, 33, 244, 39);
				}
				{
					loadRecibos = new JEditorPane();
					contenedor.add(loadRecibos);
				//	ControladorAdministrativo adm = ControladorAdministrativo.getInstancia();
				//	List<String>  reciboss = adm.idRecibos();
				//	for(Iterator<String> i= reciboss.iterator();i.hasNext();){
				//		loadRecibos.setText(i.next());
				//	}
					loadRecibos.setBounds(45, 84, 318, 166);
				}
				{
					salir = new JButton();
					contenedor.add(salir);
					salir.setText("Salir");
					salir.setBounds(452, 220, 79, 23);
					salir.addActionListener(this);
				}
			}
			pack();
			this.setSize(610, 300);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == salir){
			Menu m = Menu.getMenu();
			m.setVisible(true);
			this.setVisible(false);
		}
		
	}

}

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
public class Cronograma extends javax.swing.JFrame implements ActionListener{
	private JDesktopPane contenedor;
	private JButton salir;
	private JEditorPane contenidoCrono;
	private JLabel verCronograma;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Cronograma inst = new Cronograma();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public Cronograma() {
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
					verCronograma = new JLabel();
					contenedor.add(verCronograma);
					verCronograma.setText("Ver Cronograma");
					verCronograma.setBounds(54, 34, 141, 16);
				}
				{
					contenidoCrono = new JEditorPane();
					ControladorDeportes dep = ControladorDeportes.getInstancia();
					List<String> info = dep.MostrarCronograma();
					
					for(Iterator<String> i = info.iterator();i.hasNext();){
						contenidoCrono.setText(i.next());
					}
					contenedor.add(contenidoCrono);
					contenidoCrono.setBounds(54, 78, 376, 166);
				}
				{
					salir = new JButton();
					contenedor.add(salir);
					salir.setText("Salir");
					salir.setBounds(514, 221, 77, 23);
					salir.addActionListener(this);
				}
			}
			pack();
			this.setSize(646, 300);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==salir){
			Menu m = Menu.getMenu();
			m.setVisible(true);
			this.setVisible(false);
		}
		
	}

}

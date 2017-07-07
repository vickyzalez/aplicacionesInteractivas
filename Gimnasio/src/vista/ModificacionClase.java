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
import javax.swing.JTextField;

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
public class ModificacionClase extends javax.swing.JFrame implements ActionListener{
	private JDesktopPane contenedor;
	private JLabel IdClase;
	private JLabel hasta;
	private JButton salir;
	private JButton guardar;
	private JComboBox diass;
	private JLabel idDia;
	private JTextField texethasta;
	private JTextField TEXTDE;
	private JLabel de;
	private JLabel horario;
	private JComboBox clases;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ModificacionClase inst = new ModificacionClase();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public ModificacionClase() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			this.setTitle("Modificar Clase");
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				contenedor = new JDesktopPane();
				getContentPane().add(contenedor, BorderLayout.CENTER);
				{
					IdClase = new JLabel();
					contenedor.add(IdClase);
					IdClase.setText("ID Clase: ");
					IdClase.setBounds(43, 46, 78, 16);
				}
				{
					clases = new JComboBox();
				//	ControladorDeportes dep = ControladorDeportes.getInstancia();
				//	List<String> idclasess = dep.IdClases();
					
				//	for(Iterator<String> i=idclasess.iterator();i.hasNext();){
				//		clases.addItem(i.next());
				//	}
					
					
					contenedor.add(clases);
					
					clases.setBounds(133, 43, 109, 23);
				}
				{
					horario = new JLabel();
					contenedor.add(horario);
					horario.setText("Horario");
					horario.setBounds(43, 103, 69, 16);
				}
				{
					de = new JLabel();
					contenedor.add(de);
					de.setText("De: ");
					de.setBounds(130, 103, 25, 16);
				}
				{
					TEXTDE = new JTextField();
					contenedor.add(TEXTDE);
					TEXTDE.setBounds(173, 100, 69, 23);
				}
				{
					hasta = new JLabel();
					contenedor.add(hasta);
					hasta.setText("Hasta: ");
					hasta.setBounds(277, 103, 59, 16);
				}
				{
					texethasta = new JTextField();
					contenedor.add(texethasta);
					texethasta.setBounds(354, 100, 78, 23);
				}
				{
					idDia = new JLabel();
					contenedor.add(idDia);
					idDia.setText("ID Dia:");
					idDia.setBounds(43, 169, 49, 16);
				}
				{
					diass = new JComboBox();
				//	ControladorDeportes dep = ControladorDeportes.getInstancia();
				//	List<String> iddiass = dep.idDias();
				//	for(Iterator<String> i=iddiass.iterator();i.hasNext();){
				//		diass.addItem(i.next());
				//	}
					
					contenedor.add(diass);
				
					diass.setBounds(133, 166, 109, 23);
				}
				{
					guardar = new JButton();
					contenedor.add(guardar);
					guardar.setText("Guardar");
					guardar.setBounds(289, 217, 81, 26);
					guardar.addActionListener(this);
				}
				{
					salir = new JButton();
					contenedor.add(salir);
					salir.setText("Salir");
					salir.setBounds(390, 216, 77, 27);
					salir.addActionListener(this);
				}
			}
			pack();
			this.setSize(561, 300);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == guardar){
			ControladorDeportes dep = ControladorDeportes.getInstancia();
			dep.modificarClase(Integer.parseInt(String.valueOf(this.clases.getSelectedItem())), Integer.parseInt(this.TEXTDE.getText()), Integer.parseInt(this.texethasta.getText()),Integer.parseInt(String.valueOf(this.diass.getSelectedItem())));
			
		}
		if(e.getSource() == salir){
			this.setVisible(false);
		}
	}

}

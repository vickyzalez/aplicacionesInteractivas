package vista;
import java.awt.BorderLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
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
public class FrameAdministracion extends javax.swing.JFrame implements ActionListener{
	private JDesktopPane contenedor;
	private JButton salir;
	private JButton abonos;
	private JButton personal;
	private JButton convenios;
	private JLabel Administracion;
    private static FrameAdministracion inst=null;
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				FrameAdministracion inst = new FrameAdministracion();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	
	public static FrameAdministracion getAdministracion(){
		if(inst == null){
			inst = new FrameAdministracion();
		}
		return inst;
	}
	private FrameAdministracion() {
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
					Administracion = new JLabel();
					contenedor.add(Administracion);
					Administracion.setText("Administracion");
					Administracion.setBounds(151, 25, 139, 16);
				
				}
				{
					convenios = new JButton();
					contenedor.add(convenios);
					convenios.setText("Gestion Empresas Convenios");
					convenios.setBounds(91, 91, 217, 34);
					convenios.addActionListener(this);
				}
				{
					personal = new JButton();
					contenedor.add(personal);
					personal.setText("Gestion Empleados");
					personal.setBounds(91, 136, 217, 34);
					personal.addActionListener(this);
				}
				{
					abonos = new JButton();
					contenedor.add(abonos);
					abonos.setText("Gestion Abonos");
					abonos.setBounds(91, 181, 217, 29);
					abonos.addActionListener(this);
				}
				{
					salir = new JButton();
					contenedor.add(salir);
					salir.setText("SALIR ");
					salir.setBounds(151, 269, 93, 22);
					salir.addActionListener(this);
				}
			}
			pack();
			this.setSize(413, 341);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==convenios){
			FrameConvenios f = FrameConvenios.getFrameConvenios();
			f.setVisible(true);
			this.setVisible(false);
		}
		if(e.getSource()==this.personal){
			
		}
		if(e.getSource()==this.abonos){
			
		}
		if(e.getSource()==salir){
			this.setVisible(false);
		}
		
	}

}

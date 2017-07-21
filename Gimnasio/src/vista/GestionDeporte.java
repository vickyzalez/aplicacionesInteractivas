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
public class GestionDeporte extends javax.swing.JFrame implements ActionListener{
	private JDesktopPane contenedor;
	private JButton bajadeporte;
	private JTextField texttitulo;
	private JLabel descripcion;
	private JButton salir;
	private JButton gestionarActividad;
	private JTextField textdescripcion;
	private JLabel titulo;
	private JTextField textdeporte;
	private JLabel iddeporte;
	private JButton modificaciondeporte;
	private JButton altadeporte;
	private JLabel deportes;
    private static GestionDeporte dep = null;
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				GestionDeporte inst = new GestionDeporte();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public static GestionDeporte getDeporte(){
		if(dep == null){
			dep = new GestionDeporte();
		}
		return dep;
	}
	
	
	private GestionDeporte() {
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
					deportes = new JLabel();
					contenedor.add(deportes);
					deportes.setText("Deporte");
					deportes.setBounds(113, 21, 88, 16);
				}
				{
					altadeporte = new JButton();
					contenedor.add(altadeporte);
					altadeporte.setText("Alta Deporte");
					altadeporte.setBounds(83, 242, 150, 24);
					altadeporte.addActionListener(this);
				}
				{
					bajadeporte = new JButton();
					contenedor.add(bajadeporte);
					bajadeporte.setText("Baja Deporte");
					bajadeporte.setBounds(193, 242, 116, 24);
					bajadeporte.addActionListener(this);
				}
				{
					modificaciondeporte = new JButton();
					contenedor.add(modificaciondeporte);
					modificaciondeporte.setText("Modif Deporte");
					modificaciondeporte.setBounds(309, 242, 130, 24);
					modificaciondeporte.addActionListener(this);
				}
				{
					iddeporte = new JLabel();
					contenedor.add(iddeporte);
					iddeporte.setText("Id Deporte:");
					iddeporte.setBounds(40, 80, 73, 16);
				}
				{
					textdeporte = new JTextField();
					contenedor.add(textdeporte);
					textdeporte.setBounds(125, 76, 89, 24);
				}
				{
					titulo = new JLabel();
					contenedor.add(titulo);
					titulo.setText("Titulo: ");
					titulo.setBounds(40, 125, 59, 16);
				}
				{
					texttitulo = new JTextField();
					contenedor.add(texttitulo);
					texttitulo.setBounds(125, 121, 89, 24);
				}
				{
					descripcion = new JLabel();
					contenedor.add(descripcion);
					descripcion.setText("Descripcion: ");
					descripcion.setBounds(40, 169, 73, 17);
				}
				{
					textdescripcion = new JTextField();
					contenedor.add(textdescripcion);
					textdescripcion.setBounds(125, 163, 89, 23);
				}
				{
					gestionarActividad = new JButton();
					contenedor.add(gestionarActividad);
					gestionarActividad.setText("Gestionar Actividad");
					gestionarActividad.setBounds(282, 111, 157, 30);
					gestionarActividad.addActionListener(this);
				}
				
				{
					salir = new JButton();
					contenedor.add(salir);
					salir.setText("Salir");
					salir.setBounds(452, 241, 90, 24);
					salir.addActionListener(this);
				}
			}
			pack();
			this.setSize(565, 327);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == altadeporte){
			ControladorDeportes conDep = ControladorDeportes.getInstancia();
			conDep.altaDeporte(Integer.parseInt(this.textdeporte.getText()), this.texttitulo.getText(), this.textdescripcion.getText());
			
		}
		if(e.getSource() == this.bajadeporte){
			ControladorDeportes dep = ControladorDeportes.getInstancia();
			dep.bajaDeporte(Integer.parseInt(this.textdeporte.getText()));
		}
		if(e.getSource() == this.modificaciondeporte){
			ControladorDeportes dep = ControladorDeportes.getInstancia();
			dep.modificarDeporte(Integer.parseInt(this.textdeporte.getText()), this.texttitulo.getText(), this.textdescripcion.getText());
		}
		if(e.getSource() == this.gestionarActividad){
			GestionarActividad ga = GestionarActividad.getActividad();
			ga.setIdDeporte(this.textdeporte.getText());
			ga.setVisible(true);
			this.setVisible(false);
		}
		if(e.getSource() == salir){
			Menu m = Menu.getMenu();
			m.setVisible(true);
			this.setVisible(false);
		}
		
	}

}

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
public class GestionClase extends javax.swing.JFrame implements ActionListener {
	private JDesktopPane contenedor;
	private JLabel de;
	private JButton salir;
	private JButton guardar;
	private JLabel jLabel1;
	private JComboBox dias;
	private JTextField texthast;
	private JLabel hast;
	private JTextField desde;
	private JLabel horario;
	private JComboBox IdClases;
	private JLabel idClase;
	private JTextField textIdActividad;
	private JLabel idActividad;
	private static GestionClase instancia=null;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				GestionClase inst = new GestionClase();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public static GestionClase getClase(){
		if(instancia == null){
			instancia = new GestionClase();
		}
		return instancia;
	}
	
	private GestionClase() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			this.setTitle("Agregar Clase");
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				contenedor = new JDesktopPane();
				getContentPane().add(contenedor, BorderLayout.CENTER);
				{
					idActividad = new JLabel();
					contenedor.add(idActividad);
					idActividad.setText("ID Actividad ");
					idActividad.setBounds(43, 50, 104, 16);
				}
				{
					textIdActividad = new JTextField();
					contenedor.add(textIdActividad);
					textIdActividad.setBounds(165, 47, 93, 23);
				}
				{
					idClase = new JLabel();
					contenedor.add(idClase);
					idClase.setText("ID Clase");
					idClase.setBounds(43, 120, 72, 16);
				}
				{
					IdClases = new JComboBox();
					ControladorDeportes dep = ControladorDeportes.getInstancia();
					List<String> clases = dep.IdClases();
					for(Iterator<String> i= clases.iterator();i.hasNext();){
						IdClases.addItem(i.next());
					}
					
					contenedor.add(IdClases);
				
					IdClases.setBounds(165, 113, 93, 23);
				}
				{
					horario = new JLabel();
					contenedor.add(horario);
					horario.setText("Horario");
					horario.setBounds(43, 177, 82, 16);
				}
				{
					de = new JLabel();
					contenedor.add(de);
					de.setText("De: ");
					de.setBounds(143, 177, 30, 16);
				}
				{
					desde = new JTextField();
					contenedor.add(desde);
					desde.setBounds(185, 170, 95, 23);
				}
				{
					hast = new JLabel();
					contenedor.add(hast);
					hast.setText("Hasta:");
					hast.setBounds(318, 173, 63, 16);
				}
				{
					texthast = new JTextField();
					contenedor.add(texthast);
					texthast.setBounds(376, 170, 80, 23);
				}
				{
					
					dias = new JComboBox();
					
					ControladorDeportes dep =ControladorDeportes.getInstancia();
					List<String> Iddias = dep.idDias();
					for(Iterator<String> i= Iddias.iterator();i.hasNext();){
						dias.addItem(i.next());
					}
					contenedor.add(dias);
					dias.setBounds(376, 46, 88, 27);
				}
				{
					jLabel1 = new JLabel();
					contenedor.add(jLabel1);
					jLabel1.setText("Dia");
					jLabel1.setBounds(318, 50, 34, 16);
				}
				{
					guardar = new JButton();
					contenedor.add(guardar);
					guardar.setText("Guardar");
					guardar.setBounds(491, 218, 83, 23);
					guardar.addActionListener(this);
				}
				{
					salir = new JButton();
					contenedor.add(salir);
					salir.setText("Salir");
					salir.setBounds(600, 218, 74, 23);
					salir.addActionListener(this);
				}
			}
			pack();
			this.setSize(719, 300);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setIdActividad(String IDacT){
		this.textIdActividad.setText(IDacT);
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == guardar){
			ControladorDeportes dep = ControladorDeportes.getInstancia();
			dep.agregarClase(Integer.parseInt(this.textIdActividad.getText()),Integer.parseInt(String.valueOf(this.IdClases.getSelectedItem())), Integer.parseInt(this.desde.getText()), Integer.parseInt(this.texthast.getText()), Integer.parseInt(String.valueOf(dias.getSelectedItem())));
			
		}
		if(e.getSource() == salir){
			this.setVisible(false);
		}
	}

}

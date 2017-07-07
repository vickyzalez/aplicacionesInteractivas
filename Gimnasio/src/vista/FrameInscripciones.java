package vista;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import controladores.ControladorAdministrativo;
import controladores.ControladorSocios;


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
public class FrameInscripciones extends javax.swing.JFrame implements ActionListener {
	private JDesktopPane contenedor;
	private JRadioButton normal;
	private JButton salir;
	private JTextField TEXTDNI;
	private JButton guardar;
	private JComboBox abonos;
	private JLabel abono;
	private JComboBox convenios;
	private ButtonGroup GRUPO;
	private JRadioButton corporativa;
	private JLabel TIPO;
	private JLabel dni;
	private JLabel insccripciones;
    private static FrameInscripciones inst =null;
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				FrameInscripciones inst = new FrameInscripciones();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public static FrameInscripciones getFrameInscripciones(){
		if(inst ==null){
			inst = new FrameInscripciones();
		}
		FrameSocio s = FrameSocio.getFrameSocio();
		inst.setDni(s.gettextoDni());
		return inst;
	}
	private FrameInscripciones() {
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
					insccripciones = new JLabel();
					contenedor.add(insccripciones);
					insccripciones.setText("Inscripciones");
					insccripciones.setBounds(302, 19, 162, 16);
				}
				{
					dni = new JLabel();
					contenedor.add(dni);
					dni.setText("DNI:  ");
					dni.setBounds(50, 64, 96, 16);
				}
				{
					TIPO = new JLabel();
					contenedor.add(TIPO);
					TIPO.setText("TIPO INSCRIPCION: ");
					TIPO.setBounds(50, 119, 127, 16);
				}
				{
					normal = new JRadioButton();
					contenedor.add(normal);
					normal.setText("NORMAL ");
					normal.setBounds(45, 153, 113, 20);
					getGRUPO().add(normal);
				}
				{
					corporativa = new JRadioButton();
					contenedor.add(corporativa);
					corporativa.setText("CORPORATIVA ");
					corporativa.setBounds(45, 185, 114, 20);
					corporativa.addActionListener(this);
					getGRUPO().add(corporativa);
				}
				{
					
					convenios = new JComboBox();
			//		ControladorAdministrativo ad = ControladorAdministrativo.getInstancia();
			//			List<String> empresasView = ad.viewEmpresas();
			//				for(Iterator<String> i = empresasView.iterator();i.hasNext();){
			//					convenios.addItem(i.next());
			//				}
					contenedor.add(convenios);
				
					convenios.setBounds(45, 226, 114, 23);
					convenios.setVisible(false);
				}
				{
					abono = new JLabel();
					contenedor.add(abono);
					abono.setText("ABONO: ");
					abono.setBounds(214, 119, 79, 16);
				}
				{
					
					abonos = new JComboBox();
			
			//		ControladorAdministrativo ad = ControladorAdministrativo.getInstancia();
			//		List<String> idAbonos = ad.abonosview();
			//		for(Iterator<String> i = idAbonos.iterator();i.hasNext();){
			//			abonos.addItem(i.next());
			//		}
					contenedor.add(abonos);
					abonos.setBounds(305, 116, 150, 23);
				}
				{
					guardar = new JButton();
					contenedor.add(guardar);
					guardar.setText("GUARDAR");
					guardar.setBounds(464, 249, 92, 23);
					guardar.addActionListener(this);
				}
				{
					TEXTDNI = new JTextField();
					contenedor.add(TEXTDNI);
					contenedor.add(getSalir());
					TEXTDNI.setBounds(107, 64, 137, 23);
				}
			}
			pack();
			this.setSize(666, 323);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setDni(String dni){
		this.TEXTDNI.setText(dni);
	}
	
	
	private ButtonGroup getGRUPO() {
		if(GRUPO == null) {
			GRUPO = new ButtonGroup();
		}
		return GRUPO;
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == corporativa){
			this.convenios.setVisible(true);
		}
		if((e.getSource()==guardar)&&(this.normal.isSelected())){
			ControladorSocios s = ControladorSocios.getInstancia();
			s.generarInscripcionNormal(Integer.parseInt(this.TEXTDNI.getText()),Integer.parseInt(String.valueOf(this.abonos.getSelectedItem())));
			
		}
		if((e.getSource() == guardar)&&(this.corporativa.isSelected())){
			ControladorSocios s = ControladorSocios.getInstancia();
		//	s.generarInscripcionCorporativa(Integer.parseInt(this.TEXTDNI.getText()), Integer.parseInt(String.valueOf(this.abonos.getSelectedItem())), Integer.parseInt(String.valueOf(this.convenios.getSelectedItem())),))
		}
		if(e.getSource() == this.salir){
			FrameSocio s = FrameSocio.getFrameSocio();
			s.setVisible(true);
			this.setVisible(false);
		}
	}
	
	private JButton getSalir() {
		if(salir == null) {
			salir = new JButton();
			salir.setText("Salir");
			salir.setBounds(561, 248, 78, 24);
			salir.addActionListener(this);
		}
		return salir;
	}

}

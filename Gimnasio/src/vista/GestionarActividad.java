package vista;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
public class GestionarActividad extends javax.swing.JFrame implements ActionListener{
	private JDesktopPane contenedor;
	private JTextField textactividad;
	private JLabel descripcion;
	private ButtonGroup grupo;
	private JButton salir;
	private JButton bajaclase;
	private JButton modifClase;
	private JButton agregarClase;
	private JButton baja;
	private JButton modif;
	private JButton alta;
	private JComboBox seleccionProfesor;
	private JRadioButton sinprofesor;
	private JRadioButton profesor;
	private JTextField textdescripcion;
	private JLabel idActividad;
	private JTextField textiddeporte;
	private JLabel iddeporte;
	private static GestionarActividad inst =null;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				GestionarActividad inst = new GestionarActividad();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public static GestionarActividad getActividad(){
		if(inst == null){
			inst = new GestionarActividad();
		}
		return inst;
	}
	
	private GestionarActividad() {
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
					iddeporte = new JLabel();
					contenedor.add(iddeporte);
					iddeporte.setText("Id Deporte");
					iddeporte.setBounds(40, 31, 77, 16);
				}
				{
					textiddeporte = new JTextField();
					contenedor.add(textiddeporte);
					textiddeporte.setBounds(140, 28, 92, 26);
				}
				{
					idActividad = new JLabel();
					contenedor.add(idActividad);
					idActividad.setText("Id Actividad");
					idActividad.setBounds(40, 86, 77, 16);
				}
				{
					textactividad = new JTextField();
					contenedor.add(textactividad);
					textactividad.setBounds(140, 83, 92, 25);
				}
				{
					descripcion = new JLabel();
					contenedor.add(descripcion);
					descripcion.setText("Descripcion");
					descripcion.setBounds(40, 138, 77, 19);
				}
				{
					textdescripcion = new JTextField();
					contenedor.add(textdescripcion);
					textdescripcion.setBounds(140, 131, 92, 26);
				}
				{
					profesor = new JRadioButton();
					contenedor.add(profesor);
					profesor.setText("Profesor");
					profesor.setBounds(310, 34, 107, 20);
					getGrupo().add(profesor);
					profesor.addActionListener(this);
				}
				{
					sinprofesor = new JRadioButton();
					contenedor.add(sinprofesor);
					sinprofesor.setText("Sin Profesor");
					sinprofesor.setBounds(310, 85, 107, 20);
					getGrupo().add(sinprofesor);
					sinprofesor.addActionListener(this);
				}
				{
					seleccionProfesor = new JComboBox();
					List<String> profesores = ControladorAdministrativo.getInstancia().getIdProfesores();
					for(Iterator<String> i= profesores.iterator();i.hasNext();){
						seleccionProfesor.addItem(i.next());
					}
					
					contenedor.add(seleccionProfesor);
					seleccionProfesor.setBounds(459, 33, 101, 23);
					seleccionProfesor.setVisible(false);
				}
				{
					alta = new JButton();
					contenedor.add(alta);
					alta.setText("Alta");
					alta.setBounds(40, 238, 61, 28);
					alta.addActionListener(this);
				}
				{
					modif = new JButton();
					contenedor.add(modif);
					modif.setText("Modificacion");
					modif.setBounds(101, 238, 108, 28);
					modif.addActionListener(this);
				}
				{
					baja = new JButton();
					contenedor.add(baja);
					baja.setText("Baja");
					baja.setBounds(209, 238, 76, 28);
					baja.addActionListener(this);
				}
				{
					agregarClase = new JButton();
					contenedor.add(agregarClase);
					agregarClase.setText("Agregar Clase");
					agregarClase.setBounds(302, 238, 130, 28);
					agregarClase.addActionListener(this);
				}
				{
					modifClase = new JButton();
					contenedor.add(modifClase);
					modifClase.setText("Modificar Clase ");
					modifClase.setBounds(432, 238, 147, 28);
					modifClase.addActionListener(this);
				}
				{
					bajaclase = new JButton();
					contenedor.add(bajaclase);
					bajaclase.setText("Baja Clase");
					bajaclase.setBounds(579, 238, 119, 28);
					bajaclase.addActionListener(this);
				}
				{
					salir = new JButton();
					contenedor.add(salir);
					salir.setText("Salir");
					salir.setBounds(698, 272, 68, 23);
					salir.addActionListener(this);
				}
			}
			pack();
			this.setSize(793, 344);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private ButtonGroup getGrupo() {
		if(grupo == null) {
			grupo = new ButtonGroup();
		}
		return grupo;
	}
	
	public void setIdDeporte(String id){
		this.textiddeporte.setText(id);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == this.profesor){
			this.seleccionProfesor.setVisible(true);
		}
		if(e.getSource()== alta){
	     	if((e.getSource() == this.alta)&&(sinprofesor.isSelected())){
		    	ControladorDeportes dep = ControladorDeportes.getInstancia();
		    	dep.agregarActividadSinProfe(Integer.parseInt(this.textiddeporte.getText()), Integer.parseInt(this.textactividad.getText()),this.textdescripcion.getText());
			
		    }else{
			    ControladorDeportes dep = ControladorDeportes.getInstancia();
			    dep.agregarActividadConProfe(Integer.parseInt(this.textiddeporte.getText()),Integer.parseInt(this.textactividad.getText()),this.textdescripcion.getText(), Integer.parseInt(String.valueOf(this.seleccionProfesor.getSelectedItem())));
		    }
	    }
		if(e.getSource() == this.modif){
		   if((e.getSource() == this.modif)&&(profesor.isSelected())){
		    	ControladorDeportes dep = ControladorDeportes.getInstancia();
			    int idProfe =Integer.parseInt(String.valueOf(this.seleccionProfesor.getSelectedItem()));
			    dep.modificarActividadConProfe(Integer.parseInt(this.textactividad.getText()), this.textdescripcion.getText(),idProfe);
		   }else{
			    ControladorDeportes dep = ControladorDeportes.getInstancia();
			    dep.modificarActividadSinProfe(Integer.parseInt(this.textactividad.getText()), this.textdescripcion.getText());
		   }
		}
		if(e.getSource() == this.baja){
			ControladorDeportes dep = ControladorDeportes.getInstancia();
			dep.bajaActividad(Integer.parseInt(this.textactividad.getText()));
		}
		if(e.getSource() == this.agregarClase){
			GestionClase c = GestionClase.getClase();
			c.setIdActividad(this.textactividad.getText());
			c.setVisible(true);
		}
		if(e.getSource() == this.modifClase){
	       ModificacionClase c = new ModificacionClase();
	       c.setVisible(true);
		}
		if(e.getSource() == this.bajaclase){
			BajaClase b = new BajaClase();
			b.setVisible(true);
		}
		if(e.getSource() == salir ){
			GestionDeporte dep = GestionDeporte.getDeporte();
			dep.setVisible(true);
			this.setVisible(false);
		}
		
	}

}

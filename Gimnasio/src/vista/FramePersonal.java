package vista;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

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
public class FramePersonal extends javax.swing.JFrame implements ActionListener{
	private JDesktopPane contenedor;
	private JRadioButton Profesor;
	private JRadioButton administrativo;
	private JTextField textoImpuesto;
	private JLabel Impuesto;
	private JTextField textoRetencion;
	private JLabel retencion;
	private JTextField textosueldo;
	private JLabel sueldo;
	private JTextField textomail;
	private JLabel mail;
	private JTextField textoDomicilio;
	private JLabel domicilio;
	private JTextField textoApellido;
	private JLabel apellido;
	private JTextField textonombre;
	private JLabel nombre;
	private JTextField textodni;
	private JButton salir;
	private JButton quitar;
	private JButton alta;
	private JLabel dni;
	private ButtonGroup grupo2;
	private JRadioButton profesorfijp;
	private JRadioButton porhora;
	private JLabel quetipo;
	private ButtonGroup grupo;
	private JLabel tipoEmple;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				FramePersonal inst = new FramePersonal();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public FramePersonal() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			this.setTitle("Gestion Empleados");
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				contenedor = new JDesktopPane();
				getContentPane().add(contenedor, BorderLayout.CENTER);
				contenedor.setPreferredSize(new java.awt.Dimension(665, 298));
				{
					tipoEmple = new JLabel();
					contenedor.add(tipoEmple);
					tipoEmple.setText("Tipo Empleado");
					tipoEmple.setBounds(30, 23, 106, 16);
				}
				{
					Profesor = new JRadioButton();
					contenedor.add(Profesor);
					Profesor.setText("Profesor");
					Profesor.setBounds(164, 21, 130, 20);
					getGrupo().add(Profesor);
					Profesor.addActionListener(this);
				}
				{
					administrativo = new JRadioButton();
					contenedor.add(administrativo);
					administrativo.setText("Administrativo");
					administrativo.setBounds(164, 60, 130, 20);
					getGrupo().add(administrativo);
				}
				{
					quetipo = new JLabel();
					contenedor.add(quetipo);
					quetipo.setText("Seleccione el tipo");
					quetipo.setBounds(322, 23, 116, 16);
					quetipo.setVisible(false);
				}
				{
					porhora = new JRadioButton();
					contenedor.add(porhora);
					porhora.setText("Por Hora");
					porhora.setBounds(433, 21, 76, 20);
					getGrupo2().add(porhora);
					porhora.setVisible(false);
				}
				{
					profesorfijp = new JRadioButton();
					contenedor.add(profesorfijp);
					profesorfijp.setText("Sueldo Fijo");
					profesorfijp.setBounds(528, 21, 107, 20);
					getGrupo2().add(profesorfijp);
					profesorfijp.setVisible(false);
				}
				{
					dni = new JLabel();
					contenedor.add(dni);
					dni.setText("DNI: ");
					dni.setBounds(30, 114, 53, 16);
				}
				{
					textodni = new JTextField();
					contenedor.add(textodni);
					textodni.setBounds(101, 111, 99, 27);
				}
				{
					nombre = new JLabel();
					contenedor.add(nombre);
					nombre.setText("Nombre:");
					nombre.setBounds(30, 153, 60, 16);
				}
				{
					textonombre = new JTextField();
					contenedor.add(textonombre);
					textonombre.setBounds(102, 150, 98, 28);
				}
				{
					apellido = new JLabel();
					contenedor.add(apellido);
					apellido.setText("Apellido: ");
					apellido.setBounds(30, 193, 65, 16);
				}
				{
					textoApellido = new JTextField();
					contenedor.add(textoApellido);
					textoApellido.setBounds(102, 190, 98, 25);
				}
				{
					domicilio = new JLabel();
					contenedor.add(domicilio);
					domicilio.setText("Domicilio:");
					domicilio.setBounds(217, 116, 77, 16);
				}
				{
					textoDomicilio = new JTextField();
					contenedor.add(textoDomicilio);
					textoDomicilio.setBounds(312, 113, 76, 23);
				}
				{
					mail = new JLabel();
					contenedor.add(mail);
					mail.setText("Mail: ");
					mail.setBounds(217, 155, 58, 16);
				}
				{
					textomail = new JTextField();
					contenedor.add(textomail);
					textomail.setBounds(312, 155, 76, 23);
				}
				{
					sueldo = new JLabel();
					contenedor.add(sueldo);
					sueldo.setText("Sueldo:");
					sueldo.setBounds(217, 199, 58, 16);
				}
				{
					textosueldo = new JTextField();
					contenedor.add(textosueldo);
					textosueldo.setBounds(312, 199, 76, 23);
				}
				{
					retencion = new JLabel();
					contenedor.add(retencion);
					retencion.setText("Retencion:");
					retencion.setBounds(414, 116, 71, 16);
				}
				{
					textoRetencion = new JTextField();
					contenedor.add(textoRetencion);
					textoRetencion.setBounds(503, 113, 74, 23);
				}
				{
					Impuesto = new JLabel();
					contenedor.add(Impuesto);
					Impuesto.setText("Impuesto:");
					Impuesto.setBounds(414, 162, 71, 16);
				}
				{
					textoImpuesto = new JTextField();
					contenedor.add(textoImpuesto);
					textoImpuesto.setBounds(503, 159, 74, 23);
				}
				{
					alta = new JButton();
					contenedor.add(alta);
					alta.setText("Agregar Empleado");
					alta.setBounds(159, 249, 158, 31);
					alta.addActionListener(this);
				}
				{
					quitar = new JButton();
					contenedor.add(quitar);
					quitar.setText("Baja Empleado");
					quitar.setBounds(339, 248, 135, 32);
					quitar.addActionListener(this);
				}
				{
					salir = new JButton();
					contenedor.add(salir);
					salir.setText("Salir");
					salir.setBounds(564, 248, 71, 27);
					salir.addActionListener(this);
				}
			}
			pack();
			this.setSize(681, 335);
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
	
	private ButtonGroup getGrupo2() {
		if(grupo2 == null) {
			grupo2 = new ButtonGroup();
		}
		return grupo2;
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
			if(this.Profesor.isSelected()){
				this.porhora.setVisible(true);
				this.profesorfijp.setVisible(true);
				this.quetipo.setVisible(true);
			}
			if(e.getSource() == alta){
				if(this.administrativo.isSelected()){
					ControladorAdministrativo ad = ControladorAdministrativo.getInstancia();
					ad.altaEmpleado(Integer.parseInt(this.textodni.getText()),this.textonombre.getText(),this.textoApellido.getText(), this.textoDomicilio.getText(), this.textomail.getText(), Float.parseFloat(this.textosueldo.getText()), Float.parseFloat(this.textoRetencion.getText()),Float.parseFloat(this.textoImpuesto.getText()));
					
				}else{
					if(this.porhora.isSelected()){
						ControladorAdministrativo ad = ControladorAdministrativo.getInstancia();
						ad.altaProfesorClase(Integer.parseInt(this.textodni.getText()),this.textonombre.getText(),this.textoApellido.getText(), this.textoDomicilio.getText(), this.textomail.getText(), Float.parseFloat(this.textosueldo.getText()), Float.parseFloat(this.textoRetencion.getText()),Float.parseFloat(this.textoImpuesto.getText()));
					}else{
						ControladorAdministrativo ad = ControladorAdministrativo.getInstancia();
						ad.altaProfesorSueldo(Integer.parseInt(this.textodni.getText()),this.textonombre.getText(),this.textoApellido.getText(), this.textoDomicilio.getText(), this.textomail.getText(), Float.parseFloat(this.textosueldo.getText()), Float.parseFloat(this.textoRetencion.getText()),Float.parseFloat(this.textoImpuesto.getText()));
					}
				}
			}
			if(e.getSource()==this.quitar){
				if(this.administrativo.isSelected()){
					ControladorAdministrativo ad = ControladorAdministrativo.getInstancia();
					ad.bajaEmpleado(Integer.parseInt(this.textodni.getText()));	
				}else{
					if(this.porhora.isSelected()){
						ControladorAdministrativo ad = ControladorAdministrativo.getInstancia();
						ad.bajaProfesorClase(Integer.parseInt(this.textodni.getText()));
					}else{
						ControladorAdministrativo ad = ControladorAdministrativo.getInstancia();
						ad.bajaProfesorSueldo(Integer.parseInt(this.textodni.getText()));
					}
				}
			}
			if(e.getSource() == salir){
				FrameAdministracion fa = FrameAdministracion.getAdministracion();
				fa.setVisible(true);
				this.setVisible(false);
			}
			
	}

}

package vista;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import modelo.Socio;

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
public class FrameSocio extends javax.swing.JFrame implements ActionListener{
	private JDesktopPane contenedor;
	private JButton modificarClase;
	private JButton salir;
	private JLabel actividades;
	private JButton agregarApto;
	private JButton eliminar;
	private JButton modificar;
	private JButton agregar;
	private JButton inscribir;
	private JTextField textmail;
	private JTextField texettel;
	private JTextField TEXTDOMICILIO;
	private JTextField TEXTAPELLIDO;
	private JTextField TEXTNOMBRE;
	private JTextField TEXTDNI;
	private JLabel MAIL;
	private JLabel TELEFONO;
	private JLabel DOMICILIO;
	private JLabel apellido;
	private JLabel NOMBRE;
	private JLabel DNI;
    private static FrameSocio inst = null;
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
			FrameSocio inst = new FrameSocio();
			inst.setLocationRelativeTo(null);
			inst.setVisible(true);
			}
		});
	}
	
	public static FrameSocio getFrameSocio(){
		if(inst == null){
			inst = new FrameSocio();
		}
		return inst;
	}
	
	private FrameSocio() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				contenedor = new JDesktopPane();
				getContentPane().add(contenedor, BorderLayout.CENTER);
				contenedor.setPreferredSize(new java.awt.Dimension(684, 319));
				{
					DNI = new JLabel();
					contenedor.add(DNI);
					DNI.setText("DNI:");
					DNI.setBounds(44, 46, 75, 16);
				}
				{
					NOMBRE = new JLabel();
					contenedor.add(NOMBRE);
					NOMBRE.setText("NOMBRE: ");
					NOMBRE.setBounds(44, 84, 80, 16);
				}
				{
					apellido = new JLabel();
					contenedor.add(apellido);
					apellido.setText("APELLIDO: ");
					apellido.setBounds(44, 127, 75, 16);
				}
				{
					DOMICILIO = new JLabel();
					contenedor.add(DOMICILIO);
					DOMICILIO.setText("DOMICILIO:  ");
					DOMICILIO.setBounds(44, 168, 86, 17);
				}
				{
					TELEFONO = new JLabel();
					contenedor.add(TELEFONO);
					TELEFONO.setText("TELEFONO: ");
					TELEFONO.setBounds(44, 206, 86, 16);
				}
				{
					MAIL = new JLabel();
					contenedor.add(MAIL);
					MAIL.setText("MAIL:  ");
					MAIL.setBounds(44, 247, 68, 16);
				}
				{
					TEXTDNI = new JTextField();
					contenedor.add(TEXTDNI);
					TEXTDNI.setBounds(131, 43, 115, 23);
				}
				{
					TEXTNOMBRE = new JTextField();
					contenedor.add(TEXTNOMBRE);
					TEXTNOMBRE.setBounds(131, 81, 115, 23);
				}
				{
					TEXTAPELLIDO = new JTextField();
					contenedor.add(TEXTAPELLIDO);
					TEXTAPELLIDO.setBounds(131, 124, 115, 23);
				}
				{
					TEXTDOMICILIO = new JTextField();
					contenedor.add(TEXTDOMICILIO);
					TEXTDOMICILIO.setBounds(130, 165, 116, 23);
				}
				{
					texettel = new JTextField();
					contenedor.add(texettel);
					texettel.setBounds(130, 203, 116, 23);
				}
				{
					textmail = new JTextField();
					contenedor.add(textmail);
					textmail.setBounds(130, 244, 116, 23);
				}
				{
					inscribir = new JButton();
					contenedor.add(inscribir);
					inscribir.setText("Inscribir");
					inscribir.setBounds(413, 58, 123, 23);
					inscribir.addActionListener(this);
				}
				{
					agregar = new JButton();
					contenedor.add(agregar);
					agregar.setText("Nuevo Socio");
					agregar.setBounds(271, 266, 111, 24);
					agregar.addActionListener(this);
				}
				{
					modificar = new JButton();
					contenedor.add(modificar);
					modificar.setText("Modificar");
					modificar.setBounds(382, 266, 113, 24);
					modificar.addActionListener(this);
				}
				{
					eliminar = new JButton();
					contenedor.add(eliminar);
					eliminar.setText("Eliminar");
					eliminar.setBounds(495, 266, 113, 25);
					eliminar.addActionListener(this);
				}
				{
					agregarApto = new JButton();
					contenedor.add(agregarApto);
					agregarApto.setText("Apto Medico");
					agregarApto.setBounds(413, 92, 123, 23);
					agregarApto.addActionListener(this);
				}
				{
					modificarClase = new JButton();
					contenedor.add(modificarClase);
					modificarClase.setText("Modificar Clase");
					modificarClase.setBounds(413, 132, 123, 23);
					modificarClase.addActionListener(this);
				}
				{
					actividades = new JLabel();
					contenedor.add(actividades);
					contenedor.add(getSalir());
					actividades.setText("Actualizar Actividades");
					actividades.setBounds(413, 18, 180, 16);
				}
			}
			pack();
			this.setSize(700, 338);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String gettextoDni(){
		return this.TEXTDNI.getText();
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == inscribir){
			FrameInscripciones f = FrameInscripciones.getFrameInscripciones();
			f.setDni(gettextoDni());
			f.setVisible(true);
			this.setVisible(false);
			
		}
		if(e.getSource()== agregarApto){
			AptoMedico m = AptoMedico.getAptoMedico();
			m.setDni(gettextoDni());
			m.setVisible(true);
			this.setVisible(false);
			
		}
		if(e.getSource()==this.modificar){
		    ControladorSocios s = ControladorSocios.getInstancia();
			s.modificarSocio(Integer.parseInt(this.TEXTDNI.getText()), this.TEXTNOMBRE.getText(), this.TEXTAPELLIDO.getText(), this.TEXTDOMICILIO.getText(), Integer.parseInt(this.texettel.getText()),this.textmail.getText());
			JOptionPane.showMessageDialog(this,"Se modificaron los datos del socio","Modificacion correcta",JOptionPane.PLAIN_MESSAGE);
		}
		if (e.getSource() == this.eliminar){
			ControladorSocios s = ControladorSocios.getInstancia();
			s.bajaSocio(Integer.parseInt(this.TEXTDNI.getText()));
			JOptionPane.showMessageDialog(this,"Se elimino el socio ingresado","Eliminar Socio",JOptionPane.PLAIN_MESSAGE);
		}
		if(e.getSource()== this.agregar){
		    ControladorSocios s = ControladorSocios.getInstancia();
		    int dni = Integer.parseInt(this.TEXTDNI.getText());
		    Socio soc = s.altaSocio(dni, this.TEXTNOMBRE.getText(), this.TEXTAPELLIDO.getText(), this.TEXTDOMICILIO.getText(), Integer.parseInt(this.texettel.getText()), this.textmail.getText());
			
			if(soc !=null){
				JOptionPane.showMessageDialog(this,"El socio ingresado ya existe","Socio existente",JOptionPane.PLAIN_MESSAGE);
			}else{
				JOptionPane.showMessageDialog(this,"Se registro el socio ingresado","Registro Correcto",JOptionPane.PLAIN_MESSAGE);	
			}
		}
		if(e.getSource() == this.modificarClase){
			
		}
		if(e.getSource() == this.salir){
			this.setVisible(false);
		}
	}
	
	private JButton getSalir() {
		if(salir == null) {
			salir = new JButton();
			salir.setText("SALIR");
			salir.setBounds(608, 266, 70, 25);
			salir.addActionListener(this);
		}
		return salir;
	}

}

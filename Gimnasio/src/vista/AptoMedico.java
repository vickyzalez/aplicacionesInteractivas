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
public class AptoMedico extends javax.swing.JFrame implements ActionListener{
	private JDesktopPane contenedor;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JButton guardar;
	private JTextField TEXTOBSERVACIONES;
	private JTextField TEXTPROFESIONAL;
	private JTextField TEXTFECHA;
	private JTextField TEXTDNI;
	private JLabel fechaCertificado;
	private JLabel dni;
	private JLabel jLabel1;
    private static AptoMedico instancia = null;
    
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				AptoMedico inst = new AptoMedico();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public static AptoMedico getAptoMedico(){
		if(instancia == null){
			instancia = new AptoMedico();
		}
		FrameSocio fs= FrameSocio.getFrameSocio();
		return instancia;
	}
	
	private AptoMedico() {
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
					jLabel1 = new JLabel();
					contenedor.add(jLabel1);
					jLabel1.setText("APTO MEDICO");
					jLabel1.setBounds(324, 12, 204, 46);
					jLabel1.setFont(new java.awt.Font("Courier New",1,22));
				}
				{
					dni = new JLabel();
					contenedor.add(dni);
					dni.setText("DNI: ");
					dni.setBounds(67, 90, 47, 16);
				}
				{
					fechaCertificado = new JLabel();
					contenedor.add(fechaCertificado);
					fechaCertificado.setText("FECHA CERTIFICADO: ");
					fechaCertificado.setBounds(67, 136, 134, 16);
				}
				{
					jLabel2 = new JLabel();
					contenedor.add(jLabel2);
					jLabel2.setText("PROFESIONAL: ");
					jLabel2.setBounds(449, 80, 98, 26);
				}
				{
					jLabel3 = new JLabel();
					contenedor.add(jLabel3);
					jLabel3.setText("OBSERVACIONES: ");
					jLabel3.setBounds(449, 136, 111, 16);
				}
				{
					TEXTDNI = new JTextField();
					contenedor.add(TEXTDNI);
					TEXTDNI.setBounds(201, 82, 123, 24);
				}
				{
					TEXTFECHA = new JTextField();
					contenedor.add(TEXTFECHA);
					TEXTFECHA.setBounds(201, 129, 123, 23);
				}
				{
					TEXTPROFESIONAL = new JTextField();
					contenedor.add(TEXTPROFESIONAL);
					TEXTPROFESIONAL.setBounds(565, 80, 134, 26);
				}
				{
					TEXTOBSERVACIONES = new JTextField();
					contenedor.add(TEXTOBSERVACIONES);
					TEXTOBSERVACIONES.setBounds(565, 131, 134, 26);
				}
				{
					guardar = new JButton();
					contenedor.add(guardar);
					guardar.setText("GUARDAR");
					guardar.setBounds(331, 229, 99, 30);
					guardar.addActionListener(this);
				}
			}
			pack();
			this.setSize(828, 324);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//carga el campo de dni con el valor del dni de la ventana socio
	public void setDni(String dni){
		this.TEXTDNI.setText(dni);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==guardar){
		/*	ControladorSocios ins = null;
			ins= ControladorSocios.getInstancia();
			int dni = Integer.parseInt(this.TEXTDNI.getText());
			ins.presentarAptoMedico(dni,this.TEXTFECHA.getText(),this.TEXTPROFESIONAL.getText(),this.TEXTOBSERVACIONES.getText());
			this.setVisible(false);*/
		    FrameSocio s = FrameSocio.getFrameSocio();
			s.setVisible(true);
			this.setVisible(false);
		}
		
	}

}

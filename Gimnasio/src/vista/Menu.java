package vista;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

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
public class Menu extends javax.swing.JFrame implements ActionListener{
	private JDesktopPane contenedor;
	private JButton administrativo;
	private JButton consultar;
	private JButton salir;
	private JButton liquidacion;
	private JButton GENERAR;
	private JButton gestionsocios;
	private JButton gestionarDeporte;
	private JLabel sistema;
    private static Menu inst=null;
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Menu inst = new Menu();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public static Menu getMenu(){
		if(inst==null){
			inst = new Menu();
		}
		return inst;
	}
	
	private Menu() {
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
					sistema = new JLabel();
					contenedor.add(sistema);
					sistema.setText("GIMNASIO");
					sistema.setBounds(126, 12, 150, 31);
				}
				{
					administrativo = new JButton();
					contenedor.add(administrativo);
					administrativo.setText("ADMINISTRATIVO");
					administrativo.setBounds(74, 55, 155, 28);
					administrativo.addActionListener(this);
				}
				{
					gestionarDeporte = new JButton();
					contenedor.add(gestionarDeporte);
					gestionarDeporte.setText("GESTION DEPORTE");
					gestionarDeporte.setBounds(74, 94, 155, 27);
					gestionarDeporte.addActionListener(this);
				}
				{
					gestionsocios = new JButton();
					contenedor.add(gestionsocios);
					gestionsocios.setText("GESTION SOCIOS");
					gestionsocios.setBounds(74, 132, 155, 27);
					gestionsocios.addActionListener(this);
				
				}
				{
					GENERAR = new JButton();
					contenedor.add(GENERAR);
					GENERAR.setText("CRONOGRAMA");
					GENERAR.setBounds(74, 170, 155, 26);
					GENERAR.addActionListener(this);
				}
				{
					liquidacion = new JButton();
					contenedor.add(liquidacion);
					liquidacion.setText("LIQUIDACION");
					liquidacion.setBounds(74, 207, 155, 24);
					liquidacion.addActionListener(this);
				}
				{
					salir = new JButton();
					contenedor.add(salir);
					contenedor.add(getConsultar());
					salir.setText("SALIR");
					salir.setBounds(102, 270, 83, 30);
					salir.addActionListener(this);
				}
			}
			pack();
			this.setSize(477, 362);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==administrativo){
			FrameAdministracion a = FrameAdministracion.getAdministracion();
			a.setVisible(true);
			this.setVisible(false);
		}
		if(e.getSource() == gestionarDeporte){
			GestionDeporte dep = GestionDeporte.getDeporte();
			dep.setVisible(true);
			this.setVisible(false);
			
		}
		if(e.getSource()==gestionsocios){
			FrameSocio s = FrameSocio.getFrameSocio();
			s.setVisible(true);
			this.setVisible(false);
		}
		if(e.getSource()==GENERAR){
			ControladorDeportes dep = ControladorDeportes.getInstancia();
			dep.generarCronograma();
			JOptionPane.showMessageDialog(null, "Se genero el cronograma");
			
		}
		if(e.getSource()==liquidacion){
			ControladorAdministrativo ad = ControladorAdministrativo.getInstancia();
			ad.liquidarSueldos();
			VerRecibo recibo = new VerRecibo();
			recibo.setVisible(true);
			this.setVisible(false);
		}
		if(e.getSource()==salir){
			this.setVisible(false);
		}
		if(e.getSource() == consultar){
			Cronograma c = new Cronograma();
			c.setVisible(true);
			this.setVisible(false);
		}
	}
	
	private JButton getConsultar() {
		if(consultar == null) {
			consultar = new JButton();
			consultar.setText("Consultar Cronograma");
			consultar.setBounds(267, 113, 166, 38);
			consultar.addActionListener(this);
		}
		return consultar;
	}

}

package vista;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;


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
public class LOGIN extends javax.swing.JFrame implements ActionListener {
	private JDesktopPane CONTENEDOR;
	private JTextField TEXTCONTRASENIA;
	private JButton LOGIN;
	private JLabel contrasenia;
	private JTextField TEXTUSUARIO;
	private JLabel usuario;
	private JLabel INICIAR;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				LOGIN inst = new LOGIN();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public LOGIN() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			this.setTitle("Sistema Gimnasio");
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				CONTENEDOR = new JDesktopPane();
				getContentPane().add(CONTENEDOR, BorderLayout.CENTER);
				{
					INICIAR = new JLabel();
					CONTENEDOR.add(INICIAR);
					INICIAR.setText("INICIAR SESION");
					INICIAR.setBounds(147, 41, 97, 16);
				}
				{
					usuario = new JLabel();
					CONTENEDOR.add(usuario);
					usuario.setText("USUARIO: ");
					usuario.setBounds(27, 102, 89, 16);
				}
				{
					TEXTUSUARIO = new JTextField();
					CONTENEDOR.add(TEXTUSUARIO);
					TEXTUSUARIO.setBounds(140, 99, 111, 23);
				}
				{
					contrasenia = new JLabel();
					CONTENEDOR.add(contrasenia);
					contrasenia.setText("CONTRASENIsA:");
					contrasenia.setBounds(27, 142, 89, 26);
				}
				{
					TEXTCONTRASENIA = new JTextField();
					CONTENEDOR.add(TEXTCONTRASENIA);
					TEXTCONTRASENIA.setBounds(140, 142, 111, 20);
				}
				{
					LOGIN = new JButton();
					CONTENEDOR.add(LOGIN);
					LOGIN.setText("INGRESAR");
					LOGIN.setBounds(152, 222, 92, 23);
					LOGIN.addActionListener(this);
				}
			}
			pack();
			this.setSize(388, 300);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==LOGIN){
	       if (this.TEXTUSUARIO.getText().equalsIgnoreCase("Administrador")){
			
		        Menu m = Menu.getMenu();
			    m.setVisible(true);
			    this.setVisible(false);
		   }else{
		  	//aca seria si se registra un socio mandamos el farcade
		   }
		}
	}
	
	

}

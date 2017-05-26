/*package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controladores.ControladorSocios;

import javax.swing.JToolBar;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JScrollPane;
import javax.swing.JList;

public class WindowsBuilder extends JFrame {

	private JPanel contentPane;
	private final Action action = new SwingAction();

	*//**
	 * Launch the application.
	 *//*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowsBuilder frame = new WindowsBuilder();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	*//**
	 * Create the frame.
	 *//*
	public WindowsBuilder() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Administraci�n de Gimnasio");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnAbmSocios = new JButton("ABM Socios");
		btnAbmSocios.setBounds(283, 24, 141, 23);
		btnAbmSocios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaSocio s = new VentanaSocio();
				s.setVisible(true);
				s.setModal(true);
				//s.setDefaultCloseOperation(s.setVisible(false));
				  JOptionPane.showMessageDialog(null, "Presionado");
			    
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnAbmSocios);
		
		JButton btnAbmActividades = new JButton("ABM Actividades");
		btnAbmActividades.setBounds(283, 50, 141, 23);
		btnAbmActividades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaActividades a = new VentanaActividades();
				a.setVisible(true);
				a.setModal(true);
			}
		});
		contentPane.add(btnAbmActividades);
		
		JButton btnNewButton = new JButton("ABM Abonos");
		btnNewButton.setBounds(283, 77, 141, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaAbonos a = new VentanaAbonos();
				a.setVisible(true);
				a.setModal(true);
			}
		});
		contentPane.add(btnNewButton);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "SwingAction_1");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
*/
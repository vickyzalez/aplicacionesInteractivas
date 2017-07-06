package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controladores.ControladorDeportes;
import modelo.Abono;
import modelo.Actividad;
import modelo.Clase;
import modelo.ClaseAct;
import modelo.Deporte;

import java.awt.FlowLayout;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JRadioButton;

public class VentanaDeporte extends JFrame {
	static VentanaDeporte inst;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField txtProfesor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaDeporte frame = new VentanaDeporte();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static VentanaDeporte getVentanaDeporte(){
		if(inst == null){
			inst = new VentanaDeporte();
		}
		return inst;
	}
	/**
	 * Create the frame.
	 */
	public VentanaDeporte() {
		setTitle("DEPORTES");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		ControladorDeportes cd = ControladorDeportes.getInstancia();

		textField = new JTextField();
		textField.setBounds(306, 31, 118, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(306, 62, 118, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(306, 93, 118, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		JTextPane textPane = new JTextPane();
		textPane.setBounds(235, 28, -6, 23);
		contentPane.add(textPane);

		JTextPane txtpnCdigo = new JTextPane();
		txtpnCdigo.setText("C\u00F3digo");
		txtpnCdigo.setBounds(326, 26, -92, 20);
		contentPane.add(txtpnCdigo);

		JTextPane txtpnCdigo_1 = new JTextPane();
		txtpnCdigo_1.setEditable(false);
		txtpnCdigo_1.setText("C\u00F3digo");
		txtpnCdigo_1.setBounds(229, 31, 67, 20);
		contentPane.add(txtpnCdigo_1);

		JTextPane txtpnTtulo = new JTextPane();
		txtpnTtulo.setEditable(false);
		txtpnTtulo.setText("T\u00EDtulo");
		txtpnTtulo.setBounds(229, 62, 67, 20);
		contentPane.add(txtpnTtulo);

		JTextPane txtpnDescripcin = new JTextPane();
		txtpnDescripcin.setEditable(false);
		txtpnDescripcin.setText("Descripci\u00F3n");
		txtpnDescripcin.setBounds(229, 93, 67, 20);
		contentPane.add(txtpnDescripcin);

		
		JList list = new JList();
		list.setBounds(10, 24, 194, 167);
		DefaultListModel modelo = new DefaultListModel();
		String valor= null;
		Vector<Deporte> vectorDeportes = cd.getInstancia().getDeportes();
		if (vectorDeportes.size() > 0){

			for(int i=0; i < vectorDeportes.size(); i++ ){
				valor = "Dep: "+vectorDeportes.get(i).getCodigo() + " - "+vectorDeportes.get(i).getTitulo();
				modelo.addElement(valor);
			}
		}
		list.setModel(modelo);
		contentPane.add(list);

		JButton btnActualizarDeportes = new JButton("Actualizar lista Deportes");
		btnActualizarDeportes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String valor= null;
				contentPane.remove(list);
				modelo.removeAllElements();
				Vector<Deporte> vectorDeportes = cd.getInstancia().getDeportes();
				if (vectorDeportes.size() > 0){

					for(int i=0; i < vectorDeportes.size(); i++ ){
						valor = "Dep: "+vectorDeportes.get(i).getCodigo() + " - "+vectorDeportes.get(i).getTitulo();
						modelo.addElement(valor);
					}
				}
				list.setModel(modelo);
				contentPane.add(list);
			}
		});
		btnActualizarDeportes.setBounds(205, -1, 219, 23);
		contentPane.add(btnActualizarDeportes);

		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.setBounds(205, 124, 77, 23);
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Integer vl_codigo;

				vl_codigo = Integer.parseInt(textField.getText());

				cd.altaDeporte(vl_codigo, textField_1.getText(), textField_2.getText());


			}
		});
		contentPane.add(btnNuevo);

		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBounds(280, 124, 77, 23);
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Integer vl_codigo;

				vl_codigo = Integer.parseInt(textField.getText());
				cd.modificarDeporte(vl_codigo, textField_1.getText(), textField_2.getText());

			}
		});
		contentPane.add(btnModificar);

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(357, 124, 77, 23);
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Integer vl_codigo =  Integer.parseInt(textField.getText());

				cd.bajaDeporte(vl_codigo);


			}
		});
		contentPane.add(btnEliminar);

		//*************************************************************
		//  MANEJO DE ACTIVIDADES
		//*************************************************************
		JList list_1 = new JList();
		list_1.setBounds(10, 210, 194, 175);
		DefaultListModel modelo_1 = new DefaultListModel();
		String valor_1= null;
		Vector<Actividad> vectorActividades = cd.getInstancia().getActividades();
		if (vectorActividades.size() > 0){

			for(int i=0; i < vectorActividades.size(); i++ ){
				valor_1 = "Act: "+vectorActividades.get(i).getIdActividad() + " - "+vectorActividades.get(i).getDescripcion();
				modelo_1.addElement(valor_1);
			}
		}
		list_1.setModel(modelo_1);
		contentPane.add(list_1);

		JButton btnVerActividades = new JButton("Actualizar lista Actividades");
		btnVerActividades.setBounds(205, 190, 219, 23);
		btnVerActividades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String valor_1= null;
				contentPane.remove(list_1);
				modelo_1.removeAllElements();
				Vector<Actividad> vectorActividades = cd.getInstancia().getActividades();
				if (vectorActividades.size() > 0){

					for(int i=0; i < vectorActividades.size(); i++ ){
						Integer vl_idDeporte = Integer.parseInt(textField.getText());
						if (vl_idDeporte == vectorActividades.get(i).getIdDeporte()){
							valor_1 = vectorActividades.get(i).getIdActividad() + " - "+vectorActividades.get(i).getDescripcion();
							modelo.addElement(valor_1);}

					}
				}
				list_1.setModel(modelo_1);
				contentPane.add(list_1);

			}
		});
		contentPane.add(btnVerActividades);

		JTextPane txtpnCdigo_2 = new JTextPane();
		txtpnCdigo_2.setEditable(false);
		txtpnCdigo_2.setText("C\u00F3digo");
		txtpnCdigo_2.setBounds(229, 224, 67, 20);
		contentPane.add(txtpnCdigo_2);

		JTextPane txtpnDeporte = new JTextPane();
		txtpnDeporte.setEditable(false);
		txtpnDeporte.setText("Deporte");
		txtpnDeporte.setBounds(229, 247, 67, 20);
		contentPane.add(txtpnDeporte);

		JTextPane txtpnDescripcin_1 = new JTextPane();
		txtpnDescripcin_1.setEditable(false);
		txtpnDescripcin_1.setText("Descripci\u00F3n");
		txtpnDescripcin_1.setBounds(228, 268, 68, 20);
		contentPane.add(txtpnDescripcin_1);

		textField_3 = new JTextField();
		textField_3.setBounds(306, 247, 118, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setBounds(305, 224, 119, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);

		textField_5 = new JTextField();
		textField_5.setBounds(306, 268, 118, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);

		JRadioButton rdbtnActividadConProfesor = new JRadioButton("Actividad Con Profesor");
		rdbtnActividadConProfesor.setBounds(214, 295, 143, 23);
		contentPane.add(rdbtnActividadConProfesor);

		JRadioButton rdbtnActividadSinProfesor = new JRadioButton("Actividad Sin Profesor");
		rdbtnActividadSinProfesor.setBounds(214, 314, 143, 23);
		rdbtnActividadSinProfesor.setSelected(true);
		contentPane.add(rdbtnActividadSinProfesor);

		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnActividadConProfesor);
		bg.add(rdbtnActividadSinProfesor);

		JButton btnAgregarActividad = new JButton("Agregar");
		btnAgregarActividad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Integer vl_codigo = Integer.parseInt(textField_3.getText());
				Integer vl_deporte = Integer.parseInt(textField_4.getText());
				Integer vl_idProfe = Integer.parseInt(txtProfesor.getText());
				if (rdbtnActividadConProfesor.isSelected()){
					cd.agregarActividadConProfe(vl_codigo, vl_deporte, textField_5.getText(), vl_idProfe);}
				else{	    
					cd.agregarActividadSinProfe(vl_codigo, vl_deporte, textField_5.getText());}
			}
		});
		btnAgregarActividad.setBounds(205, 351, 77, 23);
		contentPane.add(btnAgregarActividad);


		JButton btnModificar_1 = new JButton("Modificar");
		btnModificar_1.setBounds(282, 351, 89, 23);
		btnModificar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Integer vl_codigo = Integer.parseInt(textField_3.getText());
				Integer vl_idProfe = Integer.parseInt(txtProfesor.getText());
				if (rdbtnActividadConProfesor.isSelected()){
					cd.modificarActividadConProfe(vl_codigo, textField_5.getText(), vl_idProfe);}
				else{	    
					cd.modificarActividadSinProfe(vl_codigo, textField_5.getText());}
			}
		});
		contentPane.add(btnModificar_1);

		JButton btnEliminar_1 = new JButton("Eliminar");
		btnEliminar_1.setBounds(373, 351, 89, 23);
		btnEliminar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Integer vl_codigo = Integer.parseInt(textField_4.getText());
				cd.bajaActividad(vl_codigo);

			}
		});
		contentPane.add(btnEliminar_1);

		//*************************************************************
		//  MANEJO DE CLASES
		//*************************************************************
		JList list_2 = new JList();
		list_2.setBounds(10, 408, 194, 193);
		DefaultListModel modelo_2 = new DefaultListModel();
		String valor_2= null;
		Vector<ClaseAct> vectorClases = cd.getInstancia().getClases();
		if (vectorActividades.size() > 0){

			for(int i=0; i < vectorClases.size(); i++ ){
				valor_2 = "Cl: "+vectorClases.get(i).getIdClase() + " - día:"+vectorClases.get(i).getDia()+ " - Act:"+
						  vectorClases.get(i).getIdAct()+" - De:"+ vectorClases.get(i).getHoraDesde()+ " a "+
						  vectorClases.get(i).getHoraHasta()+ " hs.";
				modelo_2.addElement(valor_2);
			}
		}
		list_2.setModel(modelo_2);
		contentPane.add(list_2);
		

		JButton btnActualizarListaClases = new JButton("Actualizar lista Clases");
		btnActualizarListaClases.setBounds(207, 385, 217, 23);
		btnActualizarListaClases.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String valor_2= null;
				contentPane.remove(list_2);
				modelo_2.removeAllElements();
				Vector<ClaseAct> vectorClases= ControladorDeportes.getInstancia().getClases();
				if (vectorClases.size() > 0){

					for(int i=0; i < vectorClases.size(); i++ ){
						valor_2 = "Cl: "+vectorClases.get(i).getIdClase() + " - día:"+vectorClases.get(i).getDia()+ " - Act:"+
								  vectorClases.get(i).getIdAct()+" - De:"+ vectorClases.get(i).getHoraDesde()+ " a "+
								  vectorClases.get(i).getHoraHasta()+ " hs.";
						modelo_2.addElement(valor_2);
					}
				}
				list_2.setModel(modelo_2);
				contentPane.add(list_2);

			}
		});
		contentPane.add(btnActualizarListaClases);

		JTextPane txtpnHoraDesde = new JTextPane();
		txtpnHoraDesde.setEditable(false);
		txtpnHoraDesde.setText("Hora Desde");
		txtpnHoraDesde.setBounds(235, 497, 67, 20);
		contentPane.add(txtpnHoraDesde);

		textField_6 = new JTextField();
		textField_6.setBounds(312, 497, 86, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);

		JTextPane txtpnHasta = new JTextPane();
		txtpnHasta.setEditable(false);
		txtpnHasta.setText("Hasta");
		txtpnHasta.setBounds(405, 497, 56, 20);
		contentPane.add(txtpnHasta);

		textField_7 = new JTextField();
		textField_7.setBounds(468, 497, 86, 20);
		contentPane.add(textField_7);
		textField_7.setColumns(10);

		JTextPane txtpnActividad = new JTextPane();
		txtpnActividad.setEditable(false);
		txtpnActividad.setText("Actividad");
		txtpnActividad.setBounds(235, 477, 73, 20);
		contentPane.add(txtpnActividad);

		textField_8 = new JTextField();
		textField_8.setBounds(312, 477, 86, 20);
		contentPane.add(textField_8);
		textField_8.setColumns(10);

		JTextPane txtpnDa = new JTextPane();
		txtpnDa.setEditable(false);
		txtpnDa.setText("D\u00EDa");
		txtpnDa.setBounds(235, 455, 73, 20);
		contentPane.add(txtpnDa);

		JTextPane txtpnCdigo_3 = new JTextPane();
		txtpnCdigo_3.setEditable(false);
		txtpnCdigo_3.setText("C\u00F3digo");
		txtpnCdigo_3.setBounds(235, 432, 73, 20);
		contentPane.add(txtpnCdigo_3);

		textField_9 = new JTextField();
		textField_9.setBounds(312, 455, 86, 20);
		contentPane.add(textField_9);
		textField_9.setColumns(10);

		textField_10 = new JTextField();
		textField_10.setBounds(312, 432, 86, 20);
		contentPane.add(textField_10);
		textField_10.setColumns(10);

		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(205, 543, 89, 23);
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Integer vl_desde = Integer.parseInt(textField_6.getText());
				Integer vl_hasta = Integer.parseInt(textField_7.getText());
				Integer vl_idAct = Integer.parseInt(textField_8.getText());
				Integer vl_idDia = Integer.parseInt(textField_9.getText());
				Integer vl_idClase = Integer.parseInt(textField_10.getText());
				cd.agregarClase(vl_idAct, vl_idClase, vl_desde, vl_hasta, vl_idDia);
			}
		});
		contentPane.add(btnAgregar);

		JButton btnModificar_2 = new JButton("Modificar");
		btnModificar_2.setBounds(297, 543, 89, 23);
		btnModificar_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Integer vl_desde = Integer.parseInt(textField_6.getText());
				Integer vl_hasta = Integer.parseInt(textField_7.getText());
				Integer vl_idDia = Integer.parseInt(textField_9.getText());
				Integer vl_idClase = Integer.parseInt(textField_10.getText());
				cd.modificarClase(vl_idClase, vl_desde, vl_hasta, vl_idDia);
			}
		});
		contentPane.add(btnModificar_2);

		JButton btnEliminar_2 = new JButton("Eliminar");
		btnEliminar_2.setBounds(389, 543, 89, 23);
		btnEliminar_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Integer vl_codigo = Integer.parseInt(textField_10.getText());
				cd.bajaClase(vl_codigo);
			}
		});
		contentPane.add(btnEliminar_2);

		txtProfesor = new JTextField();
		txtProfesor.setText("1");
		txtProfesor.setBounds(361, 299, 86, 20);
		contentPane.add(txtProfesor);
		txtProfesor.setColumns(10);



	}
}

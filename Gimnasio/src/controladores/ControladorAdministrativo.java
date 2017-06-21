package controladores;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Vector;

import modelo.Abono;
import modelo.Contratado;
import modelo.Empresa;
import modelo.Profesor;
import persistencia.AdminPersistAbono;
import persistencia.AdminPersistEmpresa;

public class ControladorAdministrativo {

	
	private static ControladorAdministrativo instancia;
	private ArrayList<Contratado> contratados;
	private Vector<Empresa> empresas;
	private Vector<Abono> abonos;
	private ArrayList<Profesor> profesores; //Ver si es necesario

	

	public ControladorAdministrativo(){
		contratados = new ArrayList<Contratado>(0);
		empresas = AdminPersistEmpresa.getInstancia().selectAll();
		abonos = AdminPersistAbono.getInstancia().selectAll();
		profesores = new ArrayList<Profesor>(0); //ver si es necesario
		
	}

	//Singleton
	public static ControladorAdministrativo getInstancia(){
		if (instancia == null){
			instancia = new ControladorAdministrativo();
		}
		return instancia;
	}

	public String obtenerDescripcionEmpresa(Integer codigo){
		String emp = null;
		Empresa empresa = AdminPersistEmpresa.getInstancia().buscarEmpresa(codigo);
		if (empresa == null) {
			System.out.println("La empresa no se encuentra dada de alta en el sistema");
		} else {
			emp = empresa.getNombre();
		}
		
		return emp;
	}

	public void altaEmpresa(String nombre){
		Integer codigo = this.empresas.size() + 1 ; //da la cantidad de empresas para generar el codigo
		Empresa emp = new Empresa(codigo, nombre);
		AdminPersistEmpresa.getInstancia().insert(emp);
		
	}
		
	public void bajaEmpresa(Integer codigo){
		Empresa empresa = AdminPersistEmpresa.getInstancia().buscarEmpresa(codigo);
		if (empresa == null) {
			System.out.println("La empresa no se encuentra dada de alta en el sistema");
		} else {
			AdminPersistEmpresa.getInstancia().delete(empresa);
			System.out.println("La empresa "+ codigo + " ha sido eliminado");
		}
		
	}
	
	
	public void altaAbono(String nombre, Float precio, Date vigencia){
		Integer codigo = this.abonos.size() + 1;
		Abono abono = new Abono(codigo, nombre, precio, vigencia);
		AdminPersistAbono.getInstancia().insert(abono);
	}
	
	public void bajaAbono(Integer codigo){
		Abono abono = AdminPersistAbono.getInstancia().buscarAbono(codigo);
		if (abono == null) {
			System.out.println("El abono no se encuentra dado de alta en el sistema");
		} else {
			AdminPersistAbono.getInstancia().delete(abono);
			System.out.println("La empresa "+ codigo + " ha sido eliminado");
		}
	}
	
	
}

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
	private Vector<Profesor> profesores; //Ver si es necesario

	

	public ControladorAdministrativo(){
		contratados = new ArrayList<Contratado>(0);
		empresas = AdminPersistEmpresa.getInstancia().selectAll();
		abonos = AdminPersistAbono.getInstancia().selectAll();
		profesores = new Vector<Profesor>(0); //ver si es necesario
		
	}

	//Singleton
	public static ControladorAdministrativo getInstancia(){
		if (instancia == null){
			instancia = new ControladorAdministrativo();
		}
		return instancia;
	}

	private Empresa buscarEmpresaBuffer (Integer codigo){
			
			for (Empresa empresa : empresas) {
				if (empresa.getCodigo() == codigo) {
					return empresa;
				} else {
					Empresa emp = AdminPersistEmpresa.getInstancia().buscarEmpresa(codigo);
					if (emp == null){
						return null;
					} else {
						empresas.addElement(emp);
						return emp;
					}
				}
				
			}
			return null;
		}
	
	 Abono buscarAbonoBuffer (Integer codigo){
		
		for (Abono abono : abonos) {
			if (abono.getCodigo() == codigo) {
				return abono;
			} else {
				Abono ab = AdminPersistAbono.getInstancia().buscarAbono(codigo);
				if (ab == null){
					return null;
				} else {
					abonos.addElement(ab);
					return ab;
				}
			}
			
		}
		return null;
	}
	
	public String obtenerDescripcionEmpresa(Integer codigo){
		String emp = null;
		Empresa empresa = buscarEmpresaBuffer(codigo);
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
		empresas.addElement(emp);
		
	}
		
	public void bajaEmpresa(Integer codigo){
		Empresa empresa = buscarEmpresaBuffer(codigo);
		if (empresa == null) {
			System.out.println("La empresa no se encuentra dada de alta en el sistema");
		} else {
			AdminPersistEmpresa.getInstancia().delete(empresa);
			System.out.println("La empresa "+ codigo + " ha sido eliminado");
			empresas.removeElement(empresa);
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

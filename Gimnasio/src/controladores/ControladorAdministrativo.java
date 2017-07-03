package controladores;

import java.sql.Date;
import java.util.Vector;

import modelo.Abono;
import modelo.Contratado;
import modelo.DiaSemana;
import modelo.Empleado;
import modelo.Empresa;
import modelo.Profesor;
import modelo.ProfesorConSueldo;
import modelo.ProfesorPorClase;
import persistencia.AdminPersistAbono;
import persistencia.AdminPersistDiaSemana;
import persistencia.AdminPersistEmpleado;
import persistencia.AdminPersistEmpresa;
import persistencia.AdminPersistProfesorClase;
import persistencia.AdminPersistProfesorSueldo;

public class ControladorAdministrativo {

	
	private static ControladorAdministrativo instancia;
	private Vector<Empleado> empleados;
	private Vector<Empresa> empresas;
	private Vector<Abono> abonos;
	private Vector<Profesor> profesores; 
	private Vector<DiaSemana> diasSemana;

	

	public ControladorAdministrativo(){
		empleados = AdminPersistEmpleado.getInstancia().selectAll();
		empresas = AdminPersistEmpresa.getInstancia().selectAll();
		abonos = AdminPersistAbono.getInstancia().selectAll();
		profesores = this.profesoresBD();
		diasSemana = AdminPersistDiaSemana.getInstancia().selectAll();
		
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
	
	private Empleado buscarEmpleadoBuffer (Integer dni){
		
		for (Empleado empleado : empleados) {
			if (empleado.getDni() == dni) {
				return empleado;
			} else {
				Empleado emp = AdminPersistEmpleado.getInstancia().buscarEmpleado(dni);
				if (emp == null){
					return null;
				} else {
					empleados.addElement(emp);
					return emp;
				}
			}
			
		}
		return null;
	}
	
	private Profesor buscarProfesorBuffer (Integer dni){
			
			for (Profesor profesor : profesores) {
				if (profesor.getDni() == dni) {
					return profesor;
				} else {
					Profesor profe = buscarProfesorEnBD(dni);
					if (profe == null){
						return null;
					} else {
						profesores.addElement(profe);
						return profe;
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
	
	 
	 //Busca al profesor tanto si es con sueldo como si es con valor por hora
	 private Profesor buscarProfesorEnBD(Integer dni){ //TODO Faltaaa
		 
		 ProfesorConSueldo prof1 = AdminPersistProfesorSueldo.getInstancia().buscarProfesorSueldo(dni);
		 if (prof1 == null){
			 
			 ProfesorPorClase prof2 = AdminPersistProfesorClase.getInstancia().buscarProfesorClase(dni) ;
			 
			 return prof2;
		 }
		 
		 return prof1;
	 }

	 
	 //busca todos los profesores en la base de datos, sin importar de que tipo sea
	 private Vector<Profesor> profesoresBD(){
		 Vector<Profesor> profesores = new Vector<Profesor>();
		 profesores.addAll(AdminPersistProfesorClase.getInstancia().selectAll());
		 profesores.addAll(AdminPersistProfesorSueldo.getInstancia().selectAll());
		 return profesores;
	 }
	 
	 //posiblemente no se use
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

	//Empresa
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
	
	//Abono
	public void altaAbono(String nombre, Float precio, Date vigencia){
		Integer codigo = this.abonos.size() + 1;
		Abono abono = new Abono(codigo, nombre, precio, vigencia);
		AdminPersistAbono.getInstancia().insert(abono);
		this.abonos.addElement(abono);
	}
	
	public void bajaAbono(Integer codigo){
		Abono abono = AdminPersistAbono.getInstancia().buscarAbono(codigo);
		if (abono == null) {
			System.out.println("El abono no se encuentra dado de alta en el sistema");
		} else {
			AdminPersistAbono.getInstancia().delete(abono);
			this.abonos.remove(abono);
			System.out.println("El abono ha sido eliminado");
		}
	}
	
	//Empleado
	public void altaEmpleado(Integer dni, String nombre, String apellido, String domicilio, String mail, 
			Float sueldo, Float retencion, Float impuesto){
		
		Empleado empleado = buscarEmpleadoBuffer(dni);
		if (empleado == null) {
		
		Empleado empl = new Empleado(dni, nombre, apellido, domicilio, mail, sueldo, retencion, impuesto);
		
		AdminPersistEmpleado.getInstancia().insert(empl);
		this.empleados.addElement(empl);
		
		} 
	
	}
	
	public void bajaEmpleado(Integer dni){
		Empleado empl = buscarEmpleadoBuffer(dni);
		if (empl == null) {
			System.out.println("El empleado no se encuentra dado de alta en el sistema");
		} else {
			AdminPersistEmpleado.getInstancia().delete(empl);
			this.empleados.remove(empl);
			System.out.println("El empleado "+ dni + " ha sido eliminado");
		}
	}
	
	//ProfesorSueldo
	public void altaProfesorSueldo(Integer dni, String nombre, String apellido, String domicilio, String mail, 
			Float sueldo, Float retencion, Float impuesto){
		
		Profesor profe = buscarProfesorBuffer(dni);
		if (profe == null) {
		
		ProfesorConSueldo prof = new ProfesorConSueldo(dni, nombre, apellido, domicilio, mail, sueldo, retencion, impuesto);
		
		AdminPersistProfesorSueldo.getInstancia().insert(prof);
		this.profesores.addElement(prof);
		
		} 
	
	}
	
	public void bajaProfesorSueldo(Integer dni){
		Profesor profe = buscarProfesorBuffer(dni);
		if (profe == null) {
			System.out.println("El profesor no se encuentra dado de alta en el sistema");
		} else {
			AdminPersistProfesorSueldo.getInstancia().delete(profe);
			this.profesores.remove(profe);
			System.out.println("El profesor "+ dni + " ha sido eliminado");
		}
	}
	
	//ProfesorClase
		public void altaProfesorClase(Integer dni, String nombre, String apellido, String domicilio, String mail, 
				Float sueldo, Float retencion, Float impuesto){
			
			Profesor profe = buscarProfesorBuffer(dni);
			if (profe == null) {
			
			ProfesorPorClase prof = new ProfesorPorClase(dni, nombre, apellido, domicilio, mail, sueldo, retencion, impuesto);
			
			AdminPersistProfesorClase.getInstancia().insert(prof);
			this.profesores.addElement(prof);
			
			} 
		
		}
		
		public void bajaProfesorClase(Integer dni){
			Profesor profe = buscarProfesorBuffer(dni);
			if (profe == null) {
				System.out.println("El profesor no se encuentra dado de alta en el sistema");
			} else {
				AdminPersistProfesorClase.getInstancia().delete(profe);
				this.profesores.remove(profe);
				System.out.println("El profesor "+ dni + " ha sido eliminado");
			}
		}
		
		public void liquidarSueldos(){
			
			Vector<Contratado> contratados = new Vector<Contratado>();
			contratados.addAll(empleados);
			contratados.addAll(profesores);
			
			for (Contratado contratado : contratados) {
				contratado.calcularSueldo();
				//TODO falta ver cómo se paga y que se hace con el sueldo
				
			}
			
		}
	
}

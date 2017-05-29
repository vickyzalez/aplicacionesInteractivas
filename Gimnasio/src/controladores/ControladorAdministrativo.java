package controladores;

import java.util.ArrayList;
import java.util.Calendar;

import modelo.Abono;
import modelo.Contratado;
import modelo.Empleado;
import modelo.Empresa;
import modelo.Profesor;
import modelo.ProfesorConSueldo;
import modelo.ProfesorPorClase;

public class ControladorAdministrativo {

	
	private static ControladorAdministrativo instancia;
	private ArrayList<Contratado> contratados;
	private ArrayList<Empresa> empresas;
	private ArrayList<Abono> abonos;
	private ArrayList<Profesor> profesores; //Ver si es necesario

	
	
	public ArrayList<Contratado> getContratados() {
		return contratados;
	}

	public void setContratados(ArrayList<Contratado> contratados) {
		this.contratados = contratados;
	}

	public ArrayList<Empresa> getEmpresas() {
		return empresas;
	}

	public void setEmpresas(ArrayList<Empresa> empresas) {
		this.empresas = empresas;
	}

	public ArrayList<Abono> getAbonos() {
		return abonos;
	}

	public void setAbonos(ArrayList<Abono> abonos) {
		this.abonos = abonos;
	}
	public ArrayList<Profesor> getProfesores() {
		return profesores;
	}

	public void setProfesores(ArrayList<Profesor> profesores) {
		this.profesores = profesores;
	}

	public ControladorAdministrativo(){
		contratados = new ArrayList<Contratado>(0);
		empresas = new ArrayList<Empresa>(0);
		abonos = new ArrayList<Abono>(0);
		profesores = new ArrayList<Profesor>(0); //ver si es necesario
		
	}

	//Singleton
	public static ControladorAdministrativo getInstancia(){
		if (instancia == null){
			instancia = new ControladorAdministrativo();
		}
		return instancia;
	}

//Buscadores
	public Abono buscarAbono(Integer id){
		for (Abono abono : getAbonos()) {
			if (abono.getCodigo() == id) {
				return abono;
			}
		} return null;
	}

	public Contratado buscarContratado(Integer dni){
		for (Contratado contratado : getContratados()) {
			if (contratado.getDni() == dni) {
				return contratado;
			}
		} return null;
	}
	
	public Empresa buscarEmpresa(Integer id){
		for (Empresa emp : getEmpresas()) {
			if (emp.getId() == id) {
				return emp;
			}
		} return null;
	}

	public Profesor buscarProfesor(Integer dni){
		for (Profesor profe : getProfesores()) {
			if (profe.getDni() == dni) {
				return profe;
			}
		} return null;
	}

//Administración de abonos
	public Abono altaAbono(Integer codigo, String nombre, Float precio, Calendar vigencia){
		Abono abono = new Abono(codigo, nombre, precio, vigencia);
		getAbonos().add(abono);
		return abono;

	}

	public void modificarAbono(Integer codigo, String nombre, Float precio, Calendar vigencia){
		Abono abono = buscarAbono(codigo);
		if (abono == null) {
			System.out.println("El abono no se encuentra registrado en el sistema");
		} else {
			abono.setNombre(nombre);
			abono.setPrecio(precio);
			abono.setVigencia(vigencia);
			System.out.println("El abono ha sido actualizado");
		}

	}

	public void eliminarAbono(Integer id){
		Abono abono = buscarAbono(id);
		getAbonos().remove(abono);
		System.out.println("El abono "+ id + " ha sido eliminado");
	}
	
//Administración de Empresas TODO ver codigo
	public Empresa altaEmpresa(String nombre){
		Empresa empresa = new Empresa(nombre);
		getEmpresas().add(empresa);
		return empresa;

	}

	public void eliminarEmpresa(Integer id){
		Empresa empresa = buscarEmpresa(id);
		getEmpresas().remove(empresa);
		System.out.println("La empresa "+ id + " ha sido eliminada");
	}


//Empleados	 
	public Contratado altaEmpleado(Integer dni, String nombre,String apellido, String domicilio, String mail, Float sueldo){
		Empleado empleado = new Empleado(dni, nombre, apellido, domicilio, mail, sueldo);
		getContratados().add(empleado);
		return empleado;
	}


//Profesores con sueldo 
	public ProfesorConSueldo altaProfSueldo(Integer dni, String nombre, String apellido, String domicilio, String mail, Float sueldo){
		ProfesorConSueldo profesor = new ProfesorConSueldo(dni, nombre, apellido, domicilio, mail, sueldo);
		getContratados().add(profesor);
		getProfesores().add(profesor);
		return profesor;
	}

//Profesores por hora 
	public ProfesorPorClase altaProfClase(Integer dni, String nombre,String apellido, String domicilio, String mail, Float valor){
		ProfesorPorClase profe = new ProfesorPorClase(dni, nombre, apellido, domicilio, mail, valor);
		getContratados().add(profe);
		getProfesores().add(profe);
		return profe;
	}

	public void eliminarContratado(Integer dni){
		Contratado empleado = buscarContratado(dni);
		getContratados().remove(empleado);
		Profesor profe = buscarProfesor(dni);
		if (profe != null){
			getProfesores().remove(profe);
		}
	}
}

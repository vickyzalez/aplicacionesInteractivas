package controladores;
import java.util.ArrayList;
import java.util.Iterator;

import modelo.*;

public class ControladorRRHH {
	private static ControladorRRHH instancia;
	private ArrayList<Empleado> empleados;

	public ControladorRRHH(){
		empleados = new ArrayList<Empleado>(0);
	}

	//Singleton
	public static ControladorRRHH getInstancia(){
		if (instancia == null){
			instancia = new ControladorRRHH();
		}
		return instancia;
	}

	public boolean AgregarEmpleado(Empleado e){
		return this.empleados.add(e);
	}

	public boolean EliminarEmpleado(Empleado e){
		return this.empleados.remove(e);
	}

	public Empleado buscarEmpleado(int dni){
		for(Iterator<Empleado> i = empleados.iterator();i.hasNext();){
			Empleado aux = i.next();
			if(aux.getDni() == dni){
				return aux;
			}
		}
		return null;
	}
	
	public void AltaAdministrativo(int dni,String nombre,String apellido, String domicilio, String mail, PuestoEmpleado puesto, float sueldo,float desc){
		EmpleadoAdminstrativo a = new EmpleadoAdminstrativo(dni,nombre,apellido,domicilio, mail, null, sueldo,desc);
		empleados.add(a);
	}
	
	public void AltaProfesorHora(int dni, String nombre, String apellido, String domicilio, String mail, PuestoEmpleado puesto,int cantH,float pago){
		ProfesorParticular pf = new ProfesorParticular(dni,nombre,apellido,domicilio,  mail);
		empleados.add(pf);
	}
	
	public void AltaProfesorFullTime(int dni,String nombre, String apellido, String domicilio, String mail, float sueldo,float desc){
		ProfesorFullTime pf = new ProfesorFullTime(dni,nombre, apellido, domicilio, mail);
		empleados.add(pf);
	}
}

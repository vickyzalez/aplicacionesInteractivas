package controladores;
import java.util.ArrayList;

import modelo.Empleado;

public class ControladorRRHH {
private ArrayList<Empleado> empleados;

public ControladorRRHH(){
	empleados = new ArrayList<Empleado>(0);
}

public boolean AgregarEmpleado(Empleado e){
	return this.empleados.add(e);
}

public boolean EliminarEmpleado(Empleado e){
	return this.empleados.remove(e);
}
}

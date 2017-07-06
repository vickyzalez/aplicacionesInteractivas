package controladores;
/*package controladores;

import modelo.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


public class SistemaGimnasio {

	private static SistemaGimnasio instancia;
    private static ControladorDeportes dep;
    private static ControladorRRHH emp;
    private static ControladorSocios socio;
    private static ControladorFinanzas inscripciones;
    
    
    private SistemaGimnasio(){
    	this.dep = null;
    	this.emp = null;
    	this.inscripciones = null;
    	this.socio = null;
    	
    }
	
    
    public static SistemaGimnasio getGimnasio(){
    	if(instancia == null){
    		instancia = new SistemaGimnasio();
    	}
    	return instancia;
    }
    
    public void agregarAdministrativo(int dni,String nombre,String apellido, String domicilio, String mail, PuestoEmpleado puesto,float sueldo,float desc){
    	emp = ControladorRRHH.getInstancia();
    	emp.AltaAdministrativo(dni, nombre, apellido, domicilio, mail, puesto, sueldo, desc);
    	System.out.println("se agrego un nuevo empleado administrativo");
    }
    
    public void agregarProfesorFulltime(int dni,String nombre,String apellido, String domicilio, String mail, PuestoEmpleado puesto, float sueldo,float desc){
    	emp = ControladorRRHH.getInstancia();
    	emp.AltaProfesorFullTime(dni, nombre, apellido, domicilio, mail, sueldo, desc);
    	System.out.println("se agrego nuevo empleado profesor");
    }
    
    public void agregarProfesorHora(int dni, String nombre, String apellido, String domicilio, String mail ,PuestoEmpleado puesto, int cantH,float pago){
    	emp = ControladorRRHH.getInstancia();
    	emp.AltaProfesorHora(dni, nombre, apellido, domicilio, mail, puesto, cantH, pago);
    	System.out.println("Se agrego nuevo empleado profesor por Hora");
    }
    
    public void agregarDeporte(Deporte deporte){
    	dep = ControladorDeportes.getInstancia();
    	dep.AgregarDeporte(deporte);
    }
    
    public void agregarSocio(SocioView s){
    	socio = ControladorSocios.getInstancia();
    	socio.AgregarSocio(s);
    }
	
    
    //este metodo se encarga de llamar al altasocio, por que se lo registra al momento de inscribirse
    //falta terminar
    public void realizarInscripcion(SocioView s) {
    	inscripciones = ControladorFinanzas.getInstancia();
    	this.agregarSocio(s);
    }
    
    //se pasa socio view por que le pedimos que ingrese el dni, y nos tiene que traer los datos de ese socio
    //y poder agregarle el apto medico
    public void agregarAptoMedicoSocio(SocioView s,AptoMedicoView amv){
    	socio = ControladorSocios.getInstancia();
    	socio.AgregarAptoMedico(s.getDni(), amv);
    }

    public SocioView obtenerSocioEliminar(int dni){
    	socio = ControladorSocios.getInstancia();
    	SocioView s = socio.buscarSocioView(dni);
    	if(s != null){
    		return s;
    	}else{
    		//despues hacemos que salga por una mini pantalla
    		System.out.println("no existe el socio");
    	}
		return null;
    	
    }
    
    public void EliminarSocio(int dni){
    	socio = ControladorSocios.getInstancia();
    	socio.EliminarSocio(dni);
    	System.out.println("se elemino el socio con dni : " + dni);
    }
}
	
	
	
	
	
	
	
	

*/
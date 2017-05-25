package Sistema;


import controladores.ControladorDeportes;
import controladores.ControladorFinanzas;
import controladores.ControladorRRHH;
import controladores.ControladorSocios;
import modelo.Abono;
import modelo.ActividadConProfesor;
import modelo.ActividadSinProfesor;
import modelo.Deporte;
import modelo.PagoMensual;
import modelo.Profesor;
import modelo.Socio;

public class Sistema {
	public static void main(String[] args) {
	//agregar acá lo que está ahora en administrador
	
	ControladorSocios controladorSocios = new ControladorSocios();
	Socio s1 = new Socio(31232111, "Juan", "Romera", "Hudson 123", 1234567890, "a@a.com.ar");
	Socio s2 = new Socio(31232222, "Juan2", "Romera2", "Hudson 456", 1234567890, "b@b.com.ar");
	
	controladorSocios.AgregarSocio(s1);
	controladorSocios.AgregarSocio(s2);
	controladorSocios.EliminarSocio(s1);
	
	ControladorFinanzas controladorFinanzas = new ControladorFinanzas();
	Abono abono = new Abono(1, "Abono1", 1000, "01.01.2010");
	PagoMensual pago = new PagoMensual(1, 31232111, 1000, "24.05.2017");
	controladorFinanzas.AgregarAbono(abono);
	controladorFinanzas.AgregarPago(pago);
	
	ControladorDeportes controladorDeportes = new ControladorDeportes();
	Deporte d1  = new Deporte(1, "Pileta", "Nataci�n");
	ActividadConProfesor a1 = new ActividadConProfesor(1, "Pileta Escuela Infantil", "Lunes", 9, 11);
	Profesor p1 = new Profesor(30252111, "Hernan", "Kamp", "Alem 123", "p@p.com.ar");
	a1.setProfesor(p1);
	ActividadSinProfesor a2 = new ActividadSinProfesor(2, "Pileta Escuela Adultos", "Lunes", 11, 13);
	d1.AgregarActividad(a1);
	d1.AgregarActividad(a2);
	controladorDeportes.AgregarDeporte(d1);
	controladorDeportes.RealizarInscripcion(s1, d1.getActividades());
	controladorDeportes.RealizarInscripcion(s2, d1.getActividades());
	
	ControladorRRHH controladorRRHH = new ControladorRRHH();
	controladorRRHH.AgregarEmpleado(p1);
	
}
}

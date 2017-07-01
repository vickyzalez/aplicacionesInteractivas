package controladores;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Vector;

import modelo.Abono;
import modelo.Actividad;
import modelo.ClaseAct;
import modelo.Inscripcion;
import modelo.Socio;
import persistencia.AdminPersistAbono;
import persistencia.AdminPersistInscrip;
import persistencia.AdminPersistSocio;

public class FachadaMolinete {
	
	public boolean validarIngreso(Integer dniSocio){

		Calendar hoy = Calendar.getInstance();
		Date today = (Date) hoy.getTime();
		Socio socio = ControladorSocios.getInstancia().buscarSocioBuffer(dniSocio);
		
		Date fechaFinAptoMed = ControladorSocios.getInstancia().obtenerFechaFinAptoMed(socio);
		Date fechaFinAbono = ControladorSocios.getInstancia().obtenerFinAbono(socio);
		
		if (today.after(fechaFinAptoMed)){
			return false;
		}
		
		if (today.after(fechaFinAbono)){
			return false;
		}
		
		Vector<Actividad> actividades = null; //acá se le pondrá las actividades del socio que se sacarán de la inscrip
		
		for (Actividad actividad : actividades) {
			for (ClaseAct clase : actividad.getClases()) {
				
				if((today.getTime() > clase.getHoraDesde()) && (today.getTime() < clase.getHoraHasta())){
					return true;
				}
			}
		}
		
		return false;	
	}	
	
}

package controladores;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Vector;

import modelo.Abono;
import modelo.Actividad;
import modelo.Clase;
import modelo.Inscripcion;
import modelo.Socio;
import persistencia.AdminPersistAbono;
import persistencia.AdminPersistInscrip;
import persistencia.AdminPersistSocio;

public class FachadaMolinete {
	
	public boolean validarIngreso(Integer dniSocio){

		Calendar hoy = Calendar.getInstance();
		Date today = (Date) hoy.getTime();
		Socio socio = AdminPersistSocio.getInstancia().buscarSocio(dniSocio);
		
		Date fechaFinAptoMed = obtenerFechaFinAptoMed(socio);
		Date fechaFinAbono = obtenerFinAbono(socio);
		
		if (today.after(fechaFinAptoMed)){
			return false;
		}
		
		if (today.after(fechaFinAbono)){
			return false;
		}
		
		Vector<Actividad> actividades = null; //acá se le pondrá las actividades del socio que se sacarán de la inscrip
		
		for (Actividad actividad : actividades) {
			for (Clase clase : actividad.getClases()) {
				
				if((today.getTime() > clase.getHoraDesde()) && (today.getTime() < clase.getHoraHasta())){
					return true;
				}
			}
		}
		
		return false;	
	}
	
	
	
	private Date obtenerFinAbono(Socio socio) {
		
		Inscripcion ins = AdminPersistInscrip.getInstancia().buscarInscrip(socio.getInscripcion());
		Abono abono = AdminPersistAbono.getInstancia().buscarAbono(ins.getCodigoAbono());
		
		return abono.getVigencia();
	}

	private Date obtenerFechaFinAptoMed(Socio socio){
		
		SimpleDateFormat formatter = new SimpleDateFormat("DD-MM-yyyy");    
	    Date date;
		try {
			date = (Date) formatter.parse(socio.getAm().getFechaFin());
		} catch (ParseException e) {
			System.out.println("error de parseo");
			return null;
		}

	    return date;
	
	}
	
}

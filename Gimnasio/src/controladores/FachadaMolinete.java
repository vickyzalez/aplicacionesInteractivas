package controladores;

import java.sql.Date;
import java.util.Calendar;
import java.util.Vector;

import modelo.ClaseAct;
import modelo.Socio;

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
		
		 
		Vector<ClaseAct> clases = ControladorSocios.getInstancia().obtenerClasesSocio(socio);
		
		for (ClaseAct clase : clases) {
			
			if((today.getTime() > clase.getHoraDesde()) && (today.getTime() < clase.getHoraHasta())){
				return true;
			}
		}
		
		
		return false;	
	}	
	
}

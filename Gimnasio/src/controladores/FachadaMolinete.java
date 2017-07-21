package controladores;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
		String fechaFinAbono = ControladorSocios.getInstancia().obtenerFinAbono(socio);

		if (today.after(fechaFinAptoMed)){
			return false;
		}


		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date parsed = null;
		try {
			parsed = (Date) sdf.parse(fechaFinAbono);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		java.sql.Date data = new java.sql.Date(parsed.getTime());


		if (today.after(data)){
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

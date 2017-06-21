package modelo;

import java.util.ArrayList;

public class InscripcionNormal extends Inscripcion {

	
	public InscripcionNormal(Integer cod, Integer dni, Integer codAbono){
		super.actividades = new ArrayList<Actividad>();
		super.codigo = cod;
		super.dniSocio = dni;
		super.codigoAbono = codAbono;
		
	}
}
